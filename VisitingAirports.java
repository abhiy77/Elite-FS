/* 19/02/2020
 * 
Given a list of flight tickets represented by pairs of departure and arrival airports [from, to], 
reconstruct the travel plan in order. All of the tickets belong to a man who departs from BZA.
Thus, the travel plan must begin with BZA.

Note:

If there are multiple valid itineraries, 
you should return the travel plan that has the smallest lexical order when read as a single string. 
For example, the travel plan ["BZA", "LGA"] has a smaller lexical order than ["BZA", "LGB"].

All airports are represented by three capital letters.
You may assume all tickets form at least one valid travel plan.

Example 1:

Input:4
DEL HYD
BZA DEL
BLR MAA
HYD BLR

Output: ["BZA", "DEL", "HYD", "BLR", "MAA"]

Example 2:

Input:5
BZA BLR
BZA CCU
BLR CCU
CCU BZA
CCU BLR
Output: ["BZA","BLR","CCU","BZA","CCU","BLR"]           
 */
package Elite;
import java.util.*;
public class VisitingAirports {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		HashMap<String,TreeSet<String>> map = new HashMap<>();
        HashMap<String,Boolean> visited = new HashMap<>();
        for(int i=0;i<n;i++) {
        	String str[] = sc.nextLine().split(" ");
        	visited.put(str[0]+" "+str[1] , false);
        	//if(!visited.containsKey(str[0])) visited.put(str[0], false);
        	//if(!visited.containsKey(str[1])) visited.put(str[1], false);
        	if(map.containsKey(str[0])) {
        		TreeSet<String> temp = map.get(str[0]);
        		temp.add(str[1]);
        		map.put(str[0],temp);
        	}
        	else {
        		TreeSet<String> temp = new TreeSet<>();
        		temp.add(str[1]);
        		map.put(str[0], temp);
        	}
        }
        //System.out.println(map);
       LinkedList<String> list = dfs(map,visited,"BZA",new LinkedList<>());
       list.removeLastOccurrence("BZA");
       System.out.println(list);
	}

	public static LinkedList<String> dfs(HashMap<String, TreeSet<String>> map, HashMap<String,Boolean> visited, String source,LinkedList<String> list) {
		list.add(source);
		if(map.containsKey(source)) {
			TreeSet<String> queue = map.get(source);
			for(String s : queue) {
				if(!visited.get(source+" "+s)) {
					visited.put(source+" "+s,true);
					list = dfs(map, visited, s,list);
				}
				if(source != "BZA") return list;
				list.add("BZA");
			}
		}
		for(Map.Entry<String, Boolean> entry : visited.entrySet()) {
			if(entry.getValue() == false) {
				dfs(map, visited, entry.getKey(), list);
			}
		}
		return list;
	}
}