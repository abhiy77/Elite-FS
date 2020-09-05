/* 04/09/2020 - (ELITE DAY - 115)
 * 
 * Ashok is given an array of integers nums.
His task is to find the longest contiguous subsequence S, 
the product of all the numbers in the subsequence should be positive.

Return the length of longest contiguous subarray.

Input Format:
-------------
Space separated integers nums[], list of numbers.

Output Format:
--------------
Print the length of the longest contiguous subsequence


Sample Input-1:
---------------
1 -1 2 -2

Sample Output-1:
----------------
4


Sample Input-2:
---------------
-1 -2 -3 0 1

Sample Output-2:
----------------
2

Explanation:
------------
0 is not considered as positive number.


Sample Input-3:
---------------
1 2 3 4 -5 6  7 8

Sample Output-3:
----------------
4

 */
package Elite;
import java.util.*;

public class MaxProductSubarrayLength {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int maxLen = 0;
		int negatives = 0;
		int firstNegative = -1;
		int zeroPos = -1;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 0) {
				zeroPos = i;
				firstNegative = -1;
				negatives = 0;
			}
			if(arr[i] > 0) {
				if(negatives % 2 == 0) maxLen = Math.max(maxLen, i -zeroPos);
				else maxLen = Math.max(maxLen, i - firstNegative);
			}
			else if(arr[i] < 0) {
				negatives++;
				if(firstNegative == -1) firstNegative = i;
			}
		}
		System.out.println(maxLen);
	}
}