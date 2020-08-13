/* 14/02/2020
 * 
Given an array with n integers, your task is to check if it could become 
non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds 
for every i (1 <= i < n).

Example 1:
    Input: 4 2 3
    Output: True
    Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

Example 2:
    Input: 4 2 1
    Output: False
    Explanation: You can't get a non-decreasing array by modify at most one element.


Note: The n belongs to [1, 10,000].

 */
package Elite;
import java.util.*;

class NonDecreasingOrder{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int input[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for(int i=0;i<input.length-1;i++){
            if(input[i] > input[i+1]) count++;
        }
        System.out.println(count > 1 ? "False" : "True");
    }
}