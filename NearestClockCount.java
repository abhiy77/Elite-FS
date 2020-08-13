/* 06/01/2020
Given a String, represents the time in the format "HH:MM" which is 24 hours format, 
find the next nearest time by reusing the digits in the given string. 
There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. 
For example, 01:34, 12:09 are all valid. 1:34, 12:9 are all invalid.

Example 1:
	Input= 12:35
	Output= 12:51
    
    Explanation: The next nearest time choosing from digits 1, 2, 3, 5, is 12:51, which occurs 16 minutes later.  
    It is not 12:32, because this occurs 23 hours and 57 minutes later.

Example 2:
	Input= 16:56
	Output= 11:11
    Explanation: The next nearest time choosing from digits 1, 6, 5, 6 is 11:11. 
    It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
    Accepted

*/
package Elite;
import java.util.*;
public class NearestClockCount {
	
	public static String checkSubstringDigits(int start ,int end,int val,String str) {
		String s = "";
		s = (Integer.parseInt(str.substring(start,end)) + val) <= 9 ? s.concat("0")+ (Integer.parseInt(str.substring(start,end)) + val) : ""+(Integer.parseInt(str.substring(start,end)) + val);
        return s;
	}
	
	public static String assign(String str) {
		String temp = "";
		if(str.substring(3,5).equals("59")) {
			if(str.substring(0,2).equals("23")) {
				temp = "00:00";
			}
			else {
				temp = checkSubstringDigits(0, 2, 1, str) +":00";
			}
		}
		else {
			temp = checkSubstringDigits(0, 2, 0, str)+":" +checkSubstringDigits(3, 5, 1, str);
		}
		//System.out.println(temp);
		return temp;
	}

	public static boolean isSafe(String temp,String str) {
		for(int i=0;i<str.length();i++) {
			if(!str.contains(Character.toString(temp.charAt(i)))){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
	     Scanner sc = new Scanner(System.in);
         String str = sc.nextLine();
         String temp = assign(str);
         while(!isSafe(temp,str)) {
        	 temp = assign(temp);
         }
         System.out.println(temp);
	}
}