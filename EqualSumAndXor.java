/* 17/04/2020 - HOME
 * Given an integer n, find each x such that:
0<= x <=n
n+x=n XOR x
Print the number of x's satisfying the criteria.

For example, if n=4, there are four values:
4+0=4XOR0=4
4+1=4XOR1=5
4+2=4XOR2=6
4+3=4XOR3=7

Input Format:
A single integer, n.

Output Format:
Print the total number of integers x satisfying the criteria.

Sample Input1:
5
Sample Output1:
2
Explanation1:
For n=5, the x values 0 and 2 satisfy the conditions:
5+0=5, 5XOR0=5
5+2=7, 5XOR2=7

Sample Input2:
10
Sample Output2:
4
Explanation2:
For n=10, the x values 0, 1, 4, and 5 satisfy the conditions:
10+0=10, 10XOR0=10
10+1=11, 10XOR1=11
10+4=14, 10XOR4=14
10+5=15, 10XOR5=15

NOTE: *****You should not compare the values of (x^n), (x+n) *****

========= Testcases Program-1 =========
case =1
input =5
output =2

case =2
input =0
output =1

case =3
input =100
output =16

case =4
input =50
output =8

case =5
input =34
output =16

case =6
input =64
output =64

case =7
input =79
output =4

case =8
input =10
output =4

 */
package Elite;
import java.util.*;
public class EqualSumAndXor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int unset = 0;
		while(n > 0) {
			if((n & 1) == 0)
				unset++;
			n >>= 1;
		}
		System.out.println(1<<unset);
	}
}