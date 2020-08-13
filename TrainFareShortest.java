/* 13/05/2020 - HOME
 * Given below are the fares between various stations. 
The first line gives the number of stations and number of connections between them.

Find the smallest cost from the first station to the last station.

Input Format:
    - 1st line contains two space-separated integers S and C, 
      the number of stations and the number of connections between them.
    - Each of the next C lines contains three space-separated integers F and T, W
      the starting and ending stations that are connected and the fare between them.

Output Format:
    - An integer, smallest cost from the first station to the last station. 
     If the last station cannot be reached from first station , print -1.
     
Sample Input:
4 4
1 2 20
1 3 5
2 4 30
3 4 40

Sample Output:
45
 */
package Elite;
import java.util.*;

public class TrainFareShortest {

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
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[0][i] = Math.min(arr[0][i], arr[0][j] + arr[j][i]);
			}
		}
		System.out.println(arr[0][n-1] == 1_000_000 ? -1 : arr[0][n-1]);
	}
}