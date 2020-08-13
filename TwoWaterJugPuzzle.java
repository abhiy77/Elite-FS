/* 27/04/2020 - HOME
 * Given 2 jugs of capacity a and b gallons, and an infinite supply of water, 
can you fill one of the jugs with exactly c gallons of water ?

Input Format:
First line contains 3 space separated integers a, b and c . 
a and b indicate the capacity of the two jugs respectively, 
and c denotes the exact capacity with which one of the jugs should be filled.

Output Format:
print "YES" if one of the jugs can be filled with exactly c gallons of water 
and "NO" if they cannot be filled. ( quotes are for clarity )

Constraints:
1 ≤ a, b, c ≤ 1000

Sample Input1:
5 3 4
Sample Output1:
YES

Sample Input2:
3 6 4
Sample Output2:
NO

Explanation:

Sample#1:
a = 5, b = 0
Now, he can fill jug b with 3 gallons from jug a.
a = 2, b = 3
He can empty jug b and empty 2 gallons from jug a to jug b.
a = 0, b = 2
Now, he can fill jug a with 5 gallons and fill jug b with 1 gallon from jug a. 
This results in jug a containing exactly 4 gallons of water.
a = 5, b = 2
a = 4, b = 3

In Sample #2, it is impossible to generate 4 gallons of water, hence "NO".

Given 2 jugs of capacity a and b gallons, and an infinite supply of water, 
can you fill one of the jugs with exactly c gallons of water ?

Input Format:
First line contains 3 space separated integers a, b and c . 
a and b indicate the capacity of the two jugs respectively, 
and c denotes the exact capacity with which one of the jugs should be filled.

Output Format:
print "YES" if one of the jugs can be filled with exactly c gallons of water 
and "NO" if they cannot be filled. ( quotes are for clarity )

Constraints:
1 ≤ a, b, c ≤ 1000

Sample Input1:
5 3 4
Sample Output1:
YES

Sample Input2:
3 6 4
Sample Output2:
NO

Explanation:

Sample#1:
a = 5, b = 0
Now, he can fill jug b with 3 gallons from jug a.
a = 2, b = 3
He can empty jug b and empty 2 gallons from jug a to jug b.
a = 0, b = 2
Now, he can fill jug a with 5 gallons and fill jug b with 1 gallon from jug a. 
This results in jug a containing exactly 4 gallons of water.
a = 5, b = 2
a = 4, b = 3

In Sample #2, it is impossible to generate 4 gallons of water, hence "NO".

========= Testcases Program-1 =========
case =1
input =5 3 4
output ="YES"

case =2
input =3 6 4
output ="NO"

case =3
input =272 618 186
output ="YES"

case =4
input =458 913 372
output ="YES"

case =5
input =872 373 828
output ="YES"

case =6
input =573 702 4
output ="NO"

case =7
input =745 970 713
output ="NO"

case =8
input =812 623 83
output ="NO"

 */
package Elite;
import java.util.*;
public class TwoWaterJugPuzzle {
	
	public static int gcd(int a,int b) {
		while(a != b) {
			if(a > b) a-=b;
			else b-=a;
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        if( k % gcd(n,m) != 0) System.out.println("NO");
        else System.out.println("YES");
	}
}