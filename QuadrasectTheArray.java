/* 30/06/2020 - HOME
 * Input Format:
-------------
Line-1 -> an integer N
Line-2 -> N space seperated integers arr[N].

Output Format:
--------------
Print a boolean value as your result


Sample Input-1:
---------------
7
1 2 1 2 2 2 1

Sample Output-1:
----------------
false

Sample Input-2:
---------------
10
3 3 4 1 5 4 2 4 5 6

Sample Output-2:
----------------
true

 */
package Elite;
import java.util.*;
public class QuadrasectTheArray {
	
	public static boolean isPossible(int arr[],int mid) {
		int curr = 0,count = 0;
		for(int i = 0;i<arr.length;i++) {
			curr += arr[i];
			if(curr > mid) {
				return false;
			}
			else if(curr == mid) {
				i++;
				curr = 0;
				count++;
			}
		}
		if(count == 4) return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int flag = 0;
		for(int i=1;i<sum/4;i++){
			if(isPossible(arr,i)) {
				flag = 1 ;
				break;
			}
		}
		if(flag == 1)System.out.println("true");
		else System.out.println("false");
		
	}
}