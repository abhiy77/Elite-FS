/* 22/09/2020 - (ELITE DAY - 124)
 * 
You have two sets of candles with different heights, P and Q.
And kept the candles in two parallel lines.

Now, you can swap one candle at a time, from P and Q and 
the position of the candles in their line should be same.

At the end of the swaps, The candles in set P and set Q, 
should be in ascending order of their heights.

You will be given P and Q, after placing in parallel lines.
Your task is to find the minimum number of swaps required
to arrange the candles in P and Q in ascending orer.

Note: It is guaranteed that the answer is always possible.

Input Format:
-------------
Line-1: An integer N, num of candles in P and Q.
Line-2: N space separated integers, heights of the candles in Line-P.
Line-3: N space separated integers, heights of the candles in Line-Q.

Output Format:
--------------
Print an integer, minimum number of swaps required.


Sample Input-1:
---------------
4
1 3 5 4
1 2 3 7

Sample Output-1:
----------------
1

Explanation:
------------
Swap the 4th candle in P and Q. 
Then the heights of the candles in P = [1, 3, 5, 7],  Q = [1, 2, 3, 4]
Both are in ascending order.

*/
package Elite;
import java.util.*;

class MinimumSwaps {
    public int minSwap(int[] A, int[] B) {
        // n: natural, s: swapped
        int n1 = 0, s1 = 1;
        for (int i = 1; i < A.length; ++i) {
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
            if (A[i-1] < A[i] && B[i-1] < B[i]) {
                n2 = Math.min(n2, n1);                   
                s2 = Math.min(s2, s1 + 1);
            }
            if (A[i-1] < B[i] && B[i-1] < A[i]) {
                n2 = Math.min(n2, s1);
                s2 = Math.min(s2, n1 + 1);
            }
            n1 = n2;
            s1 = s2;
        }
        return Math.min(n1, s1);
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int A[]=new int[n];
		for(int i=0;i<n;i++)
			A[i]=sc.nextInt();
		int B[]=new int[n];
		
		for(int i=0;i<n;i++)
			B[i]=sc.nextInt();
		System.out.println(new MinimumSwaps().minSwap(A,B));		
	}
}