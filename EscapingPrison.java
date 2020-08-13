/* 02/07/2020 - HOME
 * Input Format:
-------------
Line-1 -> two integers R,C
Next R lines -> contains C space seperated integers, [0, -1, -2] only

Output Format:
--------------
Print R * C Matrix


Sample Input-1:
---------------
3 4
0 -1 -2 -1
-1 -1 -2 -1
0 0 0 -1

Sample Output-1:
----------------
0 -1 2 -1
-1 -1 1 -1
0 0 0 -1


Sample Input-2:
---------------
4 4
0 -1 -2 -2
-2 -1 -2 -1
-2 -2 -2 -1
-2 -1 0 -2

Sample Output-2:
----------------
0 -1 3 4
1 -1 2 -1
2 2 1 -1
3 -1 0 1

 */
package Elite;
import java.util.*;

public class EscapingPrison {
	
	public static void recurse(int[][] arr,int i,int j,int steps,boolean visited[][]) {
		if(arr[i][j] == -2) {
			arr[i][j] = Math.min(Integer.MAX_VALUE, steps);
		}
		else if(arr[i][j] > 0) {
			arr[i][j] = Math.min(arr[i][j], steps);
		}
		if(i-1 >= 0 && !visited[i-1][j] && arr[i-1][j] != -1) {
			visited[i-1][j] = true;
			recurse(arr, i-1, j, steps+1, visited);
			visited[i-1][j] = false;
		}
		if(j+1 < arr[0].length && !visited[i][j+1] && arr[i][j+1] != -1) {
			visited[i][j+1] = true;
			recurse(arr, i, j+1, steps+1, visited);
			visited[i][j+1] = false;
		}
		if(i+1 < arr.length && !visited[i+1][j] && arr[i+1][j] != -1) {
			visited[i+1][j] = true;
			recurse(arr, i+1, j, steps+1, visited);
			visited[i+1][j] = false;
		}
		if(j-1 >= 0 && !visited[i][j-1] && arr[i][j-1] != -1) {
			visited[i][j-1] = true;
			recurse(arr, i, j-1, steps+1, visited);
			visited[i][j-1] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int arr[][] = new int[rows][cols];
		Queue<Gate> queue = new LinkedList<>();
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 0) queue.add(new Gate(i,j));
			}
		}
		for(Gate gate : queue) {
			recurse(arr,gate.x,gate.y,0,new boolean[rows][cols]);
		}
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class Gate{
	int x,y;
	Gate(int x,int y){
		this.x = x;
		this.y = y;
	}
}