/* 10/09/2020 - (ELITE DAY - 118)
 * 
 * You are provided with a string of characters(lowercase only),
You can chnage the order of the characters of the string.
After changing the order, the resultant string should contain 
no two immidiate characters equal.

Return true, if you are able to find such resultant string, 
Otherwise false.

Input Format:
-------------
A String S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
aaabd

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaab

Sample Output-2:
----------------
false

 */
package Elite;
import java.util.*;

public class RearrangingString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		HashMap<Character,Integer> map = new HashMap<>();
		
		int max = Integer.MIN_VALUE;
		char letter = '@';
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if(max < map.get(c)) {
				max = map.get(c);
				letter = c;
			}
		}
		
		int rem = s.length() - max;
		if(max > rem+1) System.out.println(false);
		else System.out.println(true);
	}
	
}