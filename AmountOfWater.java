/* 27/02/2020
 * A Kid is arranging a structure using building blocks, 
by placing one on another or adjacent to it.
           ___
here each |___| represents one building block.

The following structure made up of some building blocks

                      ___
                  ___|___|    ___
                 |___|___|_w_|___|___              ___
              ___|___|___|___|___|___| w   _w_  w |___| 
          ___|___|___|___|___|___|___|_w__|___|_w_|___|____________

            0  1   3   4   2   3    2   0   1   0   2

After that structure is made, kid pour water on it.
How much amount of water can be stored by the structure.


            
Example:
    Input= 0 1 3 4 2 3 2 0 1 0 2
    
    Output= 6
    
    Explanation:
    In the above structure,  6 units of water (w represents the water in the structure)
    can be stored.
 */
package Elite;
import java.util.*;
public class AmountOfWater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int n = arr.length;
		int left [] = new int[n];
		int right[] = new int[n];
		int water = 0;
		left[0] = arr[0]; right[n-1] = arr[n-1];
		for(int i=1;i<n;i++) {
			left[i] = Math.max(arr[i], left[i-1]);
		}
		for(int i=n-2;i>=0;i--) {
			right[i] = Math.max(arr[i], right[i+1]);
		}
		for(int i=0;i<n;i++) {
			water += Math.min(left[i], right[i])-arr[i];
		}
		System.out.println(water);
	}
}