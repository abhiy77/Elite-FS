/* 05/06/2020 - HOME
 * REFERENCE - GEEKS FOR GEEKS (Check if it is possible to transform one string to another)
 * 
 * You can perform the following operations on the string A:

1. Capitalize zero or more of A's lowercase letters.
2. Delete all of the remaining lowercase letters in A.

Given two strings A and B, determine if it's possible to make equal to as described.

Input Format:
-------------
Line-1 -> A single string A, contains [A-Za-z], 
Line-2 -> A single string B, contains [A-Z]

Output Format:
--------------
Print "YES", If you can match String A with B
Otherwise print "NO"


Sample Input:
-------------
daBcd
ABC
Sample Output:
--------------
YES


Sample Input:
-------------
AbcDE
AFDE
Sample Output:
--------------
NO
 */
package Elite;
import java.util.*;

class MatchingStrings{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int m = a.length();
        int n = b.length();
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=0;i<m;i++){
            for(int j=0;j<=n;j++){
                if(dp[i][j]){
                    if(j < n && Character.toUpperCase(a.charAt(i)) == b.charAt(j)){
                        dp[i+1][j+1] = true;
                    }
                    if(!Character.isUpperCase(a.charAt(i))){
                        dp[i+1][j] = true;
                    }
                }
            }
        }
        System.out.println(dp[m][n] ? "YES" : "NO");
    }
}