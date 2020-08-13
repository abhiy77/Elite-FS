/* 02/03/2020
 * Given an array of integers, find the most occurring element of the array and 
return any one of its indexes randomly with equal probability.

Examples:

Input: 
-1 4 9 7 7 2 7 3 0 9 6 5 7 8 9

Output:  
Element with maximum frequency present at index 6
OR
Element with maximum frequency present at Index 3
OR
Element with maximum frequency present at index 4
OR
Element with maximum frequency present at index 12

All outputs above have equal probability.
 */
package Elite;
import java.util.*;
public class MostOccurringElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int max = 0,index = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			int num = map.getOrDefault(arr[i], 0)+1;
			if(max < num) {
				max = num; index = i;
			}
			map.put(arr[i],num);
		}
		System.out.println(index);
	}
}
