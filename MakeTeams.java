/* ELITE DAY - 108 (25/07/2020)
In a school, there are N students in a class numbered from 1,2,3..N.
During the play time in school, drill master wants to split them into 
two teams based on their interest.

If the pair of students want to play opposite each other, drill master should 
put them in different teams, e.g. pair[i] = (A,B), it is not allowed to 
put A and B in same team.
 
You need to find out wether is it possible to put everyone into two teams or not.
return true if it is possible, otherwise false.

Input Format:
----------------
Line-1 -> Two Integers, N and P, number of students N, number of pairs P.
Next P lines -> Two integers, one pair[i], where 'i' is from 0 to P-1

Output Format:
------------------
Print a boolean result.


Sample Input-1:
-------------------
4 3
1 2
1 3
2 4

Sample Output-1:
---------------------
true

Explanation: 
----------------
team1 [1,4], team2 [2,3]

Sample Input-2:
-------------------
5 5
1 2
2 3
3 4
4 5
1 5

Sample Output-2:
---------------------
false

*/
package Elite;
import java.util.Scanner;

class MakeTeams {
    public static boolean canMakeTeams(int N, int[][] pair) {
        int[][] graph = new int[N][N];
        for (int[] d : pair) {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }
        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }
    private static boolean dfs(int[][] graph, int[] group, int index, int g) {
        group[index] = g;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (group[i] == g) {
                    return false;
                }
                if (group[i] == 0 && !dfs(graph, group, i, -g)) {
                    return false;
                }
            }
        }
        return true;
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int p=sc.nextInt();
		int pair[][]=new int[p][2];
		for(int i=0;i<p;i++){
			pair[i][0]=sc.nextInt();
			pair[i][1]=sc.nextInt();
		}
		
		System.out.println(canMakeTeams(n,pair));
	}
}
