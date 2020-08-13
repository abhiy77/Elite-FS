/* 27/02/2020
 * You have given a task,
to count number of substrings which are pallindromes from a given String.

Example 1:
    Input= abc
    Output= 3
    Explanation= Three substrings are pallindrome: "a", "b", "c".
 

Example 2:
    Input= aaa
    Output= 6
    Explanation= Six substrings are pallindrome: "a", "a", "a", "aa", "aa", "aaa".

NOTE:
The substrings with different start indexes or end indexes are counted as 
different substrings even they consist of same characters.
 */
package Elite;
import java.util.*;

class PalindromicSubstrings{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = str.length();
        for(int i=0;i<str.length()-1;i++){
            int j = i-1, k=i+1;
            while(j >= 0 && k<=str.length()-1 && str.charAt(j--) == str.charAt(k++)) count++;
            if(str.charAt(i) != str.charAt(i+1)) continue;
            else count++;
            j = i-1;k = i+2;
            while(j >= 0 && k<=str.length()-1 && str.charAt(j--) == str.charAt(k++)) count++;
        }
        System.out.println(count);
    }
}
