/* 20/06/2020 - HOME
 * Input Format:
-------------
- An Integer N

Output Format:
--------------
- Print the name of the winner
  (Ram or Nag)

Note: Ram always starts first.

Sample Input-1:
---------------
4
Sample Output-1:
----------------
Ram

Sample Input-2:
---------------
3
Sample Output-2:
----------------
Nag


 */
package Elite;
import java.util.*;

public class Pick2BlocksAndSubtractGame {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<n;i++) list.add(i+1);
		if(n == 1 || n% 2 == 0) {
			System.out.println("Ram");
		}
		else {
			System.out.println("Nag");
		}
	}
}