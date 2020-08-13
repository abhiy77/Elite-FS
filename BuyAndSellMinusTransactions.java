/* 10/03/2020
Your are given an array of integers prices, 
for which the i-th element is the price of a given stock on day i; 
and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, 
but you need to pay the transaction fee for each transaction. 
You may not buy more than 1 share of a stock at a time 
(ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
    Input: 1 3 2 8 4 9
           2
    Output:8
    Explanation:The maximum profit can be achieved by:
                Buying at prices[0] = 1
                Selling at prices[3] = 8
                Buying at prices[4] = 4
                Selling at prices[5] = 9
                The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
                

Example 2:
    Input: 1 3 2 8 4 9
           2
    Output:8
    Explanation:The maximum profit can be achieved by:
                Buying at prices[0] = 1
                Selling at prices[3] = 8
                Buying at prices[4] = 4
                Selling at prices[5] = 9
                The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
*/
package Elite;
import java.util.*;
public class BuyAndSellMinusTransactions {
	public static int max = 0;
	public static void recurse(int[] arr,boolean buy,int i,int min,int val,int f) {
		max = Math.max(max, val);
		if(i == arr.length) {
			return;
		}
		for(int j=i;j<arr.length;j++) {
			if(buy) {
				recurse(arr, !buy, j+1, arr[j],val,f);
				recurse(arr, buy, j+1, arr[j],val,f);
			}
			if(!buy) {
				recurse(arr, !buy, j+1, arr[j],val+arr[j] - min-f,f);
				recurse(arr, buy, j+1,arr[j], val,f);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int fees = sc.nextInt();
		recurse(arr,true,0,arr[0],0,fees);
		System.out.println(max);
	}
}