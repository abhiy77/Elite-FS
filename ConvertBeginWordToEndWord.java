/* 02/03/2020
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
hit
cog
hot dot dog lot log cog

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.


Example 2:

Input:
hit
cog
hot dot dog lot log

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
package Elite;
import java.util.*;
public class ConvertBeginWordToEndWord {
	
	static int min = Integer.MAX_VALUE;
	public static boolean check(String begin,String transform) {
		int count = 0;
		for(int i=0;i<begin.length();i++) {
			if(begin.charAt(i) != transform.charAt(i)) count++;
		}
		return count == 1;
	}

	public static void findTransformation(String begin, String end, List<String> list, int count,boolean[] visited) {
		System.out.println(begin);
		if(begin.equals(end)) min = Math.min(min, count);
		for(int i=0;i<list.size();i++) {
			if(!visited[i] && check(begin,list.get(i))) {
				visited[i] = true;
				findTransformation(list.get(i), end, list, count+1, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String begin = sc.nextLine();
		String end = sc.nextLine();
		List<String> list = Arrays.asList(sc.nextLine().split(" "));
		boolean[] visited = new boolean[list.size()];
		findTransformation(begin,end,list,1,visited);
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}