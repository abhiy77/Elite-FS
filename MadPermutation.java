/* 11/07/2020 - HOME
 * REFERENCE - GEEKS FOR GEEKS DERANGEMENT
 * Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer result.

Note: result should be mod 1000000007

Sample Input-1:
---------------
2

Sample Output-1:
----------------
1


Sample Input-2:
---------------
3

Sample Output-2:
----------------
2

 */
package Elite;
import java.util.*;
public class MadPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n+1];
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 1;
		for(int i=3;i<=n;i++){
		    dp[i] = ((i-1) * (dp[i-1] + dp[i-2]))%1000000007;
		}
		System.out.println(dp[n]);
	}
}