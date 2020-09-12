/* 12/09/2020 - (ELITE DAY - 120)
 * 
 * Given positive natural numbers are 1,2,3,4,5,6,7,8,9,10,11,12,13.....
You are given an integer P.
Your task is to find the digit at position-P in the natural number series.

Note:  P < 2^31.

Input Format:
-------------
An integer P.

Output Format:
--------------
Print a digit, at Position P.


Sample Input-1:
---------------
4

Sample Output-1:
----------------
4

Sample Input-1:
---------------
15

Sample Output-1:
----------------
2

Explanation:
------------
The digit at position 15 from the natural number series:
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12,13,.....
After number 9, digit at position-10 is 1, digit at position-11 is 0, 
digit at position-12 is 1, digit at position-13 is 1,  
digit at position-14 is 1, digit at position-15 is 2.

 */
package Elite;
import java.util.*;

public class DigitAtPosition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n <= 9) System.out.println(n);
		else {
			n-=9;
			
			long digits = 2 , startNum = (long)(Math.pow(10,digits-1)) , totalNums = (long)(Math.pow(10, digits) - Math.pow(10, digits-1));
			while(true) {
				
				if(n - totalNums*digits > 0) {
					n -= (totalNums*digits);
					digits++;
					totalNums *= 10;
					startNum *= 10;
				}
				else {
					long num = startNum + (int)Math.ceil(n/digits) - 1;
					long temp = (n % digits);
					if(temp == 0)System.out.println(num % 10);
					else System.out.println((num / ((long)Math.pow(10,digits - temp )))%10);
					break;
				}
				
			}	
		}
	}
}