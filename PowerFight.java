/* 18/06/2020 - HOME
 * Input Format:
-------------
Line-1 -> a single integer N.
Line-2 -> N space-separated integers.

Output Format:
--------------
Print an integer as your result.

Sample Input-1:
-------------
3
3 2 5

Sample Output-1:
--------------
16

Sample Input-2:
-------------
3
3 2 1

Sample Output-2:
--------------
10

 */
package Elite;
import java.util.*;

public class PowerFight {
	public static int maxPower = 1;
	
	public static void recurse(int i,int[]  powers,int curr,int weight) {
		if(i == powers.length) {
			maxPower = Math.max(curr, maxPower);
			return;
		}
		for(int j = i;j<powers.length;j++) {
			recurse(j+1,powers,curr,weight+1);
			recurse(j+1,powers,curr + weight*powers[j],weight);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int powers[] = new int[n];
		for(int i=0;i<n;i++) powers[i] = sc.nextInt();
		Arrays.sort(powers);
		recurse(0,powers,0,1);
		System.out.println(maxPower);
	}
}