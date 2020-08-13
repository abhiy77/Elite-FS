/* 26/05/2020 - HOME
 * Input Format:
    - two space separated strings

Output Format:
    - print the length of longest common subsequence


Example 1:
    
    Input: abcde ace 
    Output: 3  
    Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

    Input: abc abc
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

    Input: abc def
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.

 */
package Elite;
import java.util.*;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int m = a.length();
		int n = b.length();

		int dp[][] = new int[m+1][n+1];
		
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i == 0 || j == 0) continue;
				if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println(dp[m][n]);
	}
}