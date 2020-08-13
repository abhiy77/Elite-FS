/* ELITE DAY - 109
Indian Super League organizing a football match at Eden Gardens.
The teams are Bangalore and Chennai are playing opposite each other.

After Match starts, each team making some goals at certain time, 
for example, goal 'goal[i]' was made by a player at time 'time[i]'.
goal[i]: indicates the team number 0 (Bangalore) or 1 (Chennai).
time[i]: indicates the time of the goal made.

Now, your task is to find out the leading team at given time t[j].

Input Format:
------------------
Line-1: Two integers N and K, no of goalsgoal[i] and no of times t[j]
Line-2: N space seperated integers only 0's and 1', goals[i]
Line-3: N space seperated integers, time[i]
Line-4: K space seperated integers , t[i]
 
Output Format:
------------------
Print K space seperated integers as result.


Sample Input-1:
--------------------
7 5
0 1 1 0 0 1 0
0 5 10 15 20 25 30
3 12 25 15 24

Sample Output-1:
---------------------
0 1 1 0 0 1

Explanation:
---------------
At time 3, the goals are [0], and 0 is leading.
At time 12, the goals are [0,1,1], and 1 is leading.
At time 25, the goals are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent goal)
At time 15, the goals are [0,1,1,0], and 0 is leading (as ties go to the most recent goal)
At time 25, the goals are [0,1,1,0,0], and 0 is leading.
*/
package Elite;
import java.util.*;

public class WhoIsWinner {

    Map<Integer, Integer> m = new HashMap<>();
    int[] time;
    public WhoIsWinner(int[] goals, int[] times) {
        int n = goals.length, lead = -1;
        Map<Integer, Integer> count = new HashMap<>();
        time = times;
        for (int i = 0; i < n; ++i) {
            count.put(goals[i], count.getOrDefault(goals[i], 0) + 1);
            if (i == 0 || count.get(goals[i]) >= count.get(lead)) lead = goals[i];
            m.put(times[i], lead);
        }
    }

    public int q(int t) {
        int i = Arrays.binarySearch(time, t);
        return i < 0 ? m.get(time[-i-2]) : m.get(time[i]);
    }
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int t=sc.nextInt();
		
		int goals[]=new int[n];
		int times[]=new int[n];
		for(int i=0;i<n;i++)
			goals[i]=sc.nextInt();
		for(int i=0;i<n;i++)
			times[i]=sc.nextInt();
		
		WhoIsWinner tvc= new WhoIsWinner(goals,times);
		
		for(int i=0;i<t;i++)
		System.out.print(tvc.q(sc.nextInt())+" ");
	}
}
