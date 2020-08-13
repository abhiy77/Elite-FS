/* 23/03/2020 - HOME
 * 
Solve a given equation and return the value of x in the form of string "x=#value". 
The equation contains only '+', '-' operation, the variable x and its coefficient.

If there is no solution for the equation, return "No solution".

If there are infinite solutions for the equation, return "Infinite solutions".

If there is exactly one solution for the equation, we ensure that the value of x is an integer.

Example 1:
    Input: x+5-3+x=6+x-2
    Output: "x=2"

Example 2:
    Input: x=x
    Output: "Infinite solutions"

Example 3:
    Input: 2x=x
    Output: "x=0"

Example 4:
    Input: 2x+3x-6x=x+2
    Output: "x=-1"

Example 5:
    Input: x=x+2
    Output: "No solution"

=======Testcases Program-3=======
case =1
input =x+5-3+x=6+x-2
output ="x=2"

case =2
input =x=x
output ="Infinite solutions"

case =3
input	=2x=x
output ="x=0"

case =4
input =2x+3x-6x=x+2
output	="x=-1"

case =5
input =x=x+2
output ="No solution"

case =6
input =7x+5x-7=3x+8x-4
output ="x=3"

case =7
input =8x-7x+15x-9x=3x+5x+4
output ="x=-4"

case =8
input =8x-7x+15x-9x=2x+5x+4
output ="No solution"

case =9
input =x+34=7x-56x+44
output ="x=0"

case =10
input =x-x=x-x
output ="Infinite solutions"



 */
package Elite;
import java.util.*;
public class SolvingEquations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String temp[] = str.split("=");
		//System.out.println(Arrays.toString(arr));
		int arr1[] = getCount(temp[0]);
		int arr2[] = getCount(temp[1]);
		//System.out.println(Arrays.toString(getCount(temp[0])) + " " + Arrays.toString(getCount(temp[1])));
		if(arr1[0] == arr2[0]) {
			if(arr1[1] == arr2[1]) System.out.println("Infinite solutions");
			if(arr1[1] != arr2[1])System.out.println("No solution");
		}
		else if(arr1[1] == arr2[1] && arr1[0] !=arr2[0])System.out.println("0");
		else {
			System.out.println("x="+(arr2[1] - arr1[1])/(arr1[0] - arr2[0]));
		}
	}
	
	public static int[] getCount(String str) {
		int count = 0,count2=0;
		char op = '+';
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '+') {
				op = '+'; continue;
			}
			if(str.charAt(i) == '-') {
				op = '-'; continue;
			}
			StringBuffer sb = new StringBuffer();
			while(i < str.length() && str.charAt(i) != '+' && str.charAt(i) != '-' ) {
				sb.append(str.charAt(i));i++;
			}
			if(sb.toString().contains("x")) {
				sb.deleteCharAt(sb.toString().indexOf('x'));
				if(sb.length() == 0) sb.append(1);
				if(op=='+') {
					count += (Integer.valueOf(sb.toString()));
				}
				else count -= (Integer.valueOf(sb.toString()));
			}
			else {
				if(op=='+') {
					count2 += (Integer.valueOf(sb.toString()));
				}
				else count2 -= (Integer.valueOf(sb.toString()));
			}
			if(i == str.length()) break;
			i--;
		}
		return new int[] {count,count2};
	}
}
