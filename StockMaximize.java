/* 29/05/2020 - HOME
 * HACKER RANK - STOCK MAXIMIZE
 * 
 * Your algorithms have become so good at predicting the market that you now know 
what the share price of Wooden Orange Toothpicks Inc. 
(WOT) will be for the next number of days.

Each day, you can either buy one share of WOT, 
sell any number of shares of WOT that you own, or not make any transaction at all. 

What is the maximum profit you can obtain with an optimum trading strategy?

For example, if you know that prices for the next two days are prices=[1,2], 
you should buy one share day one, and sell it day two for a profit of 1. 
If they are instead prices=[2,1], no profit can be made so you don't buy or sell stock.

Input Format:
-------------
    - The first line contains an integer N, the number of predicted prices for WOT.
    - The next line contains n space-separated integers prices[i], 
      each a predicted stock price for day i.

Output Format:
    - Each containing the maximum profit which can be obtained.

Sample Input-1:
3
5 3 2
Sample Output-1:
0

Sample Input-2:
3
1 2 100
Sample Output-2
197

Sample Input-3:
4
1 3 1 2
Sample input-3:
3

Sample input-4:
4
1 2 1 3
Sample Output-4:
5
Explanation
    - For the first case, you cannot obtain any profit because the share price never rises.

    - For the second case, you can buy one share on the first two days 
      and sell both of them on the third day.
    
    - For the third case, you can buy one share on day 1, sell one on day 2, 
      buy one share on day 3, and sell one share on day 4.
    
    - For the fourth case, you can buy one share on first 3 days, 
      and sell three of them on day 4.
 */
package Elite;
import java.util.*;

public class StockMaximize {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            int numOfDays = scanner.nextInt();
            int[] prices = new int[numOfDays];
            for (int j = 0; j < numOfDays; j++) {
                prices[j] = scanner.nextInt();
            }
            System.out.println(getMaxProfit(prices));
        }
    }

    public static long getMaxProfit(int[] prices) {
        long profit = 0L;
        int maxSoFar = 0;
        for (int i = prices.length - 1; i > -1 ; i--) {
            if (prices[i] >= maxSoFar) {
                maxSoFar = prices[i];
            }
            profit += maxSoFar - prices[i];
        }
        return profit;
    }
    
}