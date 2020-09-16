/* 15/09/2020 - (ELITE DAY 121)
In the present situation, most of the movies releasing in OTTs.
The Showtime OTT in US, introduced a new offer for the customers, 
they can purchase either 1-day, 7-day, or 30-day subscription,
and the cost is as follows price[0], price[1], price[2].

The Subscription allows you to watch as many movies as you want with in subscribed days. 
For example:
If you purchased, a 7-day subscription on day 5, then you can watch
the movies for 7 days: day 5, 6, 7, 8, 9, 10 and 11.

Your task is to find out the minimum cost, you spend to watch the movies
in the given list of days .

NOTE: Days are numbered from 1, 2, 3, ...365, in sorted order.

Input Format:
-------------
Line 1: Space separated integer days[], list of days.
Line 2: 3 space separated integer price[], cost of subscription.

Output Format:
--------------
Print an integer, minimum cost. 


Sample Input-1:
---------------
1 4 6 7 8 20
2 7 15

Sample Output-1:
----------------
11

Explanation:
------------
For example, here is a way to buy subscription, to watch the movies in given days:
On day 1, buy a 1-day subscription for price[0] = $2, which cover day 1.
On day 4, buy a 7-day subscription for price[1] = $7, which cover days 4, 5, ..., 10.
On day 20, buy a 1-day subscription for price[0] = $2, which cover day 20.
In total you spent $11.


Sample Input-2:
---------------
1 2 3 4 5 6 7 8 9 10 30 31
2 7 15

Sample Output-2:
----------------
17

Explanation:
------------
For example, here is a way to buy subscription, to watch the movies in given days:
On day 1, buy a 30-day subscription for price[2] = $15, which cover days 1, 2, 3,....,30.
On day 31, buy a 1-day subscription for price[0] = $2, which cover day 31.
In total you spent $17.

*/
package Elite;
import java.util.*;
import java.io.*;

class MinCostofSubscription{
    public int minCostofSubscription(int[] days, int[] price) {
        int n = days[days.length - 1];
        boolean[] travel = new boolean[n+1];
        int[] amount = new int[n+1];
        for(int day : days) {
            travel[day] = true;
        }
        amount[0] = 0;
        for(int i=1; i<=n; ++i) {
            if(travel[i]) {
                int min = amount[i-1] + price[0];
                min = Math.min(min, (i < 7 ? 0 : amount[i-7]) + price[1]);
                min = Math.min(min, (i < 30 ? 0 : amount[i-30]) + price[2]);
                amount[i] = min;
            } else {
                amount[i] = amount[i-1];
            }
        }
        return amount[n];
    }
	
	public static void main(String args[] ) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] sarr = str.split(" ");
		int[] days = Arrays.asList(sarr).stream().mapToInt(Integer::parseInt).toArray();
		
		String str1 = br.readLine();
		String[] sarr1 = str1.split(" ");
		int[] price = Arrays.asList(sarr1).stream().mapToInt(Integer::parseInt).toArray();

		System.out.println(new MinCostofSubscription().minCostofSubscription(days,price));
	}
}
