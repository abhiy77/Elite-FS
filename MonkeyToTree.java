/*T 09/01/2020
 * here's a tree, a mokey, and several fruits. 

Positions are represented by the cells in a 2D grid. 

Your goal is to find the minimal distance for the monkey to 
collect all the fruits and put them under the tree one by one. 

The monkey can only take at most one fruit at one time 
and can move in four directions - up, down, left and right, to the adjacent cell. 
The distance is represented by the number of moves.

Example 1:
    Input=  5
            7
            2 2
            4 4
            2
            3 0
            2 5
    Output= 12
    Input Format:
        Height : 5
        Width : 7
        Tree position : [2,2]
        Monkey : [4,4]
        Number of Fruits : 2
        Fruits : [[3,0], [2,5]]
*/
package Elite;
import java.util.*;

class Pos{
	int x,y;
	public Pos(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class MonkeyToTree {
	
	public static int findManhattan(int x1,int y1,int x2,int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
        Pos tree = new Pos(sc.nextInt(),sc.nextInt());
        Pos monkey = new Pos(sc.nextInt(),sc.nextInt());
        int fruits = sc.nextInt();
        Pos[] fruit_locations = new Pos[fruits];
        int min = Integer.MAX_VALUE,minindex = 0;
        for(int i=0;i<fruits;i++) {
        	Pos fruit = new Pos(sc.nextInt(),sc.nextInt());
        	if(min > findManhattan(fruit.x, fruit.y, monkey.x, monkey.y)) {
        		minindex = i;
        		min  = findManhattan(fruit.x, fruit.y, monkey.x, monkey.y);
        	}
        	fruit_locations[i] = fruit;
        }
        
        int count = 0;
        for(int i=0;i<fruits;i++) {
        	if(minindex == i) {
        		count += (findManhattan(fruit_locations[i].x, fruit_locations[i].y, monkey.x, monkey.y) + findManhattan(fruit_locations[i].x, fruit_locations[i].y, tree.x, tree.y));
        	}
        	else {
            	count+= findManhattan(fruit_locations[i].x, fruit_locations[i].y, tree.x, tree.y) * 2;
        	}
        }
        System.out.println(count);
	}
}
