/* 28/08/2020 - (ELITE DAY 113)
 * 
 * Given a bunch of baskets in a row, each basket contains few fruits in it.
You can select K number of baskets, one after other.
The selection of basket is either from beginning or from the end the row.

Return the maximum number of fruits you have after K baskets collected.

Input Format:
-------------
Line-1 -> Two integers N and K, N is no of baskets and K is the basket count you can pick.
Line-2 -> N space separated integers fruits[], fruits in each basket.

Output Format:
--------------
Print an integer, Maximum num of fruits you can collect.


Sample Input-1:
---------------
7 3
1 2 3 4 5 6 1

Sample Output-1:
----------------
12


Sample Input-2:
---------------
5 3
2 2 2 2 2

Sample Output-2:
----------------
6

 */
package Elite;
import java.util.*;

public class SatelliteStations {
	
	public static int LIMIT = 100000000;
	
	public static int findMinDist(int minCost[],boolean visited[]) {
		int minVal = Integer.MAX_VALUE;
		int minIndex = 0;
		
		for(int i=0;i<minCost.length;i++) {
			if(!visited[i] && minVal > minCost[i]) {
				minVal = minCost[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt()-1;
		int edges = sc.nextInt();
		int arr[][] = new int[n][n];
		for(int x[] : arr) {
			Arrays.fill(x,LIMIT);
		}
		
		for(int i=0;i<edges;i++) {
			int x = sc.nextInt() -1;
			int y = sc.nextInt() - 1;
			int cost = sc.nextInt();
			
			arr[x][y] = cost;
		}

		int minCost[] = new int[n];
		Arrays.fill(minCost,Integer.MAX_VALUE);
		minCost[k] = 0;
		boolean visited[] = new boolean[n];
		
		for(int i=0;i<n-1;i++) {
			int x = findMinDist(minCost,visited);
			visited[x] = true;
			
			for(int y=0;y<arr[x].length;y++) {
				if(!visited[y] && minCost[x] != Integer.MAX_VALUE && arr[x][y] != LIMIT) {
					minCost[y] = Math.min(minCost[y],minCost[x] + arr[x][y]); 
				}
			}
		}
		int max = 0;
		int flag = 0;
		
		
		for(int i=0;i<minCost.length;i++) {
			if(i == k)continue;
			if(minCost[i] == Integer.MAX_VALUE) {
				flag = 1;
				break;
			}
			max = Math.max(max, minCost[i]);
		}
		System.out.println(flag == 0 ? max : -1);
	}
}