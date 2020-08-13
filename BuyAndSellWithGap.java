/* 10/03/2020
 * 
In a market, there is a list of price of 'N' days of an item.
i-th day price is listed as price[i]. 


A Street Seller wants to get the maximum profit by buying and selling the item.
He can do as many transactions as he like,(ie, buy one item and sell one item for multiple times) 
with the following rules:

He may not do multiple transactions on the same day
(ie, he must sell the item before he buy again). 

After Seller sell his item, he cannot buy item on next day.(rest day)

Example:
    Input: 2 4 1 3 6                                                                                                               
    Output: 5
    Explanation: transactions = [buy, sell, rest, buy, sell]

 */
package Elite;
import java.util.*;
public class BuyAndSellWithGap {
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
				recurse(arr, !buy, j+2, arr[j],val+arr[j] - min);
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