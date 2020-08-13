/* 09/07/2020 - HOME
 * Input Format:
-------------
An integer N, where n is 2 power k

Output Format:
--------------
Print the output as shown in the sample


Sample Input-1:
---------------
4

Sample Output-1:
----------------
((a,d),(b,c))


Sample Input-2:
---------------
8

Sample Output-2:
----------------
(((a,h),(d,e)),((b,g),(c,f)))

 */
package Elite;
import java.util.*;
public class WimbledonPairMatching {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> temp = new LinkedList<>();
		for(int i=0;i<n;i++) {
			temp.add(""+(char)(i+97));
		}
		while(n != 1) {
			List<String>result = new LinkedList<>();
			while(!temp.isEmpty()) {
				result.add("(" + temp.remove(0) + "," + temp.remove(temp.size()-1) + ")");
			}
			n/=2;
			temp = result;
		}
		System.out.println(temp.get(0));
	}
}