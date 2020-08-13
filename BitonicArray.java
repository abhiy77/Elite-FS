/* 03/03/2020
 * 
 Given a bitonic sequence of n distinct elements, 
 write a program to find a given element x in the bitonic sequence in O(log n) time. 
 A Bitonic Sequence is a sequence of numbers which is first strictly increasing then 
 after a point strictly decreasing.

Examples:

Input : 
-3 9 10 20 17 5 1
20
Output :3

Input :
5 6 7 8 9 10 3 2 1
30
Output : -1 
 */
package Elite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BitonicArray {


	    public static void main(String args[])  throws IOException {

		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int[] arr = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray(); 
	        int key = Integer.parseInt(br.readLine());
	        int point = findPoint(arr);
	        System.out.println(point);
	        if(key > arr[point]) System.out.println(-1);
	        else {
	        	int a = findElement(arr,key,0,point);
	        	int b = findElement(arr,key,point+1,arr.length-1);
	        	if(a > 0)System.out.println(a);
	        	else if(b > 0)System.out.println(b);
	        	else System.out.println(-1);
	        }
	    } 
	    
	    public static int findPoint(int[] arr){
	        int low=0,high=arr.length-1;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(arr[mid] <= arr[mid+1]){
	                low = mid+1;
	            }
	            else if(arr[mid] >= arr[mid+1] && arr[mid] >= arr[mid-1]){
	                return mid;
	            }
	            else if(arr[mid] >= arr[mid+1]) high = mid-1;
	        }
	        return low;
	    }
	    
	     public static int findElement(int[] arr,int key,int low,int high){
	        while(low<=high){
	            int mid = ((low+high)/2);
	            if(arr[mid] ==key){
	                return mid;
	            }
	            else if(arr[mid] > key){
	                high = mid-1;
	            }
	            else if(arr[mid] < key) low = mid+1;
	        }
	        return -1;
	    }
}