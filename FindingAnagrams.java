/* 20/02/2020
 * In a school, Teacher has given a task to her students.
Teacher ask the students to find out, all the start indices othe anagrams of P in S.
Both S and P are strings consists of lowercase alphabets only. 

Print the indices in ascending order only.


Example 1:
    Input=  cbaebabacd
            abc
    Output= [0, 6]
    Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
    Input=  abab
            ab
    Output= [0, 1, 2]
    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
package Elite;
import java.util.*;

public class FindingAnagrams {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char arr1[] = sc.nextLine().toCharArray();
		char arr2[] = sc.nextLine().toCharArray();
		int count[] = new int[26];
		int temp[] = new int[26];
		LinkedList<Integer> list = new LinkedList<>(); 
		for(int i=0;i<arr2.length;i++) {
			count[arr2[i]-'a']++;
		}
		for(int i=0;i<=arr1.length-arr2.length;i++) {
			if(i == 0) {
				for(int j=0;j<arr2.length;j++) {
					temp[arr1[j]-'a']++;
				}
				if(Arrays.equals(count, temp))list.add(i);
			}
			else {
				temp[arr1[i-1]-'a']--;
				temp[arr1[i+arr2.length-1]-'a']++;
				if(Arrays.equals(count, temp))list.add(i);
			}
		}
		System.out.println(list);
	}
}