/* 20/05/2020 - HOME
 * Input Format:
    - line-1 contains 2 space-separated integers r and c, 
      the rows and columns of grid.
    - Each of the next r lines contains a string of length c
      describing a row of the grid, consist of letters [B .*S].
    - The last line contains an integer , a guess number.

Output Format:
    - print "pass"  if your guess is correct. 
    Otherwise, print "fail"
    

Sample Input:
-------------
5 11
..........*
.BBBBBBBBBB
...........
BBBBBBBBBB.
S..........
0
Sample Output:
--------------
pass


Sample Input:
-------------
4 11
.B.B......B
.B*.B.BBB.B
.BB.B.BS...
......BBBB.
4
Sample Output:
--------------
fail

 */
package Elite;
import java.util.*;

public class ReachTheEnd{
    
    public static String bfs(char[][] grid,int rows,int cols,int k,Coor2 start,Coor2 end,boolean[][] visited){
        Queue<Coor2> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
        	System.out.println(queue);
            Coor2 c = queue.poll();
            visited[c.x][c.y] = true;
            if(c.val > k) continue;
            if(c.x == end.x && c.y == end.y && c.val == k) return "pass";
            int x = c.x;
            int y = c.y;
            Queue<Coor2> temp = new LinkedList<>();
            if(x + 1 < rows && !visited[x+1][y] && grid[x+1][y] != 'B'){
                temp.add(new Coor2(x+1,y,c.val));
            }
            if(y - 1 >=0 && !visited[x][y-1]  && grid[x][y-1] != 'B'){
                temp.add(new Coor2(x,y-1,c.val));
            }
            if(x - 1 >=0 && !visited[x-1][y] && grid[x-1][y] != 'B'){
                temp.add(new Coor2(x-1,y,c.val));
            }     
            if(y + 1 < cols && !visited[x][y+1] && grid[x][y+1] != 'B'){
                temp.add(new Coor2(x,y+1,c.val));
            }
            if(temp.size() == 1) {
            	queue.add(temp.poll());
            }
            else if(temp.size() > 1) {
            	while(!temp.isEmpty()) {
            		Coor2 coor2 = temp.poll();
            		coor2.val += 1;
            		queue.add(coor2);
            	}
            }
            temp.clear();
        }
        
        return "fail";
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        char grid[][] = new char[rows][cols];
        Coor2 start = new Coor2(0,0,0);
        Coor2 end = new Coor2(0,0,0);
        sc.nextLine();
        for(int i=0;i<rows;i++){
           String str = sc.nextLine();
           for(int j=0;j<str.length();j++){
               grid[i][j] = str.charAt(j);
               if(grid[i][j] == 'S'){
                   start.x = i;
                   start.y = j;
               }
               if(grid[i][j] == '*'){
                   end.x = i;
                   end.y = j;
               }
           }
        }
        int k = sc.nextInt();
        
        System.out.println(bfs(grid,rows,cols,k,start,end, new boolean[rows][cols]));
    }
}

class Coor2{
    int x,y,val;
    Coor2(int x,int y,int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    public String toString() {
    	return "[" + x + "," + y + "," + val + "]";
    }
}