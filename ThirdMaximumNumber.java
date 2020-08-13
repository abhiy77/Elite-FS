/* 03/02/2020
 * Given an array of integers, return the third maximum number in this array. 
If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
    Input: 3 2 1
    Output: 1
    Explanation: The third maximum is 1.

Example 2:
    Input: 1 2
    Output: 2
    Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
    Input: 2 2 3 1
    Output: 1
    Explanation: Note that the third maximum here means the third maximum distinct number.
    Both numbers with value 2 are both considered as second maximum.
    
Should not use sort() method
 */
package Elite;
import java.util.*;

class ThirdMaximumNumber{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        
        int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer :: parseInt).toArray();
        
        for(int num : arr){
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(max1 == num) continue;
            else if(max2 < num){
                max3 = max2;
                max2 = num;
            }
            else if(max2 == num) continue;
            else if(max3 < num){
                max3 = num;
            }
        }
        
        if(max3 == Integer.MIN_VALUE) System.out.println(max1);
        else System.out.println(max3);
    }
}