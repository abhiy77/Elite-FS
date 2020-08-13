/* 02/03/2020
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 

The same cell should not be used more than once.

Example:

    input=  3
            4
            A B C E
            S F C S
            A D E E
            ABCCED
    output= true
    
    input=  3
            4
            A B C E
            S F C S
            A D E E
            ABCB
    output= false
 */
package Elite;
import java.util.*;
public class ConstructingWordIn2DGrid {
	
	public static boolean searchWord(char[][] arr,int m,int n,String word,int i ,int j,boolean[][] visited) {
		if(word.isEmpty() || word.length()==1 && word.charAt(0) == arr[i][j]) {
			return true;
		}
		if(i< 0 || i >=m || j<0 || j>=n) return false;
		if(word.charAt(0) != arr[i][j]) return false;
		visited[i][j] = true;
		if(i-1 >=0 && !visited[i-1][j] && searchWord(arr, m, n, word.substring(1), i-1, j,visited)) return true;
		if(j+1 < n && !visited[i][j+1] && searchWord(arr, m, n, word.substring(1), i, j+1,visited)) return true;
		if(i+1 < m && !visited[i+1][j] && searchWord(arr, m, n, word.substring(1), i+1, j,visited)) return true;
		if(j-1 >=0 && !visited[i][j-1] && searchWord(arr, m, n, word.substring(1), i, j-1,visited)) return true;
		visited[i][j] = false;
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		char arr[][] = new char[m][n];
		boolean visited[][] = new boolean[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.next().charAt(0);
			}
		}
		sc.nextLine();

		String word = sc.nextLine();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(searchWord(arr, m, n, word, i, j,visited)) {
					System.out.println(true);
					System.exit(1);
				}
			}
		}
		System.out.println(false);
	}
}