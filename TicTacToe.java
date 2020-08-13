/* 09/07/2020 - HOME
Complete the code given below

Input Format:
-------------
Line-1 -> An integer N
Next few lines conatins 3 integers.

Note: Atmost N*N lines of input you can take.
if you found a winner stop reading the inputs.

Output Format:
--------------
Print Player-1, if he wins
Print Player-2, if he wins
Otherwise print "Tie"


Sample Input-1:
---------------
3
0 0 1
0 2 2
2 2 1
1 1 2
2 0 1
1 0 2
2 1 1

Sample Output-1:
----------------
Player-1


*/
package Elite;
import java.util.*;

class Game {
	int arr[][];

    /** Initialize your data structure here. */
    public Game(int n) {
        arr = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        arr[row][col] = player;
        if(canWin(row,col,player,arr.length)) return player;
        return 0;
    }
    
    public boolean canWin(int row,int col,int num,int n) {
    	int sum = 0;
    	for(int i=0;i<n;i++) {
    		if(arr[row][0] == num)sum++;
    		else break;
    	}
    	if(sum == n)return true;
    	
    	sum = 0;
    	for(int i=0;i<n;i++) {
    		if(arr[0][col] == num)sum++;
    		else break;
    	}
    	if(sum == n)return true;
    	
    	sum = 0;
    	if(row == col) {
    		for(int i=0,j=0;i<n && j < n;i++,j++) {
    			if(arr[i][j] == num)sum++;
    			else break;
    		}
    		if(sum == n) return true;
    	}
    	
    	sum = 0;
    	if(row == n-1-col) {
    		for(int i=0,j = n-1;i < n && j >=0 ;i++,j--) {
    			if(arr[i][j] == num)sum++;
    			else break;
    		}
    		if(sum == n) return true;
    	}
    	return false;
    }
}

public class TicTacToe
{
    public static void main(String args[])
    {
        /**
        * Your Game object will be instantiated and called as such:
        * Game obj = new Game(n);
        * int param_1 = obj.move(row,col,player);
        */
        
    }
}