/* 30/04/2020 - HOME
 * 
Christy is interning at HackerRank. 
One day she has to distribute some chocolates to her colleagues. 
She is biased towards her friends and plans to give them 
more than the others. One of the program managers hears of this 
and tells her to make sure everyone gets the same number.

To make things difficult, she must equalize the number of chocolates in a series of operations. 
For each operation, she can give 1,2,or 5 chocolates to all but one colleague. 
Everyone who gets chocolate in a round receives the same number of pieces.

For example, assume the starting distribution is [1,1,5]. 
She can give 2 bars to the first two and the distribution will be [3,3,5]. 
On the next round, she gives the same two 2 bars each, 
and everyone has the same number: [5,5,5].

Given a starting distribution, calculate the minimum number of operations needed
so that every colleague has the same number of chocolates.

Input Format:
	- The first line contains an integer , the number of colleagues.
	- The second line contains  space-separated integers denoting the number of chocolates each colleague has.

Output Format
	- Print the minimum number of operations needed.

Sample Input
4
2 2 3 7
Sample Output
2

Explanation
Start with [2,2,3,7]
Add 1 to all but the 3rd element -> [3,3,3,8]
Add 5 to all but the 4th element -> [8,8,8,8]
Two operations were required.

Sample Input:
3
10 7 12
Sample Output:
3
Explanation:
Start with [10,7,12]
Add 5 to the first two elements -> [15,12,12]
Add 2 to the last two elements -> [15,14,14]
Add 1 to the last two elements -> [15,15,15]
Three operations were required.

========= Testcases Program-3 =========
case =1
input =3
10 7 12
output =3

case =2
input =4
2 2 3 7
output =2

case =3
input =8
15 27 8 9 10 6 13 11
output =16

case =4
input =12 18 19 24 21 6 13 11 20 13 15 16 20
output =33

case =5
input =5
27 18 19 24 21
output =8

case =6
input =10
15 27 8 9 10 2 7 6 13 11
output =25

case =7
input =15
15 27 8 9 10 2 7 12 18 19 24 21 6 13 11
output =45

case =8
input =12
3 4 5 6 9 8 2 7 11 10 12 1
output =22

 */
package Elite;
import java.util.*;

public class DistributingChocolates {
	
	public static int equal(int[] arr){
	    Arrays.sort(arr);
	    int min = arr[0];
	    int arrLen = arr.length;
	    int finalSolution = -1;
	    int subFinal;
	    int delta;
	    int[][] results = new int[arrLen][3];

	    for (int j = 0; j < 3; j++){
	        subFinal = 0;

	        for (int i = 0; i < arrLen; i++){
	            results[i][j] = 0;
	            delta = ( arr[i] - min ) + j;

	            while ( true ) {
	                if( delta >=5 ) {
	                    delta -= 5;
	                }else if( delta >=2 ) {
	                    delta -= 2;
	                }else if ( delta >= 1 ) {
	                    delta -= 1;
	                } else {
	                    break;
	                }
	                results[i][j]++;
	            }
	            subFinal += results[i][j];
	        }
	    //   System.out.println("Subfinal in " + j + "th iteration :" + subFinal);
	        if( finalSolution > subFinal || finalSolution < 0 ) finalSolution = subFinal;
	    }
	    return finalSolution;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		System.out.println(equal(arr));
	}
}