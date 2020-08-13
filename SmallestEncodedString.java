/* 12/03/2020
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].

Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.

What is the length of the shortest reference string S possible that encodes the given words?

Example:

Input:time me bell
Output: 10
Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 

Note:

1 <= words.length <= 20, if violated print -1
1 <= words[i].length <= 7, if violated print -2
Each word has only lowercase letters.

 */
package Elite;
import java.util.*;
import java.util.stream.Collectors;
public class SmallestEncodedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = Arrays.asList(sc.nextLine().split(" ")).stream().sorted((x,y)-> (y.length()-x.length())).collect(Collectors.toList());
		if(list.size() < 0 || list.size() > 20) {
			System.out.println(-1);
			System.exit(1);
		}

		if(list.get(0).length() < 0 || list.get(0).length() > 7) {
			System.out.println(-2);
			System.exit(1);
		}
		for(int i=0;i<list.size();i++){
		    list.set(i,list.get(i)+"#");
		}
		List<String> out = new LinkedList<>();
		out.add(list.get(0));
		int count = list.get(0).length();
		boolean flag = false;
		for(int i=1;i<list.size();i++) {
			String str = list.get(i);
			if(!flag && str.length() == out.get(0).length() && str.compareTo(out.get(0)) != 0) {
				out.add(str); count +=str.length();
			}
			else if(!flag && str.length() < out.get(0).length()) {
				flag = true;i--;
			}
			else {
				boolean s = false;
				for(int j=0;j<out.size();j++) {
					if(out.get(j).contains(str)) {
						s = true; break;
					}
				}
				if(!s) {
					count +=str.length();
					out.add(str);
				}
			}
		}
		System.out.println(count);
	}
}