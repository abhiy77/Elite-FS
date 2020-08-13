/* 19/03/2020 - HOME
 * Sundar works in a farm belongs to Mr.Vikas Oberoi. 
On the occasion Sundar's Birthday, Mr Vikas Oberoi planned to give a gift to Sundar. 

Mr.Vikas Oberoi offered all the fruits that Sundar can collects in one go 
from the right side of the farm returning back to the same side, 
such that he can take exactly 2 left turns. 

Sundar can start plucking from any cell A[i][N] where 1 <=i <= N. 
The farm is represented as a 2D matrix, each cell consisting of some units of fruit.

Sundar wants to collect as much amount of fruits as possible,
but he is illiterate, so he needs your help to get more fruits.

Please refer to the image below for more clarification on how to traverse the farm. 

Input Format
------------
first line consists of 2 space separated integers N and M, 
denoting the dimension of the farm.
The next N lines consist of M space separated integers 
each denoting the amount of dragon fruit in the cell.

Output Format
-------------
Output a single integer denoting the maximum amount of fruit Sundar could collect.

Sample-1:
    Input:
        3 3
        1 2 3
        3 3 1
        4 1 6
    Output:
        20

    Explanation:
		1<-2<-3
		|
		3 3 1
		|
		4->1->6
    Sundar starts from "3" and takes 1st left turn at "1" and takes 
    2nd left turn at "4" and reaches "6".
    so, the number of fruits he collects is 3 + 2 + 1 + 3 + 4 + 1 + 6 = 20



Sample-2:
    Input:
        3 3
        3 7 4
        1 9 6
        1 7 7
    Output:
        34
    
    Explanation:
		3 7<-4
		  |
		1 9 6
		  |
		1 7->7
    Sundar starts from "4" and takes 1st left turn at "7" and takes 
    2nd left turn at "7" and reaches "7".
    so, the number of fruits he collects is 4 + 7 + 9 + 7 + 7 = 34

 */
package Elite;
import java.util.*;
public class CollectFruitsWith2LeftTurns {

	public static int max = Integer.MIN_VALUE;
	
	public static void maxFruitCombination(int[][] arr,int m,int n,int cost,int i,int j,int turns,boolean[][] visited) {
		if(turns == 2 && j ==n-1) {
			max = Integer.max(max, cost+arr[i][j]);
			return;
		}
		if(turns == 0) {
			if(j-1 >=0 && !visited[i][j-1]) {
				visited[i][j-1] = true;
				maxFruitCombination(arr, m, n, cost+arr[i][j], i, j-1, turns,visited);
				visited[i][j-1] = false;
			}
			if(i+1 < m && !visited[i+1][j]) {
				visited[i+1][j] = true;
				maxFruitCombination(arr, m, n, cost+arr[i][j], i+1, j, turns+1,visited);
				visited[i+1][j] = false;
			}
		}
		if(turns == 1) {
			if(i+1 < m && !visited[i+1][j]) {
				visited[i+1][j] = true;
				maxFruitCombination(arr, m, n, cost+arr[i][j], i+1, j, turns,visited);
				visited[i+1][j] = false;
			}
			if(j+1 < n && !visited[i][j+1]) {
				visited[i][j+1] = true;
				maxFruitCombination(arr, m, n, cost+arr[i][j], i, j+1, turns+1,visited);
				visited[i][j+1] = false;
			}
		}
		if(turns == 2 && j != n-1) {
			visited[i][j+1] = true;
			maxFruitCombination(arr, m, n, cost+arr[i][j], i, j+1, turns, visited);
			visited[i][j+1] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int arr[][] = new int[m][n];
		boolean visited[][] = new boolean[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<m;i++) {
			visited[i][n-1] = true;
			maxFruitCombination(arr, m, n,0,i,n-1,0,visited);
			visited[i][n-1] = false;
		}
		System.out.println(max);
	}
}