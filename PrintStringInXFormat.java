/* 11/03/2020
 * Given a string of odd length, print the string X format.

Sample Input: 
abcde

Sample Output:
a   e
 b d
  c
 b d
a   e 

NOTE: If it is not possible to print X pattern, print -1. 
Read the string using nextLine or readLine method.
 */
package Elite;
import java.util.*;
public class PrintStringInXFormat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = str.length();
		if(n< 3 || n % 2 == 0) System.out.println(-1);
		else {
			StringBuffer sb = new StringBuffer();
			LinkedList<StringBuffer> list = new LinkedList<>();
			for(int i=0;i<=n;i++) {
				list.add(new StringBuffer());
			}
			for(int i=0;i<n;i++) {
				sb.append(" ");
			}
			for(int i=0;i<=n/2;i++) {
				sb.setCharAt(i, str.charAt(i));
				sb.setCharAt(n-1-i, str.charAt(n-1-i));
				StringBuffer temp = new StringBuffer(sb);
				list.set(i, temp);
				list.set(n-i-1, temp);
				sb.setCharAt(i,' ');
				sb.setCharAt(n-i-1,' ');
			}
			System.out.println(list);
		}
	}
}
