/* 24/01/2020
 * Given a sorted integer array without duplicates, 
return the summary of its ranges.

Example 1:
    Input= 0 1 2 4 5 7
    Output= ["0->2","4->5","7"]
    Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

Example 2:
    Input= 0 2 3 4 6 8 9
    Output= ["0","2->4","6","8->9"]
    Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

 */
package Elite;
import java.util.*;
public class ContinuousRange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<String> list = new LinkedList<>();
		String input[] = sc.nextLine().split(" ");
		int arr[] = Arrays.asList(input).stream().mapToInt(Integer :: parseInt).toArray();
		StringBuffer sb = new StringBuffer(arr[0]+"");
		for(int i=1;i<arr.length;i++) {
			if(arr[i] - arr[i-1] == 1  && i == arr.length-1) {
				sb.append("->"+ arr[i]);
				if(!list.contains(sb.toString()))list.add(sb.toString());
			}
			else if(arr[i] - arr[i-1] == 1)continue;
			else {
				if(sb.charAt(0) != input[i-1].charAt(0)) {
					sb.append("->"+ arr[i-1]);
				}
				if(!list.contains(sb.toString()))list.add(sb.toString());
				sb.delete(0,sb.length());
				sb.append(arr[i]+"");
			}
		}
		if(arr.length > 1 && arr[arr.length-1] - arr[arr.length-2] != 1 && !list.contains(arr[arr.length-1] + "")) list.add(arr[arr.length-1]+"");
        System.out.println(list);
	}
}