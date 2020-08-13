/* 04/03/2020
 * Given a matrix of 2-Dimensional array of n rows and n columns. 
Print this matrix in snake fashion starting from column n-1 
as shown in the figure below.

Example:
    Input=  3
        1 2 3 
        4 5 6
        7 8 9
    Output= 3 2 1 4 5 6 9 8 7
    Explanation:
        1<-2<-3 
        |
        4->5->6
              |
        7<-8<-9

 */
package Elite;
import java.util.*;
public class MatrixSnakePrint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				int j = n-1;
				while(j >= 0) {
					System.out.print(arr[i][j--]+" ");
				}
			}
			else {
				int j = 0;
				while(j<=n-1) {
					System.out.print(arr[i][j++] + " ");
				}
			}
		}
	}
}
