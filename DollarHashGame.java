/* 27/06/2020 - HOME
 * Input Format:
 * 
 * Replace 2 consecutive dollars with hashes . If the current player cannot make a move then the other player wins
-------------
A string S, contains only $ and # 

Output Format:
--------------
print either 'true' or 'false' as your answer.


Sample Input-1:
---------------
$$$$$$

Sample Output-1:
----------------
true

Sample Input-2:
---------------
$$#$$$

Sample Output-2:
----------------
false


 */
package Elite;
import java.util.*;


import java.util.Scanner;

class DollarHashGame {
    int len;
    char ss[];
	boolean canWin(String s) {
		len = s.length();
		ss = s.toCharArray();
		return canWin();
	}
	boolean canWin() {
		for (int is = 0; is <= len-2; ++is) {
			if (ss[is] == '$' && ss[is+1] == '$') {
				ss[is] = '#'; ss[is+1] = '#';
				boolean wins = !canWin(); 
				ss[is] = '$'; ss[is+1] = '$';
				if (wins) return true;
			}
		}
		return false;
	} 
	public static void main(String args[])
	{
		System.out.println(new DollarHashGame().canWin(new Scanner(System.in).next()));
	}
}
//public class DollarHashGame {
//	static boolean winner = true;
//	
//	public static boolean recurse(String str,boolean turn) {
//		System.out.println(str);
//		if(str.length() < 2) return false;
//		for(int i=0;i<str.length()-1;i++) {
//			if(str.charAt(i) == '$' && str.charAt(i+1) == '$') {
//				if(recurse(str.substring(0,i) + "##" +str.substring(i+2),!turn)){
//					winner = turn;
//					return true;
//				}
//			}
//		}
//		winner = !turn;
//		return true;
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
//		int n = str.length();
//		if(n == 0 || n == 1) {
//			System.out.println("false");
//			System.exit(1);
//		}
//		recurse(str,true);
//		System.out.println(winner);
//	}
//}