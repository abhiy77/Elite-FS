/* 20/01/2020
 * Given an array of integers and an integer k, 
you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
    Input=  1 1 1
    	    2
    Output= 2
    Explanation: Continuous Sets [1,1] ,[1,1] 
Example 2:
    Input=  1 2 3 4
    	    5
    Output= 1
    Explanation: Continuous Sets [2,3] only, [1,4] is not a continuous set. 
 */
package Elite;

import java.util.*;

class ContinuousSumSubarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] list = sc.nextLine().split(" ");
		int[] nums = Arrays.asList(list).stream().mapToInt(Integer::parseInt).toArray();
		int target = sc.nextInt();
		int sum = 0,count = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0, 1);
		System.out.println(map);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - target)) {
				count += map.get(sum - target);
				System.out.println("Count is " + count);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			System.out.println(map);
		}
		System.out.println(count);
	}
}
/*
 * import java.util.*; public class ContinuousSumSubarray {
 * 
 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
 * String arr[] = sc.nextLine().split(" "); int target = sc.nextInt(); int num[]
 * = new int[arr.length]; for(int i=0;i<arr.length;i++) { num[i] =
 * Integer.parseInt(arr[i]); } int sum = 0,count = 0;
 * 
 * for(int i=0,j=0;i<num.length && j< num.length;) { System.out.println(i +" "
 * +j ); if(sum + num[j]< target) { sum+=num[j]; j++; } else if(sum + num[j] ==
 * target) { count++; sum -= num[i]; i++;
 * 
 * } else if(sum + num[j] > target) { i++; } } System.out.println(count); } }
 */