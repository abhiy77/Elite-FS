/* 23/01/2020
 * 
You are merging data from two sources connected to a network access point to create a new data packet. 

You must merge strings a and b, and the return a single merged string. 
A merge operation on two strings is described as follows.

Append alternating characters from a and b, respectively, to some new string mergedString.
Once all of the characters in one of the strings have been merged, 
append the remaining characters in the other string to mergedString.

As an example, assume you have two strings to merge : 'abc' and 'stuvwx'. 
Alternate between the first and second strings as long as you can :

'a' + 's'+'b'+'t'+'c' +'u'. At this point you have traversed the first string and have generated 'asbtcu'. 
The remainder of the second string ,'vwx' is now added to the end of the string, creating 'asbtcuvwx'.

Sample Input:
kmit
ngit

Sample Output:
knmgiitt


 * 
 */
package Elite;
import java.util.*;
public class MergeStrings {

	public static void main(String[] args)
    { 
	   Scanner sc = new Scanner(System.in);
	   String first = sc.nextLine();
	   String second = sc.nextLine();
	   int i=0,j=0;
	   StringBuilder sb = new StringBuilder();
	   while(i <  first.length() && j <second.length()){
	       sb.append(""+first.charAt(i++)+second.charAt(j++));
	   }
	   while(i < first.length()){
	       sb.append(""+first.charAt(i++));
	   }
	   while(j <second.length()){
	       sb.append(""+second.charAt(j++));
	   }
	   System.out.println(sb.toString());
    } 
}