/* 07/04/2020 - HOME 
 * You have a warehouse with M containers filled with an infinite number of candies. 
The containers are arranged in a single row, equally spaced to be 1 meter apart. 
You also have 2 robots that can pick up 1 piece of candy and transport it between 
any two containers.

The robots take instructions in the form of queries consisting of two integers Ma and Mb, 
respectively. To execute a query, a robot travels to container Ma, picks up 1 candy, 
transports it to container Mb, and then stops at Mb until it receives another query.

Calculate the minimum total distance the robots must travel to execute N queries in order.

Note: You choose which robot executes each query.

Input Format:
  - The first line has two space-separated integers, M (the number of containers) and 
    N (the number of queries).
  - The  subsequent lines each contain two space-separated integers, Ma and Mb respectively,
    each line Ni describes the ith query.

Output Format:
  - Print an integer denoting the minimum total distance that the robots must travel to 
    execute the queries in order.

Sample Input-1
			5 4
			1 5
			3 2
			4 1
			2 4
Sample Output-1
			11

Sample Input-2
			10 3
			2 4
			5 4
			9 8
Sample Output-2
			5

Explanation
	Sample-1:
		Robot-1: 1 5, Distance is 4 meters.
		Robot-2: 3 2, Distance is 1 meter.
		Robot-1: From 5 4 ,then 4 1, Distance is 4 meters.
		Robot-2: From 2 2, then 2 4, Distance is 2 meters.
		Sum the distances traveled ( 4 + 1+ 4 + 2 = 11 ).

	Sample-2:
		Robot-1: 2 4 , Distance is 4 meters.
		Robot-1: From 4 5, then 5 4, Distance is 2 meters.
		Robot-2: 9 8, Distance is 1 meters.
		Sum the distances traveled (2 + 2 + 1 = 5).
		

========= Testcases Program-4 =========
case =1
input =7 10
3 4
6 1
5 7
1 4
4 5
5 2
5 2
5 3
7 2
3 5
output =34

case =2
input =8 10
6 1
2 6
8 2
3 5
7 2
1 5
2 1
1 8
2 8
2 7
output =59

case =3
input =5 7
4 1
5 3
5 2
3 1
4 5
4 3
1 3
output =21

case =4
input =6 5
6 5
1 5
1 5
2 5
3 1
output =23

case =5
input =5 8
4 3
1 3
3 1
2 3
5 1
2 4
4 3
4 5
output =19

case =6
input =10 7
2 1
5 7
1 8
8 2
8 5
7 4
2 9
output =32

case =7
input =10 9
5 9
7 9
8 10
9 3
10 9
4 7
10 4
5 9
8 1
output =40

case =8
input =5 4
1 5
3 2
4 1
2 4
output =11
 */
package Elite;
import java.util.*;
public class RobotsAndCandies {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int containers = sc.nextInt();
		int queries = sc.nextInt();
		int a[] = new int[queries];
		int b[] = new int[queries];
		
		for(int i = 0; i < queries; i++){
			a[i] = sc.nextInt() - 1;
			b[i] = sc.nextInt() - 1;
		}	
		int dp[][] = new int[queries + 1][containers + 1];
		
		for(int i = queries - 1; i >= 1; i--){
			for(int j = 0; j < containers; j++){
				dp[i][j] = dp[i + 1][b[i - 1]] + Math.abs(a[i] - j) + Math.abs(b[i] - a[i]);
				dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + Math.abs(b[i - 1] - a[i])  + Math.abs(b[i] - a[i]));
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int j = 0; j < containers; j++)
			ans = Math.min(ans, dp[1][j] + Math.abs(b[0] - a[0]));
		
		System.out.println(ans);	
	}
}