/* 05/03/2020
 * 
 Given a R * C matrix of integers, sort matrix diagonally in ascending order from the top-left 
 to the bottom-right then return the sorted array.

 

Example 1:


Input:4 4
6 5 7 8 
1 2 3 4
5 6 7 8
9 6 3 2

Output: 
2 3 4 8 
1 2 5 7 
5 3 6 8 
9 6 6 7

==========================================================

Explanation
A[i][j] on the same diagonal have same value of i - j
For each diagonal,
put its elements together, sort, and set them back.

*/
package Elite;
import java.util.*;

class SortMatrixDiagonally{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0,j=0;i<m && j < n;i++,j++){
           list.add(arr[i][j]);
        }
        Collections.sort(list);
        for(int k=0,i=0,j=0;k<list.size();k++,i++,j++){
           arr[i][j] = list.get(k); 
        }
        for(int i=1;i<m;i++){
            list.clear();
            int x = i, y = 0;
            while( x < m && y < n){
                list.add(arr[x][y]); x++; y++;
            }
            Collections.sort(list);
            x = i ; y  = 0 ;
            for(int k = 0;k<list.size();k++,x++,y++){
                arr[x][y] = list.get(k);
            }
        }
        for(int j=1;j<n;j++){
            list.clear();
            int x = 0 , y = j;
            while(x < m && y < n) {
            	list.add(arr[x][y]); x++; y++;
            }
            Collections.sort(list);
            x = 0 ; y = j;
            for(int k = 0;k<list.size();k++,x++,y++){
                arr[x][y] = list.get(k);
            }
        }
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		System.out.print(arr[i][j] + " ");
        	}
        	System.out.println();
        }
    }
}