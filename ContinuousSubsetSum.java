/* 17/09/2020 - (ELITE DAY - 122)
 * 
 * Given a set of weights of n items weights[], and another item wieght w.
Your task is to check if the sum of weights of continuous subset is equal to 
one of the multiple of w, where subset size should be minimum 2.

For Example: Mulitpke of w means, w=3 then multiple of w are
3, 6, 9, 12, .... so on.

Print true, if such subset sum is possible.
Otherwise, print false.

Input Format:
-------------
Line-1 : Two integers n and w, number of weights and weight to match.
Line-2 : n space separated integers, weights of n items.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
5 17
23 3 5 5 9

Sample Output-1:
----------------
false


Sample Input-2:
---------------
5 4
1 2 3 6 5

Sample Output-2:
----------------
true

Explanation: 
------------
sum of  continuous subset of weights [1,2,3,6]  equals to 12, multiple of 4.


******* Subarray *******
case =1
input =10 50
4 85 34 21 9 73 16 2 38 46
output =true

case =2
input =5 4
1 2 3 5 6
output =true

case =3
input =5 17
23 3 5 5 9
output =false

case =4
input =15 23
9 7 3 12 4 4 7 13 13 14 6 15 2 6 4
output =true

case =5
input =15 7
3 2 2 15 8 13 9 9 3 1 3 2 11 10 12 
output =true

case =6
input =10 31
1 2 3 4 5 6 7 8 9 10
output =false

case =7
input =20 64
1 2 4 1 4 8 10 11 3 7 15 12 8 15 9 3 8 13 9 1
output =false

case =8
input =20 100
1 9 10 12 1 1 6 5 11 8 4 8 8 6 1 14 9 8 15 11
output =false



 */
package Elite;
import java.util.*;

public class ContinuousSubsetSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}

		int flag = 0;
		for(int i=0;i<n;i++) {
			int sum = 0;
			for(int j=i;j<n;j++) {
				sum += arr[j];
				if(sum % w == 0) {
					flag = 1;
					break;
				}
			}
		}
		if(flag == 1)System.out.println(true);
		else System.out.println(false);
	}
}