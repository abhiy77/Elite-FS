/* 01/04/2020 - HOME
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  
For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word 'a' from A is universal if for every 'b' in B, 'b' is a subset of 'a'. 

Return a list of all universal words in A.  You can return the words in alphabetical order.

 
Sample Input 1:
        leoc amazon apple facebook google 
        lo eo
Sample Output 1: 
        google leoc


Sample Input 2: 
        amazon apple facebook google leoc
        ec oc ceo
Sample Output 2: 
        facebook leoc
 

Note:
    1 <= A.length, B.length <= 10000
    1 <= A[i].length, B[i].length <= 10
    A[i] and B[i] consist only of lowercase letters.
    All words in A[i] are unique: there isn't i != j with A[i] == A[j].

 */
package Elite;
import java.util.*;
public class UniversalWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr1[] = sc.nextLine().split(" ");
		String arr2[] = sc.nextLine().split(" ");
		LinkedList<String> result = new LinkedList<>();
		for(int i = 0;i<arr1.length;i++) {
			int flag = 0;
			HashMap<Character,Integer> map = new HashMap<>();
			String str = arr1[i];
			for(int j = 0;j<str.length();j++) {
				map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);
			}
			
			for(int j=0;j<arr2.length;j++) {
				HashMap<Character,Integer> map2 = new HashMap<>(map);
				String str2 = arr2[j];
				for(int k=0;k<str2.length();k++) {
					char c = str2.charAt(k);
					if(!map2.containsKey(c) || map2.get(c) == 0) {
						flag = 1; break;
					}
					else map2.put(c, map2.get(c)-1);
				}
				if(flag == 1) break;
			}
			if(flag == 1)continue;
			else result.add(arr1[i]);
		}
		Collections.sort(result);
		System.out.println(result);
	}
}