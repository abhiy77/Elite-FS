/* 04/06/2020 - HOME
 * HACKERRANK - SEPARATE THE NUMBERS
 * 
 * Input Format:
-------------
Line-1 -> An Integer String.

Output Format:
--------------
Print its answer on a new line,
either "YES x" where x is the smallest first number of the increasing sequence, or "NO"

Sample Input:
-------------
91011
Sample Output:
--------------
YES 9

Sample Input:
-------------
010203
Sample Output:
--------------
NO



------Testcases------------

case =1
input =91011
output ="YES 9"

case =2
input =99100
output ="YES 99"

case =3
input =101103
output ="NO"

case =4
input =010203
output ="NO"

case =5
input =99910001001
output ="YES 999"

case =6
input =7891011
output ="YES 7"

case =7
input =9899100
output ="YES 98"

case =8
input =101102103104105
output ="YES 101"

 */
package Elite;
import java.util.*;

public class SeparateTheNumbers {
	
	public static boolean isSequencePossible(String num,String temp) {
		if(temp.charAt(0) == '0') return false;
		int index = temp.length();
		int size = index;
		while(index < num.length()) {
			if(temp.charAt(temp.length()-1) == '9') size++;
			if(index + size > num.length()) return false;
			int next = Integer.parseInt(num.substring(index,index + size));
			if(Integer.parseInt(temp) + 1 != next) return false;
			temp = Integer.toString(next);
			index+=size;
		} 
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int flag = 0;
		for(int i=1;i<=16;i++) {
			if(i > num.length()/2) break;
			String temp = num.substring(0,i);
			if(isSequencePossible(num,temp)) {
				System.out.println("YES "+temp);
				flag=1;
				break;
			}
		}
		if(flag == 0) System.out.println("NO");
	}
}