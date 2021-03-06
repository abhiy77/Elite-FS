/* ELITE DAY - 108 (25/07/2020)

Anup is interested in Word Play, He invented a new game on words
Anup will give you a string S and index P (1-indexed).
You need apply the rules of the game on that string  
and find out the character at a given index P.

Rules are as follows:
1. You have to read one character at a time and keep appending as a word until you find a digit(d).
2. Once you find a digit, the entire word is repeatedly appended d-1 more times in total.

Input Format:
----------------
Line-1 -> A String S
Line-2 -> An integer P, index value.

Output Format:
------------------
Print the result as a String.


Sample Input-1:
-------------------
kmit2ngit3
12

Sample Output-1:
---------------------
t

Explanation-1:
----------------
The resultant string is "kmitkmitngitkmitkmitngitkmitkmitngit".
The 12th character in the string is "t".

Sample Input-2:
-------------------
ab3c4
9

Sample Output-2:
---------------------
b

Explanation-2:
----------------
The resultant string is "abababcabababcabababcabababc"
The 9th character in the string is "b".

*/
package Elite;
import java.util.Scanner;

class  WordPlay {
    public static String characterAtIndex(String S, int K) {
        for (int len = 0, i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                int num = S.charAt(i) - '0', count = 0;
                for (; count < num - 1 && K > len; count++) {
                    K -= len;
                }
                if (count != num - 1) {
                    return characterAtIndex(S, K);
                } else {
                    len *= num;
                }
            } else {
                len++;
                K--;
                if (K == 0) {
                    return String.valueOf(S.charAt(i));
                }
            }
        }
        return "";
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int index=sc.nextInt();
		System.out.println(characterAtIndex(s,index));
	}
}
