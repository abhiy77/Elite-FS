/* 22/04/2020 - HOME
 * You are given an integer N. Can you find the least positive integer X 
made up of only 9's and 0's, such that, X is a multiple of N?
Note:
X is made up of "one or more occurences of 9" and "zero or more occurences of 0".

Input Format:
An integer N for which the solution has to be found.

Output Format:
Print the answer X. The output should not contain any leading zeroes.

Constraints:
1 <= N <= 500

Sample Input1:
5
Sample Output1:
90
Explanation1:
90 is the smallest number made up of 9's and 0's divisible by 5. Similarly, 
you can derive for other cases.

Sample Input2:
7
Sample Output2:
9009

Sample Input3:
1
Sample Output3:
9

========= Testcases Program-1 =========
case =1
input =5
output =90

case =2
input =7
output =9009

case =3
input =1
output =9

case =4
input =11
output =99

case =5
input =34
output =999090

case =6
input =47
output =90099

case =7
input =22
output =990

case =8
input =67
output =9909099
 */
package Elite;
import java.util.*;
public class MultipleOfANumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = 9;
		int iterations = 0;
		Queue<String> queue = new LinkedList<>();
		queue.add("9");
		while(iterations < 1000) {
			String temp = queue.poll();
			if(Integer.parseInt(temp) % n == 0) {
				x = Integer.parseInt(temp);
				break;
			}
			else {
				queue.add(temp + "0");
				queue.add(temp + "9");
			}
		}
		System.out.println(x);
	}
}