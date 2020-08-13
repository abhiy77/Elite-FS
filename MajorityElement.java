/*30/01/2020
 * Given an array of size n, find the majority element. 
The majority element is the element that appears more than [ n/2 ] times.

You may assume that the array is non-empty 
and the majority element always exist in the array.

Example 1:
	Input: 3 2 3
	Output: 3

Example 2:
	Input: 2 2 1 1 1 2 2
	Output: 2
NOTE: if there are two such elements exist print the first one.
 * 
 */
package Elite;
import java.util.*;

class MajorityElement{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer :: parseInt).toArray();
        int majority = arr[0];
        int count = 0;
        
        for(int i=0;i<arr.length;i++){
            if(count < 0){
                majority = arr[i];
                count = 0;
            }
            if(majority == arr[i]) count++;
            else count --;
        }
        System.out.println(majority);
    }
}
