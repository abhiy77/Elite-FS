/* 20/02/2020
 * You have given a orchard splitted into n equal plots in a row.
Some of the plots are planted with orange plants, some are not.

you are not allowed to plant these orange plants in adjacent plots, 
they would compete for water and both would die.

Given a orchard represents with 0's and 1's (0 inidcates not planted 1 indicates planted), 
and a number n, 

return true, if n new orange plants can be planted in it 
without violating the no-adjacent-oranges rule.
else false.


Example 1:
Input= 1 0 0 0 1
1
Output= true

Example 2:
Input= 1 0 0 0 1
2
Output= false


Note:
    It is guaranteed that input array will not violate adjacent rule.
    0<n<size of array
 */
package Elite;
import java.util.*;
public class AdjacentFlowers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int count = sc.nextInt();
		int sum = 0;
		int n = arr.length;
		if(n >= 2 && arr[0] == 0 && arr[1] == 0) {
			arr[0] = 1;
			count--;
		}
		if(n >=4 && arr[n-1] == 0 && arr[n-2] == 0) count--;
		for(int i=1;i<n-1;i++) {
			if(arr[i] == 0) sum++;
			if(sum == 3) {
				count--; sum=1;
			}
			if(arr[i] == 1) sum=0;
		}
		if(count <=0) System.out.println(true);
		else System.out.println(false);
	}
}
