/* 11/03/2020
 *  
You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing 
every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: 
every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

print the answer in ascending order.

Note:
1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20

Sample Input: 
abc deq mee aqq dkd ccc 
abb

Sample Output:
aqq mee

Explanation: 
"mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.


 */
package Elite;
import java.util.*;

public class MatchPatternWithMap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String words[] = sc.nextLine().split(" ");
		LinkedList<String> result = new LinkedList<>();
		String pattern = sc.nextLine();
		if(words.length <=0 || words.length > 50 ){
		    System.out.print("");
		} 
		else{
		    for(int i=0;i<words.length;i++) {
		        String word = words[i];
		    if(word.length() > 20 || word.length() < 1) break;      
			if(words[i].length() != pattern.length()) continue;
			HashMap<Character,Character> map = new HashMap<>();
			LinkedList<Character> list = new LinkedList<>();
			int flag = 0;
			for(int j = 0;j<word.length();j++) {
				if(map.containsKey(pattern.charAt(j)) && map.get(pattern.charAt(j)) != word.charAt(j)) {
					flag = 1; break;
				}
				else if(!map.containsKey(pattern.charAt(j))) {
					if(list.contains(word.charAt(j))) {
						flag = 1; break;
					}
					else {
						list.add(word.charAt(j));
						map.put(pattern.charAt(j), word.charAt(j));
					}
				}
			}
			if(flag == 0)result.add(word);
		}
		Collections.sort(result);
		System.out.print(result.isEmpty() ? "" : result);  
		}
	}
}