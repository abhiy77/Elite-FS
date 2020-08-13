/* 27/03/2020 - HOME
 * Write a program to interchange the middle row and middle column  elements of a matrix .
Accept the number of rows and columns of the matrix from the user
if the matrix is not a square matrix print -1.
*assume it is odd dimensions matrix. 

Sample input:
5 5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25

Sample Output:
1 2 11 4 5 
6 7 12 9 10 
3 8 13 18 23 
16 17 14 19 20 
21 22 15 24 25 

 */
package Elite;
import java.util.*;
public class MiddleRowColumnExchangeMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		if(m!= n)System.out.println(-1);
		else {
			int arr[][] = new int[m][n];
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int x = m/2, y = n/2;
			for(int i=0;i<m;i++) {
				int temp = arr[x][i];
				arr[x][i] = arr[i][y];
				arr[i][y] = temp;
			}
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}	
}