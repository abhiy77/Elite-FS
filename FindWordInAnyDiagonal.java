/* 24/03/2020 - HOME
 * Magazines and newspapers often have letter matrices in which certain words need to be located. 

Umesh, a puzzle fanatic at IIT Roorkee, had an idea for a new kind of searching puzzle. 
In the letter matrix provided, words can be located along any set of diagonals, 
with repetition of past selected letters.

Given a matrix of size NxN, 
you need to find out the total number of locations of a particular string.

Input Format:
-------------
Line 1: An integer N.
Next N Lines: Elements of the NxN matrix in row major order (separated by a space)
Last Line: The string to search.

Output Format:
--------------
Line 1: The number of ways in which the string can be found in the matrix.


Sample Input:
5
B X A X X
X A X X X
X B B X X
X A X A X
X X B X X
ABA

Sample Output:
14
 
Explanation:
	For example, in the letter matrix:
		B X A X X
		X A X X X
		X B B X X
		X A X A X
		X X B X X


	The string ABA can be found in 14 different ways – corresponding to the following locations:

		  A	      B	      A
		(1,1)	(0,0)	(1,1)
		(1,1)	(2,2)	(3,1)
		(1,1)	(2,2)	(3,3)
		(1,1)	(2,2)	(1,1)
		(3,1)	(2,2)	(3,1)
		(3,1)	(2,2)	(3,3)
		(3,1)	(4,2)	(3,1)
		(3,1)	(4,2)	(3,3)
		(3,1)	(2,2)	(1,1)
		(3,3)	(2,2)	(3,3)
		(3,3)	(2,2)	(1,1)
		(3,3)	(2,2)	(3,1)
		(3,3)	(4,2)	(3,1)
		(3,3)	(4,2)	(3,3)

 */
package Elite;
import java.util.*;
public class FindWordInAnyDiagonal {
	public static int count = 0;
	public static void searchWordIn2DGrid(char[][] arr, int i, int j, String word) {
		if(word.length() == 0) {
			count++; return;
		}
		if(i-1>=0 && j-1>=0 && arr[i-1][j-1] == word.charAt(0)) searchWordIn2DGrid(arr, i-1, j-1, word.substring(1));
		if(i-1>=0 && j+1<arr[0].length && arr[i-1][j+1] == word.charAt(0)) searchWordIn2DGrid(arr, i-1, j+1, word.substring(1));
		if(i+1< arr.length && j-1>=0 && arr[i+1][j-1] == word.charAt(0)) searchWordIn2DGrid(arr, i+1, j-1, word.substring(1));
		if(i+1< arr.length && j+1<arr[0].length && arr[i+1][j+1] == word.charAt(0)) searchWordIn2DGrid(arr, i+1, j+1, word.substring(1));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char arr[][] = new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.next().charAt(0);
			}
		}
		sc.nextLine();
		String word = sc.nextLine();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] != word.charAt(0)) continue;
				searchWordIn2DGrid(arr,i,j,word.substring(1));
			}
		}
		System.out.println(count);
	}
}