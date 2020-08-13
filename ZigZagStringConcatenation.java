/* 04/03/2020
 * 

Given a string and number of rows 'n'. 
Print the string formed by concatenating n rows when input string is 
written in row-wise Zig-Zag fashion.

Sample Input:
ABCDEFGHIJKLM
3
Sample Output: 
AEIMBDFHJLCGK

Explanation: Let us write input string in Zig-Zag fashion
             in 3 rows.
A       E       I       M
  B   D   F   H   J   L
    C       G       K
Now concatenate the two rows and ignore spaces 
in every row. We get "AEIMBDFHJLCGK"


 * 
 */
package Elite;
import java.util.*;
public class ZigZagStringConcatenation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = sc.nextInt();
		if(n == 1){
		    System.out.println(str); System.exit(1);
		}
		StringBuilder[] arr = new StringBuilder[n];
		for(int i=0;i<n;i++)arr[i] = new StringBuilder();
		boolean down = true;
		int i = 0,j=0;
		while(i < str.length()) {
			if(down) {
				arr[j].append(str.charAt(i));
				i++; j++;
				if(j == n-1) down = !down;
			}
			else {
				arr[j].append(str.charAt(i));
				i++;j--;
				if(j==0) down = !down;
			}
		}
		for(StringBuilder sb : arr) {
			System.out.print(sb.toString()+"");
		}
	}
}
