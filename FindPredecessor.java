/* 04/03/2020
 * Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2,
if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  
For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, 
where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain formed using the given list of words.

 

Example 1:

Input: a b ba bca bda bdca
Output: 4
Explanation: one of the longest word chain is "a","ba","bda","bdca".
 */
package Elite;
import java.util.*;

public class FindPredecessor {
	static int max = 0;
	
	public static void findPredecesors(String arr[],String str,int i,int count) {
		if(i == arr.length) {
			max = Math.max(max, count);
			return;
		}
		if(checkOneDistinct(str, arr[i]) && Math.abs(arr[i].length() - str.length()) ==1 ) {
			findPredecesors(arr, arr[i], i+1, count+1);
		}
		else findPredecesors(arr, str, i+1, count);
	}
	
	public static boolean checkOneDistinct(String str1,String str2) {
		int count[] = new int[26];
		for(int i=0;i<str1.length();i++) {
			count[str1.charAt(i)-'a']++;
		}
		for(int j=0;j<str2.length();j++) {
			count[str2.charAt(j)-'a']--;
		}
		int result = 0;
		for(int i=0;i<count.length;i++) {
			if(count[i] != 0) result++;
		}
		return result == 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		Arrays.sort(arr,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length())return o1.compareTo(o2);
					return (o1.length()-o2.length());
			}
			
		});
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length-1;i++) {	
			findPredecesors(arr, arr[i], i+1, 1);
		}
		System.out.println(max);	
	}
}

//ConcurrentHashMap<String,List<String>> map = new ConcurrentHashMap<>();
//map.put(arr[0],new LinkedList<String>());
//int max = 1;
//String maxKey = arr[0];
//for(int i=1;i<arr.length;i++) {
//	String str = arr[i];
//	int flag = 0;
//	for(Map.Entry<String, List<String>> entry : map.entrySet()) {
//		List<String> list = map.get(entry.getKey());
//		if(entry.getKey().length() == str.length()) {
//			flag = 1;
//			break;
//		}
//		else if(entry.getKey().length()+1 == str.length()) {
//			for(int j=0;j<list.size();j++) {
//				if(checkOneDistinct(str, list.get(j))) {			
//					flag = 2; break;
//				}
//			}
//		}
//		if(flag == 1) {
//			map.put(str,new LinkedList<String>());
//		}
//		if(flag == 2) {
//			list.add(str);
//			if(max < list.size() + 1) {
//				max = list.size()+1;
//				maxKey = entry.getKey();
//			}
//		}	
//		if(flag == 0)map.put(str, new LinkedList<String>());
//	}
//}
//System.out.print(maxKey+" ");
//List<String> temp = map.get(maxKey);
//for(int i=0;i<temp.size();i++) {
//	System.out.print(temp.get(i) + " ");
//}

