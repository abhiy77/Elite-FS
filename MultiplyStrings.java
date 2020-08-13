/*25/02/2020
 * Hemanth is playing with Strings, He takes two strings contains positive numbers only.
Can you help him to find the amount of 'value in string-1' increased by
'value in string-2' times.

Example 1:
	Input=	5 4
	Output= 20

Example 2:
	Input=	121 432 
	Output= 52272

Note:
Input should contain digits only, and shouldnot contain leading 0's except 0.
There will be no leading minus '-' symbol also/
Should not use built-in BigInteger library.
Should not convert the given strings into integers.
 */
package Elite;
import java.util.*;

public class MultiplyStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] num1 = sc.next().toCharArray();
		char[] num2 = sc.next().toCharArray();
		int result[] = new int[num1.length + num2.length];

		for(int j=num2.length-1;j>=0;j--) {
			int carry = 0;
			for(int i=num1.length-1;i>=0;i--) {
				int sum =  (((num2[j]-'0')*(num1[i]-'0') + carry)) ;
				result[i+j+1] += sum;
				carry = result[i+j+1]/10;
				result[i+j+1] %=10;
				if(i == 0) result[i+j] = carry;
			}
		}
		StringBuffer sb = new StringBuffer();
		int flag = 0;
		for(int i=0;i<result.length;i++) {
			if(flag == 0 && result[i] == 0) continue;
			else {
				flag = 1;
				sb.append(result[i]);
			}
		}
		System.out.println(sb.toString().isEmpty() ? 0 : sb.toString());
	}
}
