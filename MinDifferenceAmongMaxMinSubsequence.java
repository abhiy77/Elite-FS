/* 02/06/2020 - HOME
 * Input Format:
-------------
Line-1 -> contains two integers N, K. N is the number of elements in array .
Line-2 -> contains N space seperated integers, elemets of the array.

Output Format:
--------------
Print an integer that denotes the minimum possible value.


Sample Input:
10 4
76 7 8 48 15 89 72 69 51 13
Sample Output:
8

Sample Input:
5 2
1 2 1 2 1
Sample Output:
0


 */
package Elite;
import java.util.*; 

public class MinDifferenceAmongMaxMinSubsequence {
    
    public static int minDifferenceAmongMaxMin(int arr[], int n, int k){
        Arrays.sort(arr); 
        int ans = Integer.MAX_VALUE; 

        for (int i = 0; i <= (n - k); i++) 
        { 
            int diff = arr[i + k - 1] - arr[i]; 
            ans = Math.min(ans, diff); 
        } 
        return ans; 
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int k = sc.nextInt(); 
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(minDifferenceAmongMaxMin(arr, n, k)); 
    } 
} 