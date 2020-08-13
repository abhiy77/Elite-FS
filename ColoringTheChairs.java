/* 22/01/2020
 * There are a row of n chairs, each chair can be painted with 
one of the three colors: red, blue or green. 

The cost of painting each chair with a certain color is different. 
You have to paint all the chairs such that no two adjacent chairs have the same color.

The cost of painting each chair with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting chair 0 with color red; 
costs[1][2] is the cost of painting chair 1 with color green, and so on... 
Find the minimum cost to paint all chairs.

Note:
All costs are positive integers.

Example:

Input=	3
			17 2 17
			16 16 5
			14 3 19
Output= 10
Explanation: Paint chair 0 into blue, paint chair 1 into green, paint chair 2 into blue. 
 Minimum cost: 2 + 5 + 3 = 10.

 */
package Elite;
import java.util.*;
public class ColoringTheChairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int chairs = sc.nextInt();
		int arr[][] = new int[chairs][3];
		for(int i=0;i<chairs;i++) {
			for(int j=0;j<3;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=1;i<arr.length;i++) {
			arr[i][0] += Math.min(arr[i-1][1],arr[i-1][2]);
			arr[i][1] += Math.min(arr[i-1][0],arr[i-1][2]);
			arr[i][2] += Math.min(arr[i-1][0],arr[i-1][1]);
		}
		int len = arr.length -1;
		System.out.println(Math.min(arr[len][0],Math.min(arr[len][1], arr[len][2])));
	}
}
