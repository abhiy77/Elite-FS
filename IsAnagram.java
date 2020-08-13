/* 03/03/2020
 * 
 Find if 2 strings are anagrams, is it possible to find it in o(n) time and O(1) space.
 
input:god
dog
 
 output:
 true
 
 
 input:kmit
 ngir
 
 output:
 false
 
 */
package Elite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IsAnagram {

	private static boolean isAnagramWithOneArray(String a, String b) {
	    int arr[] = new int[26];
        if(a.length() != b.length()) return false;
        for(int i=0;i<a.length();i++){
            arr[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++){
            arr[b.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(arr[i] != 0) return false;
        }
        return true;
	}
	
	   public static void main(String args[])  throws IOException {

		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String strFirst = br.readLine();
			String strSecond = br.readLine();

			System.out.println(isAnagramWithOneArray(strFirst,strSecond));
	  
	    } 
	
}