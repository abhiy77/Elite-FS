/* 27/01/2020
 * Given a string s. Return all the words vertically in the same order in which they appear in s.
Words are returned as a list of strings, complete with spaces when is necessary. 
(Trailing spaces are not allowed).

Each word would be put on only one column and that in one column there will be only one word.

Example 1:
	Input=  HOW ARE YOU
	Output= HAY,ORO,WEU,
	Explanation: Each word is printed vertically. 
	 "HAY"
	 "ORO"
	 "WEU"

Example 2:
	Input=  TO BE OR NOT TO BE
	Output= TBONTB,OEROOE,   T,
	Explanation: Trailing spaces is not allowed. 
	"TBONTB"
	"OEROOE"
	"   T"

Example 3:
	Input=  CONTEST IS COMING
	Output= CIC,OSO,N M,T I,E N,S G,T,

NOTE: String can contains both uppercase and lowercase alphabets 
Take care of OUTPUT format.
 */
package Elite;
import java.util.*;

class VerticalWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = sc.nextLine().split(" ");

		int maxVal = -1;
		for (String s : input) {
			maxVal = Integer.max(s.length(), maxVal);
		}

		for (int i = 0; i < input.length; i++) {
			int temp = maxVal - input[i].length();
			while (temp-- >= 0) {
				input[i] += "@";
			}
		}

		LinkedList<String> list = new LinkedList<>();

		for (int i = 0; i < maxVal; i++) {
			String str = "";
			for (String s1 : input) {
				str += s1.charAt(i);
			}
			str = str.replaceAll("@", " ");
			list.add(str);
		}

		for (String s : list) {
			int flag = 0;
			StringBuffer sb = new StringBuffer();
			for (int i = s.length() - 1; i >= 0; i--) {
				if (flag == 0 && s.charAt(i) == ' ') {
					continue;
				} else {
					flag = 1;
				}
				if (flag == 1)
					sb.append(s.charAt(i));
			}
			System.out.print(sb.reverse() + ",");
		}
	}
}