/*18/02/2020
 * 
 Given an array nums, write a function to move all 0's to the end of it while maintaining the 
 relative order of the non-zero elements.

Example:

Input: 0 1 0 3 12
Output: 1 3 12 0 0
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
package Elite;
import java.util.*;

class MoveZeroes{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int n = arr.length;
        int temp = 0;
        for(int i=0;i<n;i++){
            if(arr[i] !=0){
                int x = arr[temp];
                arr[temp++] = arr[i];
                arr[i] = x;
            }
        }
       for(int i=0;i<n;i++){
          System.out.print(arr[i] + " ");
       }
    }
}