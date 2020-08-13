/* 24/03/2020 - HOME
 * You have N bulbs in a row numbered from 1 to N. Initially, all the bulbs are turned off. 
We turn on exactly one bulb everyday until all bulbs are on after N days.

You are given an array bulbs of length N where bulbs[i] = x means that on the (i+1)th day, 
we will turn on the bulb at position x where i is 0-indexed and x is 1-indexed.

Given an integer K, find out the minimum day number such that there exists two turned on bulbs 
that have exactly K bulbs between them that are all turned off.

If there isn't such day, return -1.

Example 1:
	Input: 	1 3 2
			1
	Output: 2
	Explanation:
		On the first day: bulbs[0] = 1, first bulb is turned on: [1,0,0]
		On the second day: bulbs[1] = 3, third bulb is turned on: [1,0,1]
		On the third day: bulbs[2] = 2, second bulb is turned on: [1,1,1]
		We return 2 because on the second day, there were two on bulbs with one off bulb between them.


Example 2:
	Input:	1 2 3
			1
	Output: -1

 */
package Elite;
import java.util.*;
public class TurnOnAndOffBulbs {

	public static boolean check(int i,int j,boolean visited[]) {
		if(i > j) {
			i=i+j ; j=i-j ; i=i-j;
		}
		for(int k=i+1;k<j;k++) {
			if(visited[k]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int k = sc.nextInt();
		boolean visited[] = new boolean[arr.length+1];
		visited[arr[0]] = true;
		int days = 1;
		for(int i=1;i<arr.length;i++) {
			visited[arr[i]] = true;
			days++;
			for(int j=0;j<i;j++) {
				if(Math.abs(arr[i]-arr[j]) == k+1 && check(arr[i],arr[j],visited)) {
					System.out.println(days);
					System.exit(1);
				}
			}
		}
		System.out.println(-1);
	}
}