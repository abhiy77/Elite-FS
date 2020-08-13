/* 20/03/2020 - HOME
 * Alex plans on visiting the museum and is at the counter to purchase tickets to get in. 
Tickets are sold only one at a time. If a visitor needs more than one ticket, 
he/she has to pass through the queue again to buy each one.

Given the number of visitors and the number of tickets each visitor needs, 
determine the amount of time Alex requires to buy the number needed. 
Alex's place in the queue will be given. Each transaction takes 1 unit of time. and 
the time taken to go to the back of the line can be ignored.

Example 1:
	Input:1 2 5		
			 1
	Output: 4

	Explanation:
		There are 3 buyers needing 1, 2 and 5 tickets each. Alex is at index 1 and need 2 tickets. 
        index-0     index-1      index-2   time      resultant list
            1           1           1       3        ==> 0 1 2
            NA          1           1       2        ==> 0 0 1
        
        at this time person at index 1 get all his/her tickets. 
        needed a total of 4 units of time to get all his/her tickets
            
 * 
 */
package Elite;
import java.util.*;
import java.util.stream.Collectors;
public class StandingInLineAndPurchasingTickets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
		int alexPos = sc.nextInt();
		int remaining = list.get(alexPos),currPos= alexPos;
		int count = 0;
		while(remaining > 0) {
			//System.out.println(list + " " + (count+1) + " " + remaining);
			count++;
			int num = list.remove(0);
			num-=1;
			if(currPos == 0) {
				currPos = list.size();remaining-=1;
			}
			else currPos--;
			if(num>0)list.add(num);
		}
		System.out.println(count);
	}
}