/* 05/05/2020 - HOME
 * 
Input Format:
    - An array of integers that are non-negative integers. 

Output Format:
    - print true, if player-1 is winner
      Otherwise, print false 

Sample Input-1: 
1 5 2

Sample Output-1: 
false


Sample Input-2: 
1 5 233 7

Sample Output-2: 
true

 */
package Elite;
import java.util.*;
import java.util.stream.Collectors;
public class TwoPlayerIntegerGame {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean chance = true;
		int player1 =0,player2 = 0;
	    List<Integer> list = Arrays.asList(sc.nextLine().split(" ")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
	    while(list.size() > 0) {
	    	if(chance) {
	    		if(list.size() == 1) {
	    			player1 += list.remove(0);
	    		}
	    		else if(list.size() == 2) {
	    			if(list.get(0) > list.get(1)) player1 += list.remove(0);
	    			else player1 += list.remove(1);
	    		}
	    		else {
	    			int first = list.get(0) - Math.max(list.get(1), list.get(list.size()-1));
	    			int second = list.get(list.size()-1) - Math.max(list.get(0), list.get(list.size() - 2));
	    			if(first > second) {
	    				player1 += list.remove(0);
	    			}
	    			else {
	    				player1 += list.remove(list.size() - 1);
	    			}
	    		}
	    		chance = false;
	    	}
	    	else {
	    		if(list.size() == 1) {
	    			player2 += list.remove(0);
	    		}
	    		else if(list.size() == 2) {
	    			if(list.get(0) > list.get(1)) player2 += list.remove(0);
	    			else player2 += list.remove(1);
	    		}
	    		else {
	    			int first = list.get(0) - Math.max(list.get(1), list.get(list.size()-1));
	    			int second = list.get(list.size()-1) - Math.max(list.get(0), list.get(list.size() - 2));
	    			if(first > second) {
	    				player2 += list.remove(0);
	    			}
	    			else {
	    				player2 += list.remove(list.size() - 1);
	    			}
	    		}
	    		chance = true;
	    	}
	    }
	    if(player1 > player2) System.out.println(true);
	    else System.out.println(false);
	}
}