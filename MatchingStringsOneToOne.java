/* 27/08/2020 - (ELITE DAY 112)
 * 
 * Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and distinct non-empty substring in S2, 
where each non-empty substring in S2 also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
aabb xyzabcxyzabc

Sample Output-3:
----------------
false


********** Program-3 **********

case =1
input =abab kmitngitkmitngit
output =true

case =2
input =aaaa kmjckmjckmjckmjc
output =true

case =3
input =aabb xyzabcxyzabc
output =false

case =4
input =kick keshavsmarakcollegekeshav
output =true

case =5
input =assam applesapotasapotamangoapple
output =false

case =6
input =redivider keshavmemorialinstituteoftechnologyofinstitutememorialkeshav
output =true

case =7
input =redivider keshavmemorialinstituteoftechnologymemorialinstituteoftechnology
output =false

case =8
input =tictoctoe temptationicecreamcreamstonetemptationoreobiscuitcreamstonetemptationoreobiscuitelephanthouse
output =true


 */
package Elite;
import java.util.*;

public class MatchingStringsOneToOne {
	
	public static boolean flag = false;
	
	public static void recurse(String str1,String str2,HashMap<Character,String> map) {
		
		if(flag)return;
		if(str1.isEmpty() && str2.isEmpty()) {
			System.out.println(map);
			flag = true;
			return;
		}
		else if(str1.isEmpty() || str2.isEmpty())return;

		char key = str1.charAt(0);
		if(map.containsKey(key)) {
			String val = map.get(key);
			if(str2.length() >= val.length() && str2.substring(0,val.length()).equals(val)) {
				recurse(str1.substring(1),str2.substring(val.length()),map);
			}
			else {
				return;
			}
		}
		else {
			for(int i=1;i<=str2.length();i++) {
				String substr = str2.substring(0,i);
				map.put(key, substr);
				recurse(str1.substring(1),str2.substring(substr.length()),map);
				map.remove(key);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		recurse(str1,str2,new HashMap<Character,String>());
		System.out.println(flag);
	}
}