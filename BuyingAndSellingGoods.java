/* 10/03/2020
 * In a market, there is a list of price of 'N' days of an item.
i-th day price is listed as price[i]. 


A Street Seller wants to get the maximum profit by buying and selling the item.
He has permission to complete at most one transaction ,(ie, buy one item and sell one item) 


Note that he cannot sell an item before he buys one.

Example 1:
    Input: 7 1 5 3 6 4
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
                 Not 7-1 = 6, as selling price needs to be larger than buying price.

Example 2:
    Input: 7 6 4 3 1
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0

Example 3:
    Input: 1 2 3 4 5 6 7 8 9 10
    Output: 9
    Explanation: Buy on day 1 (price = 1) and sell on day 10 (price = 10), profit = 10-1 = 9.
 */
package Elite;
import java.util.*;

public class BuyingAndSellingGoods {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int n = arr.length;
		int dp[] = new int[n+1];
		int min = arr[0];
		
		for(int i=1;i<n;i++) {
			dp[i] = Math.max(dp[i-1],arr[i] - min);
			min = Math.min(min, arr[i]);
		}
		System.out.println(dp[n]);
	}
}
