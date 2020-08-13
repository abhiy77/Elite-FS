/*17/02/2020
 * 
You have a number of envelopes with widths and heights given as a pair of integers (w, h).
One envelope can fit into another if and only if both the width and height of one envelope is 
greater than the width and height of the other envelope.

What is the maximum number of envelopes can you put one inside other

Note:
Rotation is not allowed.

Example:

Input: 4
5 4
6 4
6 7
2 3

Output: 3 

Explanation: 
The maximum number of envelopes you can put one inside other is 3 ([2,3] => [5,4] => [6,7]).


 */
package Elite;
import java.util.*;
public class EnvelopesInEnvelopes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair1[] pairs = new Pair1[n];
        for(int i=0;i<n;i++) {
        	pairs[i] = new Pair1(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(pairs);
        int dp[] = new int[n];
        int len = 0;
        for(int i=0;i<n;i++) {
        	int x = Arrays.binarySearch(dp, 0,len,pairs[i].height);
        	if(x < 0) {x = -(x+1);}
        	dp[x] = pairs[i].height;
        	if(x == len) len++;
        }
        System.out.println(len);
	}
}

class Pair1 implements Comparable<Pair1>{
	int width,height;

	public Pair1(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public int compareTo(Pair1 o) {
		if(this.width != o.width) {
			return this.width-o.width;
		}
		else {
			return o.height-this.height;
		}
	}	
}