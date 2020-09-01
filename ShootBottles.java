/* 01/09/2020 - (ELITE DAY 114)
 * 
 * You are playing a shooting game.
There are N bottles hanging to a rod, i-th bottle numbered bottle[i].

If you shoot i-th bottle, you will get bottle[i-1]*bottle[i]*bottle[i+1] points.
The more points you score, the more rewards you can win.

Your task is to score the maximum points by shooting all the ballons wisely.

Note: After you shoot bottle at i-th index, bottles at i-1 and i+1 positions
become adjacent. if there is no existing 'i-1' or 'i+1' positions for selected bottle.
you can assume that bottle[i-1] = bottle[i+1] = 1.

Input Format:
-------------
N space separated integers bottles[].

Output Format:
--------------
Print an integer, maximum points you can get.


Sample Input:
---------------
3 1 5 8

Sample Output:
----------------
167

Explanation:
------------
Given bottles = [3, 1, 5, 8] 
position 	points
--------------------
1				3*1*5
5				3*5*8
3				1*3*8
8				1*8*1
--------------------
Total = 167


Sample Input:
---------------
2 1 3 5 4

Sample Output:
----------------
102

Explanation:
------------
Given bottles = [3, 1, 5, 8] 
position 	points
--------------------
5				3*5*4
1				2*1*3
3				2*3*4
2				1*2*4
4				1*4*1
--------------------
Total = 102

 */
package Elite;
import java.util.*;

public class ShootBottles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int n = arr.length;
		if(n == 0)System.out.println(0);
		else {
			int dp[][] = new int[n][n];
			
			for(int len = 0;len < n;len++) {
				for(int i=0;i+len < n;i++) {
					int j = i+len;
					for(int k=i;k<=j;k++) {
						int leftBottle = (i == 0 ? 1 : arr[i-1]);
						int rightBottle = (j == n -1 ? 1 : arr[j+1]);
						
						int leftRec = (k == i ? 0 : dp[i][k-1]);
						int rightRec = (k == j ? 0 : dp[k+1][j]);
						
						dp[i][j] = Math.max(dp[i][j], (leftBottle * arr[k] * rightBottle) + leftRec + rightRec);
					}
				}
			}
			System.out.println(dp[0][n-1]);
		}
	}
}