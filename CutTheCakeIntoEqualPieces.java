/* 20/03/2020 - HOME
 * Lasya has ordered a Cake delivery. 
The cake can be considered a perfect circle. 
There were n premade cuts in the cake when it was delivered. Each cut is a straight 
segment connecting the center of the cake with its boundary.

Let O be the center of the cake, Pi be the endpoint of the i-th cut lying on the boundary, 
and R be the point of the boundary straight to the right of O. 
Then the counterclockwise-measured angle ∠ROPi is equal to ai degrees, 
where ai is an integer between 0 and 359. 
Note that angles between 0 and 180 angles correspond to Pi in the top half of the cake, 
while angles between 180 and 360 angles correspond to the bottom half.

Lasya may cut her cake a few more times, and the new cuts still have to be straight 
segments starting at the center. She wants to make the pizza separated into several 
equal slices, with each slice being a circular sector with no cuts inside of it. 
How many new cuts Lasya will have to make?

Input Format
------------
The first line contains a single integer n− 
    the numbers of premade cuts (2≤n≤360).

The second lines contains n integers a1,…,an − 
    angles of the cuts 1,…,n respectively (0≤a1<…,an−1<360).

Output Format
-------------
Print a single integer − the smallest number of additional cuts Vasya has to make 
so that the pizza is divided into several equal slices.
Example-1:
    Input:
        2
        90 210
    Output:
        1
    
    Explanation:
        The pizza will be cut into three equal slices after making one extra cut at 330 degrees.


Example-2:
    Input:
        2
        0 1
    Output:
        358
    Explanation:
        Lasya will have to cut this pizza into 360 pieces of 1 degree angle each.
        so, need to make 358 new cuts.

 */
package Elite;
import java.util.*;
public class CutTheCakeIntoEqualPieces {
	
	public static int GCD(int a,int b) {
		if(a == 0) return b;
		return GCD(b%a,a);
	}
	
	public static int findGCD(LinkedList<Integer> angles) {
		int temp = angles.get(0);
		for(int i=1;i<angles.size();i++) {
			temp = GCD(temp,angles.get(i));
			if(temp == 1) return 1;
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cuts = sc.nextInt();
		if(cuts < 2|| cuts >360)System.out.println(-1);
		LinkedList<Integer> angles = new LinkedList<>();
		for(int i=0;i<cuts;i++) {
			int num = sc.nextInt();
			angles.add(num);
		}
		angles.add(360);
		Collections.sort(angles);
		if(Collections.max(angles) == Collections.min(angles)) {
			System.out.println(0);
		}
		else {
			int result = findGCD(angles);
			System.out.println(360/result - cuts);
		}
	}
}