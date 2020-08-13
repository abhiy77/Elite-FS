/* 03/03/2020
 * 
 Rotate an array (of size n) k times left
 
 input : 1 2 3 4 5 6 7
 2
 output: 3 4 5 6 7 1 2
 
 Time complexity : O(n)
 */
 

package Elite;

import java.util.*;

public class RotateArray {
	
	public static void swapFromBack(int[] arr,int i,int j) {
		while(i < j) {
			int temp = arr[i];
			arr[i]= arr[j];
			arr[j] = temp;
			i++;j--;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int k = sc.nextInt();
		swapFromBack(arr,0,arr.length-1);
		swapFromBack(arr,0,arr.length-k-1);
		swapFromBack(arr, arr.length-k, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
