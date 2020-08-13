/*10/03/2020
 * 
 */
package Elite;
import java.util.*;
public class BuyAndSellWithNTransactions {
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
		recurse(arr,true,0,arr[0],0,sc.nextInt());
		System.out.println(max);
	}
}