/* 29/01/2020
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.  
Return the number of possible non-empty sequences of letters you can make.


Example 1:
Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:
Input: "AAABBC"
Output: 188

 
Note:
    1 <= tiles.length <= 7
    tiles consists of uppercase English letters.


 */
package Elite;
import java.util.*;
class Tiles {
	public static int result = 0;

	public static void recurse(int[] count) {
		for (int i = 0; i < 26; i++) {
			if (count[i] == 0)
				continue;
			result++;
			count[i]--;
			recurse(count);
			count[i]++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();

		int[] count = new int[26];

		for (int i = 0; i < input.length(); i++) {
			count[input.charAt(i) - 'A']++;
		}
		recurse(count);
		System.out.println(result);
	}
}
