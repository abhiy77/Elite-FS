/* 27/08/2020 - (ELITE DAY 112)
 * 
 * Kiran is working with strings and their subsequences.
A subsequence can be formed from a string by deleting some characters(may be string itself)

Kiran has given two strings S and T, your task to form T by concatenating the subsequences of S  

Return the minimum number of subsequences required to form T.
If the task is impossible, return -1 .

Input Format:
-------------
Line-1 -> Two strings S and T

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
abc abcbc

Sample Output-1:
----------------
2

Explanation: 
------------
T = "abcbc" can be formed by "abc" and "bc",
which are subsequences of S = "abc".


Sample Input-2:
---------------
abc acdbc

Sample Output-2:
----------------
-1

Explanation: 
------------
string T cannot be constructed from the
subsequences of string S due to the character "d" in string T.

 */
package Elite;
import java.util.*;

public class MinimumSubsequencesRequired {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			set.add(s.charAt(i));
		}
		int flag = 0;
		for(int i = 0;i<t.length();i++) {
			if(!set.contains(t.charAt(i))) {
				flag = 1;
				break;
			}
		}
		if(flag == 1) {
			System.out.println(-1);
		}
		else {
			int minSequences = 1;
			int i = 0,j = 0;
			while(i < s.length() && j < t.length()) {
				if(s.charAt(i) == t.charAt(j)) {
					i++;j++;
				}
				else i++;
				if(j == t.length())break;
				if(i == s.length()) {
					minSequences++;
					i = 0;
				}
			}
			System.out.println(minSequences);
		}
	}
}