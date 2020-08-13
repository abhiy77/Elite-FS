/* 08/04/2020 - HOME
 * 
In a revised game of hopscotch, a child is trying to cross a line of tiles 
with a binary string painted on it. 

Consider the line of tiles to be like a 1D array, where each tile has either a 1 or a 0, 
and a consecutive series of tiles making the whole string. 

The game starts with the child standing in front of the leftmost character of the string

All jumps to reach the end of the string can only be on tiles with 0 or only be on tiles with 1.

The game is won if the child can reach the end of the string, taking jumps 
with the minimum required power. 

In 10101, the power of the jump from beginning to the first tile is 1, 
but from the first to the third tile is 2 and so on.

Find the minimum power the child's jump should have in order to win the game for 
different binary strings. 

Note : In one jump, the child can jump to the right, 
any distance from 1 to the value of the power of her jump.

For example, for the string 10101, the power of the jump needs to be minimum 2.

Sample Input 
    11111

Sample Output 
    1

Explanation :
Since all the string elements are 1, 
the minimum power of the jump needs to be 1 to cross the string.

Sample Input 
    11101

Sample Output
    2

========= Testcases Program-1 =========
case =1
input =11111
output =1

case =2
input =11101
output =2

case =3
input =10101
output =2

case =4
input =1001111100111000111
output =4

case =5
input =100111110011110011
output =3

case =6
input =11110101010110111
output =2

case =7
input =11001100111011100111
output =3

case =8
input =1111111101001000100001
output =5
*/
package Elite;
import java.util.*;
public class HopscotchJumping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int min_power = 1,streak=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '0') {
				streak++;
			}
			else if(str.charAt(i) == '1') {
				min_power = Math.max(min_power,streak+1);
				streak = 0;
			}
		}
		min_power = Math.max(min_power,streak+1);
		System.out.println(min_power);
	}
}