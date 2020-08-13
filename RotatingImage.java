/* 26/02/2020
 * 
Venkat is playing with Integer Matrices, 
He is transforming the matix content as described in the examples
	
Example-1:

    Input = 3
            7 8 9
    		4 5 6
    		1 2 3
    		
    Output= [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
    			   

Example-2:

    Input=  4
            2 3 4 5
    		6 7 10 9
    		5 4 3 2
    		9 8 7 4
    			 
    Output= [[9, 5, 6, 2], [8, 4, 7, 3], [7, 3, 10, 4], [4, 2, 9, 5]]

Note:
You may assume given matrix is a square matrix.
You have to modify the input 2D matrix without using additional matrix.
			   
 */
package Elite;
import java.util.*;

class RotatingImage{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer arr[][] = new Integer[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int x = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = x;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<(n/2);j++){
                int x = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = x;
            }
        }
        	System.out.println(Arrays.deepToString(arr));
    }
}