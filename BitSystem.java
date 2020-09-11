/* 11/09/2020 - (ELITE DAY 119)
 * Given a integer value N, indicates number of bits in a binary number.

Your task is to design a Binary Code System, 
where two consecutive values in BCS having N bits, must have one bit difference only.
For example refer the sample testcases.

Find and print the integer values of BCS, starting from 0.


Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3

Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0     
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4

 */
package Elite;
import java.util.*;

public class BitSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i=1;i<=n;i++){
            int count = res.size()-1;
            int add = (int)Math.pow(2,i-1);
            while(count>=0)
                   res.add(add+res.get(count--));
        }
        System.out.println(res);
	}
}