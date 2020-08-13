/* 27/03/2020 - HOME
 * Priyanka works for an international toy company that ships by container. 
Her task is to the determine the lowest cost way to combine her orders for shipping. 
She has a list of item weights. 
The shipping company has a requirement that all items loaded in a container must weigh 
less than or equal to 4 units plus the weight of the minimum weight item. 
All items meeting that requirement will be shipped in one container.

What is the smallest number of containers that can be contracted to ship the items 
based on the given list of weights?

For example, there are items with weights w=[1,2,3,4,5,11,12,13]. 
This can be broken into two containers:[1,2,3,4,5] and [10,11,12,13]. 
Each container will contain items weighing within 4 units of the minimum weight item. 

Input Format
-------------
The first line contains an integer n, the number of orders to ship.
The next line contains n space-separated integers,w[1],w[2],...w[n] , 
representing the orders in a weight array.

Output Format
-------------
Print the integer value of the number of containers Priyanka 
must contract to ship all of the toys. 

Sample Input
------------
8
1 2 3 21 7 12 14 25

Sample Output
-------------
4

Explanation
-----------
The first container holds items weighing 1, 2 and 3. (weights in range 1...5)
The second container holds the items weighing 21 units. (21...25)
The third container holds the item weighing 7 units. (7...11)
The fourth container holds the items weighing 12 and 14 units. (12...14)
4 containers are required.

 */
package Elite;
import java.util.*;
public class ShippingContainers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		int containers = 0;
		for(int i=0;i<arr.length;i++) {
			int min = arr[i];
			int j = 0;
			while(j < arr.length && arr[j] <= arr[i]+4) j++;
			i = j-1;
			containers++;
		}
		System.out.println(containers);
	}
}
