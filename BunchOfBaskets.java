/* 28/08/2020 - (ELITE DAY 113)
 * 
 * Given a bunch of baskets in a row, each basket contains few fruits in it.
You can select K number of baskets, one after other.
The selection of basket is either from beginning or from the end the row.

Return the maximum number of fruits you have after K baskets collected.

Input Format:
-------------
Line-1 -> Two integers N and K, N is no of baskets and K is the basket count you can pick.
Line-2 -> N space separated integers fruits[], fruits in each basket.

Output Format:
--------------
Print an integer, Maximum num of fruits you can collect.


Sample Input-1:
---------------
7 3
1 2 3 4 5 6 1

Sample Output-1:
----------------
12


Sample Input-2:
---------------
5 3
2 2 2 2 2

Sample Output-2:
----------------
6

 */
package Elite;
import java.util.*;

public class BunchOfBaskets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int i=0,j=0;
		int temp = 0;
		int max = 0;
		while(j <= n-k-1) {
			temp += arr[j++];
		}
		while(j < arr.length) {
			max = Math.max(max, sum - temp);
			temp -= arr[i++];
			temp += arr[j++];
		}
		max = Math.max(max, sum - temp);
				
		System.out.println(max);
	}
}