/* 24/09/2020 - (ELITE DAY - 125)
 * 
You are given a String S, consist only three characters [,  ], *
Your task is to check whether the string S is Valid or Not.
If S is valid print true, otherwise false.

To check the validity of the String S, follow these rule:
	- Open Square Bracket '[' must go before the corresponding Close Square Bracket parenthesis ']'.
	i.e., Square Brackets should follow proper opening and closing.
	- '*', can be treated as either open square bracket, clsoing square bracket,
	 or an empty string.
	- An empty string is also valid.

Input Format:
-------------
A string S, conatins only these three characters [, ], *

Output Format:
--------------
Print a boolean value,whether S is Valid or not.


Sample Input-1:
---------------
[*]

Sample Output-1:
----------------
true

Sample Input-2:
---------------
**]

Sample Output-2:
----------------
true

*/
package Elite;
import java.util.*;

class ValidBrackets {
    public boolean checkValidString(String s) {
       int lo = 0, hi = 0;
       for (char c: s.toCharArray()) {
           lo += c == '[' ? 1 : -1;
           hi += c != ']' ? 1 : -1;
           if (hi < 0) break;
           lo = Math.max(lo, 0);
       }
       return lo == 0;
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		System.out.println(new ValidBrackets().checkValidString(s));		
	}
}