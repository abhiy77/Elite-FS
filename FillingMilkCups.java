/* 17/09/2020 - ELITE DAY - 122)
 * 
 * Ramu is a milk supplier to Somu. He has only two aluminium cups of capacity m and n litres..
Using these two cups, he can measure the milk. 
He has to supply exactly P litres of milk to Somu.

To measure the milk, operations allowed are:
	- Fill one of the cups completely with milk.
	- Empty the other cup.
	- Pour milk from one cup into another cup till it fills completely,
	 or the first cup itself is empty.
	 
Such that, at the end one or both cups contains P litres of the milk.
	
Please help Ramu, to check whether P litres of milk can be measured
using the two cups or not.

Input Format:
-------------
3 space separated integers, m, n and P.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
3 5 4

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 4 5

Sample Output-2:
----------------
false

******* MilkandCup *******
case =1
input =3 5 4
output =true

case =2
input =2 4 5
output =false

case =3
input =10 15 25
output =true

case =4
input =5 7 9
output =true

case =5
input =11 35 23
output =true

case =6
input =11 21 33
output =false

case =7
input =17 29 25
output =true

case =8
input =11 21 35
output =false




 */
package Elite;
import java.util.*;

public class FillingMilkCups {
	
	public static boolean canFill(int wt1,int wt2,int target,boolean[][] visited,int cap1,int cap2) {
		if((wt1 == target && wt2 == 0) || (wt1 == 0 && wt2 == target) || wt1 + wt2 == target) return true;
		if(!visited[wt1][wt2]) {
			visited[wt1][wt2] = true;
			
			return (canFill(0, wt2, target, visited,cap1,cap2) || canFill(wt1, 0, target, visited,cap1,cap2)
			      || canFill(cap1, wt2, target, visited,cap1,cap2) || canFill(wt1, cap2, target, visited, cap1, cap2)
			      || canFill(wt1 + Math.min(wt2, cap1 - wt1),wt2 - (Math.min(wt2, cap1 - wt1)),target,visited,cap1,cap2)
			      || canFill(wt1 - Math.min(cap2 - wt2, wt1),wt2 + Math.min(wt1, cap2 - wt2),target,visited,cap1,cap2));
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wt1 = sc.nextInt();
		int wt2 = sc.nextInt();
		int target = sc.nextInt();
		int max = Math.max(wt1, Math.max(wt2, target));
		boolean visited[][] = new boolean[max+1][max+1];
		
		System.out.println(canFill(0,0,target,visited,wt1,wt2));
	}
}