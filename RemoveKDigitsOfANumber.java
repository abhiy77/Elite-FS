/* 03/04/2020 - HOME
 * 
Introduction to programming is considered as easiest subject among the students of first years 
(well ,usually). So they are not focusing much on lectures. When professor realises 
this he becomes very angry and plans to fail all the students of the batch.

He writes a very big number on the whiteboard and says : 
" This will be the minimum mark required to pass this course" . 
When students see this gigantic number written on the whiteboard most of them become 
pretty sure that they are going to fail this semester.

So the some of the students started trying to convince the professor to not do so. 
So the professor gives them a number K and says : 
" You can erase exactly K digits of the given number" .

Now students want to make this number as small as possible. 
So you being the second most intelligent student of the batch decide 
to solve the problem. Save the other students.

Input
The only line in the input contains one string denoting the number written on the whiteboard
and integer K.

Output
Output the minimum number you can make without any trailing zeroes.

a
Sample Input :
1023231 3

Sample output :
221

Explanation :
Need to remove 3 digits from the given number so 
First we need to remove starting 1 to take the advantage of preceeding zero which any way has no value being as first digit. 
So Number is 023231(23231)
Second Remove 3 Number becomes 2231
Third Remove 3 Number becomes 221

========= TestCases Prog-4 =========

case =1
input =4732801984 7
output =14

case =2
input =65487948914 7
output =4414

case =3
input =97987453193 8
output =193

case =4
input =978234516 8
output =16

case =5
input =120023431 4
output =231

case =6
input =120054621 4
output =421

case =7
input =120054634 5
output =34

case =8
input =1023231 4
output =21

 */
package Elite;
import java.util.*;
public class RemoveKDigitsOfANumber {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		char c[] = sc.next().toCharArray();
		int k = sc.nextInt();
		Stack<Character> stack = new Stack<>();
		stack.push(c[0]);
		for (int i = 1; i < c.length; i++) {
			for(int j = stack.size()-1;j>=0;j--) {
				if(k == 0)break;
				else if(stack.get(j) > c[i]) {
					k--; stack.pop();
				}
				else break;
			}
			stack.push(c[i]);
		}
		for(int i=0;i<stack.size();i++) {
			if(stack.get(i) != '0')System.out.print(stack.get(i));
		}
	}
}