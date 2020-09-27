/* 24/09/2020 - (ELITE DAY - 125)
Thomas constructing a Tree of N nodes, nodes labelled as 0, 1, 2, .. ,n-1.
He is given a list of n-1 edges[], where edge[i]=[v1, v2], is an undirected edge
between v1 and v2.

He can construct the tree by selecting any node as root node.
You task is to find out the trees with the  smallest height , among all the trees.
Print the root nodes of all the smallest height trees in ascending order.

NOTE: A Tree,is a connected graph without simple cycles.

Input Format:
-------------
Line-1: An integer N, number of nodes.
Next N-1 lines: Tewo integers, represent an edge.

Output Format:
--------------
Print the list of root nodes of Smallest Height Trees.
In ascending order

Sample Input-1:
---------------
4
0 1
2 1
1 3

Sample Output-1:
----------------
[1]

Explanation:
-------------
Tree Combinations are.

		0						1			
		|					   / | \
	   1					 0  2  3
	 /	  \
	2     3
	
		2						3			
		|					    |
	   1					   1
	 /	  \					 /   \
	0    3 				0    2


Sample Input-1:
---------------
6
3 0
1 3
3 2
4 3
5 4

Sample Output-1:
----------------
[3, 4]

*/
package Elite;
import java.util.*;

public class MinimumHeightTrees {


//A more elegant solution but returning root node of only one sub tree. 
		public List<Integer> findMinHeightTrees(int n, int[][] edges) {
			if (n == 0) return new ArrayList<>();
			else if (n == 1) {
				List<Integer> ret = new ArrayList<>();
				ret.add(0);
				return ret;
			}
			List<Integer>[] lists = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				lists[i] = new ArrayList<>();
			}
			for (int i = 0; i < edges.length; i++) {
				int v1 = edges[i][0];
				int v2 = edges[i][1];
				lists[v1].add(v2);
				lists[v2].add(v1);
			}
			List<Integer> leaves = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (lists[i].size() == 1) {
					leaves.add(i);
				}
			}
			int count = n;
			while (count > 2) {
				int size = leaves.size();
				count -= size;
				List<Integer> newLeaves = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					int leaf = leaves.get(i);
					for (int j = 0; j < lists[leaf].size(); j++) {
						int toRemove = lists[leaf].get(j);
						lists[toRemove].remove(Integer.valueOf(leaf));
						if (lists[toRemove].size() == 1)
							newLeaves.add(toRemove);
					}
				}
				leaves = newLeaves;
			}
			return leaves;
		}
//
//    int diameter;
//    int nodeIndex;
//    List<Integer> res;
//    
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//            
//        Map<Integer, List<Integer>> tree = new HashMap<>();
//        tree.put(0, new ArrayList<>());
//        for(int i = 1; i < n; i++)
//            tree.put(i, new ArrayList<>());
//        for(int[] x: edges) {
//            tree.get(x[0])
//                .add(x[1]);
//            tree.get(x[1])
//                .add(x[0]);
//        }
//        diameter = -1;
//        nodeIndex = 0;
//        
//        dfs(tree, 0, 0, new HashSet<>(), new ArrayList<>());
//        
//        diameter = -1;
//        dfs(tree, nodeIndex, 0, new HashSet<>(), new ArrayList<>());
//        
//        List<Integer> ans = new ArrayList<>();
//        ans.add(res.get(diameter / 2));
//        if(diameter % 2 == 1)
//            ans.add(res.get(diameter / 2 + diameter % 2));
//        
//        return ans;
//    }
    
//    public void dfs(Map<Integer, List<Integer>> tree, int node ,int level, Set<Integer> visited, List<Integer> ans) {
//        visited.add(node);
//        ans.add(node);
//        
//        if(level > diameter){
//            diameter = level;
//            nodeIndex = node; 
//            res = ans;
//        }
//        
//        for(int x : tree.get(node)) {
//            if(!visited.contains(x))
//                dfs(tree, x, level + 1, visited, new ArrayList<>(ans));
//        }
//    }
    

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int edges[][]=new int[n][2];
		for(int i=0;i<n-1;i++){
			edges[i][0]=sc.nextInt();
			edges[i][1]=sc.nextInt();
		}
		List<Integer> result=new MinimumHeightTrees().findMinHeightTrees(n,edges);
		Collections.sort(result);
		System.out.println(result);		
	}
}