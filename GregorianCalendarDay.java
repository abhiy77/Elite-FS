/* 13/03/2020
 * 
Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, 
return the day number of the year.

Example 1:
    Input:  2019-01-09
    Output: 9
Explanation: Given date is the 9th day of the year in 2019.

Example 2:
    Input:  2019-02-10
    Output: 41

Example 3:
    Input:  2003-03-01
    Output: 60

Example 4:
    Input: 2004-03-01
    Output: 61

Note: If the given date is invalid. print -1.

 */
package Elite;
import java.util.*;
public class GregorianCalendarDay {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int date[] = Arrays.asList(sc.nextLine().split("-")).stream().mapToInt(Integer::parseInt).toArray();
		if(date[2] == 29 && date[1] == 1 && date[0]%4 != 0 || date[2] > arr[date[1]] || date[1] > 12)System.out.println(-1);
		else {
			int days = 0;
			for(int i=1;i<date[1];i++) {
				days += arr[i];
			}
			days += date[2] + (date[0] %4 == 0 && date[1] > 2 || date[1] == 2 && date[2] == 29 ? 1 : 0);
			System.out.println(days);
		}
	}
}
