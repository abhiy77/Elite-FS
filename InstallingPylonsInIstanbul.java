/* 24/03/2020 - HOME
 * The city of Istanbul is represented as an n*m matrix, where rows and columns start with index 1.

Istanbul has a network of road ways that always run in straight horizontal lines along a row. 
In other words, the start and end points of a road way are (r,c1) and (r,c2), 
where r represents the row number, c1 represents the starting column, 
and c2 represents the ending column of the road way.

The mayor of Istanbul is surveying the city to determine the number of locations 
where pylons can be placed. A pylon can be placed in any cell that is not occupied by a road way.

Given a map of Istanbul and its k road ways, 
find and print the number of cells where the mayor can place pylons.

Input Format
The first line contains three space-separated integers n,m and k, 
	- the number of rows, columns and ways to be mapped.
Each of the next  lines contains three space-separated integers, r,c1 and c2, 
	- the row number and the way column start and end.

Output Format
Print a single integer denoting the number of cells where the mayor can install pylons.

Sample-1:
Input
    4 4 3
    2 2 3
    3 1 4
    4 4 4
Output
    9

Sample-2:
Input
    8 7 5
    1 4 7
    3 2 6
    8 1 5
    3 2 5
    7 2 6
Output
    37

Note: A road way may overlap other road ways within the same row.

 */
package Elite;
import java.util.*;
public class InstallingPylonsInIstanbul {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int arr[][] = new int[n][m];
		for(int i=0;i<k;i++) {
			int row = sc.nextInt()-1;
			int col1 = sc.nextInt()-1;
			int col2 = sc.nextInt()-1;
			for(int j=col1;j<=col2;j++) {
				arr[row][j] = 1;
			}
		}
		int count = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j] == 0)count++;
			}
		}
		System.out.println(count);
	}
}