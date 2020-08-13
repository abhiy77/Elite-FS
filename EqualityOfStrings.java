/* 19/02/2020
 * Given two strings A and B, 
return true if they are equal when both are typed into empty text editors
else false.
$ means a backspace character.

Example 1:
    Input= ab$c ad$c
    Output= true
    Explanation: Both A and B become "ac".
    
Example 2:
    Input= b$$ c$d$
    Output= true
    Explanation: Both A and B become "".

Example 3:
    Input= $$c $a$c
    Output= true
    Explanation: Both A and B become "c".

Example 4:
    Input= $c b
    Output= false
    Explanation: A becomes "c" while B becomes "b".


Can you solve it in O(N) time and O(1) space?
*/
package Elite;
import java.util.*;
public class EqualityOfStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer str1 = new StringBuffer(sc.next());
		StringBuffer str2 = new StringBuffer(sc.next());
		int m = str1.length() , n = str2.length();
		int count = 0;
		for(int i=m-1;i>=0;i--) {
			if(str1.charAt(i) == '$') {
				count++;
			}
			else if(count > 0) {
				str1.setCharAt(i,'$');
				count--;
			}
		}
		count = 0;
		for(int i=n-1;i>=0;i--) {
			if(str2.charAt(i) == '$') {
				count++;
			}
			else if(count > 0) {
				str2.setCharAt(i,'$');
				count--;
			}
		}
		if(str1.toString().replace("$", "").equals(str2.toString().replace("$", ""))) {
			System.out.println(true);
		}
		else System.out.println(false);
	}
}