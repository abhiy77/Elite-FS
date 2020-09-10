/* 10/09/2020 - (ELITE DAY - 118)
 * 
 * 
Can you help the teacher to find the minimum number of chocolates to distribute?

Input Format:
-------------
Lien-1 -> An integer N, number of students
Line-2 -> N space separated integers, scores of the students in the line.

Output Format:
--------------
Print an integer, minimum number of chocolates.


Sample Input-1:
---------------
3
1 0 2

Sample Output-1:
----------------
5

Explanation: 
------------
You can distribute to the first, second and third student with 2, 1, 2 chocolates respectively.


Sample Input-2:
---------------
3
2 3 3

Sample Output-2:
----------------
4

Explanation: 
------------
You can distribute to the first, second and third student with 1, 2, 1 chocolates
respectively. The third student gets 1 candy because it satisfies the above two rules.

 */
package Elite;
import java.util.*;

public class DistributingChocolatesForStudents {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int left[] = new int[n];
		int right[] = new int[n];
		
		Arrays.fill(left, 1);
		Arrays.fill(right,1);
		
		for(int i=1;i<n;i++) {
			if(arr[i] > arr[i-1]) left[i] = left[i-1] + 1;
		}
		
		for(int i=n-2;i>=0;i--) {
			if(arr[i] > arr[i+1]) right[i] = right[i+1] + 1;
		}
	
		int count = 0;
		
		for(int i=0;i<n;i++) {
			count += Math.max(left[i], right[i]);
		}
		
		System.out.println(count);
	}
}