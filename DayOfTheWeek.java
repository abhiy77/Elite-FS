/* 13/03/2020
 * Given a date, return the corresponding day of the week for that date.
The input is given as three integers representing the day, month and year respectively.
Return the answer as one of the following values 
{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.

Example 1:
	Input: 31-08-2019
	Output: Saturday

Example 2:
	Input: 18-07-1999
	Output: Sunday

Example 3:
	Input: 15-08-1993
	Output: Sunday
 

Constraints:
If the given date is invalid. print -1.
Date should be in the range from 01-01-1901 to 31-12-2099, otherwise -2.
 */
package Elite;
import java.time.*;
import java.util.*;
public class DayOfTheWeek {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int date[] = Arrays.asList(sc.nextLine().split("-")).stream().mapToInt(Integer::parseInt).toArray();
		try {
			 LocalDate d = LocalDate.of(date[2], date[1], date[0]);
			 if(d.compareTo(LocalDate.of(1901, 1, 1)) < 0 || d.compareTo(LocalDate.of(2099, 12, 31)) > 0) {
					System.out.println(-2);
					System.exit(1);
				}
				String s = d.getDayOfWeek().toString();
				System.out.println(s.substring(0,1)+ s.substring(1).toLowerCase());
		}catch(Exception e) {
			System.out.println(-1);
			System.exit(1);
		}	
	}
}