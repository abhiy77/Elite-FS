/* 06/05/2020 - HOME
Input Format:
    - A String S.

Output Format:
    -Print Shortest Possible String.
    if final String is empty, print -1.

Sample Input:
aaabccddd

Sample Output:
abd

Sample Input:
baab

Sample Output:
-1
 */
package Elite;
import java.util.*;
public class CompressionOfString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while(true) {
			if(str.length() == 0) break;
			char c = str.charAt(0);
			int count = 0,index = 0,temp = str.length(),i=0;
			
			for(i=1;i<str.length();i++) {
				if(c == str.charAt(i)) {
					count++;
				}
				else {
					if(count == 1) {
						str = str.replace(str.substring(index, i),"");
						i -= (count + 1);
					}
					else if(count > 1) {
						str = str.replace(str.substring(index, i-1),"");
						i -= count;
					}
					index = i;
					c = str.charAt(i);
					count = 0;
				}
			}
			if(count == 1) {
				str = str.replace(str.substring(index, i),"");
			}
			else if(count > 1) {
				str = str.replace(str.substring(index, i-1),"");
			}
			if(str.length() == temp) break;
		}
		if(str.length() == 0) System.out.println(-1);
		else System.out.println(str);
	}
}