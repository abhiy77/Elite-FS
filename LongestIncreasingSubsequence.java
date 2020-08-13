/* 17/02/2020 
 Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: 10 9 2 5 3 7 101 18
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?


 */
package Elite;
import java.util.*;
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer ::parseInt).toArray();
		int n = arr.length;
		int dp[] = new int[n];
		int curr = 0;
		for(int i=0;i<n;i++) {
			int x = Arrays.binarySearch(dp, 0,curr,arr[i]);
			//System.out.print(x + " " + curr);
			if(x < 0) {x=-(x+1);}
			//System.out.println("  New X " + x);
			dp[x] = arr[i];
			if(x == curr) curr++; 
		}
		System.out.println(curr);
	}
}
