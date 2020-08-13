/* 21/01/2020 
  
Problem: write a program to find Maximum area for given sequence of plots.
In a layout of plots, all plots are having equal width, which is 10 meters, but these
plots varies in length For a given sequence of plots lengths, you need find what is maximum
rectangle area you can make ?

		 ----------
 		 |		  |
---------|        |	
|		 | 		  |---------
| 30*10	 | 40*10  |	25*10  |
|		 |		  |		   |---------
|		 |		  |		   |  20*10 |
-------------------------------------
 
Sample Input:
4
30 40 25 20 

Sample Output:
800

Explanation:
	 Max Area is 4*10*20 = 800 sq meters

 */

package Elite;
import java.util.*;

public class MaxAreaOfSeqOfPlots {
	
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
		    arr[i] = sc.nextInt();
		}
		int i=0,start = 0;
		Stack<Integer> stack = new Stack<>();
		while(i<n){
		    if( stack.empty() || arr[i] >= arr[stack.peek()]) {
		    	  stack.push(i); 
		        //System.out.println("i is "+i + " " + stack); 
		      i++;
		    }
		    else{
		        int top = stack.pop();
		        int maxArea = arr[top] * (stack.empty() ? i : i - stack.peek() - 1);
		       // System.out.println(i+"  " + maxArea);
		        max = Math.max(max, maxArea);
		    }
		}
		while(!stack.isEmpty()) {
			int top = stack.pop();
	        int maxArea = arr[top] * (stack.empty() ? i : i - stack.peek() - 1);
	        max = Math.max(max, maxArea);
		}
		System.out.println(max);
	}
}