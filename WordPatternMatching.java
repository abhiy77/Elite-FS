/* 04/09/2020 - (ELITE DAY - 115)
 * 
Madhu is given strings, Word W and Pattern P.
W contains only lowercase letters, P contains lowercase letters and $, *.

In the pattern:
'$' indicates any single lowercase letter.
'*' indicates zero more number of lowercase letters.

Madhu's task is to find out, whether Pattern is matching the complete Word or not.
If pattern match the complete word, print true.
Otherwise false.

Input Format:
-------------
Two strings, Word and Pattern

Output Format:
--------------
Print the boolean result


Sample Input-1:
---------------
aa *

Sample Output-1:
----------------
true


Sample Input-2:
---------------
cb $a

Sample Output-2:
----------------
false


Sample Input-3:
---------------
abcde a*d*

Sample Output-3:
----------------
true


Sample Input-4:
---------------
acdcb a*c$b

Sample Output-4:
----------------
false

 */
package Elite;
import java.util.*;

class WordPatternMatching{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String pattern = sc.next();
        
        boolean dp[][] = new boolean[word.length()+1][pattern.length()+1];
        
        dp[0][0] = true;
        
        for(int i=1;i<pattern.length()+1;i++){
            if(pattern.charAt(i-1) == '*') dp[0][i] = dp[0][i-1];
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(word.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '$'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        System.out.println(dp[word.length()][pattern.length()]);
    }
}