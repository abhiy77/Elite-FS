/* 26/05/2020 - HOME
 * 
 * REFERENCE _ HACKER RANK (NEW YEAR CHAOS)
 * 
 * Input Format:
    - line-1 contains an integer N, the number of people
    - line-2 has N space-separated integers, indicates positions of the people

Output Format:
    - Print an integer , as result if you can get original positions.
    Otherwise print "Not Possible"
    
Sample Input:
8
1 2 5 3 7 8 6 4
Sample Output:
7


Sample Input:
8
5 1 2 3 7 8 6 4
Sample Output:
Not Possible
 */
package Elite;
import java.util.*;

public class BribingPeople {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q[] = new int[n+1];
		for(int q_i=1; q_i <= n; q_i++){
			q[q_i] = in.nextInt();
		}
		// your code goes here
		int result = 0;
		boolean chaotic = false;
		boolean done = false;
		int[] bribe = new int[n+1];
		
		while(!done) {
			done = true;
			for(int i = 1; i < n; i++) {
				if(q[i] > q[i+1]) {
					bribe[q[i]]++;
					if(bribe[q[i]] > 2) {
						System.out.println("Too chaotic");
						chaotic = true;
						done = true;
						break;
					} else {
						result++;
						int temp = q[i];
						q[i] = q[i+1];
						q[i+1] = temp;
						done = false;
					}
				}
			}
		}
		
		if(!chaotic)
			System.out.println(result);
		in.close();
    }
}