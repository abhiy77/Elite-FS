/* 05/03/2020
 * 
Given two strings A and B, check if A is subsequence of B.

B is a very long string, and A is a short string 

A subsequence of a string is a new string which is formed from the original string by deleting some
(can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "def" is a subsequence of "adheazgbf" while "zab" is not).

Example 1:

input:
def
adheazgbf

output:
true

Example 2:

input:
zab
adheazgbf

output:
false

*/
package Elite;
import java.util.*;

public class FindIfSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int i = 0, j = 0;
		int m = a.length(), n = b.length();
		while(i < m && j < n) {
			if(a.charAt(i) == b.charAt(j)) {
				i++; j++;
			}
			else j++;
		}
		if(i == m) System.out.println(true);
		else System.out.println(false);
	}
}
