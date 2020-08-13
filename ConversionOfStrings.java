/* 19/02/2020
 * You will be given two strings A and B of the same length, 
determine whether you can convert A into B by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in A
to any other lowercase English character.

Return true if and only if A and B are equal after conversion.


Example 1:
	Input= aabcc ccdee
	Output= true
	Explanation: 
	Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. 
	Note that the order of conversions matter.

Example 2:
	Input= football ballfoot
	Output= false
	Explanation: There is no way to transform A to B.
 

Note:
Both A and B contain only lowercase English letters.

 */
package Elite;
import java.util.*;
public class ConversionOfStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character,Character> map = new HashMap<>();
		String str1 = sc.next();
		int flag = 0;
		String str2 = sc.next();
		int m = str1.length();
		for(int i=0;i<m;i++) {
			char x = str1.charAt(i);
			if(map.containsKey(x)) {
				if(str2.charAt(i) != map.get(x)) {
					flag = 1; break;
				}
			}
			else {
				map.put(x, str2.charAt(i));
			}
		}
		if(flag ==1)System.out.println(false);
		else System.out.println(true);
	}
}