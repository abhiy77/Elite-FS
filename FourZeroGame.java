/* 27/04/2020 - HOME
 * Charlie and Johnny play a game. 
For every integer X Charlie gives, Johnny has to find the smallest positive integer Y, 
such that X * Y contains only 4's and 0's and 
starts with one or more 4's followed by zero or more 0's. 
(i.e.), 404 is an invalid number but 400 is a valid number.

If a is the number of 4's and b is the number of 0's, can you print the value of 2 * a + b.

Input Format
The first line containing the integer X as stated above.

Output Format
Print the output 2 * a + b in a newline as stated in the problem statement.


Sample Input #1
4
Sample Output #1
2

Sample Input #2
5
Sample Output #2
3

Sample Input #3
80
Sample Output #3
4

Explanation:
For the Sample #1, the smallest such multiple of 4 is 4 itself. 
Hence value of a will be 1 and and value of b will be 0. 
The required value of 2 * a+b is 2.

For the Sample #2, Y = 8 and 40 is the minimum such multiple of 5. 
Hence value of a,b and 2 * a+b will be 1, 1 and 3 respectively.

For the Sample #3, Y = 5 and 400 is the minimum such multiple of 5. 
Hence value of a,b and 2 * a+b will be 1, 2 and 4 respectively.

========= Testcase's Program-2 =========
case =1
input =4
output =2

case =2
input =5
output =3

case =3
input =8
output =3

case =4
input =41
output =10

case =5
input =3
output =6

case =6
input =2
output =2

case =7
input =59
output =116

case =8
input =23
output =44

 */
package Elite;
import java.util.*;

public class FourZeroGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int c2=0,c5=0,a=1,b;  //n=2^(2+b)*5^b*11111..a
        while(n%2==0){
            c2++;
            n/=2;
        }
        while(n%5==0){
            c5++;
            n/=5;
        }
        b=Math.max(c2-2,c5);
        for(int i=1%n;i!=0;i=(10*i+1)%n,a++);
        //System.out.println(a + " " + b);
        System.out.println(2*a+b);
    }
}