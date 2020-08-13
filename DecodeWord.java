/* ELITE DAY - 105
	“Enigma” is a German encoding machine which was used to transmit messages as numbers. 
    Alan Turing a British cryptologist has hired KMIT students to break the code and save England. 
    
    Alan has figured out and informed you that each letter is represented as number in enigma 
    with 'a' being 1 'b' being 2,.. and 'z' being 26. 
    
    However a number 211 can mean “ua” or “baa” or “bk”. Further Turing has also supplied you 
    with a dictionary of potential targets which Germany is 
    likely to attack like “london” ,”reading” , “york”  etc. 
    
    Given an enigma generated message, you should help Turing inform the British Defence system
    about the next target. For example 12151441514 means the next attack is on London. 
    Similarly 25151811 means York will be attacked.
    
    Input Format:
    -------------
    Line-1 -> space seperated Strings, dictionary of potential targets.
    Line-2 -> a String, enigma generated message.
    
    Output Format:
    --------------
    Print the potential target.
    
    
    Sample Input-1:
    ---------------
    london reading york cambridge oxford norwich bradford 
    12151441514
    
    Sample Output-1:
    ----------------
    london
    
    Sample Input-2:
    ---------------
    london reading york cambridge oxford norwich bradford
    31132189475
    
    Sample Output-2:
    ----------------
    cambridge

*/
package Elite;
import java.util.*;

class DecodeWord {
 
    public static String findMatch(String encode, String decode) {
        String match="";
		for(int i=0;i<decode.length();i++){
			match=match+(decode.charAt(i)-96);
		}
		return match;
    }
    public static String findDecode(String str[],String encode) {
        for(String decode:str){
			if(encode.equals(findMatch(encode,decode)))
				return decode;
		}
        return "No Match";
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String[] str=sc.nextLine().split(" ");
		String en=sc.next();
		System.out.println(findDecode(str,en));
	}
}