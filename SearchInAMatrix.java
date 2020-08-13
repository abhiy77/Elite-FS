/* 18/02/2020
 * Write an efficient algorithm that searches for a value in an m x n matrix. 

This matrix has the following properties:
    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.
    
Example-1:
    input= 5 5      //m rows and n column size of matrix
    1  4  7 11 15     
    2  5  8 12 19
    3  6  9 16 22
    10 13 14 17 24
    18 21 23 26 30
    5               //last line, target.
    output=true

Example-2:
    input= 5 5
    1 4 7 11 15
    2 5 8 12 19
    3 6 9 16 22
    10 13 14 17 24
    18 21 23 26 30
    20
    output=false.

 */
package Elite;
import java.util.*;
public class SearchInAMatrix {

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
		int target = sc.nextInt();
		for(int i=0,j=0;i<rows && j<cols;i++,j++) {
			if(arr[i][j] == target) {
				System.out.println(true);
				System.exit(1);
			}
			if(arr[i][cols-1] < target) {
				if(Arrays.binarySearch(arr[i],i,rows,target)> 0) {
					System.out.println(true);
					System.exit(1);
				}
			}
			if(arr[rows-1][j] < target) {
				int temp[] = new int[rows-i];
				for(int k=0;k<rows;k++) {
					temp[k] = arr[k+i][j];
				}
				if(Arrays.binarySearch(temp,target)> 0) {
					System.out.println(true);
					System.exit(1);
				}

			}
		}
		System.out.println(false);
	}
}