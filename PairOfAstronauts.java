/* 30/04/2020 - HOME
 * 
The member states of the UN are planning to send 2 people to the moon. 
They want them to be from different countries. 
You will be given a list of pairs of astronaut ID's. 
Each pair is made of astronauts from the same country. 
Determine how many pairs of astronauts from different countries they can choose from.

For example, we have the following data on 2 pairs of astronauts, and 4 astronauts total, 
numbered 0 through 3.
1   2
2   3
Astronauts by country are [0] and [1,2,3]. 
There are 3 pairs to choose from: [0,1], [0,2] and [0,3].

Input Format:
The first line contains two integers n and p, the number of astronauts and the number of pairs.
Each of the next p lines contains 2 space-separated integers denoting astronaut ID's 
of two who share the same nationality.

Output Format
- An integer that denotes the number of ways to choose a pair of astronauts from different coutries.

Sample Input1:
5 3
0 1
2 3
0 4
Sample Output1:
6
Explanation1:
Persons numbered [0,1,4] belong to one country, 
and those numbered [2,3] belong to another. 
The UN has 6 ways of choosing a pair:
[0,2],[0,3],[1,2],[1,3],[4,2],[4,3]

Sample Input2:
4 1
0 2
Sample Output2:
5
Explanation2:
Persons numbered [0,2] belong to the same country, 
but persons 1 and 3 don't share countries with anyone else. 
The UN has 5 ways of choosing a pair:
[0,1],[0,3],[2,1],[2,3],[1,3]

========= Testcases Program-2 =========
case =1
input =4 1
0 2
output =5

case =2
input =5 3
0 1
2 3
0 4
output =6

case =3
input =6 3
1 2
3 4
1 4
output =9

case =4
input =8 5
0 1
2 3
4 2
5 6
0 5
output =19

case =5
input =7 4
0 1
1 2
2 3
3 4
output =11

case =6
input =9 5
0 1
2 3
3 4
4 5
1 6
output =27

case =7
input =9 6
0 1
1 2
3 4
4 5
5 6
6 7
output =23

case =8
input =10 5
1 8
2 7
3 6
4 5
5 9
output =39

 */
package Elite;
import java.util.*;

public class PairOfAstronauts {

	private static LinkedList<Integer> dfs(LinkedList<LinkedList<Integer>> adjList, int astronauts, boolean[] visited,LinkedList<Integer> temp, int i) {
		temp.add(i);
		visited[i] = true;
		for(int e : adjList.get(i)) {
			if(!visited[e]) dfs(adjList, astronauts, visited, temp, e);
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int astronauts = sc.nextInt();
		int pairs = sc.nextInt();
		LinkedList<LinkedList<Integer>> adjList = new LinkedList<>();
		LinkedList<LinkedList<Integer>> result = new LinkedList<>();
		for(int i=0;i<astronauts;i++) {
			adjList.add(new LinkedList<>());
		}
		for(int i=0;i<pairs;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adjList.get(x).add(y);
			adjList.get(y).add(x);
		}
		boolean visited[] = new boolean[astronauts];
		for(int i=0;i<astronauts;i++) {
			if(!visited[i]) {
				result.add(dfs(adjList,astronauts,visited,new LinkedList<>(),i));
			}
		}
		int total = 0;
		//System.out.println(result);
		for(int i=0;i<result.size()-1;i++) {
			for(int j=i+1;j<result.size();j++) {
				total += result.get(i).size()*result.get(j).size();
			}
		}
		System.out.println(total);
	}
}