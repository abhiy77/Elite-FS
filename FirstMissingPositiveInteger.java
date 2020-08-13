/*06/03/2020
 * 
 Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input:1 2 0
Output: 3
Example 2:

Input: 3 4 -1 1
Output: 2
Example 3:

Input: 7 8 9 11 12
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.

------------------------------------------------------------------------------

case=1
input=2 6 3 8 4 9 -1 -2 11 15
output=1

case=2
input=1 2 6 3 8 4 9 11 15
output=5

case=3
input=10 12 1 11 13 2 8 7 9 6 5 3
output=4

case=4
input=10 12 1 11 13 2 8 7 9 6 5 3 4 16 20 19 18 17 
output=14

case=5
input=1 3 4 2 5 7 6 12 13 15 20 10 8 9
output=11

case=6
input=10 11 12 1 2 3 4 5 6 7 8 9 13 14 16 15 18 19
output=17

case =7
input =8 7 6 5 4 2 1
output =3


 */
package Elite;
import java.util.*;
public class FirstMissingPositiveInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str[] = sc.nextLine().split(" ");
		int nums[] = new int[str.length+1];
		int n = nums.length;
		for(int i=1;i<n;i++) {
			nums[i] = Integer.parseInt(str[i-1]);
		}
		for(int i=1;i<n;i++) {
			if(nums[i] < 0) nums[i] = 0;
		}
		for(int i=1;i<n;i++) {
			if(Math.abs(nums[i]) >= n || Math.abs(nums[i]) ==0) {
				continue;
			}
			else {
					int val = Math.abs(nums[i]);
					if(nums[val] > 0) nums[val] = -nums[val];
			}
		//	System.out.println(i+"   " +Arrays.toString(nums));
		}
		for(int i=1;i<n;i++) {
			if(nums[i] > 0) {
				System.out.println(i);
				break;
			}
		}
	}
}