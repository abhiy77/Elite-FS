/* 02/07/2020 - HOME
 * Input Format:
-------------
Line-1 -> two integers R,C
Next R lines -> contains C space seperated integers, 0's and 1's only

Output Format:
--------------
Print R * C Matrix


Sample Input-1:
---------------
3 4
0 1 0 1
1 0 1 1
1 1 0 0

Sample Output-1:
----------------
0 1 0 1
1 0 0 1
1 1 1 0

 */
package Elite;
import java.util.*;
public class SadAndHappyNeighbours {
	
	public static int neighbourCount(int[][] arr,int i,int j) {
		int count = 0;
		if(i-1 >= 0 && j-1 >= 0 && (arr[i-1][j-1] == 1 || arr[i-1][j-1] == 2)) count++;
		if(i-1 >= 0 &&  (arr[i-1][j] == 1 || arr[i-1][j] == 2)) count++;
		if(i-1 >= 0 && j+1 < arr[0].length && (arr[i-1][j+1] == 1 || arr[i-1][j+1] == 2)) count++;
		if(j-1 >= 0 && (arr[i][j-1] == 1 || arr[i][j-1] == 2)) count++;
		if(j+1 < arr[0].length && (arr[i][j+1] == 1 || arr[i][j+1] == 2)) count++;
		if(i+1 < arr.length && j-1 >= 0 && (arr[i+1][j-1] == 1 || arr[i+1][j-1] == 2)) count++;
		if(i+1 < arr.length && (arr[i+1][j] == 1 || arr[i+1][j] == 2)) count++;
		if(i+1 < arr.length && j+1 < arr[0].length && (arr[i+1][j+1] == 1 || arr[i+1][j+1] == 2)) count++;
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int arr[][] = new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(arr[i][j] == 0) {
					if(neighbourCount(arr,i,j) == 3) {
						arr[i][j] = 3;
					}
				}
				else if(arr[i][j] == 1) {
					if(neighbourCount(arr, i, j) < 2 || neighbourCount(arr, i, j) > 3) {
						arr[i][j] = 2;
					}
				}
			}
		}
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print((arr[i][j] == 1 || arr[i][j] == 3 ? 1 : 0 ) + " ");
			}
			System.out.println();
		}
	}
}