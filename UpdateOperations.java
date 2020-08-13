/* 22/01/2020
 * Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments 
each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

    Input=	5		//array size, s
    		3		//no.of.operations, n
    		1 3 2	//next 'n' triplets
    		2 4 3
    		0 2 -2
    Output= [-2,0,3,5,3]	//modified array
    Explanation:
    Initial state:
    [0,0,0,0,0]
    
    After applying operation [1,3,2]:
    [0,2,2,2,0]
    
    After applying operation [2,4,3]:
    [0,2,5,5,3]
    
    After applying operation [0,2,-2]:
    [-2,0,3,5,3]
*/
package Elite;
import java.util.*;
public class UpdateOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int operations = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i=0;i<operations;i++) {
			Triplet triplet = new Triplet(sc.nextInt(),sc.nextInt(),sc.nextInt());
			arr[triplet.start] += triplet.increment;
			arr[triplet.end+1] += -(triplet.increment);
		}
		for(int i=1;i<arr.length;i++) {
			arr[i] = arr[i]+arr[i-1];
		}
       
	   for(int i=0;i<n;i++) {
		   System.out.print(arr[i]+" ");
	   }
	}
}

class Triplet{
	int start,end,increment;

	public Triplet(int start, int end, int increment) {
		this.start = start;
		this.end = end;
		this.increment = increment;
	}
}
