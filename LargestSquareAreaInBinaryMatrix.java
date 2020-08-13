/* 18/02/2020
 * Given a 2D binary matrix filled with 0's and 1's, 
find the largest square containing only 1's  and return its area.

Example:
    Input: 4
    5
    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0
    Output: 4
*/
package Elite;
import java.util.*;
public class LargestSquareAreaInBinaryMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int input[][] = new int[rows][cols];
		int dp[][] = new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				input[i][j] = sc.nextInt();
				if(i==0 || j==0) dp[i][j] = input[i][j];
			}
		}
		int max = 0;
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
                    if(input[i][j] == 1) {
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
					max = Math.max(dp[i][j], max);
				}
				
			}
		}
	    System.out.println(max*max);		
	}
}