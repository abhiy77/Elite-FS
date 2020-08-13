/* Given a matrix consists of only 0's and 1's s 
Find the longest line of consecutive one in the matrix. 
The line could be horizontal, vertical, or any diagonal.

Example:
Input:3 3
0 1 1 0
0 1 1 0
0 0 0 1
Output: 3
*/
package Elite;
import java.util.*;
class ConsecutiveLength
{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int[][] arr=new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        int[][] dp=new int[rows+1][cols+1];
        int max=0;
        for(int i=1;i<rows+1;i++){
            for(int j=1;j<cols+1;j++){
                if(arr[i-1][j-1]==1) {
                    dp[i][j]=Math.max(1+dp[i][j-1],dp[i][j]);
                    if(max<dp[i][j]) max=dp[i][j];
                }
            }
        }
        for(int i=0;i<rows+1;i++)
        Arrays.fill(dp[i],0);
        for(int i=1;i<rows+1;i++)
        {
            for(int j=1;j<cols+1;j++)
            {
                if(arr[i-1][j-1]==1)
                {
                    dp[i][j]=Math.max(1+dp[i-1][j-1],dp[i][j]);
                    if(max<dp[i][j]) max=dp[i][j];
                }
            }
        }
       for(int i=0;i<rows+1;i++)
        Arrays.fill(dp[i],0);
        for(int i=1;i<rows+1;i++){
            for(int j=1;j<cols+1;j++){
                if(arr[i-1][j-1]==1){
                    dp[i][j]=Math.max(1+dp[i-1][j],dp[i][j]);
                    if(max<dp[i][j]) max=dp[i][j];
                }
            }
        }
        System.out.println(max);     
    }
}