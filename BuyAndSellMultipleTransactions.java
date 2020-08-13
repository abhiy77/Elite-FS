/* 10/03/2020
 * In a market, there is a list of price of 'N' days of an item.
i-th day price is listed as price[i]. 


A Street Seller wants to get the maximum profit by buying and selling the item.
He can do as many transactions as he want ,(i.e., buy one item and sell one item multiple times) 


Note that he cannot buy and sell an item on same day(He must sell the item before he buy again).

Example 1:
    Input: 7 1 5 3 6 4
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
                 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

Example 2:
    Input: 1 2 3 4 5 
    Output: 4
    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
                 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
                 engaging multiple transactions at the same time. You must sell before buying again.

Example 3:
    Input: 7 6 4 3 1
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
package Elite;
import java.util.*;
public class BuyAndSellMultipleTransactions {
	public static int max = 0;
	public static void recurse(int[] arr,boolean buy,int i,int min,int val) {
		max = Math.max(max, val);
		if(i == arr.length) {
			return;
		}
		for(int j=i;j<arr.length;j++) {
			if(buy) {
				recurse(arr, !buy, j+1, arr[j],val);
				recurse(arr, buy, j+1, arr[j],val);
			}
			if(!buy) {
				recurse(arr, !buy, j+1, arr[j],val+arr[j] - min);
				recurse(arr, buy, j+1,arr[j], val);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		recurse(arr,true,0,0,0);
		System.out.println(max);
	}
}