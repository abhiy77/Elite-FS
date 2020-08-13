/* 20/01/2020
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving 
the order of characters. 

No two characters may map to the same character but a character may map to itself.

Example 1:

Input:egg add
Output: true

Example 2:

Input: foo bar
Output: false

Example 3:

Input: paper title
Output: true
Note:
You may assume both s and t have the same length.


The idea is that we need to map a char to another one, for example, "egg" and "add", 
we need to constract the mapping 'e' -> 'a' and 'g' -> 'd'. 
Instead of directly mapping 'e' to 'a', 
another way is to mark them with same value, for example, 'e' -> 1, 'a'-> 1, 
and 'g' -> 2, 'd' -> 2, this works same.


 */
package Elite;
import java.util.*;

class IsomorphicStrings{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String d = sc.next();
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),d.charAt(i));
            }
               else if(map.get(s.charAt(i)) != d.charAt(i)){
                   System.out.println(false);
                   System.exit(0);
               }
        }
        System.out.println(true);
    }
}