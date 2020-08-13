/* 26/02/2020
 * Venkat is interested to play with numbers.
He has an array of numbers of size S, and everytime he selects N numbers in contiguous order 
from the very left of the array to the very right of the array. 

You can only see the N numbers in the selection. 
Each time the selection of numbers moves right by one position. 
Return the max of selected numbers.

Example:
    Input = 1 3 -1 -3 5 3 6 7
            3
    Output: 3 3 5 5 6 7 

Explanation: 
    Selection position             Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7      3
    1 [3  -1  -3] 5  3  6  7       3
    1  3 [-1  -3  5] 3  6  7       5
    1  3  -1 [-3  5  3] 6  7       5
    1  3  -1  -3 [5  3  6] 7       6
    1  3  -1  -3  5 [3  6  7]      7

Note:
    You may assume N is always valid, 1 <= N <= S for non-empty array.

Follow up:
Could you solve it in linear time?

 */
package Elite;
import java.util.*;

class MaxInASlidingWindow{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int size = sc.nextInt();
        int n = arr.length;
        for(int i=0;i<=n-size;i++){
            int max = 0;
            for(int j =i;j<i+size;j++){
                max = Math.max(max,arr[j]);
            }
            System.out.print(max+" ");
        }
        // int left[] = new int[n];
        // int right[] = new int[n];
        // left[0] = arr[0]; right[n-1] = arr[n-1];
        // for(int i=1;i<n;i++){
        //     left[i] = Math.max(left[i],left[i-1]);
        // }
        // for(int i=n-2;i>=0;i--){
        //     right[i] = Math.max(right[i],right[i+1]);
        // }
        // for(int i=0;i<=n-size;i++){
        //     System.out.print(Math.max(left[i+size],right[i])+" ");
        // }
        // for(int i=0;i<n;i++){
        //     if(i < size-1){
        //         max = Math.max(arr[i],max);
        //     }
        //     else if(i == size-1){
        //         max = Math.max(max,arr[i]);
        //         System.out.println(max+" ");
        //     }
        //     else{
        //         if(arr[i] > max){
        //             System.out.println(arr[i]); max = arr[i];
        //         }
        //     }
        // }
    }
}