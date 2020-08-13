/* 23/03/2020 - HOME
 * The member of  Olympic Council of Asia (OCA) is planning to select people for the Asian Games. 
They want to choose two from different states. 

You will be given a list of pairs of athlete id's. 
Each pair is made of athletes from the same state. Determine how many pairs of athletes from 
different states they can choose from.

For example, we have the following data on 2 pairs of athletes, and 4 athletes total, numbered  
0 through 3.
ID State ID
1  2
2  3
athletes by state are [0] and [1,2,3]. There are 3 pairs to choose from:[0,1],[0,2] and [0,3].


Input Format:
-----------------
The first line contains two integers n and p, the number of athletes and the number of pairs.
Each of the p next lines contains 2 space-separated integers denoting athlete ID's of two athletes
who share the same state.

Output Format
-------------
An integer that denotes the number of ways to choose a pair of athletes from different states.

Sample Input 1:
--------------
    5 3
    0 1
    2 3
    0 4
    
Sample Output 1:
---------------
    6
    
Explanation:
    Persons numbered [0,1,4] belong to one state, and those numbered [2,3] belong to another. 
    The member has 6 ways of choosing a pair [0,2],[0,3],[1,2],[1,3],[4,2],[4,3]
    
Sample Input 2:
---------------
    4 1
    0 2

Sample Output 2:
----------------
    5

Explanation:
    Persons numbered [0,2] belong to one state. but persons 1 & 3 don't share states with anyone else.
    The member has 5 ways of choosing a pair [0,1],[0,3],[2,1],[2,3],[1,3].

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
input =6 4
0 1
2 3
4 5
0 2
output =8

case =4
input =8 6
0 1
2 3
4 5
6 7
0 7
6 3
output =12

case =5
input =10 5
0 1
2 5
1 4
5 6
4 7
output =36

case =6
input =12 3
0 3
2 4
3 6
output =62

case =7
input =6 3
1 2
2 3
3 4
output =9

case =8
input =8 3
0 1
2 3
4 5
output =25

case =9
input =7 5
0 1
0 3
0 4
1 5
2 4
output =6

case =10
input =6 3
0 1
1 4
4 5
output =9



 */
package Elite;
import java.util.*;

public class PairsOfAthletes {
	
	public static HashSet<Integer> getCombinations(LinkedList<LinkedList<Integer>> list,boolean visited[],int source,HashSet<Integer> temp) {
		visited[source] = true;
		temp.add(source);
		LinkedList<Integer> curr = list.get(source);
		for(int i=0;i<curr.size();i++) {
			if(!visited[curr.get(i)]) {
				getCombinations(list, visited, curr.get(i), temp);
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int athletes = sc.nextInt();
		int pairs = sc.nextInt();
		LinkedList<LinkedList<Integer>> list = new LinkedList<>();
		for(int i=0;i<athletes;i++) {
			LinkedList<Integer> temp = new LinkedList<>();
			temp.add(i);
			list.add(temp);
		}
		for(int i=0;i<pairs;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.get(x).add(y);
			list.get(y).add(x);
		}
		LinkedList<LinkedList<Integer>> result = new LinkedList<>();
		boolean visited[] = new boolean[athletes];
		for(int i=0;i<athletes;i++) {		
			if(!visited[i])result.add(new LinkedList<Integer>(getCombinations(list,visited,i,new HashSet<>())));
		}
		System.out.println(result);
		int combinations = 0;
		for(int i=0;i<result.size()-1;i++) {
			for(int j=i+1;j<result.size();j++) {
				combinations += result.get(i).size()*result.get(j).size();
			}
		}
		System.out.println(combinations);
	}
}