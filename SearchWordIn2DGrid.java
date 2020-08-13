/* 02/03/2020
 * 
 Search a Word in a 2D Grid of characters
Given a 2D grid of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said be found in a direction if all characters match in this direction (not in zig-zag form).

The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up and 4 Diagonal directions.

Input:4
4
T E X T
T E T T
E X I T
T E L L
LIE

Output: 3 3
        
        
        

 */
package Elite;
import java.util.*;
public class SearchWordIn2DGrid {
	
	public static boolean search(String word,char[][] arr,int i,int j) {
		int x = i,y=j,index = 1;
		while(x-1 >=0 && y-1 >=0 && index < word.length() && arr[x-1][y-1] == word.charAt(index)) {
			x--; y--; index++;
		}
		if(index == word.length()) return true;
		
		x =i;y=j;index=1;
		while(x-1 >=0 && index < word.length() && arr[x-1][y] == word.charAt(index)) {
			x--; index++;
		}
		if(index == word.length()) return true;
		
		x =i;y=j;index=1;
		while(x-1 >=0 && y+1 < arr[0].length && index < word.length() && arr[x-1][y+1] == word.charAt(index)) {
			x--; y++; index++;
		}
		if(index == word.length()) return true;
		
		x =i;y=j;index=1;
		while(y-1 >=0  && index < word.length() && arr[x][y-1] == word.charAt(index)) {
			y--; index++;
		}
		if(index == word.length()) return true;
		
		x =i;y=j;index=1;
		while(y+1 < arr[0].length  && index < word.length() && arr[x][y+1] == word.charAt(index)) {
			y++; index++;
		}
		if(index == word.length()) return true;
		
		x =i;y=j;index=1;
		while(x+1 < arr.length && y-1 >=0 && index < word.length() && arr[x+1][y-1] == word.charAt(index)) {
			x++; y--; index++;
		}
		if(index == word.length()) return true;
		
		x =i;y=j;index=1;
		while(x+1 < arr.length && index < word.length() && arr[x+1][y] == word.charAt(index)) {
			x++;  index++;
		}
		if(index == word.length()) return true;
		
		x =i;y=j;index=1;
		while(x+1 < arr.length && y+1 < arr[0].length && index < word.length() && arr[x+1][y+1] == word.charAt(index)) {
			x++; y++; index++;
		}
		if(index == word.length()) return true;
		return false;
	}
	
	public static void searchWord(char[][] arr, int m,int n, String word) {
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] == word.charAt(0)) {
					if(search(word,arr,i,j)) System.out.println(i+" "+j);;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		char arr[][] = new char[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.next().charAt(0);
			}
		}
		sc.nextLine();

		String word = sc.nextLine();
		searchWord(arr,m,n,word);
	}
}