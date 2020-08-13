/* 20/01/2020
 * There is a keyboard consists of following keys only,

Key 1: (S): Print one 'S' on screen.
Key 2: (Ctrl-S): Select the whole screen.
Key 3: (Ctrl-C): Copy selection to buffer.
Key 4: (Ctrl-P): Print buffer on screen appending it after what has already been printed.

Now, you can only press the keyboard for N times (with the above four keys), 
find out the maximum numbers of 'S' you can print on screen.

Example 1:
Input:3
Output: 3
Explanation: 
We can at most get 3 S's on screen by pressing following key sequence:
S, S, S

Example 2:
Input: 7
Output: 9
Explanation: 
We can at most get 9 S's on screen by pressing following key sequence:
S, S, S, Ctrl-S, Ctrl-C, Ctrl-P, Ctrl-P

 */
package Elite;
import java.util.*;
public class KeyboardMaxSequence {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n<=6) {
			System.out.println(n);
		}
		else {
		   int screen[] = new int[n+1];
		   
		   for(int i=1;i<=6;i++) {
			   screen[i] = i;
		   }
		   
		   for(int i=7;i<=n;i++) {
			   screen[i] = Math.max(2*screen[i-3], Math.max(3*screen[i-4], 4*screen[i-5]));
		   }
		   System.out.println(screen[n]);
		}
	}
}