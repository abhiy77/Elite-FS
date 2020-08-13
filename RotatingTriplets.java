/* 24/04/2020 - HOME
 * Larry has been given a permutation of a sequence of natural numbers 
incrementing from 1 as an array. He must determine whether the array can be sorted 
using the following operation any number of times:
-Choose any 3 consecutive indices and rotate their elements in 
such a way that ABC->BCA->CAB->ABC.

For example, if A={1,6,5,2,4,3}:

A				rotate 
[1,6,5,2,4,3]		[6,5,2]
[1,5,2,6,4,3]		[5,2,6]
[1,2,6,5,4,3]		[5,4,3]
[1,2,6,3,5,4]		[6,3,5]
[1,2,3,5,6,4]		[5,6,4]
[1,2,3,4,5,6]
YES

Input Format:
The first line contains an integer n, the length of A.
The next line contains n space-separated integers .

Constraints:
3<=n<=1000
1<=A[i]<=n
 
Output Format:
print YES if A can be fully sorted. Otherwise, print NO.

Sample Input1:
3
3 1 2
Sample Output1:
YES

Sample Input2:
5
1 2 3 5 4
Sample Output2:
NO

Explanation

Sample #1:
A=[3,1,2]->rotate->[3,1,2]->A=[1,2,3]
A is now sorted, so we print YES.

Sample #2:
No sequence of rotations will result in a sorted . Thus, we print NO.


========= Testcases Program-2 =========
case =1
input =12
9 6 8 12 3 7 1 11 10 2 5 4
output =NO

case =2
input =21
17 21 2 1 16 9 12 11 6 18 20 7 14 8 19 10 3 4 13 5 15
output =YES

case =3
input =15
5 8 13 3 10 4 12 1 2 7 14 6 15 11 9
output =NO

case =4
input =13
8 10 6 11 7 1 9 12 3 5 13 4 2
output =YES

case =5
input =18
7 9 15 8 10 16 6 14 5 13 17 12 3 11 4 1 18 2
output =NO

case =6
input =3
3 1 2
output =YES

case =7
input =4
1 3 4 2
output =YES

case =8
input =5
1 2 3 5 4
output =NO

 */
package Elite;
import java.util.*;
public class RotatingTriplets {
	
	public static boolean isPermutation(int[] arr) {
		int temp[] = arr.clone();
		Arrays.sort(temp);
		int n = temp.length;
		for(int i=1;i<n;i++) {
			if(temp[i] != i) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		if(!isPermutation(arr)) {
			System.out.println("NO");
		}
		else {
			int result = 0;
			boolean used[] = new boolean[n+1];
			for(int i=1;i<=n;i++) {
				if(!used[i]) {
					int cur = i, size = 1;
					while(!used[cur]) {
						used[cur] = true;
						size ^= 1;
						cur = arr[cur];
					}
					result ^= size;
				}
			}
			System.out.println(result == 0 ? "YES" : "NO");
		}
	}
}