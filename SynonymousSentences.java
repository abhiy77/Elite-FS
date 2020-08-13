/* 16/01/2020
 * Given a list of pairs of equivalent words synonyms and a sentence text, output all possible synonymous sentences 
sorted lexicographically.
 

Example 1:

Input:
synonyms =3
happy joy
sad sorrow
joy cheerful
I am happy today but was sad yesterday

Output:
[I am cheerful today but was sad yesterday,
I am cheerful today but was sorrow yesterday,
I am happy today but was sad yesterday,
I am happy today but was sorrow yesterday,
I am joy today but was sad yesterday,
I am joy today but was sorrow yesterday]
 
 */
package Elite;
import java.util.*;

public class SynonymousSentences {
	
	public static void findSynonyms(HashMap<String,String> map ,TreeSet<String> set,String str) {
		int flag = 0;
		for(Map.Entry<String, String> entry : map.entrySet()) {
			if(str.contains(entry.getKey())) {
				flag = 1;
				set.add(str.replaceFirst(entry.getKey(), entry.getValue()));
				findSynonyms(map, set, str.replaceFirst(entry.getKey(), entry.getValue()));
			}
		}
		if(flag == 0) return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String,String> map = new HashMap<>();
		int synonyms = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<synonyms;i++) {
			String arr[] = sc.nextLine().split(" ");
			map.put(arr[0], arr[1]);
		}
		String str = sc.nextLine();
		TreeSet<String> set = new TreeSet<>();
		set.add(str);
		
		findSynonyms(map,set,str);
		System.out.println(set);
	}
}
