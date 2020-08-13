/* 15/04/2020 - HOME
 * 
Madison, is a little girl who is fond of toys. 
Her friend Mason works in a toy manufacturing factory . 
Mason has a 2D board A of size H*W with H rows and W columns. 
The board is divided into cells of size 1*1 with each cell indicated by it's coordinate (i, j). 
The cell (i,j) has an integer Aij written on it.
To create the toy Mason stacks  number of cubes of size 1*1*1 on the cell (i, j).

Given the description of the board showing the values of Aij and 
that the price of the toy is equal to the 3d surface area find the price of the toy.

NOTE: ******For description look in Testcases document.******

Input Format:
	- The first line contains two space-separated integers H and W the height and the width of the board respectively.
	- The next H lines contains W space separated integers. 
	  The jth integer in ith line denotes Aij.

Output Format:
	- Print the required answer, i.e the price of the toy, in one line.

Sample Input-1
1 1
1
Sample Output-1
6
Explanation-1
For diagram look at Testcases Doc.
So, The surface area of 1*1*1 cube is 6.

Sample Input-2
3 3
1 3 4
2 2 3
1 2 4
Sample Output-2
60

Explanation-2
For diagram look at Testcases Doc.


========= Testcases Program-1 =========
case =1
input =4 4
4 4 4 4
4 4 4 4
4 4 4 4
4 4 4 4
output =96

case =2
input =4 4
1 2 3 4
1 2 3 4
1 2 3 4
1 2 3 4
output =84

case =3
input =5 4
87 8 93 2
97 32 48 95
37 26 48 7
9 84 57 43
98 34 50 9
output =2236

case =4
input =	4 3
2 3 4
7 3 4
9 4 6
2 3 1
output =114

case =5
input =3 3
1 3 4
2 2 3
1 2 4
output =60


case =6
input =1 1
1
output =6

case =7
input =1 10
91 80 7 41 36 11 48 57 40 43
output =1276

case =8
input =10 1
51
32
28
49
28
21
98
56
99
77
output =1482

 */
package Elite;
import java.util.*;
public class ThreeDSurfaceArea {

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
		int surfaceArea = 2 * rows * cols;
		int i=0,j=0;
		for(j=0;j<cols;j++) {
			i=0;
			int temp = arr[i][j];
			surfaceArea += temp;
			for(i=1;i<rows;i++) {
				if(temp < arr[i][j]) {
					surfaceArea += (arr[i][j] - temp);
				}
				temp = arr[i][j];
			}
		}
		
		for(j=0;j<cols;j++) {
			i=rows-1;
			int temp = arr[i][j];
			surfaceArea += temp;
			for(i=rows-2;i>=0;i--) {
				if(temp < arr[i][j]) {
					surfaceArea += (arr[i][j] - temp);

				}
				temp = arr[i][j];
			}
		}
		
		for(i=0;i<rows;i++) {
			j=0;
			int temp = arr[i][j];
			surfaceArea += temp;
			for(j = 1;j<cols;j++) {
				if(temp < arr[i][j]) {
					surfaceArea += (arr[i][j] - temp);
				}
				temp = arr[i][j];
			}
		}

		for(i=0;i<rows;i++) {
			j=cols-1;
			int temp = arr[i][j];
			surfaceArea += temp;
			for(j = cols-2;j>=0;j--) {
				if(temp < arr[i][j]) {
					surfaceArea += (arr[i][j] - temp);
				}
				temp = arr[i][j];
			}
		}
		
		System.out.println(surfaceArea);
	}
}