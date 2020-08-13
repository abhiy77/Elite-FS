/* 22/04/2020 - HOME
 * 
In ordinary chess, the pieces are only of two colors, black and white. 
In our version of chess, we are including new pieces with unique movements. 
One of the most powerful pieces in this version is the red knight.

The red knight can move to six different positions based on its current position 
(UpperLeft, UpperRight, Right, LowerRight, LowerLeft, Left) as shown in the figure below.
	
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
	|    |    | ul |    | ur |    |    |
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
	|    |  l |    | K  |    | r  |    |
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
	|    |    | ll |    | lr |    |    |
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
	
The board is a grid of size n*n. 
Each cell is identified with a pair of coordinates (i,j), 
where i is the row number and j is the column number, both zero-indexed. 
Thus, (0,0) is the upper-left corner and (n-1,n-1) is the bottom-right corner.

Given the coordinates of the starting position of the red knight and the coordinates of the destination, 
print the minimum number of moves that the red knight has to make 
in order to reach the destination and after that, 
print the order of the moves that must be followed to reach the destination in the shortest way. 
If the destination cannot be reached, print only the word "Impossible".

Note: There may be multiple shortest paths leading to the destination. 
Hence, assume that the red knight considers its possible neighbor locations in the 
following order of priority: UL, UR, R, LR, LL, L. 
In other words, if there are multiple possible options, 
the red knight prioritizes the first move in this list, as long as the shortest path is still achievable. 
Check sample input3: for an illustration.

Input Format
	- The first line of input contains a single integer n. 
	- The second line contains four space-separated integers istart, jstart, iend, jend 
	  denotes the coordinates of the starting position and  denotes the coordinates of the final position.

Output Format
	- If the destination can be reached, print two lines. 
		In the first line, print a single integer denoting the minimum number of moves 
		that the red knight has to make in order to reach the destination. 
		In the second line, print the space-separated sequence of moves.
	- If the destination cannot be reached, print a single line containing only the word Impossible.

Sample Input1:
7
6 6 0 1
Sample Output 0
4
UL UL UL L
Explanation1:

	------------------------------------
	|    | Ke |    | ul |    |    |    |
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
	|    |    |    |    | ul |    |    |
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
	|    |    |    |    |    | ul |    |
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
	|    |    |    |    |    |    | Ks |
	------------------------------------

Sample Input2:
6
5 1 0 5
Sample Output2:
Impossible


Sample Input3:
7
0 3 4 3
Sample Output3:
2
LR LL
Explanation3:

    ------------------------------------
	|    |    |    | Ks |    |    |    |
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
	|    |    | lr |    | ll |    |    |
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
	|    |    |    | Ke |    |    |    |
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
	|    |    |    |    |    |    |    |
	------------------------------------
    We can reach Ke from Ks in two ways
    a) lr, ll
    b) ll, lr
    We choose option (a), because priority order. 
    
    ========= Testcases Program-3 =========
case =1
input =7
0 3 4 3
output =2
LR LL

case =2
input =6
5 1 0 5
output =Impossible

case =3
input =7
6 6 0 1
output =4
UL UL UL L

case =4
input =10
0 2 8 6
output =4
LR LR LR LR

case =5
input =70
7 15 67 3
output =30
LR LR LR LR LR LR LR LR LR LL LL LL LL LL LL LL LL LL LL LL LL LL LL LL LL LL LL LL LL LL

case =6
input =30
25 2 23 29
output =14
UR R R R R R R R R R R R R R

case =7
input =10
9 9 5 3
output =4
UL UL L L

case =8
input =5
4 1 0 3
output =2
UR UR

 */
package Elite;
import java.util.*;
public class RedKnight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Point sp = new Point(sc.nextInt(), sc.nextInt(),0,"");
		Point ep = new Point(sc.nextInt(), sc.nextInt(),0,"");
		boolean visited[][] = new boolean[n][n];
		int directions[][] = {{-2,-1},{-2,1},{0,2},{2,1},{2,-1},{0,-2}};
		String movements[] = {"UL","UR","R","LR","LL","L"};
		Queue<Point> queue = new LinkedList<>();
		TreeMap<Integer,LinkedList<String>> map = new TreeMap<>();
		queue.add(sp);
		int min = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			if(min < point.moves) continue;
			if(point.start == ep.start && point.end == ep.end) {
				LinkedList<String> list = map.get(point.moves);
				if(list == null) {
					list = new LinkedList<>();
					map.put(point.moves, list);
				}
				list.add(point.str);
				min = Math.min(point.moves, min);
			}
			for(int i=0;i<6;i++) {
				int temp_x = point.start + directions[i][0];
				int temp_y = point.end + directions[i][1];
				if(temp_x < 0 || temp_x >= n || temp_y < 0 || temp_y >= n || visited[temp_x][temp_y]) continue;
				visited[temp_x][temp_y] = true;
				queue.add(new Point(temp_x,temp_y,point.moves+1,point.str + movements[i] + " "));
			}
		}
		if(map.isEmpty())System.out.println("Impossible");
		else {
			Map.Entry<Integer,LinkedList<String>> entry = map.pollFirstEntry();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue().get(0));
		}
	}
}

class Point{
	int start,end,moves;
	String str;
	Point(int start,int end,int moves,String str){
		this.start = start;
		this.end = end;
		this.moves = moves;
		this.str = str;
	}
}