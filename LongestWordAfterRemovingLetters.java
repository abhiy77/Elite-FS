/* 24/02/2020
 * Shireesha has a habbit of playing with words,
She has a word 'W'and a wordlist 'WL', 
find the long word in the wordlist,  after she removes few letters from the word(W). 

If there are two or more possibilities,
return the long word with the smallest lexicographical order. 

If there is no possible result, return -1.

Note:
All the words in the input will only contain lower-case letters.

Example-1:
    Input=  abpcplea
            ale apple monkey plea
    Output= apple

Example-2: 
    Input=  abpcplea
            a b c
    Output= a
    
    */
package Elite;
import java.util.*;
public class LongestWordAfterRemovingLetters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int max = 0;
		String result = "";
		String arr[] = sc.nextLine().split(" ");
		for(String a : arr) {
			int j = 0;
			for(int i=0;i<str.length();i++) {
				char x = str.charAt(i);
				if(a.charAt(j) == x) j++;
				if(j == a.length()) {
					if(max < j) {
						max = j;
						result = a;
					}
					else if(max == j) {
						if(result.compareTo(a) == 1)
							result = a;
					}
					break;
				}
			}
		}
		if(result.equals(""))System.out.println(-1);
		else System.out.println(result);
	}
}
