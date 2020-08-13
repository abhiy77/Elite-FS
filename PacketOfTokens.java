/* 05/03/2020
In a Packet of Tokens, every token has a unique integer.  
You can order tokens of the Packet in any order you want.

Initially, all the tokens are hidden (closed) in the Packet.

Now, you do the following steps repeatedly, until all tokens are shown (opened):

Take the top token of the Packet, show it, and take it out of the Packet.

If there are still tokens in the Packet, put the next top token of the Packet at the bottom of the Packet.
If there are still hidden tokens, go back to previous step.  Otherwise, stop.
Return an ordering of the Packet that would show the tokens in increasing order.

The first entry in the answer is considered to be the top of the Packet.

 

Example 1:

Input: 28 24 22 13 14 16 18
Output: 13 24 14 22 16 28 18

Explanation: 
We get the Packet in the order [28,24,22,13,14,16,18] (this order doesn't matter), and reorder it.
After reordering, the Packet starts as [13,24,14,22,16,28,18], where 13 is the top of the Packet.
We show 13, and move 24 to the bottom.  Packet Now-> [14,22,16,28,18,24].
We show 14, and move 22 to the bottom.  Packet Now-> [16,28,18,24,22].
We show 16, and move 28 to the bottom.  Packet Now-> [18,24,22,28].
We show 18, and move 24 to the bottom.  Packet Now-> [22,28,24].
We show 22, and move 28 to the bottom.  Packet Now-> [24,28].
We show 24, and move 28 to the bottom.  Packet Now-> [28].
We show 28.
Since all the tokens shown are in increasing order, the answer is correct.
*/
package Elite;
import java.util.*;
public class PacketOfTokens {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		int result[] = new int[arr.length];
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<arr.length;i++) queue.add(i);
		for(int i=0;i<arr.length;i++) {
			result[queue.poll()] = arr[i];
			queue.add(queue.poll());
		}
		System.out.println(Arrays.toString(result));
	}
}