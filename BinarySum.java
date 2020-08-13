/* 20/02/2020
 * A kid is playing with strings, every time he pick two strings contains only 1's and 0's
The kid wants to to add these two strings, using binary addition concept.

Please help him to findout the sum of two strings of 1's and 0's

Example 1:
    Input=  11
            1
    Output= 100

Example 2:
    Input=  1010
            1011
    Output= 10101
    
Example 3:
    Input = 00001010                                                                                                                
            10110                                                                                                                   
    Output= 00100000
 */
package Elite;
import java.util.*;
public class BinarySum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		StringBuffer sb = new StringBuffer();
		int i=str1.length()-1 ,j=str2.length()-1;
		int carry = 0;
		while(i>=0 && j>=0) {
			if(str1.charAt(i) == '0' && str2.charAt(j) == '1' || str1.charAt(i) == '1' && str2.charAt(j) == '0') {
				if(carry == 0) sb.append(1);
				else sb.append(0);
			}
			else if(str1.charAt(i) =='0' && str2.charAt(j) == '0') {
				if(carry == 0) sb.append(0);
				else {
					sb.append(1);
					carry = 0;
				}
			}
			else if(str1.charAt(i) =='1' && str2.charAt(j) == '1') {
				if(carry == 0) {
					sb.append(0);
					carry = 1;
				}
				else sb.append(1);
			}
			i--;j--;
		}
		while(i>=0) {
			if(str1.charAt(i) == '0') {
				if(carry == 1) {
					sb.append(1); carry = 0;
				}
				else sb.append(0);
			}
			else {
				if(carry == 1) sb.append(0);
				else sb.append(1);
			}
			i--;
		}
		while(j>=0) {
			if(str2.charAt(j) == '0') {
				if(carry == 1) {
					sb.append(1); carry = 0;
				}
				else sb.append(0);
			}
			else {
				if(carry == 1) sb.append(0);
				else sb.append(1);
			}
			j--;
		}
		if(carry == 1)sb.append(1);
		System.out.println(sb.reverse());
	}
}