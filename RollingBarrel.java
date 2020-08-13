/* 04/07/2020 - HOME
 * Arjuna season 5 - isGoalPossible
 * case =1
input =5
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
0 4
4 4
output =12

case =2
input =7
0 0 0 1 1 0 1
1 0 0 0 0 1 1
1 0 1 1 0 0 0
0 0 0 0 0 1 0
0 1 0 1 0 0 1
1 0 0 0 0 1 0
0 1 0 1 1 1 1
0 2
5 4
output =7

case =3
input =5
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
0 4
3 2
output =-1

case =4
input =6
0 0 0 1 0 0
0 1 0 0 0 1
1 0 0 0 1 0
0 0 1 0 1 0
0 0 0 1 0 0
0 1 0 0 1 0
0 4
5 2
output =9

case =5
input =8
0 0 0 1 0 0 0 1
0 1 0 0 0 1 0 0
1 0 0 0 0 0 1 0
0 0 1 0 0 0 1 0
0 0 0 1 1 0 0 0
0 1 0 0 1 0 0 1
1 0 0 0 0 0 0 1
0 0 0 0 1 0 0 0
0 5
6 4
output =-1

case =6
input =8
0 0 0 1 0 0 0 1
0 1 0 0 0 1 0 0
1 0 0 0 0 0 1 0
0 0 1 0 0 0 1 0
0 0 0 1 1 0 0 0
0 1 0 0 1 0 0 1
1 0 0 0 0 0 0 1
0 0 0 0 1 0 0 0
0 6
7 0
output =19

case =7
input =9
0 1 0 0 0 0 1 0 0
0 0 0 0 1 0 0 0 1
0 1 0 0 0 0 1 0 0
0 0 0 1 0 0 0 0 1
1 0 0 0 0 1 0 0 0
0 0 1 0 0 0 0 1 0
0 0 0 0 1 0 0 0 0
0 1 0 0 0 0 1 0 1
0 0 0 1 0 0 0 0 0
0 7
7 5
output =13

case =8
input =9
0 1 0 0 0 0 1 0 0
0 0 0 0 1 0 0 0 1
0 1 0 0 0 0 1 0 0
0 0 0 1 0 0 0 0 1
1 0 0 0 0 1 0 0 0
0 0 1 0 0 0 0 1 0
0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 1 0 1
0 0 0 1 0 0 0 0 0
0 7
7 4
output =-1


 */
package Elite;
import java.util.*;

public class RollingBarrel {
	static String result = "";
	
	public static void assign(String temp) {
		if(result.isEmpty())result = temp;  
		else if(result.compareTo(temp) > 0) {
			result = temp;
		}
	}
	
	public static void check(int temp_x,int temp_y,String temp,char c,int [][] arr,Coors dest,Queue<Pairs> queue) {
		int x = temp_x,y = temp_y,flag = 0;
		String s = "";
		if(temp.isEmpty() || temp.charAt(temp.length()-1) != 'D') {
			while(x-1 >=0 && arr[x-1][y] != 1) {
				flag = 1;
				if(x-1 == dest.x && y == dest.y) {
					if(x-2 == -1 || arr[x-2][y] == 1) {
						assign(temp+"U");
						flag = 2;
						break;
					}
				}
				s+="U";
				x--; 
			}
		}
		if(flag == 1)queue.add(new Pairs(x,y,temp+s));

		s="";
		x = temp_x; y = temp_y;flag = 0;
		if(temp.isEmpty() || temp.charAt(temp.length()-1) != 'L') {
			while(y+1 < arr[0].length && arr[x][y+1] != 1) {
				flag = 1;
				if(x == dest.x && y+1 == dest.y) {
					if(y+2 == arr[0].length || arr[x][y+2] == 1 ) {
						assign(temp+"R");
						flag = 2;
						break;
					}
				}
				s+="R";
				y++; 
			}
		}
		if(flag == 1)queue.add(new Pairs(x,y,temp+s));
		
		s="";
		x = temp_x; y = temp_y;flag = 0;
		if(temp.isEmpty() || temp.charAt(temp.length()-1) != 'U') {
			while(x+1 < arr.length && arr[x+1][y] != 1) {
				flag = 1;
				if(x+1 == dest.x && y == dest.y) {
					if(x+2 == arr.length || arr[x+2][y] == 1) {
						assign(temp+"D");
						flag = 2;
						break;
					}
				}
				s+="D";
				x++; 
			}
		}
		if(flag == 1)queue.add(new Pairs(x,y,temp+s));
		
		s="";
		x = temp_x; y = temp_y;flag = 0;
		if(temp.isEmpty() || temp.charAt(temp.length()-1) != 'R') {
			while(y-1 >=0 && arr[x][y-1] != 1) {
				flag = 1;
				if(x == dest.x && y-1 == dest.y) {
					if(y-2 == -1 || arr[x][y-2] == 1) {
						assign(temp+"L");
						flag = 2;
						break;
					}
				}
				s+="L";
				y--; 
			}
		}
		if(flag == 1)queue.add(new Pairs(x,y,temp+s));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int rows = sc.nextInt();
		int cols = rows;
		int arr[][] = new int[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				arr[i][j] = sc.nextInt();
			}
		}
		Coors source = new Coors(sc.nextInt(),sc.nextInt());
		Coors dest = new Coors(sc.nextInt(),sc.nextInt());
		Queue<Pairs> queue = new LinkedList<>();
		Queue<Pairs> visited = new LinkedList<>(); 
		queue.add(new Pairs(source.x,source.y,""));
		while(!queue.isEmpty()) {
			Pairs p = queue.poll();
			int flag = 0;
			if(visited.contains(p)) {
				continue; 
			}
			if(flag == 1)continue;
			if(queue.isEmpty()) check(p.x, p.y, p.str, '@', arr, dest, queue);
			else {
				char x = p.str.charAt(p.str.length()-1);
				if(x == 'U')check(p.x,p.y,p.str,'U',arr,dest,queue);
				else if(x == 'R')check(p.x,p.y,p.str,'R',arr,dest,queue);
				else if(x == 'L')check(p.x,p.y,p.str,'L',arr,dest,queue);
				else if(x == 'D')check(p.x,p.y,p.str,'D',arr,dest,queue);
			}
			visited.add(p);
		}
		System.out.println(result.isEmpty() ? -1 : result.length()+1);
	}
}

class Pairs{   
	String str;
	int x,y;
	public Pairs(int x,int y,String str) {
		this.x = x;
		this.y = y;
		this.str = str;
	}
	@Override
	public boolean equals(Object obj) {
		Pairs p = (Pairs) obj;
		if(this.x == p.x && this.y == p.y) return true;
		return false;
	}

}

class Coors{ 
	int x,y;
	public Coors(int x,int y) {
		this.x = x;
		this.y = y;
	}
}