/* 11/07/2020 - HOME
 * Input Format:
-------------
Line-1 -> List-1 of space seperated N integers, No duplicates allowed
Line-2 -> List-2 of space seperated N integers
Line-3 -> An integer belongs to List-1

Output Format:
--------------
Print a list of integers as result.


Sample Input-1:
---------------
5 7 1 3 6
1 5 0 1 7
5

Sample Output-1:
----------------
[5, 6, 7]

 */
package Elite;
import java.util.*;

public class KillChildren{
    
    public static void dfs(HashMap<Integer,List<Integer>> map,int kill,HashMap<Integer,Boolean> visited){
        visited.put(kill,true);
    	List<Integer> temp = map.get(kill);
        if(temp == null)return;
        for(int num : temp){
            if(!visited.get(num)){
                dfs(map,num,visited);
            }
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String children[] = sc.nextLine().split(" ");
        String parent[] = sc.nextLine().split(" ");
        int kill = sc.nextInt();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        HashMap<Integer,Boolean> visited = new HashMap<>();
        for(int i=0;i<parent.length;i++){
            int num = Integer.parseInt(parent[i]);
            int child = Integer.parseInt(children[i]);
            if(!map.containsKey(num)){
                List<Integer> temp = new LinkedList<>();
                map.put(num,temp);
                visited.put(num,false);
            }
            if(!visited.containsKey(child))visited.put(child, false);
            map.get(num).add(child);
        }
        dfs(map,kill,visited);
        List<Integer> result = new LinkedList<>();
        for(Map.Entry<Integer,Boolean> entry : visited.entrySet()){
            if(entry.getValue()) result.add(entry.getKey());
        }
        Collections.sort(result);
        System.out.println(result);
    }
}
