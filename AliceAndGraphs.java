/* 19/03/2020 - HOME
 * Alice likes to play with graphs a lot. Today he created a graph in the following way. 
He first lays down N nodes in a circle. The nodes are numbered from 1 to N, 
in the clockwise order, i.e. the node 1 is followed by 2, 2 is followed by 3, 
and N is followed by 1. Two vertices are said to be adjacent if they don't have 
an intermediate vertex placed between them. There is an edge between 
each adjacent pair of vertices, so there are total N such edges. 
Each edge has an integer associated with it (may be negative).

Alice wants to find a walk from node start to node end using the above described edges. 
Alice has to pay cost for each edge in the walk equal to the integer associated with the edge. 
He wants to minimize the total cost he will incur. 
Also, Alice does not like to move through an edge more than twice. 
Note that a walk from a node u to v can contain repeated vertices in it.

Find out minimum cost that Alice has to pay.


Input Format
------------
The first line contains a single integer N denoting the number of nodes.

The second line contains N space-separated integers R1, R2, ..., RN 
denoting the integer of the rib from node i to node (i % N) + 1. 
Note that RN is an integer on a rib from node N to node 1.

The third line contains two integers start and end 
denoting the first and the last node of the walk. 

Output Format
------------
output a single line containing the minimal possible cost Alice need to pay.

Example-1:
    Input:
        4
        1 2 1 1
        1 3
    Output:
        2
    
    Explanation:
        Alice's walk starts with node 1. He goes to node 4 by incurring a cost of 1. 
        Then from node 4, he goes to node 3 by incurring a cost of 1 more. 
        Total cost incurred is 2.

Example 2:
    Input:
        5
        -5 100 100 100 2
        1 5
    Output:
        -8
    
    Explanation:
        Alice goes from 1 to 2 by incurring a cost of -5. 
        Then from 2 to 1 using the edge 2nd time and incurring cost of -5 again. 
        Now, he can not use the edge between 1 and 2 again, 
        as he has traversed the edge already twice. 
        Now he will go from node 1 to node 4 by paying a cost of 2. 
        Total sum of costs incurred is -5 + -5 + 2 = -8. 
        This is the minimum possible cost that Alice can have.

 */
package Elite;
import java.util.*;
public class AliceAndGraphs {
	public static int min = Integer.MAX_VALUE;
	public static void findMinCostPath(int[] edges,int start,int end,int cost,int[] visited) {
		//if(start >= edges.length) return;
		System.out.println(start+" "+cost);
		if(start == end) {
			min = Integer.min(min, cost);
			return;
		}
		if(visited[start] < 2) {
			visited[start]++;
			findMinCostPath(edges, (start+1)%edges.length, end, cost+edges[start], visited);
			visited[start]--;
		}
		int temp = (start-1 <0 ? edges.length-1:start-1); 
		if(visited[temp] < 2) {
			visited[temp]++;
			findMinCostPath(edges,(start-1 <0 ? edges.length-1:start-1) , end, cost+edges[temp], visited);
			visited[temp]--;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int edges[] = new int[n];
		for(int i=0;i<n;i++) {
			edges[i] = sc.nextInt();
		}
		int start = sc.nextInt()-1;
		int end = sc.nextInt()-1;
		int visited[] = new int[n];
		findMinCostPath(edges, start, end, 0,visited);
		System.out.println(min);
	}
}