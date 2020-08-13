/* 19/03/2020 - HOME
 * You are given a sequence A of N integers: A1,A2,A3... AN.

You would like to make all elements in A different. To do so, you may perform operations 
of two types:

Remove an element. The cost of this operation is X coins.
Decrease the value of an element by one. The cost is Y coins.
You may perform as many operations as you wish.
It is possible and allowed that some elements will become negative
(after you decrease an element multiple times).

Your task is to find the minimum number of coins you would need in order to 
make A pairwise distinct.

Input Format
------------
The first line contains three space-separated integers N, X, and Y 
		— the size of the sequence and costs of operations.
The second line contains N space-separated integers A1,A2,A3...AN
		— the initial sequence.

Output Format
-------------
Print one integer — the minimum number of coins needed to make A pairwise distinct.



Sample Input :
6 10 3
5 2 5 3 5 2

Sample Output :
16

Explanation :
we are given a sequence of size n=6.
The cost of removing and decreasing by one are 10 and 3 respectively.

The initial sequence is (5 2 5 3 5 2).
One optimal strategy is:

Remove one of three fives, e.g. the middle one. The remaining sequence is (5 2 3 5 2).
Decrease the second element by one, to get (5 1 3 5 2).
Decrease the first element by one, to get (4 1 3 5 2).
This way, you need to spend 10+3+3 =16 coins. 
The resulting sequence(4 1 3 5 2) is indeed pairwise distinct.

 */
package Elite;
import java.util.*;

public class MakeAllNumbersDistinct {
    public static void main(String args[] ) throws Exception {
      
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        long cost = 0;
        int[] a = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        HashMap<Integer,Integer> distinctNumbers = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            int h = a[i];
            if(distinctNumbers.containsKey(h))
            {
                int cnt = 0;
                //repeat until number not found, decrement it ,increase the count 
                //and check for decremented value 
                while(distinctNumbers.containsKey(h))
                {
                    h--;
                    cnt+=1;
                }
                //check whether removal costs more or decrement costs more
                if(cnt*y>x)
                {
                    cost+=x;
                }
                else
                {
                    cost+=cnt*y;
                    distinctNumbers.put(h,1);//add decremented number to list
                }
            }
            else
            {
            	distinctNumbers.put(h,1);
            }
        }
        System.out.println(cost);
    }
}