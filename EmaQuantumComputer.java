/* 06/04/2020 - HOME
 * Ema built a quantum computer! Help her test its capabilities by solving the problem below.
Given a grid of size n*m, each cell in the grid is either good or bad.

A valid plus is defined here as the crossing of two segments (horizontal and vertical) of equal lengths. 
These lengths must be odd, and the middle cell of its horizontal segment must cross the middle cell of its vertical 
segment.

Find the two largest valid pluses that can be drawn on good cells in the grid, and return an integer 
denoting the maximum product of their areas. In the above diagrams, our largest pluses have areas of 5 and 9.
The product of their areas is 5*9=45.

Note: The two pluses cannot overlap, and the product of their areas should be maximal.

Input Format:
- The first line contains two space-separated integers, n and m.
- Each of the next  lines contains a string of  characters where each character is either G (good) or B (bad). 
  These strings represent the rows of the grid. If the yth character in the xth line is G, then (x,y) is a good cell. 
  Otherwise it's a bad cell.

Output Format:
Find 2 pluses that can be drawn on good cells of the grid, and return an integer denoting the maximum product of their areas.

Sample Input-1
			5 6
			GGGGGG
			GBBBGB
			GGGGGG
			GGBBGB
			GGGGGG
Sample Output -1
			5

Sample Input-2
			6 6
			BGBBGB
			GGGGGG
			BGBBGB
			GGGGGG
			BGBBGB
			BGBBGB
Sample Output-2
			25
Explanation
    For the explanation below, we will refer to a plus of length i as Pi.
    
    Sample-1
    	There is enough good space to color one P3 plus and one P1 plus. Area(P3)=5 and Area(P1)=1.
    	The product of their areas is 5*1 = 1.
    
    Sample-2
    	There is enough good space to color two P3 pluses. Area(P3)=5. 
    	The product of the areas of our two P3 pluses is 5*5 = 25.
    
    
    ========= Testcases Program-2 =========
case =1
input =5 6
GGGGGG
GBBBGB
GGGGGG
GGBBGB
GGGGGG
output =5

case =2
input =6 6
BGBBGB
GGGGGG
BGBBGB
GGGGGG
BGBBGB
BGBBGB
output =25

case =3
input =6 7
GGGGGGG
BGBBBBG
BGBBBBG
GGGGGGG
GGGGGGG
BGBBBBG
output =5

case =4
input =7 7
GBGBGGB
GBGBGGB
GBGBGGB
GGGGGGG
GGGGGGG
GBGBGGB
GBGBGGB
output =45

case =5
input =8 8
GGGGGGGG
GBGBGGBG
GBGBGGBG
GGGGGGGG
GBGBGGBG
GGGGGGGG
GBGBGGBG
GGGGGGGG
output =81

case =6
input =9 9
BGBBBBBGB
BGBBBBBGB
GGGGGGGGG
BGBBBBBGB
GGGGGGGGG
BGBBBBBGB
GGGGGGGGG
GGGGGGGGG
BGBBBBBGB
output =25

case =7
input =8 9
GGGGGGGGG
GBBBGGBGG
GBBBGGBGG
GBBBGGBGG
GBBBGGBGG
GBBBGGBGG
GBBBGGBGG
GGGGGGGGG
output =1

case =8
input =7 7
BBGGBGG
GGGGGGG
GGGGGGG
BBGGBGG
BBGGBGG
GGGGGGG
BBGGBGG
output =45

 */
package Elite;
import java.util.*;

public class EmaQuantumComputer {
	
	public static boolean isValid(Plus p1,Plus p2) {
		if(p1.top.x >= p2.top.x && p1.top.x <= p2.bottom.x && p1.top.y == p2.top.y) return false;
		if(p1.bottom.x >= p2.top.x && p1.bottom.x <= p2.bottom.y && p1.bottom.y == p2.top.y) return false;
		if(p1.top.x <= p2.left.x && p1.bottom.x >= p2.left.x && p1.top.y >= p2.left.y && p1.top.y <= p2.right.y) return false;
		if(p2.top.x >= p1.top.x && p2.top.x <= p1.bottom.x && p2.top.y == p1.top.y) return false;
		if(p2.bottom.x >= p1.top.x && p2.bottom.x <= p1.bottom.y && p2.bottom.y == p1.top.y) return false;
		if(p2.top.x <= p1.left.x && p2.bottom.x >= p1.left.x && p2.top.y >= p1.left.y && p2.top.y <= p1.right.y) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		sc.nextLine();
		char arr[][] = new char[rows][cols];
		LinkedList<Plus> plusses = new LinkedList<>();
		for(int i=0;i<rows;i++) {
			String str = sc.nextLine();
			for(int j=0;j<str.length();j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for(int i = 1;i<rows;i++) {
			for(int j = 1;j<cols;j++) {
				if(arr[i][j] == 'G') {
					int t=i,r=j,b=i,l=j;
					while(true) {
						if(t-1 < 0 || r+1 >= cols || b+1 >=rows || l-1 < 0) break;
						if(arr[t-1][j] == 'B' || arr[i][r+1] == 'B' || arr[b+1][j] == 'B' || arr[i][l-1] == 'B') break;
						t-=1; r+=1; b+=1; l-=1;
					}
					if(t == b && r == l) continue;
					else plusses.add(new Plus(new Coord(t,j),new Coord(i,r),new Coord(b,j),new Coord(i,l),Math.abs( ((t-b)/2) * 4 )));
				}
			}
		}
		Collections.sort(plusses);
		System.out.println(plusses);
		int max = 0;
		for(int i=0;i<plusses.size();i++) {
			Plus p1 = plusses.get(i);
			for(int j=i+1;j<plusses.size();j++) {
				Plus p2 = plusses.get(j);
				if(isValid(p1,p2)) {
					max = Math.max(max, p1.val*p2.val);
				}
			}
		}
		if(plusses.size() == 0) System.out.println(1);
		else System.out.println(max == 0 ? plusses.get(0).val : max);
	}
}

class Plus implements Comparable<Plus>{
	Coord top,right,bottom,left;
	int val = 1;
	public Plus(Coord top, Coord right, Coord bottom,Coord left,int val) {
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
		this.val += val;
	}
	@Override
	public int compareTo(Plus o) {
		if(o.val != val) return (o.val - val); 
		return 0;
	}
	public String toString() {
		return "[ {"+ top + "},{" + right + "},{" + bottom + "},{" + left + "} ]" + "--" + val;
	}
}

class Coord{
	int x, y;
	Coord(int x,int y){
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return x+" "+y;
	}
}