/* 12/03/2020
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle.
 Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.
 
 If you are not able to form a rectangle based on array size, print -1,
 If you are not able to form a matrix based on array size, print -2.

Example 1:
	Input:4 5
	1 0 0 1 0
	0 0 1 0 1
	0 0 0 1 0
	1 0 1 0 1
	Output: 1
	Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 

Example 2:
	Input:3 3
	1 1 1
	1 1 1
	1 1 1
	Output: 9
	Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 

Example 3:
	Input: 1 4
	Output: -1
	Explanation: Rectangles must have four distinct corners.
 */
package Elite;
import java.util.*;
public class CornerRectangles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		if(m <= 0 || n <= 0) {System.out.println(-2); System.exit(1);}
		if(m == 1 || n == 1) {System.out.println(-1); System.exit(1);}
		int arr[][] = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int count = 0;
		for(int i=0;i<m-1;i++) {
			for(int j=i+1;j<m;j++) {
				int x = 0,y=0;
				int sum = 1;
				boolean flag = false;
				while(x < n) {
					if(!flag && arr[i][x] == 1 && arr[j][y] == 1) {
						x++;flag = true;
					}
					else if(flag) {
						if(arr[i][x] == 1 && arr[j][x] == 1) {
							count+=sum;sum++;
						}
						x++;
					}
					else {x++; y++;}
				}
			}
		}
		System.out.println(count);
	}
}