/* 29/01/2020
 * Given an input string (s) and a pattern (p), 
implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.


Example 1:
Input:  aa
        a
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
    Input:  aa
            a*
    Output: true
    Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input:  ab
        .*
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input:  aab
        c*a*b
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

Example 5:
    Input:  mississippi
            mis*is*p*.
    Output: false

 */
package Elite;
import java.util.*;
public class RegularExpressionMatching {
	
	public static boolean regexMatch(String str,String pattern) {
		boolean arr[][] = new boolean[str.length()+1][pattern.length()+1];
		
		arr[0][0] = true;
		
		for(int i=1;i<arr[0].length;i++) {
			if(pattern.charAt(i-1) == '*') {
				arr[0][i] = arr[0][i-2];
			}
		}
		
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<arr[0].length;j++) {
				if(pattern.charAt(j-1) == str.charAt(i-1) || pattern.charAt(j-1) == '.') {
					arr[i][j] = arr[i-1][j-1];
				}
				else if(pattern.charAt(j-1) == '*') {
					arr[i][j] = arr[i][j-2];
					if(pattern.charAt(j-2) == str.charAt(i-1) || pattern.charAt(j-2) == '.') {
						arr[i][j] = arr[i][j-2] | arr[i-1][j];
					}
				}
				else {
					arr[i][j] = false;
				}
			}
		}
		return arr[str.length()][pattern.length()];
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String pattern = sc.nextLine();
		System.out.println(regexMatch(str, pattern));
	}
}

/*
case =1
input =memorial
m*emor*al
output =false

case =2
input =iiijjjjijjjkkkkiii
i*j*ik*iii
output =false

case =3
input =institute
i.s*ti*ut*.
output =false

case =4
input =institute
i.s*.it*ut*.
output =true

case =5
input =aaaaaaaaaaaaabbbbbbbbcccccc
a*b*.....c
output =true

case =6
input =iiijjjjijjjkkkkiii
i*j*i...k*iii
output =true

case =7
input =m
m*e*.o*r*a*l*
output =true

case =8
input =m
me*mo*r*a*l*
output =false*/


//public static boolean recurse(String str,String pattern) {
//if(pattern.length() == 0 && str.length() == 0) {
//	return true;
//}
//if( pattern.charAt(0) == str.charAt(0) || pattern.charAt(0) == '.') {
//	if(pattern.length() > 1 && pattern.charAt(1) == '*') {
//		if(recurse(str.substring(1), pattern)== true) return true;
//	}
//	else {
//		if(recurse(str.substring(1), pattern.substring(1))== true) return true;
//	}
//}
//else if(pattern.length() > 1 && pattern.charAt(0) != str.charAt(0)) {
//	if(pattern.charAt(1) == '*') {
//		if(recurse(str, pattern.substring(2)) == true) return true;
//	}
//}
//System.out.println(pattern + "  " + str);
//return false;
//}