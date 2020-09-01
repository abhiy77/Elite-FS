/* 01/09/2020 - (ELITE DAY 114)
 * 
 * Amith decided go on a holiday trip. 
Given a map of N holiday spots numbered 0,1,2,.. N-1, map shows the connecting routes
between the holiday sopts, the routes are bidirectional, and
the connecting routes are indicates as routes[i] = [from , to , distance ]. 
He can travel only a certian distance D.

Your task is to find the holiday spot H with the smallest number of holiday spots
that are reachable from H and whose distance is at most D, 

If there are multiple holiday spots, return H with the greatest number.


Input Format:
-------------
Line-1 -> Three integers, N number of holiday spots, R is the number of connecting routes
          and D is the distance can travel.
Next R lines -> Three space separated integers, from , to and distance.

Output Format:
--------------
Print an integer, holiday spot.


Sample Input-1:
---------------
4 4 4
0 1 3
1 2 1
1 3 4
2 3 1

Sample Output-1:
----------------
3


Explanation:
------------
Distance can travel= 4,

From			Reachable sopts
-------------------------------------
Holiday-spot 0 -> [Holiday-spot 1, Holiday-spot 2] 
Holiday-spot 1 -> [Holiday-spot 0, Holiday-spot 2, Holiday-spot 3] 
Holiday-spot 2 -> [Holiday-spot 0, Holiday-spot 1, Holiday-spot 3] 
Holiday-spot 3 -> [Holiday-spot 1, Holiday-spot 2] 

Holiday-spots 0 and 3 have 2 reachable Holiday-spots at a distance = 4, 
but we have to return Holiday-spot 3 since it has the greatest number.


Sample Input-2:
---------------
5 6 2
0 1 2
0 4 8
1 2 3
1 4 2
2 3 1
3 4 1

Sample Output-2:
----------------
0

Explanation:
------------
Distance can travel= 2,

From			Reachable sopts
-------------------------------------
Holiday-spot 0 -> [Holiday-spot 1] 
Holiday-spot 1 -> [Holiday-spot 0, Holiday-spot 4] 
Holiday-spot 2 -> [Holiday-spot 3, Holiday-spot 4] 
Holiday-spot 3 -> [Holiday-spot 2, Holiday-spot 4]
Holiday-spot 4 -> [Holiday-spot 1, Holiday-spot 2, Holiday-spot 3]

Holiday-spots 0 has 1 reachable Holiday-spot at a distance = 2, 

 */
package Elite;
import java.util.*;

public class HolidaySpots {
	
	public static int INF = 10000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int spots = sc.nextInt();
		int routes = sc.nextInt();
		int distance = sc.nextInt();
		
		int arr[][] = new int[spots][spots];
		
		for(int a[] : arr) {
			Arrays.fill(a, INF);
		}
		
		for(int i=0;i<arr.length;i++) {
			arr[i][i] = 0;
		}
		
		for(int i=0;i<routes;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dist = sc.nextInt();
			arr[x][y] = dist;
			arr[y][x] = dist;
		}
		
		for(int k=0;k<spots;k++) {
			for(int i=0;i<spots;i++) {
				for(int j=0;j<spots;j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		int idx = 0;
		int minRoutes = Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			int count = 0;

			for(int j=0;j<arr[0].length;j++) {
				if(i == j)continue;
				if(arr[i][j] <= distance) {
					count++;
				}
			}

			if(minRoutes >= count) {
				minRoutes = count;
				idx = i;
			}
		}
		System.out.println(idx);
	}
}