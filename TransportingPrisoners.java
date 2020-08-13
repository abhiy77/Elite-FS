/* 30/06/2020 - HOME
 * Input Format:
-------------
line-1 -> two integers N and D
line-2 -> N space seperated integers

Output Format:
--------------
Print an integer as your result.


Sample Input-1:
---------------
8 4
1 2 3 4 5 6 7 8

Sample Output-1:
----------------
11


Sample Input-2:
---------------
6 3
3 2 3 4 1 5

Sample Output-2:
----------------
7
 */
package Elite;
import java.util.*;
public class TransportingPrisoners {
	
	public static boolean isPossible(int arr[],int mid,int days) {
		int curr = 0, count = 1;
		for(int i=0;i<arr.length;i++) {
			curr += arr[i];
			if(count > days) return false;
			if(curr > mid) {
				count++;
				curr = arr[i];
			}
		}
		if(count > days) return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int prisoners = sc.nextInt();
		int days = sc.nextInt();
		int arr[] = new int[prisoners];
		int sum = 0;
		for(int i=0;i<prisoners;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int ans = sum;
		int i = 0, j = sum;
		while(i <= j) {
			int mid = (i+j)/2;
			if(isPossible(arr,mid,days)) {
				ans = Math.min(ans, mid);
				j = mid-1;
			}
			else i = mid+1;
		}
		System.out.println(ans);
	}
}