/* 05/05/2020 - HOME
 * Input Format:
    - First line contains an integer N, indicates number of rooms
    - Next N lines contains an array of space separated integers, indicates KEYS of rooms
      Where room[i] has a list of KEYS, rooms[i][j], and 
      each KEY, rooms[i][j] is an integer in [0, 1, ..., N-1]. 
      A KEY, rooms[i][j] = v opens the room with number v.

Output Format:
    - Print true if and only if you can enter every room.
      Otherwise, print false


Sample Input 1: 
4
1
2
3
0
Sample Output 1: 
true


Sample Input 2: 
4
1 3
3 0 1
2
0

Sample Output 2: 
false


 */
package Elite;
import java.util.*;

public class RoomsOfKeys {
	
	public static void findPath(List<LinkedList<Integer>> adjList,boolean[] visited,int source) {
		visited[source] = true;
		LinkedList<Integer> temp = adjList.get(source);
		for(int item : temp) {
			if(!visited[item]) {
				findPath(adjList, visited, item);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rooms = sc.nextInt();
		sc.nextLine();
		List<LinkedList<Integer>> adjList = new LinkedList<>();
		for(int i=0;i<rooms;i++) {
			adjList.add(new LinkedList<>());
		}
		for(int i=0;i<rooms;i++) {
			int temp[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
			for(int j=0;j<temp.length;j++) {
				if(i == temp[j]) continue;
				if(!adjList.get(i).contains(temp[j]))adjList.get(i).add(temp[j]);
				if(!adjList.get(temp[j]).contains(i))adjList.get(temp[j]).add(i);
			}
		}
		System.out.println(adjList);
		boolean visited[] = new boolean[rooms];
		findPath(adjList,visited,0);
		int flag = 0;
		for(int i=0;i<rooms;i++) {
			if(!visited[i]) {
				flag = 1;
				System.out.println(false);
				break;
			}
		}
		if(flag == 0) System.out.println(true);
	}
}