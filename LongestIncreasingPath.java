/* 17/02/2020
 * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. 
You may NOT move diagonally or move outside of the boundary 

Example 1:
	Input: 3
		9 9 4
		6 6 8
		2 1 1
	Output: 4 
	Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:
	Input: nums = 3
			3 4 5
			3 2 6
			2 2 1
	Output: 4 
	Explanation: The longest increasing path is [3, 4, 5, 6]. 
	Moving diagonally is not allowed.

 */
package Elite;
import java.util.*;
public class LongestIncreasingPath {

	static int max =0;
	public static void dfs(int[][] arr,int n,int count,int row,int col,int prev,boolean[][] visited) {
		//System.out.println("Count is " + count + "  arr["+row+"]["+col+"]");
		max = Math.max(max, count);	
			if(row+1 < n && arr[row][col] > arr[row+1][col] && visited[row+1][col] == false) {
				visited[row+1][col] = true;
				dfs(arr, n, count+1, row+1, col, arr[row][col], visited);
				visited[row+1][col] = false;
			}
			if(row-1 >=0 && arr[row][col]  > arr[row-1][col] && visited[row-1][col] == false) {
				visited[row-1][col] = true;
				dfs(arr, n, count+1, row-1, col, arr[row][col], visited);
				visited[row-1][col] = false;
			}
			if(col+1 <n && arr[row][col]  > arr[row][col+1] && visited[row][col+1] == false) {
				visited[row][col+1] = true;
				dfs(arr, n,count+1, row, col+1, arr[row][col], visited);
				visited[row][col+1] = false;
			}
			if(col-1 >=0 && arr[row][col]  > arr[row][col-1] && visited[row][col-1] == false) {
				visited[row][col-1] = true;
				dfs(arr, n, count+1, row, col-1, arr[row][col], visited);
				visited[row][col-1] = false;
			}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		boolean visited[][] = new boolean[n][n];

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				visited[i][j] = true;
				dfs(arr,n,1,i,j,-1,visited);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}
}