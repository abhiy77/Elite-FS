/* 25/02/2020
 * From a row of floral garden, each tree has its own kind of blooms.
For example, i-th bloomtree produces a bloom of kind i-th bloomtree

You start at any bloomtree of your choice, and repeatedly perform the following steps:

    Step-1: Add a bloom from this bloomtree to your box. 
      If you cannot, stop.
      
    Step-2: Move to the next bloomtree to the right of the current bloomtree.
      If there is no bloomtree to the right, stop.
      
    Note that you do not have any choice after the initial choice of starting bloomtree: 
    you must perform step 1, then step 2, then back to step 1, then step 2, and so on 
    until you stop.

You have two boxes, and each box can carry any quantity of bloom, 
but you want each box to only carry one type of bloom each.

What is the maximum amount of bloom you can collect at the end?


Example 1:
    Input: 1 2 1
    Output: 3
    Explanation: We can collect [1,2,1].
    
    
Example 2:
    Input: 0 1 2 2
    Output: 3
    Explanation: We can collect [1,2,2].
        If we started at the first bloomtree, we would only collect [0, 1].


Example 3:
    Input: 1 2 3 2 2
    Output: 4
    Explanation: We can collect [2,3,2,2].
        If we started at the first bloomtree, we would only collect [1, 2].


Example 4:
    Input: 3 3 3 1 2 1 1 2 3 3 2 4
    Output: 5
    Explanation: We can collect [1,2,1,1,2].
        If we started at the first bloomtree or the eighth bloomtree, 
        we would only collect 4 blooms.


 * 
 */
package Elite;
import java.util.*;

public class BloomTree{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int x = 0,y=-1,x_occur = 0,y_occur = -1;
        int  x_val = arr[0],y_val = -1,max = 0,temp = 1;
        for(int i=1;i<arr.length;i++){
        	//System.out.println("X " + x + " Y " + y + " X_VAL " + x_val + "  Y_VAL " + y_val + " Temp " + temp + " Max " + max);
            if(y == -1 && x_val != arr[i]){
                y = i; y_val = arr[i]; y_occur = i;
                temp++;
            }
            else if(arr[i] == x_val){
            	if(arr[i] != arr[i-1]) x_occur = i;
                 temp++; x = i;
            }
            else if(arr[i] == y_val){
            	if(arr[i] != arr[i-1]) y_occur = i;
                 temp++; y = i;
            }
            else {
                max = Math.max(max,temp);
                if(y > x){
                    temp = (i-y_occur+1);
                    x = i; x_val = arr[i]; x_occur = i;
                }
                else{
                    temp = (i-x_occur+1);
                    y = i; y_val = arr[i]; y_occur = i;
                }
            }
        }
        System.out.println(max > temp ? max : temp);
    }
}