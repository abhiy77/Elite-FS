/* ELITE DAY - 106

The city of chandigarh is one of the best planned city. 
All the locations in the city are assigned in the form of grid.
Further after the onsight of COVID-19 certain localities having been marked
as containment localities, other localities  marked as normal. 

The chief minister of punjab Capt. Amrinder Singh has hired you to help him 
with some logistic planning. Capt. Amrinder Singh has given you a map, 
where all the containment localities are marked as 1 and covid free locations as 0.

You are asked to identify a suitable location where the punjab government can 
set up a Makeshift Hospital. This Makeshift Hospital has to be at the closest 
Manhattan Distance from all the Containment localities, i.e. the sum of distance 
of this makeshift hospital is the least from all containment localities.
 
 
Input Format:
-------------
Line-1 -> two integers size of the grid, r * c
Next r lines-> contains 'c' space seperated integers, [0, 1] only.

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
3 5
1 0 0 0 1
0 0 0 0 0
0 0 1 0 0

Sample Output-1:
----------------
6

Explanation: Given three containment localities at (0,0), (0,4), and (2,2):
The point (0,2) is an suitable location , as the total
travel distance
of 2+2+2=6 is minimal. 

So return 6.


----------Testcases-----------
case =1
input =3 5
1 0 0 0 1
0 0 0 0 0
0 0 1 0 0
output =6

case =2
input =4 7
1 0 0 1 0 0 1
0 0 0 0 0 0 0
1 0 0 0 0 0 1
0 0 0 1 0 0 1
output =23

case =3
input =5 5
0 1 0 1 0
1 0 0 0 1
0 0 1 0 0
1 0 0 0 1
0 1 0 1 0
output =24

case =4
input =7 7
1 0 0 0 0 0 1
0 1 0 1 0 1 0
1 0 0 1 0 0 1
0 0 1 0 0 1 0
1 0 0 0 1 0 0
0 1 0 1 0 1 0
1 0 0 0 0 0 1
output =62

case =5
input =10 7
1 0 0 0 0 0 1
0 1 0 1 0 1 0
1 0 0 1 0 0 1
0 0 1 0 0 1 0
0 0 1 0 0 1 0
1 0 0 0 1 0 0
0 1 0 1 0 1 0
1 0 0 0 1 0 0
0 1 0 1 0 1 0
1 0 0 0 0 0 1
output =105

case =6
input =10 8
1 0 0 0 0 0 1 0
0 1 0 0 0 0 0 1
1 0 0 1 0 0 1 0
0 0 1 0 0 1 0 0
0 0 1 0 0 1 0 0
1 0 0 0 1 0 0 0
0 1 0 1 0 1 0 1
1 0 0 0 1 0 0 0
0 0 0 1 0 0 0 1
1 0 0 0 0 0 0 1 
output =106

case =7
input =10 10
1 0 0 0 0 1 0 0 1 0
0 1 0 0 0 1 0 0 0 1
1 0 0 1 0 0 1 0 0 1
0 0 1 0 0 1 0 0 1 0
0 0 1 0 0 1 0 0 0 1
1 0 0 0 1 0 0 0 0 1
0 1 0 0 0 1 0 1 0 0
1 0 0 0 1 0 0 0 0 1
0 0 0 1 0 0 0 1 0 1
1 0 0 0 0 1 0 0 0 1
output =161

case =8
input =10 10
1 0 0 0 0 1 0 0 0 0
0 1 0 0 0 1 0 0 0 1
1 0 0 1 0 0 0 0 0 0
0 0 1 0 0 0 0 0 1 0
0 0 1 0 0 1 0 0 0 1
1 0 0 0 0 0 0 0 0 0
0 1 0 0 0 1 0 1 0 0
1 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 0 0
1 0 0 0 0 1 0 0 0 1
output =112

*/
package Elite;
import java.util.*;

public class SuitableLocation {
	public static int minTotalDistance(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		List<Integer> I = new ArrayList<>(m);
		List<Integer> J = new ArrayList<>(n);
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] == 1){
					I.add(i);
					J.add(j);
				}
			}
		}
		
    return getMin(I) + getMin(J);
	}

	private static int getMin(List<Integer> list){
		int ret = 0;
		
		Collections.sort(list);
		
		int i = 0;
		int j = list.size() - 1;
		while(i < j){
			ret += list.get(j--) - list.get(i++);
		}
		
		return ret;
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		int grid[][]=new int[r][c];
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				grid[i][j]=sc.nextInt();
		System.out.println(minTotalDistance(grid));
	}
}