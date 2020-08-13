/* 24/04/2020 - HOME
 * 
Sherlock considers a string to be valid if all characters of the string appear 
the same number of times. It is also valid if he can remove just 1 character 
at one of the index in the string, and the remaining characters will occur 
the same number of times. 

Given a string S, determine if it is valid. If so, return YES, otherwise return NO.

For example, if S=abc, it is a valid string because frequencies are [a:1,b:1,c:1]. 
So is s=abcc because we can remove one c and have 1 of each character in the remaining string. 
If s=abccc however, the string is not valid as we can only remove 1 occurrence of c. 
That would leave character frequencies of [a:1, b:1,c:2].

Input Format:
A single string .

Constraints:
Each character S[i] -> [a-z] 

Output Format:
Print YES if string S is valid, otherwise, print NO.

Sample Input1:
aabbcd
Sample Output1:
NO

Explanation1:
Given S="aabbcd", we would need to remove two characters, 
both c and d -> aabb or a and b -> abcd, to make it valid. 
We are limited to removing only one character, so S is invalid.

Sample Input2:
abcdefghhgfedecba
Sample Output2:
YES

Explanation2:
All characters occur twice except for e which occurs 3 times. 
We can delete one instance of e to have a valid string.


========= Testcases Program-3 =========
case =1
input =aabbccddeefghi
output ="NO"

case =2
input =aabbcd
output ="NO"

case =3
input =abcdefghhgfedecba
output ="YES"

case =4
input =abbcccddeeeeedddccccbba
output ="NO"

case =5
input =thequickbrownfoxfoxjumpsoveroverjumpslittlelittlelazydoglazythequickbrowndog
output ="NO"

case =6
input =qwertyuiopasdfghjklmnbvcxzadfghjklpoiutrmnbvcxdwesdgj
output ="NO"

case =7
input =qwertykeypadpakedqweryty
output ="NO"

case =8
input =redivider
output ="YES"

 */
package Elite;
import java.util.*;

public class SherlockValidString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		HashMap<Character,Integer> map = new HashMap<>();
		HashMap<Integer,Integer> res = new HashMap<>();
		int n = str.length();
		for(int i=0;i<n;i++) {
			char c = str.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for(Map.Entry<Character,Integer> entry : map.entrySet()) {
			res.put(entry.getValue(), res.getOrDefault(entry.getValue(), 0) + 1);
		}
		System.out.println(map);
		System.out.println(res);
		if(res.size() > 2) System.out.println("NO");
		else if(res.size() == 1) System.out.println("YES");
		else {
			Object arr[] = res.values().toArray();
			List<Integer> list = new LinkedList<>(res.keySet());
			if((Integer)arr[0] == 1 || (Integer)arr[1] == 1  && Math.abs(list.get(0) - list.get(1)) <= 1) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}