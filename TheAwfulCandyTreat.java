/* 15/04/2020 - HOME
 * 
A jail has a number of prisoners and a number of treats to pass out to them. 
Their jailer decides the fairest way to divide the treats is to seat 
the prisoners around a circular table in sequentially numbered chairs. 
A chair number will be drawn from a hat. 
Beginning with the prisoner in that chair, one candy will be handed to each prisoner 
sequentially around the table until all have been distributed.

The jailer is playing a little joke, though. 
The last piece of candy looks like all the others, but it tastes awful. 
Determine the chair number occupied by the prisoner who will receive that candy.

For example, there are 4 prisoners and 6 pieces of candy. 
The prisoners arrange themselves in seats numbered 1 to 4. 
Let's suppose two is drawn from the hat. 
Prisoners receive candy at positions 2,3,4,1,2,3. The prisoner who receives the awful treat, sits in chair number .

Input Format:
Line contain 3 space-separated integers:
-n : the number of prisoners
-m : the number of sweets
-s : the chair number to start passing out treats at

Output Format:
Print the chair number of the prisoner who receives the awful treat.

Sample Input-1
5 2 2
Sample Output-1
3
Explanation-1
Distribution starts at seat 2 so prisoners in seats 2 and 3 get sweets. Warn prisoner 3	.

Sample Input-2
7 19 2
Sample Output-2
6
Explanation-2
There are 7 prisoners, 19 sweets and they are passed out starting at chair 2. 
The candies go all around twice and there are 5 more candies passed to each prisoner from seat 2 to seat 6.

========= Testcases Program-3 =========
case =1
input =144 797951344 1
output =112

case =2
input =17 900306316 1
output =1

case =3
input =169 647839529 169
output =167

case =4
input =5 311730064 2
output =5

case =5
input =4 463934462 4
output =1

case =6
input =155634995 840192364 67379577
output =129396965

case =7
input =543780156 962564973 467116054
output =342120714

case =8
input =984873585 997634055 103050157
output =115810626


 */
package Elite;
import java.util.*;
public class TheAwfulCandyTreat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int prisoners = sc.nextInt();
		int sweets = sc.nextInt();
		int startPos = sc.nextInt();
		int firstTreat = prisoners - (startPos- 1);
		if(sweets <= firstTreat) {
			System.out.println(startPos + sweets -1);
		}
		else {
			sweets-= firstTreat;
			int mod = sweets % prisoners;
			System.out.println(mod == 0 ? prisoners : mod);
		}
		sc.close();
	}
}