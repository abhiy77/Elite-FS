/* 28/01/2020
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
In other words, one of the first string's permutations is the substring of the second string.


Example 1:
    Input: ab
    eidbaooo
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
    Input:ab
    eidboaoo
    Output: false
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10000].


 */
package Elite;
import java.util.*;

class FindingPermutation{
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str1 = sc.nextLine();
        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr1);
        String str2 = sc.nextLine();
        for(int i=0;i<=str2.length()-str1.length();i++) {
        	char arr2[] = str2.substring(i, i+str1.length()).toCharArray();
        	Arrays.sort(arr2);
        	int flag = 0;
        	for(int j=0;j<arr2.length;j++){
        	    if(arr1[j] != arr2[j] ) {
        	        flag = 1; break;
        	    }
        	}
        	if(flag == 0){
        	   System.out.println(true); System.exit(1); 
        	} 
        }
        System.out.println(false);
    }
}