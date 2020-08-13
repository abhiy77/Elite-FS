/* 14/02/2020
 * 
 Given a list of words (without duplicates), please write a program that returns all 
 concatenated words in the given list of words.
 
A concatenated word is defined as a string that is comprised entirely of 
at least two shorter words in the given array.

Example:
Input: cat cats catsdogcats dog dogcatsdog hippopotamuses rat ratcatdogcat

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

 */
package Elite;
import java.util.*;
public class WordBreak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<String> output = new LinkedList<>();
		List<String> arr = Arrays.asList(sc.nextLine().split(" "));
		List<String> copy = new LinkedList<String>(arr);
		for(String item : arr) {
			copy.remove(item);
			int n = item.length();
			boolean dp[] = new boolean[n+1];
			dp[0] = true;
			for(int i=1;i<=n;i++) {
				for(int j=0;j<i;j++) {
					System.out.println(item.substring(j,i));
					if(dp[j] && copy.contains(item.substring(j,i))) {
						dp[i] = true;
						break;
					}
				}
			}
			if(dp[n] == true) output.add(item);	
			copy.add(item);
			//System.out.println(Arrays.toString(dp));
		}
		System.out.println(output);
	}
}		