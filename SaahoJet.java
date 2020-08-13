/* 19/03/2020 - HOME
 *     Sujeeth has created flying machine named Sahoo-JET. 
Sahoo-Jet can only fly horizontally, independent of the environment. 
One day, Sujeeth started his flight from Dubai's highest tower, 
traveled some distance and landed on another tower of same height! 
So much fun! But unfortunately, new towers have been built recently.

    Let us describe the problem in one dimensional space. We have in total N
towers aligned from left to right. The i-th tower has a height of h(i). 
A flying route can be described as (i,j) with i!=j, which means, 
Sujeeth starts his Saaho-JET at the top of the tower i and lands on the tower j. 

    Since Saaho-JET can only fly horizontally, Sujeeth will remain at the height h(i) only. 
Thus the path (i,j) can be valid, only if each of the towers i,i+1....,j+1,j is not 
strictly greater than h(i) and if the height of the tower he starts from and 
arrives on have the same height. 

Help Sujeeth in counting the number of valid paths represented by ordered pairs (i,j).

Input Format:
-------------
The first line contains N, the number of towers. 
The next line contains N space separated integers representing the heights of the towers.

Output Format:
--------------
Print an integer that denotes the number of valid routes.

Sample-1
    Input :
    6
    3 2 1 2 3 3
    Output :
    8

    Explanation :
        The first line contains the number of towers. 
        The next line contains space separated integers representing the heights of the towers. 
    
        ==>   tower at position 1 can jump on tower at position 5,6 
        because of same height and towers in between is less height.
        ==>    tower at position 2 can jump on tower at position 4 
        because of same height and tower in between is less height.
        ==>   tower at position 5 can jump on tower at position 6 
        because of same height and towers in between is less height.
        ==>   total 4 jumps possible from left to right, 
        another 4 jumps possible from right to left so total 8 jumps possible.

Sample-2:
    Input:
    3
    1 1000 1
    Output:
    0
    Explanation:
        ==>   tower at position 1 cannot jump on tower at position 3
        because of tower in between has more height.
 */
package Elite;
import java.util.*;
public class SaahoJet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int buildings = sc.nextInt();
		int[] heights = new int[buildings];
		for(int i=0;i<buildings;i++) {
			heights[i] = sc.nextInt();
		}
		int count = 0;
		for(int i=0;i<buildings;i++) {
			for(int j=i+1;j<buildings;j++) {
				if(heights[i] == heights[j]) count++;
				else if(heights[i] < heights[j]) break;
			}
		}
		System.out.println(count*2);
	}
}