/* 26/03/2020 - HOME
 * Abhinav is organizing a racing competation.N numbers of team (numbered as 1 to N) 
are participating in this race. Each team has M number of players. 
For each team M (team size) number of T-shirts are to be provided by the organizer. 
Each T-shirt contains a number(of that player) and may contain number of 
other player(s) of his own team.

At a time maximum P number of players(P≤M) can run in a ground.

Rules of race are following-
* Each player takes 1 minute to complete his race.
* Players(may be all) are dependent on some other players(the player(s)number written on his T-shirt) of his team.
* A player can only start the race if player(s) number written on his T-shirt have finished their race.
* Time taken by a team to complete the race is total time taken by players of team untill all have finished the race.
Time may be infinite.
* Team who will take minimum time will be winner.
* Your task is to find winner team.

Input Format:
-------------
* The first line of the input contains an integer N denoting the number of teams
* The second line contains integer M denoting number of players of a team and D denoting 
sum of count of numbers written on T-shirt of each player(excluding his number) of a team.
* The next D lines contain two integer A and B denoting B will finish only after A finished.
* Repeat the steps 2 and 3 N times.

Output Format:
--------------
Output a single integer in a separate line denoting the team number of winner team.
If all teams take infinite time to complete the race or in case of tie output "0"(without quote).

Sample Input:
2
4 3
1 3
3 2
4 2
3 3
1 2
1 3
2 1
Sample Output:
1

Explanation:

For Team-1:
Firstly 1 and 4 finish their race simultaneously and take 1 minute, because they haven't need to wait for others.
Now 3 will finish his race in 1 minute.Since, only 2 is left ,he will finish his race in 1 minute.

Total no of time taken by Team-1 =1+1+1=3 minutes.

For Team-2:
3 and 2 will wait to finish 1,but 1 is also waiting for 2. In this situation no one can start race. Hence, 
Team-2 will take infinite time.

Team 1 will be winner.

 */
package Elite;
import java.util.*;
public class RaceCompetitionTopological {

	 public static Queue<Integer> findZeroRank(int[] rank,Queue<Integer> queue){
	        for(int i=0;i<rank.length;i++){
	            if(rank[i] == 0) queue.add(i);
	        }
	        return queue;
	    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int teams = sc.nextInt();
		LinkedList<Integer> completionTimes = new LinkedList<>();
		for(int i=0;i<teams;i++) {
			int players = sc.nextInt();
			int d = sc.nextInt();
			LinkedList<LinkedList<Integer>>arr = new LinkedList<>();
	        for(int j=0;j<players;j++){
	            arr.add(new LinkedList<Integer>());
	        }
	        int[] rank = new int[players];
			for(int j=0;j<d;j++) {
				int x = sc.nextInt()-1;
	            int y = sc.nextInt()-1;
	            arr.get(x).add(y);
	            rank[y]++;   
			}
			Queue<Integer> queue = new LinkedList<>();
			if(findZeroRank(rank,queue).isEmpty()) {
	        	completionTimes.add(Integer.MAX_VALUE);
	        	continue;
	        }
			int x = queue.size();
			int count = 0;
	        while(!queue.isEmpty()){
	            if(x == 0) {x = queue.size(); count++;}
	            int element = queue.poll();
	            for(int e : arr.get(element)){
	                rank[e]--;
	                if(rank[e] == 0){
	                    queue.add(e);
	                }
	            }
	            x--;
	        }
	        completionTimes.add(count);
		}
		if(Collections.min(completionTimes) == Integer.MIN_VALUE || Collections.max(completionTimes) == Collections.min(completionTimes)) {
			System.out.println(0);
		}
		else {
			System.out.println(completionTimes.indexOf(Collections.min(completionTimes)) + 1);
		}
	}
}