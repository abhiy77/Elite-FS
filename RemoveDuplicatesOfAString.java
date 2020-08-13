/* 05/03/2020
 * 
Given a string S, remove all the consecutive duplicates. 
keep one character and remove all subsequent same characters.


Example-1:
Input=  rraabbccdf
Output= rabcdf

Example-2:
Input=  aabbbabb                                                                                                                
Output= abab
 * 
 */
package Elite;
import java.util.*;
public class RemoveDuplicatesOfAString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder result = new StringBuilder(str.charAt(0)+"");
		char c = str.charAt(0);
		for(int i=1;i<str.length();i++) {
			char x = str.charAt(i);
			if(c == x) continue;
			else {
				result.append(x);
				c = x;
			}
		}
		System.out.println(result.toString());
	}
}
