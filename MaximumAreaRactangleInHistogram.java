/* 13/04/2020 - HOME
 * A histogram is a polygon composed of a sequence of rectangles aligned at a common base line.
For simplicity, assume that the rectangles have equal widths but may have different heights. 
For	example, the figure on the left shows a histogram that consists of rectangles 
with the heights 3, 2, 5, 6, 1, 4, 4, measuredin units where 1 is the width of the rectangles.

Here our problem is:given an array with heights of rectangles (assuming	width is 1),
we need to find the largest rectangle.
In below diagram, each line(|) indicates one small rectangle.

         |						 		 |
      |  |					          |==|
      |  |     |  |				      |==|     |  |
|     |  |     |  |				|     |==|     |  |
|  |  |  |     |  |			    |  |  |==|     |  |
|  |  |  |  |  |  |				|  |  |==|  |  |  |
3  2  5  6  1  4  4				3  2  5  6  1  4  4
Sample Input:
	7
	3 2 5 6 1 4 4
Sample Output:
	10

Explanation: 
Here using 5 and 6 rectangles. 
we can make maximum rectangle choosing height "5" from each rectangle.
so, 5*2 = 10. 

----------------------Testcases---------------------------

case =1
input =6
2 3 4 6 7 4
output =16

case =2
input =3
5 1 6
output =6

case =3
input =9
6 7 4 1 1 6 8 3 4
output =12

case =4
input =7
3 2 5 6 1 4 4
output =10

case =5
input =10
7 3 8 5 6 3 4 9 2 8
output =24

case =6
input =12
20 12 20 5 10 20 8 15 12 14 11 9
output =64

case =7
input =15
20 12 20 5 10 20 8 15 12 14 11 9 16 13 18
output =88

case =8
input =20
80 55 31 76 44 68 95 69 96 13 74 36 17 19 18 37 16 81 86 98
output =279

 */
package Elite;
import java.util.*;
public class MaximumAreaRactangleInHistogram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int maxArea = 0,i=0,num =0;
		Stack<Integer> stack = new Stack<>();
		for(i=0;i<arr.length;) {
			System.out.println(i + " " + stack + " " + maxArea);
			if(stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
				stack.push(i); i++;
			}
			else {
				num = stack.pop();
				int area = arr[num] * (stack.isEmpty() ? i : i - stack.peek()-1);
				maxArea = Math.max(maxArea, area);
			}
		}
		while(!stack.isEmpty()) {
			num = stack.pop();
			int area = arr[num] * (stack.isEmpty() ? i : i - stack.peek()-1);
			maxArea = Math.max(maxArea, area);
		}
		System.out.println(maxArea);
	}
}