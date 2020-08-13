/* 26/03/2020 - HOME
 * Protection of the Indian border and safe transport of items from one point 
to another along the border are the paramount jobs for the Indian army. 
However they need some information about the protection status along the 
length of the border. The border can be viewed as the real x-axis. 
Along the axis, Indian army has N checkpoints for lookout.

We know that each checkpoint is located at an integer location xi. 
Each checkpoint must have a fleet of armed men which are responsible 
for guarding the neighboring areas of the checkpoint and provide 
military assistance of all kinds. The size of the fleet is based on 
the location of the checkpoint and how active the region is for terrorist activities.

Given the number of armed men assigned at the ith checkpoint, as pi, 
this information is available for all checkpoints.
With the skills of the armed men, it is known that if for the ith checkpoint, 
the length on the x axis that they can defend is a closed interval [xi-pi, xi+pi].

Now, your task is to transport some military items from position S to 
the end position E on the x-axis. 

Input Format
------------
First line of the input contains 3 integers N, S and E. 
N is the number of checkpoints that the Indian Army has on the border.
Then N lines follow. ith line contains 2 integers, xi and pi.

Output Format
-------------
Print the total distance of the x-axis from S to E, that is not protected by the armed forces.

Sample Input
    5 229 8419
    1795 95
    4873 720
    3149 81
    6101 2325
    3674 629
Sample Output
    2626

 */
package Elite;
import java.util.*;
public class IndianArmy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int source = sc.nextInt();
		int dest = sc.nextInt();
		int distance = 0;
		TreeMap<Integer,Integer>  endpoints = new TreeMap<>();
		for(int i=0;i<n;i++) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			endpoints.put(x1-x2,x1+x2);
		}
		//System.out.println(endpoints);
		while(source < dest) {
			int key = endpoints.firstKey();
			int value = endpoints.get(endpoints.firstKey());
			if(dest <= key) {
				distance += dest - source;
				source = dest;
			}
			else if(source <= key) {
				distance += key - source;
				source = value;
			}
			else if(source >= key && source <= value) {
				source = value;
			}

			endpoints.pollFirstEntry();
		//	System.out.println(source + " " + distance);
		}
		System.out.println(distance);
	}
}