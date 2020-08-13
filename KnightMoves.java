/* 27/04/2020 - HOME
 * KnightL is a chess piece that moves in an L shape. 
We define the possible moves of KnightL(a,b) as any movement 
from some position (x1,y1) to some (x2,y2) satisfying either of the following:

	x2=(x1+ a) or (x1- a) and y2=(y1+ b) or (y1- b)
	or
	x1=(x2+ a) or (x2- a) and y1=(y2+ a) or (y2- a)

Note that (a,b) and (b,a) allow for the same exact set of movements. 
For example, the diagram below depicts the possible locations that KnightL(1,2) or KnightL(2,1)
can move to from its current location at the center of a 5*5 chessboard:

	(For Picture look Testcases Document IMAGE-1)

Observe that for each possible movement,
the Knight moves 2 units in one direction (i.e., horizontal or vertical) 
and 1 unit in the perpendicular direction.

Given the value of n for an n*n chessboard, 
answer the following question for each (a,b) pair where <=a,b<n:

What is the minimum number of moves it takes for KnightL(a,b) 
to get from position (0,0) to position (n-1,n-1)? 
If it's not possible for the Knight to reach that destination, the answer is -1 instead.
Then print the answer for each KnightL(a,b) according to the Output Format specified below.

Input Format
A single integer denoting n.

Constraints
5<= n <= 25

Output Format
Print exactly n-1 lines of output in which each line i (where 1 <=	i < n) 
contains n-1 space-separated integers describing the minimum number of moves
KnightL(i,j)  must make for each respective j (where 1 <=j < n).
If some KnightL(i,j) cannot reach position (n-1, n-1), 
print -1 instead.

For example, if n=3, we organize the answers for all the  pairs in our output like this:
(1,1) (1,2)
(2,1) (2,2)

Sample Input:
5
Sample Output:
4 4 2 8
4 2 4 4
2 4 -1 -1
8 4 -1 1

Explanation:
The diagram below depicts possible minimal paths for , , and :

	(for picture look Testcases Document Image-2)

One minimal path for KnightL(1,4) is:
(0,0) -> (1,4) -> (2,0) -> (3,4) -> (4,0) -> (0,1) -> (4,2) -> (0,3) -> (4,4)
We then print 4 4 2 8 as our first line of output because 
    KnightL(1,1) took 4 moves, KnightL(1,2) took 4 moves,
    KnightL(1,3) took 2 moves, KnightL(1,4) took 8 moves.
In some of the later rows of output, it's impossible for KnightL(i,j) to reach position (4,4). 

For example,  KnightL(3,3) can only move back and forth between (0,0) and (3,3) 
so it will never reach (4,4).

========= Testcases Program-3 =========
case =1
input =5
output =4 4 2 8
4 2 4 4
2 4 -1 -1
8 4 -1 1

case =2
input =6
output =5 4 3 2 5
4 -1 2 -1 -1
3 2 -1 -1 -1
2 -1 -1 -1 -1
5 -1 -1 -1 1

case =3
input =8
output =7 6 5 6 5 2 7
6 -1 6 -1 2 -1 -1
5 6 -1 2 -1 -1 -1
6 -1 2 -1 -1 -1 -1
5 2 -1 -1 -1 -1 -1
2 -1 -1 -1 -1 -1 -1
7 -1 -1 -1 -1 -1 1


case =4
input =7
output =6 4 4 8 2 12
4 3 4 2 16 3
4 4 2 4 4 4
8 2 4 -1 -1 -1
2 16 4 -1 -1 -1
12 3 4 -1 -1 1

case =5
input =9
output =8 6 4 4 6 12 2 16
6 4 6 4 8 2 8 8
4 6 -1 4 2 -1 -1 -1
4 4 4 2 4 4 4 4
6 8 2 4 -1 -1 -1 -1
12 2 -1 4 -1 -1 -1 -1
2 8 -1 4 -1 -1 -1 -1
16 8 -1 4 -1 -1 -1 1


case =6
input =10
output =9 6 5 8 5 6 7 2 9
6 -1 6 -1 10 -1 2 -1 -1
5 6 3 6 7 2 13 -1 3
8 -1 6 -1 2 -1 -1 -1 -1
5 10 7 2 -1 -1 -1 -1 -1
6 -1 2 -1 -1 -1 -1 -1 -1
7 2 13 -1 -1 -1 -1 -1 -1
2 -1 -1 -1 -1 -1 -1 -1 -1
9 -1 3 -1 -1 -1 -1 -1 1

case =7
input =13
output =12 8 6 8 4 4 8 12 6 20 2 24
8 6 6 4 10 4 12 8 12 2 12 12
6 6 4 8 6 4 8 8 2 8 8 8
8 4 8 3 8 4 12 2 36 16 -1 3
4 10 6 8 -1 4 2 -1 -1 -1 -1 -1
4 4 4 4 4 2 4 4 4 4 4 4
8 12 8 12 2 4 -1 -1 -1 -1 -1 -1
12 8 8 2 -1 4 -1 -1 -1 -1 -1 -1
6 12 2 36 -1 4 -1 -1 -1 -1 -1 -1
20 2 8 16 -1 4 -1 -1 -1 -1 -1 -1
2 12 8 -1 -1 4 -1 -1 -1 -1 -1 -1
24 12 8 3 -1 4 -1 -1 -1 -1 -1 1

case =8
input =11
output =10 8 6 4 4 8 6 16 2 20
8 5 4 4 4 3 8 2 28 5
6 4 -1 8 4 -1 2 16 -1 -1
4 4 8 -1 4 2 -1 -1 -1 -1
4 4 4 4 2 4 4 4 4 4
8 3 -1 2 4 -1 -1 -1 -1 -1
6 8 2 -1 4 -1 -1 -1 -1 -1
16 2 16 -1 4 -1 -1 -1 -1 -1
2 28 -1 -1 4 -1 -1 -1 -1 -1
20 5 -1 -1 4 -1 -1 -1 -1 1

 */
package Elite;
import java.util.*;

public class KnightMoves {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n-1][n-1];
		for(int i=1;i<=n-1;i++) {
			for(int j=1;j<=n-1;j++) {
				Queue<ChessPoint> queue = new LinkedList<>();
				boolean visited[][] = new boolean[n][n];
				int min = Integer.MAX_VALUE;
				int[][] directions = {{i,j},{j,i},{j,-i},{i,-j},{-i,-j},{-j,-i},{-j,i},{-i,j}};
				queue.offer(new ChessPoint(0,0,0));
				
				while(!queue.isEmpty()) {
					ChessPoint item = queue.poll();
				//	System.out.println(item);
					if(item.x == n-1 && item.y ==n-1) {
						min = Math.min(min, item.moves);
				        continue;
					}
					if(item.moves > min) continue;
					
					for(int k=0;k<directions.length;k++) {
						int tx = item.x + directions[k][0];
						int ty = item.y + directions[k][1];
						if(tx >=0 && tx < n && ty >=0 && ty < n && !visited[tx][ty]) {
							visited[tx][ty] = true;
							queue.offer(new ChessPoint(tx,ty,item.moves+1));
						}
					}
				}
				arr[i-1][j-1] = (min == Integer.MAX_VALUE ? -1 : min);
			}
		}
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class ChessPoint{
	int x,y,moves;
	ChessPoint(int x,int y,int moves){
		this.x = x;
		this.y = y;
		this.moves = moves;
	}
	public String toString() {
		return "[" + x + "," + y + "," + moves + "]";
	}
}