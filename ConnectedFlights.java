/* 01/04/2020 - HOME
 * 
There are n cities connected by m flights. 
Each fight starts from city u and arrives at v with a price w.

Now given all the cities and flights, 
together with starting city src and the destination dst, 
your task is to find the cheapest price from src to dst with up to k stops. 
If there is no such route, output -1.

Note:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.


Sample Input 1: 
        3 3
        0 1 100
        1 2 100
        0 2 500
        0 2 1

Sample Output 1: 
        200

Explanation: 
The graph looks like this:
	       0
	  100 / \ 500
	     /	 \
	    1-----2
	      100
The cheapest price from city 0 to city 2 with at most 1 stop costs 200.

Sample Input 2: 
        3 3
        0 1 100
        1 2 100
        0 2 500
        0 2 0

Sample Output 2: 
        500

Explanation: 
The graph looks like this:
	       0
	  100 / \ 500
	     /	 \
	    1-----2
	      100

The cheapest price from city 0 to city 2 with at most 0 stop costs 500.

 */
package Elite;
import java.util.*;
public class ConnectedFlights {
	public static int min = Integer.MAX_VALUE;
	
	public static void findMinDistance(int source,int dest,int[][] arr,boolean[] visited,int curr,int stops,int cost) {
		if(curr > stops) return;
		if(source == dest) {
			min = Integer.min(min, cost);
			return;
		}
		for(int i = 0;i<arr[source].length;i++) {
			if(arr[source][i] != 1000000 && !visited[i]) {
				visited[i] = true;
				findMinDistance(i, dest, arr, visited, curr+1, stops, cost+arr[source][i]);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cities = sc.nextInt();
		int flights = sc.nextInt();
		int arr[][] = new int[cities][cities];
		for(int a[] : arr) {
			Arrays.fill(a, 1000000);
		}
		for(int i = 0;i<flights;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int cost = sc.nextInt();
			arr[x][y] = cost;
			arr[y][x] = cost;
		}
		int source = sc.nextInt();
		int dest = sc.nextInt();
		int stops = sc.nextInt();
		boolean visited[] = new boolean[cities];
		visited[source] = true;
		findMinDistance(source, dest, arr,visited , -1, stops,0);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}