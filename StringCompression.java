/* 04/03/2020
 * 
 * 
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.

 
Follow up:
Could you solve it using only O(1) extra space?


Example-1:
    Input=  aabbccc
    Output= 6
    Explanation:
        "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
        Return 6, and the first 6 characters of the input array should be: a2b2c3

Example-2:
    Input=  a
    Output= 1
    Explanation:
        Nothing is replaced.
        first 1 characters of the input  should be: a
        
Example-3:
    Input=  abbbbbbbbbbbb
    Output= 4
    Explanation:
        Since the character "a" does not repeat, it is not compressed. 
        "bbbbbbbbbbbb" is replaced by "b12".
        Notice each digit has it's own entry in the array.
        first 4 characters of the input  should be: ab12
        
Example-4:
    Input=  abababaaa
    Output= 8
    Explanation:
        Since the character "a", "b" does not repeat immediately, it is not compressed. 
        "aaa" is replaced by "a3".
        Notice each digit has it's own entry in the array.
        first 8 characters of the input  should be: abababa3
*/
package Elite;
import java.util.*;
public class StringCompression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for(int i = 0;i<str.length();) {
			int x = i+1;
			while( x < str.length() && str.charAt(x) == str.charAt(i)) {
				x++; count++;
			}
			if(count > 1) sb.append(str.charAt(i)+""+count);
			else sb.append(str.charAt(i));
			count = 1;i=x;
		}
		System.out.println(sb.length());
	}
}