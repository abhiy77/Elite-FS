/* 04/05/2020 - HOME
 * Input Format:
    - The first line contains two space-separated integers N and K, 
        N is the length of the board's sides and K is the number of obstacles.
        
    - The next line contains two space-separated integers P and Q, 
        the queen's row and column position.
        
    - Each of the next K lines contains two space-separated integers P[i] and Q[i], 
    the row and column position of Obstacle[i].


Output Format:
    - Print the number of squares that the queen can attack from position (P,Q).


Sample Input:
6 3
3 3
5 6
1 2
4 4
Sample Output:
16
 */
package Elite;
import java.util.*;
public class QueensAttack {
	
	public static int findMoves(int[][] board,int n,int row,int col) {
		int moves = 0;
		for(int i=row-1,j=col-1;i>=0 && j>=0 && board[i][j] != 1;i--,j--) moves++;
		for(int i=row-1;i>=0 && board[i][col] != 1;i--) moves++;
		for(int i=row-1,j=col+1;i>=0 && j<n && board[i][j] != 1;i--,j++) moves++;
		for(int j=col+1;j<n && board[row][j] !=1;j++) moves++;
		for(int i=row+1,j=col+1;i<n && j < n && board[i][j] != 1; i++,j++) moves++;
		for(int i=row+1;i<n && board[i][col] != 1;i++) moves++;
		for(int i=row+1,j=col-1;i<n && j>=0 && board[i][j] != 1;i++,j--) moves++;
		for(int j=col-1;j>=0 && board[row][j] != 1;j--) moves++;
		
		return moves;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int board[][] = new int[n][n];
		int k = sc.nextInt();
		int p = sc.nextInt()-1;
		int q = sc.nextInt()-1;
		for(int i=0;i<k;i++) {
			board[sc.nextInt()-1][sc.nextInt()-1] = 1;
		}
		System.out.println(findMoves(board,n,p,q));
	}
}