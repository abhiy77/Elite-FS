/* 04/05/2020 - HOME
 * Anna loves graph theory! She has a tree where each vertex is numbered from  to , and each contains a data value.

The sum of a tree is the sum of all its nodes' data values. If she cuts an edge in her tree, she forms two smaller trees. The difference between two trees is the absolute value between their sums.

Given a tree, determine which edge to cut so that the resulting trees have a minimal difference between them, then return that difference.
Input Format
    - The first line contains an integer N, the number of vertices in the tree.
    - The second line contains space-separated integers, 
      where each integer 'i' denotes the value of data[i].
    - Each of the N-1 subsequent lines contains two space-separated integers
    i and j, describing edge i<->j in tree T.

Output Format
A single line containing the minimum difference possible for tree T.


Sample Input:
8
10 20 30 40 50 60 70 80
1 2
2 3
2 4
3 5
3 6
4 7
4 8
Sample Output:
20
 */
package Elite;
import java.util.*;
public class CutTheTree {
	public static int min = Integer.MAX_VALUE,cost = 0;
	
	private static void findMinDifference(LinkedList<LinkedList<Integer>> adjList, int[][] invalid, int[] arr,boolean[] visited,int i,int source) {
		visited[source] = true;
		System.out.print(source + " ");
		LinkedList<Integer> temp = adjList.get(source);
		for(int item : temp) {
			if((invalid[i][0] == source && invalid[i][1] == item) || (invalid[i][0] == item && invalid[i][1] == source)) {
				continue;
			}
			else {
				if(!visited[item]) {
					cost += arr[item-1];
					findMinDifference(adjList, invalid, arr, visited, i, item);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int totalSum = 0;
		int invalid[][] = new int[n-1][2];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			totalSum += arr[i];
		}
		LinkedList<LinkedList<Integer>> adjList = new LinkedList<>();
		for(int i=0;i<n+1;i++) {
			adjList.add(new LinkedList<>());
		}
		for(int i=0;i<n-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjList.get(a).add(b);
			adjList.get(b).add(a);
			invalid[i][0] = a;
			invalid[i][1] = b;
		}
		for(int i=0;i<n-1;i++) {
			cost = arr[0];
			findMinDifference(adjList,invalid,arr,new boolean[n+1],i,1);
			System.out.println("Invalid arr " + invalid[i][0] + " " + invalid[i][1]);
			System.out.println("Cost in " + i + "th iteration "  + cost + "\n");
			int diff = Math.abs(totalSum - cost);
			min = Math.min(Math.abs(diff-cost), min);
		}
		System.out.println(min);
	}
}