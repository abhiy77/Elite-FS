/* 22/01/2020
Given a string containing digits from 2-9 inclusive, return all possible letter 
combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

___________________
|  1  |  2  |  3  |
| --  | abc | def |
-------------------
|  4  |  5  |  6  |
| ghi | jkl | mno |
-------------------
|  7  |  8  |  9  |
| pqrs| tuv | wxyz|
-------------------

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Your answer should be in lexical order.
*/
package Elite;
import java.util.*;
public class TelephoneDigits {
	
	public static void findAllCombinations(String str,TreeSet<String> set,HashMap<String,String> map,String curr) {
		if(str.isEmpty()) {
			set.add(curr); return;
		}
			String x = map.get(Character.toString(str.charAt(0)));
			
			for(int i=0;i<x.length();i++) {
				findAllCombinations(str.substring(1), set, map, curr+x.charAt(i));
			}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String,String> map = new HashMap<>();
		map.put("2", "abc");  map.put("3", "def");
		map.put("4", "ghi");  map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs"); map.put("8","tuv");
		map.put("9","wxyz");
		
		String str = sc.next().replace("1","");
		
		TreeSet<String> set = new TreeSet<>();
		
		findAllCombinations(str,set,map,"");
        System.out.println(set);
	}
}