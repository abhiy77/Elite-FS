/* 24/01/2020
 * Write an algorithm to determine if a number is "special number".

A special number is a number defined by the following process: 
Starting with any positive integer, 
replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 

Those numbers for which this process ends in 1 are special numbers.

Example: 
    Input: 19
    Output: true
    Explanation: 
    1^2 + 9^2 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
 */
package Elite;
import java.util.*;
public class SpecialNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String special_num = sc.next();
		LinkedList<Integer> list = new LinkedList<>();
		int total = 0;
		while(total != 1 ) {
			total = 0;
			for(int i=0;i<special_num.length();i++) {
				int x = Integer.parseInt(""+special_num.charAt(i));
				total +=(Math.pow(x,2));
			}
			if(list.contains(total)) {
				System.out.println(false);
				break;
			}
			list.add(total);
			special_num = String.valueOf(total);
		}
		if(total == 1)System.out.println(true);
	}
}