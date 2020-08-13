/* 12/03/2020
 * Given a matrix of m*n size, 
the task is to print its elements in diagonally pattern.

Sample Input:
3 3     //size of the array
1 2 3   //array
4 5 6
7 8 9

Sample Output: 
1 2 4 7 5 3 6 8 9

Explanation:

1-2 3 
 / /|
4 5 6
|/ /	  
7 8-9

NOTE: If it is not possible to create array with given size, print -1.
 */
package Elite;
import java.util.*;
public class PrintMatrixDiagonally {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		if(m <= 0 || n <= 0) {System.out.println(-1); System.exit(1);}
		int arr[][] = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int sum = 0;
		while(sum < m+n-1) {
			if(sum% 2 == 0) {
				for(int i=m-1;i>=0;i--) {
					for(int j =0;j<n;j++) {
						if(i+j  == sum)System.out.print(arr[i][j] + " ");
					}
				}
			}
			else {
				for(int i=0;i<m;i++) {
					for(int j =n-1;j>=0;j--) {
						if(i+j  == sum)System.out.print(arr[i][j] + " ");
					}
				}
			}
			sum++;
		}
	}
}