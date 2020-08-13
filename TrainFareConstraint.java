/* 13/05/2020 - HOME
 * 
 */
package Elite;
import java.util.*;

public class TrainFareConstraint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int paths = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int temp[] : arr) {
			Arrays.fill(temp, 1_000_000);
		}
		for(int i=0;i<paths;i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int cost = sc.nextInt();
			arr[x][y] = cost;
			arr[y][x] = cost;
		}
		int maxCost = -1;
		for(int i=1;i<n;i++) arr[0][i] = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[0][i] >=  arr[0][j] + arr[j][i]) {
					arr[0][i] = arr[0][j] + arr[j][i];
					maxCost = Math.max(maxCost, arr[j][i]);
				}
				//arr[0][i] = Math.min(arr[0][i], arr[0][j] + arr[j][i]);
			}
		}
		System.out.println(arr[0][n-1] == 1_000_000 ? -1 : maxCost);
	}
}