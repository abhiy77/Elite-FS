/*08/09/2020 - (ELITE DAY - 117)
 * 
 * Given a nokia phone,with the following dialpad.
		1 2 3
		4 5 6
		7 8 9
		* 0 #
And You are given an L band to dial the number,  
Using the L band you can dial the number as follows, 
- You can start with any digit,
	- if you are at digit 1, next digit you can choose {6,8}
	- if you are at digit 2, next digit you can choose {7,9}
	- if you are at digit 3, next digit you can choose {4,8}
	and so on..

Now your task is to find how many distinct numbers of length N you can dial.

Note: Numbers should contain only digits, no {* , #}.
Answer is modulo 1000000007.

Input Format:
-------------
An integer N, length of numbers
 
Output Format:
--------------
Print an integer, number of distinct numbers you can dial.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
10

Explanation:
-------------
To dial a number of length 1, you can dial all digits.


Sample Input-2:
---------------
2

Sample Output-2:
----------------
20

Explanation:
------------
To dial a number of length 2, the possible numbers are
{04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94}

Sample Input-3:
---------------
5

Sample Output-3:
----------------
240

 */
package Elite;
import java.util.*;

public class DiallingNumbers {

	static long MODULO = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		map.put(0, Arrays.asList(4,6));
		map.put(1, Arrays.asList(6,8));
		map.put(2, Arrays.asList(7,9));
		map.put(3, Arrays.asList(4,8));
		map.put(4, Arrays.asList(0,3,9));
		map.put(6, Arrays.asList(0,1,7));
		map.put(7, Arrays.asList(2,6));
		map.put(8, Arrays.asList(1,3));
		map.put(9, Arrays.asList(2,4));
		
		int dp[][] = new int[10][n+1];
		
		for(int i=0;i<=9;i++) {
			dp[i][1] = 1;
		}
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				List<Integer> list = map.get(j);
				if(list == null)continue;
				for(int val : list) {
					dp[val][i] = dp[val][i] + dp[j][i-1];
					dp[val][i] %= MODULO;
				}
			}
		}
		
		int ans = 0;
		for(int i=0;i<=9;i++) {
			ans += dp[i][n];
			ans %= MODULO;
		}
		System.out.println(ans);
	}
}