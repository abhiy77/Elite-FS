/* 29/01/2020
 * Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:
	Input:	8
	Output:	 3
	Explanation:
		8 -> 4 -> 2 -> 1

Example 2:
	Input:	7
	Output:	 4
	Explanation:
		7 -> 8 -> 4 -> 2 -> 1
		or
		7 -> 6 -> 3 -> 2 -> 1

 * 
 */
package Elite;
import java.util.*;
public class BitCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		while(num != 1) {
			System.out.print(num+" ");
			if(num %2 == 0) {
				num/=2;
			}
			else {
				num = (Integer.bitCount(num+1) >= Integer.bitCount(num-1)? num-1 :num+1);
			}
			count++;
		}
        System.out.println(count);
	}
}
