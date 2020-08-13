/* 11/06/2020 - HOME
 * Input Format:
------------
A String S.

Output Format:
--------------
Print whether it is "Special" or "Not Special" on a new line.


Sample Input:
-------------
acxz

Sample Output:
--------------
Special


Sample Input:
-------------
dcxz

Sample Output:
--------------
Not Special

 */
package Elite;
import java.util.*;

public class SpecialString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = str.length();
		int i = 0, j = n-1;
		int flag = 0;
		while(i < j) {
			if(Math.abs(str.charAt(i) - str.charAt(i+1)) != Math.abs(str.charAt(j) - str.charAt(j-1))){
				flag = 1;
				break;
			}
			i++; j--;
		}
		if(flag == 0) System.out.println("Special");
		else System.out.println("Not Special");
		sc.close();
	}
}