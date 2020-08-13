/* 21/01/2020
 * Given N technologies, labelled from 1 to N.

We are given relations[i] = [A, B], representing a prerequisite relationship between technology A and technology B: 
technology A has to be Completed before learning technology B.

In one month you can learn any number of technologies as long as you have completed all the 
prerequisites for learning that technology.

Return the minimum number of months needed to learn all technologies.  
If there is no way to learn all the technologies, return -1.


Input Format:   an integerer n, in First line indicates no of technologies
                an integer k, second line  no.of. prerequisite relations.
                next 'k' lines indicates prerequisite relation of technology
Output Format:  no of months required to finish all technologies if possible, otherwise -1.
Example 1:

Input=  3       //no of technologies
        2       //no.of prerequisite relations
        1 3     //to learn technology-3 prerequisite is technology-1
        2 3     //to learn technology-3 prerequisite is technology-2
Output= 2
Explanation: 
In the first month, technology 1 and 2 are completed. In the second month, technology 3 is completed.


Example 2:

Input=  3       //no of technologies
        3       //no.of prerequisite relations
        1 2     //to learn technology-2 prerequisite is technology-1
        2 3     //to learn technology-3 prerequisite is technology-2
        3 1     //to learn technology-1 prerequisite is technology-3
Output= -1
Explanation: 
No technology can be learned because they depend on each other.
 */
package Elite;

import java.util.*;

class TopologicalSortTechnologies{
    
    public static Queue<Integer> findZeroRank(int[] rank,Queue<Integer> queue){
        for(int i=1;i<rank.length;i++){
            if(rank[i] == 0) queue.add(i);
        }
        return queue;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int tech = sc.nextInt();
        int connections = sc.nextInt(),months =1;
        LinkedList<LinkedList<Integer>>arr = new LinkedList<>();
        for(int i=0;i<=tech;i++){
            arr.add(new LinkedList<Integer>());
        }
        int[] rank = new int[tech+1];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<connections;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.get(x).add(y);
            rank[y]++;            
        }
        if(findZeroRank(rank,queue).isEmpty()) {
        	System.out.println(-1);
        	System.exit(1);
        }
        
    	int x = queue.size();
        while(!queue.isEmpty()){
            if(x == 0) {x = queue.size(); months++;}
            int element = queue.poll();
            for(int i : arr.get(element)){
                rank[i]--;
                if(rank[i] == 0){
                    queue.add(i);
                }
            }
            x--;
        }
        System.out.println(months);
    }
}