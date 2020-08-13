/* 23/04/2020 - HOME
 * 
Lia is fascinated by anything she considers to be a twin. 
She calls a pairs of positive integers, i and j, twins if:
-They are both prime. A prime number is an integer greater than 1 that has no positive divisors 
other than 1 and itself.
-Their absolute difference is exactly equal to  2(i.e.|j-i|=2).

Given an inclusive interval of integers from n to m, 
can you help Lia find the number of pairs of twins there are in the interval 
Note that pairs (i,j) and (j,i) are considered to be the same pair.

Input Format:
Two space-separated integers describing the respective values of  n and m.

Output Format:
Print a single integer denoting the number of pairs of twins.

Sample Input1:
3 13
Sample Output1:
3
Explanation1:
There are three pairs of twins: (3,5),(5,7) and (7,9).

========= Testcases Program-1 =========
case =1
input =3 13
output =3

case =2
input =4 5
output =0

case =3
input =1 1000
output =35

case =4
input =13 956
output =32

case =5
input =281 586
output =8

case =6
input =45 639
output =22

case =7
input =869782 1082556
output =1516

case =8
input =3449962 3573724
output =718

 */
package Elite;
import java.util.*;
public class PrimeTwins {
	
	public static boolean isPrime(int num) {
		if(num % 2 == 0) return false;
		for(int i=3;i<=Math.sqrt(num);i+=2) {
			if(num % i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int val = start > 3 ? start : 3;
		int pairs = 0;
		for(int i=val;i<=end-2;i++) {
			if(isPrime(i) && isPrime(i+2)) {
				pairs++;
			}
		}
		System.out.println(pairs);
	}
}