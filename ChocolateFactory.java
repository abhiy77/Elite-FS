/* 26/03/2020 - HOME
 * Bharat is chocoholic. He found a chocolate factory of N floors ,
but the factory has N*N rooms where in each room specific number of chocolate 
is present. Now, Bharat starts collecting chocolate from ground floor. 
He can only collect chocolate from one room in a floor. Bharat can only 
move to upper room or upper-right room or upper-left room .

He want to collect maximum number of chocolate possible. Help him in 
finding maximum number of chocolate.

Input Format
------------
First line contains a value of N. 
Next N lines contains N space separated integer.

Output Format
-------------
Output a single integer denoting the maximum number of chocolate Bharat can collect.


Sample Input:
    5
    1 2 3 4 5
    1 2 3 4 5
    1 2 3 4 5
    1 2 3 4 5
    100 2 3 4 5
Sample Output:
    114
 */
package Elite;
import java.util.*;
public class ChocolateFactory {
	public static int max = Integer.MIN_VALUE;
	
	public static void collectMaxChocolates(int[][] arr, int chocolates, int i, int j) {
		if(i == 0) {
			max = Math.max(max,chocolates+arr[i][j]);
			return;
		}
		if(j-1 >=0) collectMaxChocolates(arr, chocolates+arr[i][j], i-1, j-1);
		collectMaxChocolates(arr, chocolates+arr[i][j], i-1, j);
		if(j+1 < arr.length) collectMaxChocolates(arr, chocolates+arr[i][j], i-1, j+1);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			collectMaxChocolates(arr,0,n-1,i);
		}
		System.out.println(max);
	}
}