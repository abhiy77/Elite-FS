/* 10/01/2020
You have given an integer array, 
find the contiguous subarray (containing at least one number) 
which has the largest sum and return its sum.

Example:
		Input=  -2 1 -3 4 -1 2 1 -5 4
		Output= 6
		Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, 
try coding another solution using the divide and conquer approach, 
which is more subtle.
*/
package Elite;
import java.util.*;

class LargestContiguousSumSubArray{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        int arr[] = new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for(int i=1;i<arr.length;i++){
            dp[i] = Integer.max(dp[i-1]+arr[i],arr[i]);
            if(max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}