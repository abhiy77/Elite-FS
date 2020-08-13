/*13/03/2020
 * 
 */
package Elite;
import java.util.*;
public class DecodedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int index = sc.nextInt();
		int count = 0;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<str.length();i++) {
			if(index < sb.length())break;
			char c = str.charAt(i);
			if(Character.isAlphabetic(c)) {
				sb.append(c);
				count++;
			}
			else{
				int digit = (int)(c-'0');
				if(digit == 0) {
					sb.delete(0,sb.length());
				}
				else if(count + sb.length() * (digit-1) < index) {
					count += sb.length() * (digit-1);
				}
				else {
					int rem = index - count;
					System.out.println(sb.charAt(rem%count-1));
					System.exit(1);
				}
			}
		}
		if(index >= sb.length())System.out.println("$");
		else System.out.println(sb.charAt(index-1));
	}
}