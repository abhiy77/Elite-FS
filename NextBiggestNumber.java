/* 17/09/2020 - (ELITE DAY - 122)
 * 
 * You are given a list of digits( 0 to 9) digits[].
A number is formed using the given order of the list.
for example: given list is [1,3,2], then number is 132.

Find the next biggest number in the lexographic order using the same list of digits,
by using the each digit in the list only once,
and print the digit list of such biggest number.

If such biggest number is not possible, print the smallest lexographic order of the digits.

Input Format:
-------------
Line-1 : An integer N, number of digits.
Line-2 : N space separated integers, list of digits.

Output Format:
--------------
Print an integer list.


Sample Input-1:
---------------
4
1 2 4 3

Sample Output-1:
----------------
[1, 3, 2, 4]


Sample Input-2:
---------------
4
4 3 2 1

Sample Output-2:
----------------
[1, 2, 3, 4]

******* Permutation *******
case =1
input =4
4 3 2 1
output =[1, 2, 3, 4]

case =2
input =4
1 2 4 3
output =[1, 3, 2, 4]

case =3
input =10
7 0 9 4 3 2 9 8 4 1
output =[7, 0, 9, 4, 3, 4, 1, 2, 8, 9]

case =4
input =8
1 0 0 2 3 4 2 3
output =[1, 0, 0, 2, 3, 4, 3, 2]

case =5
input =10
8 9 7 6 5 4 3 2 1 0
output =[9, 0, 1, 2, 3, 4, 5, 6, 7, 8]

case =6
input =15
8 1 1 3 9 2 3 8 5 8 1 6 7 2 3
output =[8, 1, 1, 3, 9, 2, 3, 8, 5, 8, 1, 6, 7, 3, 2]

case =7
input =15
5 4 7 3 4 9 7 4 4 4 1 7 4 9 6
output =[5, 4, 7, 3, 4, 9, 7, 4, 4, 4, 1, 7, 6, 4, 9]

case =8
input =15
1 2 3 4 3 2 1 2 3 4 3 2 1 2 3
output =[1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1, 3, 2]

 */
package Elite;
import java.util.*;

public class NextBiggestNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer arr[] = new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int j = n-1;
		while(j > 0 && arr[j] < arr[j-1]) {
			j--;
		}
		if(j == 0) {
			Arrays.sort(arr);
			System.out.println(Arrays.toString(arr));
		}
		else {
			int swapPos = j-1;
			int min = arr[j];
			int min_index = j;
			for(int i=j+1;i<n;i++) {
				if(arr[i] > arr[swapPos] && min > arr[i]) {
					min = arr[i];
					min_index = i;
				}
			}
			int temp = arr[swapPos];
			arr[swapPos] = arr[min_index];
			arr[min_index] = temp;
			Arrays.sort(arr,j,n);
			System.out.println(Arrays.toString(arr));
		}
	}
}