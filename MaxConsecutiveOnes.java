/*ELITE DAY - 101
 * 
 * REFERENCE - LEETCODE - Max Consecutive Ones II
 * 
 */
package Elite;
import java.util.Scanner;

class MaxConsecutiveOnes{
	public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, q = -1;
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                l = q + 1;
                q = h;
            }
            max = Math.max(max, h - l + 1);
        }                                                               
        return max;             
    }
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int nums[]=new int[n];
		for(int i=0;i<n;i++)
			nums[i]=sc.nextInt();
		System.out.println(findMaxConsecutiveOnes(nums));
	}
}