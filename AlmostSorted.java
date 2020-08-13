/* 14/05/2020 - HOME

You are working as the quality controller at Pearlpet plastic bottle factory. 
Each assembly line of the factory is always supposed to produce a set of bottles 
in ascending order of their heights. Sometimes there is a manufacturing defect and 
the bottles come out in a different order. 

You are allowed to do only ONE of the following corrections once. SWAP is prefered.
    a) Swap two bottles.
    b) Reverse one subsequence of bottles.


Input Format:
    - An integer N, indicates no of bottles
    - Next line contains N space seperated integers, h1,h2,h3,..hn 
      indicates heights of bottles 

Output Format:


Sample Input:
7
1 2 5 9 8 12 14
Sample Output:
swap 4 5 

Explanation:
( 1 based indexes)
In this case the swap is adequate (remember you are allowed only 1 correction)


Sample Input:
7
1 2 12 9 8 5 14
Sample Output:
reverse 3 6

NOTE:
If you cannot correct either with a single swap or reverse 
then you need to print "NOT POSSIBLE"




******Testcases***********

case =1
input =2
4 2
output ="swap 1 2"

case =2
input =3
3 1 2
output ="NOT POSSIBLE"

case =3
input =6
1 5 4 3 2 6
output ="reverse 2 5"

case =4
input =7
1 2 5 9 8 12 14
output ="swap 4 5"

case =5
input =7
1 2 12 9 8 5 14
output ="reverse 3 6"

case =6
input =9
1 2 3 8 5 6 7 4 9
output ="swap 4 8"

case =7
input =10
1 2 5 10 20 67 45 35 30 87
output ="reverse 6 9"

case =8
input =10
1 2 5 10 20 67 45 30 35 87
output ="NOT POSSIBLE"

*/
package Elite;
import java.util.*;

public class AlmostSorted{ // Almost sorted
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] input = new int[n];
    	int[] rightAnswer = new int[n];
    	for (int i = 0; i < n; i++) {
    		input[i] = sc.nextInt();
    		rightAnswer[i] = input[i];
    	}
    	Arrays.sort(rightAnswer);
    	ArrayList<Integer> misplacedNumberIndexes = new ArrayList<Integer>();
    	for (int i = 0; i < n; i++) {
    		if (input[i] != rightAnswer[i]) {
    			misplacedNumberIndexes.add(i);
    		}
    	}
    	int m = misplacedNumberIndexes.size();
    	if (m == 0) {
    		System.out.println("yes");
    		return;
    	}
    	if (m == 2) {
    		System.out.printf(
    			"yes\nswap %d %d\n",
    			misplacedNumberIndexes.get(0)+1,
    			misplacedNumberIndexes.get(1)+1
    		);
    		return;
    	}
    	int start = misplacedNumberIndexes.get(0);
    	int stop = misplacedNumberIndexes.get(m - 1);
    	int i = start;
    	int j = stop;
    	for (; i < j; i++, j--) {
    		int temp = input[i];
    		input[i] = input[j];
    		input[j] = temp;
    	}

    	boolean equality = true;
    	for (int r = 0; r < n; r++) {
    		if (input[r] != rightAnswer[r])
    			equality = false;
    	}

    	if (equality) {
    		System.out.printf(
    			"yes\nreverse %d %d\n",
    			misplacedNumberIndexes.get(0)+1, misplacedNumberIndexes.get(m-1)+1);
    	} else {
    		System.out.println("no");
    	}
    }
}