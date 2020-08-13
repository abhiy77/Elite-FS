/* 24/01/2020
 * 
A Program to check if strings are rotations of each other or not

Given a string s1 and a string s2, 
write a snippet to say whether s2 is a rotation of s1?
example:
given s1 = ABCD and s2 = CDAB, return "YES", 
given s1 = ABCD, and s2 = ACBD , return "NO"

Sample Input:
ABACD CDABA

Sample Output:
YES

Explanation:
s2 = CDABA
after 1st rotation, s2=DABAC
after 2nd rotation, s2=ABACD
in this rotation s1==s2. strings are rotations of each other.
print YES.

 * 
 */
package Elite;
import java.util.*;
class StringRotation 
{ 
	public static void main (String[] args) 
	{ 

	    Scanner sc = new Scanner(System.in);
	    String x = sc.next();
	    String y = sc.next();
	    
	    x +=x;
	    if(x.indexOf(y) > 1){
	        System.out.println("YES");
	    }
	    else System.out.println("NO");

	} 
} 
