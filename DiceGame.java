/* 20/01/2020
 * 
Given you few dices (c) , and each die has 'n' faces numbered 1, 2, ..., n.

You have to find the number of possible ways, when you roll all the dices, 
the sum of the face up numbers equals to given target.

You have to return the output as, possible ways (out of POW(n,c) total ways) modulo 10^9 + 7 

Input Format: enter 3 integers, indicates dicecount, no.of.faces and target
Output Format: an integer, indicates possible ways

Example 1:
		Input=	1	6	3
		Output=1
		Explanation: 
		You throw one dice with 6 faces.  There is only one way to get a sum of 3.

Example 2:

		Input=	2	6	7
		Output=6
		Explanation: 
		You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
		1+6, 2+5, 3+4, 4+3, 5+2, 6+1.

Example 3:

		Input=	2	5	10
		Output=1
		Explanation: 
		You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.

Example 4:
		Input=	1	2	3
		Output=0
		Explanation: 
		You throw one dice with 2 faces.  There is no way to get a sum of 3.
*/
package Elite;
import java.util.*;
public class DiceGame {
	
	static int count =0;
	public static void recurse(int dice,int[] arr,int target,int dices,int faces) {
		if(target == 0 && dice == dices)  {
			count++; return;
		}
		if(target < 0 || target == 0 && dice !=dices) return;
		
		for(int q=0;q<faces;q++) {
			recurse(dice+1, arr, target-arr[q], dices, faces);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dices = sc.nextInt();
		int faces = sc.nextInt();
		int target = sc.nextInt();
		int arr[] = new int[faces];
		for(int i=0;i<faces;i++) {
			arr[i] = i+1;
		}

		recurse(0,arr,target,dices,faces);
		System.out.println(count);
	}
}
