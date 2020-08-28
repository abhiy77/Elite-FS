/* 28/08/2020 - (ELITE DAY 113)
 * 
 * Mounika is creating the binary strings using P 1's and Q 0's.
A binary string contains only 0's and 1's.
She has given a list of binary strings binStr[] to be formed.

Her task is to find, the maximum number of binary strings can be formed, 
with given P 1's and Q 0's only. She cannot use any more 1's or 0's.

Input Format:
-------------
Line-1 -> A single line of space separated binary strings, binStr[].
Line-2 -> Two integers P and Q, P number of 1's and Q number of 0's


Output Format:
--------------
Print an integer as output, maximum number of binary strings can be formed.


Sample Input-1:
---------------
10 0001 111001 1 0
3 5

Sample Output-1:
----------------
4

Explanation:
------------
She can form 4 strings by the using of 3 1's and 5 0's
strings are 10, 0001, 1, 0.


Sample Input-2:
---------------
10 1 0
1 1

Sample Output-2:
----------------
2

Explanation:
------------
She can form 2 strings by the using of 1 1's and 1 0's
strings are 1, 0.

 */
package Elite;
import java.util.*;

public class FormingBinaryStrings {
	
	public static int[] findOnesAndZeros(String str) {
		int o = 0,z=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '0')z++;
			else o++;
		}
		return new int[] {z,o};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String binStr[] = sc.nextLine().split(" ");
		int p = sc.nextInt();
		int q = sc.nextInt();
		
		int dp[][][] = new int[binStr.length+1][p+1][q+1];
		
		for(int i=1;i<=binStr.length;i++) {
			String str = binStr[i-1];
			int[] temp = findOnesAndZeros(str);
			for(int j=0;j<=p;j++) {
				for(int k=0;k<=q;k++) {
					if(j < temp[1] || k < temp[0]) {
						dp[i][j][k] = dp[i-1][j][k];
					}
					else dp[i][j][k] = Math.max(dp[i-1][j][k], 1 + dp[i-1][j-temp[1]][k - temp[0]]);
					
				}
			}
		}
		System.out.println(dp[binStr.length][p][q]);
	}
}