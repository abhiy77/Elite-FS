/*27/01/2020
 * Given a string s, return the maximum number of ocurrences of any substring under the following rules:

The number of unique characters in the substring must be less than or equal to maxLetters.
The substring size must be between minSize and maxSize inclusive.
 

Example 1:
	Input=  aababcaab	//given string
			2			//Maximun Letters
			3			//Minimum Size
			4			//Maximum Size
	Output= 2
	Explanation: Substring "aab" has 2 ocurrences in the original string.
	It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).

Example 2:
	Input=  aaaa
			1
			3
			3
	Output= 2
	Explanation: Substring "aaa" occur 2 times in the string. It can overlap.

Example 3:
	Input=  aabcabcab
			2
			2
			3
	Output= 3

Example 4:
	Input=  abcde
			2
			3
			3
	Output= 0

 * 
 */
package Elite;
import java.util.*;

class CheckDistinctSubstrings{
    
    public static boolean checkSubstring(String str,int letters){
        HashSet<Character> set = new HashSet<>();
        for(int i =0 ;i<str.length();i++){
            set.add(str.charAt(i));
        }
        return (set.size() <= letters);
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int letters = sc.nextInt();
        int min = sc.nextInt();
        int max = sc.nextInt();
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<str.length();i++){
            if(i+min < str.length()+1){
                if(checkSubstring(str.substring(i,i+min),letters) == true){
                    String x = str.substring(i,i+min);
                    if(map.containsKey(x)){
                        map.put(x,map.get(x)+1);
                    }
                    else map.put(x,1);
                }
            }
            if(i+max < str.length()+1){
                if(checkSubstring(str.substring(i,i+max),letters) == true){
                    String x = str.substring(i,i+max);
                    if(map.containsKey(x)){
                        map.put(x,map.get(x)+1);
                    }
                    else map.put(x,1);
                }
            }
        }
        if(map.size()> 0) System.out.println(Collections.max(map.values()));
        else System.out.println(0);
    }
}