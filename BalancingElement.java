/* 19/03/2020 - HOME
 * When an element is deleted from an array, 
the higher-indexed elements shift down one index to fill the gap. 

A "balancing element" is defined as an element that, when deleted from the array, 
results in the sum of the even-indexed elements being equal to 
the sum of the odd-indexed elements. 

Determine how many balancing elements a given array contains.

Sample -1:
input =	5
			5 5 2 5 8
output = 2
Explanation:
	When the first or second 5 is deleted, the array becomes [5, 2, 5, 8]. 
	The sumeven = 5 + 5 = 10 and sumodd = 2 + 8 = 10. 
	No other elements of the original array have that property. 
	There are 2 balancing elements: arr[0] and arr[1].

Sample -2:
input =	4
			2 1 6 4
output = 1
Explanation:
	When the 1 is deleted, the array becomes [2,6,4]. 
	The sumeven = 2 + 4 = 6 and sumodd = 6 
	No other elements of the original array have that property. 
	There is one balancing element: arr[1].

 */
package Elite;
import java.util.*;
public class BalancingElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int count = 0;
		for(int i=0;i<n;i++) {
			int evenSum = 0,oddSum = 0;
			for(int j = 0;j<i;j++) {
				if(j%2 == 0) evenSum += arr[j];
				else oddSum += arr[j];
			}
			for(int j =i+1;j<n;j++) {
				if((j-1)%2 == 0) evenSum += arr[j];
				else oddSum += arr[j];
			}
			if(evenSum == oddSum) count++;
		}
		System.out.println(count);
	}
}