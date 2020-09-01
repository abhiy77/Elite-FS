/* 01/09/2020 - (ELITE DAY 114)
 * 
 * You are decorating a side wall with balloons.
You have an unlimited set of ballons of three different colors.

The decoration should have N rows of 3 balloons each. 
You have to make sure that no two adjacent balloons have the same colour.
both vertically and horizontally.

Return the number of ways you can decorate the wall,  
the answer must be computed modulo 10^9 + 7

Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer as output, number of ways to decorate.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
12

Explanation:
------------
Suppose the colors are, B, G, R. Given N is 1
RBR	BRB	GRB
RBG	BRG	GRG
RGR	BGR	GBR
RGB	BGB	GBG


Sample Input-2:
---------------
2

Sample Output-2:
----------------
54

 */
package Elite;
import java.util.*;
public class DecoratingSideWall {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long bal_2 = 6;
		long bal_3 = 6;
		long next_2 = 0 , next_3 = 0;
		long modulo = (long)1e9 +7;
		for(int i=1;i<n;i++) {
			next_2 = bal_2 * 3 + bal_3 * 2;
			next_3 = bal_2 * 2 + bal_3 * 2;
			bal_2 = next_2 % modulo;
			bal_3 = next_3 % modulo;
		}
		System.out.println((bal_2 + bal_3) % modulo);
	}
}