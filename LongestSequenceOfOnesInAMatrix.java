/* 09/07/2020 - HOME
 * 
 * REFERENCE LEETCODE 562
 * Input Format:
-------------
Line-1 -> two integers r and c
Next r lines -> contains c integers, only 0's and 1's

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
3 4
0 1 1 0
0 1 1 0
0 0 0 1

Sample Output-1:
----------------
3


 */
package Elite;
import java.util.*;
public class LongestSequenceOfOnesInAMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int arr[][] = new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int dp[][][] = new int[rows][cols][4];
		int ans = arr[0][0];
		dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = dp[0][0][3] = arr[0][0];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(arr[i][j] == 1) {
					dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = dp[i][j][3] = 1;
					if (i > 0 && j > 0) {
	                    dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
	                }
					if (i > 0) {
	                    dp[i][j][1] = dp[i - 1][j][1] + 1;
	                }
	                if (j > 0) {
	                    dp[i][j][0] = dp[i][j - 1][0] + 1;
	                }
	                
	                if (j + 1 < arr[0].length && i > 0) {
	                    dp[i][j][3] = dp[i - 1][j + 1][3] + 1;
	                }
	                ans = Math.max(ans, Math.max(dp[i][j][0], dp[i][j][1]));
	                ans = Math.max(ans, Math.max(dp[i][j][2], dp[i][j][2]));	
				}	
			}
		}
		System.out.println(ans);
	}
}