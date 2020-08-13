/* 04/07/2020 -HOME
 * REFERENCE - LEETCODE VALID SUDOKU
 */
package Elite;
import java.util.*;

public class NonRepeatingMatrix {
	 public static boolean isValidSudoku(char[][] board) {
	        Set<Character> set = new HashSet<>();
	        
	        for(int i = 0; i < board.length; i++){
	            set.clear();
	            for(int j = 0; j < board[0].length; j++){
	                char c = board[i][j];
	                if(c != '.' && set.contains(c)) return false;
	                set.add(c);
	            }
	            set.clear();
	            for(int j = 0; j < board[0].length; j++){
	                char c = board[j][i];
	                if(c != '.' && set.contains(c)) return false;
	                set.add(c);
	            }
	            set.clear();
	            int m = i/3*3, n = i%3*3;
	            for(int j = 0; j < board[0].length; j++){
	                char c = board[m + j/3][n + j%3];
	                if(c != '.' && set.contains(c)) return false;
	                set.add(c);            
	            }
	        }  
	        return true;
	    }
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char arr[][] = new char[9][9];
		for(int i=0;i<9;i++) {
				arr[i] = sc.nextLine().toCharArray();
		}

		System.out.println(isValidSudoku(arr));
	}                  
}