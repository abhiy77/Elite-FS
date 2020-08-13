/* 12/03/2020
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, 
 where in each step you can delete one character in either string.

Example 1:
Input:sea
eat
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */
package Elite;
import java.util.*;
public class DeleteCharactersForStringEquality {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int m = str1.length(),n = str2.length();
		int dp[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i == 0 || j == 0) dp[i][j] = 0;
				else {
					if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
					else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(m+n-2*dp[m][n]);
	}
}