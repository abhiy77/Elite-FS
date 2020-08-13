/*27/01/2020
 * You are given a key represented as a string S which consists only alphanumeric 
character and dashes. The string is separated into N+1 groups by N dashes.

Given a number K, we want you to reformat the strings such that, 
each group contains exactly K characters, except for the first group 
which could be shorter than K, but still must contain at least one character.
Furthermore, there must be a dash inserted between two groups 
and all lowercase letters should be converted to uppercase.

Given a non-empty string S and a number K, 
format the string according to the rules described above.

Example 1:
	Input=  5F3Z-2e-9-w
	        4
	Output= 5F3Z-2E9W
	Explanation: The string S has been split into two parts, each part has 4 characters.	
	Note that the two extra dashes are not needed and can be removed.

Example 2:
	Input=  2-5g-3-J
	        2
	Output= 2-5G-3J
	Explanation: The string S has been split into three parts, each part has 2 characters 
	except the first part as it could be shorter as mentioned above.
 * 
 */
package Elite;
import java.util.*;

class GroupStrings{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int combine = sc.nextInt();
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) !='-') list.add(str.charAt(i));
        }
        for(int i=list.size()-1;i>=0;){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            while(count < combine && i >=0){
                sb.append(list.get(i));
                i--;
                count++;
                if(i < 0) break;
            }
            result.add(sb.reverse().toString().toUpperCase());
        }
        for(int i=result.size()-1;i>=0;i--){
            if(i!=0)System.out.print(result.get(i)+"-");
            else{System.out.print(result.get(i));}
        }
    }
}