/*03/03/2020
 * 
 Given a string s, find the longest palindromic substring in s. 
 You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.


Example 2:

Input: "cbbd"
Output: "bb"

Note:   if there are more than one longest pallindromes 
        print the first one.
*/
package Elite;
import java.util.*;
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        String str = sc.nextLine();
	        int max = 1;
	        String ans = ""+str.charAt(0);
	        for(int i=1;i<str.length()-1;i++){
	            int j = i, k=i;
	            while(j-1 >= 0 && k+1<=str.length()-1 && str.charAt(j-1) == str.charAt(k+1)) {
	            	j--; k++; 
	            }
	          //  System.out.println(j + " " + k + " at 1 for i " + i);
	            if(max < (k-j+1)) {
	            	ans = str.substring(j,k+1);
	            	max = k-j+1;
	            }

	            if(str.charAt(i) != str.charAt(i+1)) continue;
	            j = i;k = i+1;
	            while(j-1 >= 0 && k+1<=str.length()-1 && str.charAt(j-1) == str.charAt(k+1)) {
	            	j--; k++; 
	            }
	         // System.out.println(j + " " + k + " at 2 for i " + i);
	            if(max < (k-j+1)) {
	            	ans = str.substring(j,k+1);
	            	max = k-j+1;
	            }
	        }
	        System.out.println(ans);
	}
}