/* 04/03/2020
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
    Input=  0 1
    Output= 2
    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
    Input=  0 1 0
    Output= 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

 */
package Elite;
import java.util.*;
public class ContiguousSubArrayWithMax0And1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int zeroCount[] = new int[arr.length];
		zeroCount[0] = (arr[0] == 0 ? 1 : 0);
		int oneCount[] = new int[arr.length];
		oneCount[0] = (arr[0] == 1 ? 1 : 0);
		for(int i=1;i<arr.length;i++) {
			if(arr[i] == 0) zeroCount[i] = zeroCount[i-1] + 1;
			else zeroCount[i] = zeroCount[i-1];
		}
		for(int i=1;i<arr.length;i++) {
			if(arr[i] == 1) oneCount[i] = oneCount[i-1] + 1;
			else oneCount[i] = oneCount[i-1];
		}
		for(int i=arr.length-1;i>=0;i--) {
			if(oneCount[i] == zeroCount[i]) {
				System.out.println(i+1); break;
			}
		}	
		System.out.println(0);
	}
}