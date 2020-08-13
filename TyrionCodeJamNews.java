/* 01/04/2020 - HOME
 * Tyrion has recently qualified for Google's CodeJAM, 
and he can't keep his excitement with himself and share this news with 'K' of his friends.

One day Scrolling on Instagram Tyrion find a quote written :
 "The more the people knows, the more is the chances of FAILURE.", 
Now reading this he is scared and fears what if it will become true. 
However, he is well prepared for Google's CodeJAM even though he wants to 
find the number of peoples who had by now known the news.

Tyrion knows his friends and his friends friend (and so on) very well, 
he knows that his friends will share this news to every friend who has friendship strength ≤ 'S'.

You are given the graph representing the friendship and the friendship strength, 
find the number of peoples who knows this news. 

The graph can also be disconnected.

Input Format:
------------
    1st line:
    N M (N = No of total friends, M = total no of friendship bonds)
    Next M Lines contains 3 integers: a,b,c representing a and b are both friends with friendship strength of c.
    K S (K = no of friends with whom Tyrion shared the news, S = Friendship strength)
    Next K space separated integers representing the friends whom Tyrion shared the news.
    k1,k2.....kk.
    
    
Output Format:
--------------
    Single Integer representing the number of friends who by now knows a news.


Constraints
-----------
1≤a,b≤N,
Ki ≤ N

Sample Input:
        5 5
        1 2 6
        1 3 3
        2 3 2
        3 4 6
        3 5 5
        2 5
        1 5

Sample Output:
        4

QUICK EXPLANATION:
-----------------
    Run a DFS from each reachable node. 
    If any neighbour has edge weight ≤S, 
    it is reachable and run a DFS from it. 
    Maintain a visited array so that you visit each node utmost once. 
    Print the number of nodes that were visited.
 */
package Elite;
import java.util.*;
public class TyrionCodeJamNews {
	
	private static void findPaths(LinkedList<LinkedList<Integer>> adjList, int source, boolean[] visited,int friends) {
		visited[source] = true;
		LinkedList<Integer> list = adjList.get(source);
		for(int i=0;i<list.size();i++) {
			if(!visited[list.get(i)]) {
				findPaths(adjList, list.get(i), visited, friends);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int friends = sc.nextInt();
		int bonds = sc.nextInt();
		LinkedList<LinkedList<Integer>> adjList = new LinkedList<>();
		for(int i=0;i<friends;i++) {
			adjList.add(new LinkedList<>());
		}
		int arr[][] = new int[bonds][3]; 
		for(int i=0;i<bonds;i++) {
			arr[i][0] = sc.nextInt()-1;
			arr[i][1] = sc.nextInt()-1;
			arr[i][2] = sc.nextInt();
		}
		int sharedTo = sc.nextInt();
		int power = sc.nextInt();
		for(int i=0;i<arr.length;i++) {
			if(arr[i][2] <= power) {
				adjList.get(arr[i][0]).add(arr[i][1]);
				adjList.get(arr[i][1]).add(arr[i][0]);
			}
		}
		boolean visited[] = new boolean[friends];
		for(int i =0;i<sharedTo;i++) {
			findPaths(adjList,sc.nextInt()-1,visited,friends);
		}
		int count = 0;
		for(int i = 0;i<visited.length;i++) {
			if(visited[i]) count++;
		}
		System.out.println(count);
	}
}