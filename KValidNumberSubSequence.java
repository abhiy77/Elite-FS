/* 04/04/2020 - HOME
 * 
You are given an array A of N integers. Each integer is a single digit number in the range[0 9] . 
You are also given a number K. Now, 
you need to count how many subsequences of the array A exist such that they form a K digit valid number.

A subsequence of size K is called a valid number if there are no leading zeros in the number formed.

Notes:
    A subsequence of an array is not necessarily contiguous.
    Suppose the given array is 0 1 0 2, then if you choose subsequence to be 002, 
	then it is not a valid 3 digit number. 
    Also, it will not be considered as a single digit number. A valid 3 digit number in the array is 102. 
    

Input Fomat
The first line contains an integer N as input denoting the size of the array.
Next line contains N space separated integers that denote elements of the array.
Next line contains an integer K

Output Format
In the output, you need to print the count of valid K digit numbers


Sample Input :
        5
        1 1 0 1 0
        3

Sample Output :
        9

Explanation :
    In the given sample following are the 9 possible subsequences that form a valid 3 digit number.
    [1 2 3]=110
    [1 2 4]=111
    [1 2 5]=110
    [1 3 4]=101
    [1 3 5]=100
    [1 4 5]=110
    [2 3 4]=101
    [2 3 5]=100
    [2 4 5]=110


*/

package Elite;
import java.util.*;
public class KValidNumberSubSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int dp[][] = new int[k+1][n+1];
		for(int i=1;i<=n;i++) {
			if(arr[i-1] == 0) dp[1][i] = dp[1][i-1];
			else dp[1][i] = dp[1][i-1] + 1;
		}
		for(int i=2;i<=k;i++) {
			for(int j = i; j<=n;j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
			}
		}
		System.out.println(dp[k][n]);
	}
}