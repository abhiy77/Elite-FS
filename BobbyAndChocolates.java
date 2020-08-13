/* 14/04/2020 - HOME
Little Bobby loves chocolate. He frequently goes to his favorite 5&10 store, Choco Feast, 
to buy them. They are having a promotion at Choco Feast. If Bobby saves enough wrappers, 
he can turn them in for a free chocolate.

For example, Bobby has n=15 to spend on bars of chocolate that cost c=3 each. 
He can turn in m=2 wrappers to receive another bar. 
Initially, he buys 5 bars and has 5 wrappers after eating them. 
He turns in 4 of them, leaving him with 1, for 2 more bars. 
After eating those two, he has 3 wrappers, 
turns in 2 leaving him with 1 wrapper and his new bar. 
Once he eats that one, he has 2 wrappers and turns them in for another bar. 
After eating that one, he only has 1 wrapper, and his feast ends. Overall, 
he has eaten 5+2+1+1 = 9 bars.

Input Format:
    Three space-separated integers: n, c, and m. They represent money to spend, 
    cost of a chocolate, and the number of wrappers he can turn in for a free chocolate.

Output Format:
    For each trip to Choco Feast, print the total number of chocolates Bobby eats on a new line.

Sample Input
    10 2 5
Sample Output
    6
    
Explanation:
He spends his 10 dollars on 5 chocolates at 2 dollars apiece. He then eats them and 
exchanges all 5 wrappers to get 1 more. He eats 6 chocolates.

========= Testcases Program-1 =========
case =1
input =12 4 4
output =3

case =2
input =6 2 2
output =5

case =3
input =10 2 5
output =6

case =4
input =7 3 2
output =3

case =5
input =1576 9 645
output =175

case =6
input =46985 24 680
output =1959

case =7
input =87354 869 5522
output =100

case =8
input =16292 57 5319
output =285

*/
package Elite;
import java.util.*;

public class BobbyAndChocolates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int cost = sc.nextInt();
		int wrappers = sc.nextInt();
		int chocolates = money/cost ,curr_wrappers = money/cost;
		while(curr_wrappers >= wrappers) {
			int temp = (curr_wrappers/wrappers);
			chocolates += temp;
			curr_wrappers = curr_wrappers % wrappers + temp;
		}
		System.out.println(chocolates);
	}
}