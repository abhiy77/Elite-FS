/* 09/01/2020
 * Given a non-empty string, check if the given string can be constructed
by taking a substring of it and appending multiple copies of the substring together. 

You may assume the given string consists of lowercase English letters only and 
its length will not exceed 10000.

Example 1:
    Input=  abab
    Output= true
    Explanation: It's the substring "ab" twice.

Example 2:
    Input=  aba
    Output= false

Example 3:
    Input=  abcabcabcabc
    Output= true
    Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

 */
package Elite;
import java.util.*;
public class StringFromSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		LinkedList<Integer> list = new LinkedList<>();
        int flag = 0;
		for(int i=1;i<(str.length()/2) + 1;i++) {
			if(str.length() % i == 0) {
				String temp = new String(str);
				temp = temp.replace(str.substring(0,i),"");
				if(temp.equals("")) {
					flag = 1;
					break;
				}
				temp = str;
			}
		}
		if(flag == 1) {System.out.println("true");}
		else {System.out.println("false");}
	}
}
