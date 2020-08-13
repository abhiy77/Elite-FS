/* 03/02/2020
 * Thanos has arrived on a planet to find the infinity stones. 
The planet is divided into different territories. 
He has some loyal supporters on the planet called ‘Zakos’ 
who control a territory under them. Thanos gives C[i] of gold 
to i-th Zakos in exchange of work done. 

Zakos are friends with other Zakos and they share information 
with each other for free.

Thanos will destroy half the planet when every Zakos knows about him. 
What is the minimum number of gold Thanos will have to spend so that 
entire planet knows about him.

Input Format
------------
The first line contains two integer numbers N and M
— the number of Zakos on the planet and the number of pairs of Zakos friends.

The second line contains N space separated integers C[i]
— the amount of gold i-th Zakos receives for the work he does.

Then m lines follow, each containing a pair of numbers (X[i],Y[i]) 
which represent that Zakos X[i] and Y[i] are friends. 
It is guaranteed that each pair is listed at most once.

Output Format
-------------
Print one number — the minimum amount of gold Thanos has 
to spend in order to find all infinity stones.

Sample Input:
5 2
2 5 3 4 8
1 4
4 5

Sample Output:
10

Explanation:

Here the best decision is to pay the first Zakos (2)
(he will spread the news to fourth character, and the fourth one will spread it to fifth).
 Also Thanos has to pay the second(5) and the third Zakos(3), 
 so they know the news and spread it in their territory.
 
 the minimum amount of gold Thanos has to spend in order to find all infinity stones is 10(2+5+3).
 
 
 */
package Elite;
import java.util.*;

class ThanosAndZakos{
    
    public static int total=0,curr=Integer.MAX_VALUE;
    public static int recurse(LinkedList<LinkedList<Integer>> adjList,int[] cost,boolean[] visited,int i){
        if(visited[i] == false){
            visited[i] = true;
            if(curr > cost[i]) curr = cost[i];
            LinkedList<Integer> list = adjList.get(i);
            for(int node : list){
                if(!visited[node]){
                    curr = recurse(adjList,cost,visited,node);
                }
            }
        }
        return curr;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int friends = sc.nextInt();
        int pairs = sc.nextInt();
        int cost[] = new int[friends+1];
        for(int i=1;i<=friends;i++){
            cost[i] = sc.nextInt();
        }
        LinkedList<LinkedList<Integer>> adjList = new LinkedList<>();
        adjList.add(new LinkedList<Integer>());
        for(int i=1;i<=friends;i++){
            LinkedList<Integer> temp = new LinkedList<>();
            adjList.add(temp);
        }
        boolean[] visited = new boolean[friends+1];
        for(int i=0;i<pairs;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }
        for(int i=1;i<=friends;i++){
            if(!visited[i]) {
                curr = Integer.MAX_VALUE;
                recurse(adjList,cost,visited,i);
                total+=curr;
            }
        }
        System.out.println(total);
    }
}