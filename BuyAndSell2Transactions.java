/* 10/03/2020
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time
(i.e., you must sell the stock before you buy again).

Example 1:

Input: 3 3 5 0 0 3 1 4
Output: 6
Explanation: Buy on day   (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
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
public class BuyAndSell2Transactions {
	public static int max = 0;
	public static void recurse(int[] arr,boolean buy,int i,int min,int val,int c) {
		max = Math.max(max, val);
		if(c == 0) return;
		if(i == arr.length) {
			return;
		}
		for(int j=i;j<arr.length;j++) {
			if(buy) {
				recurse(arr, !buy, j+1, arr[j],val,c);
				recurse(arr, buy, j+1, arr[j],val,c);
			}
			if(!buy) {
				recurse(arr, !buy, j+1, arr[j],val+arr[j] - min,c-1);
				recurse(arr, buy, j+1,arr[j], val,c);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		recurse(arr,true,0,arr[0],0,2);
		System.out.println(max);
	}
}