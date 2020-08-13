/* 23/03/2020 - HOME
 * Shakuni, a self-employed photo frame maker, has started his business. In short time, 
he became popular as the frames were quite good and more importantly the prices were
reasonable. Now that the business is on track, Shakuni, in order to make more money, has
devised a cunning formula for the prices. According to the new formula, in a given transaction,
per customer, the price of a frame shall be equal to 
its current price * (number of frames purchased previously + 1).

Bheem and his friends wanted to purchase some photo frames. After knowing the pricing
formula of Sakuni to maximize the cost of frames, he is looking for someone to help him with
an idea that gives the minimum cost and buy the required number of photo frames for him and
his friends.

Given, the total number of Frames (F), the number of friends (N) and the price list of all 
frames,write a program to find the minimum total cost that 
Bheem must pay to purchase F number of frames from Shakuni.

Sample:
    Input
        3 2
        2 5 6
    Output
        15
    Comments
        The first line 3 2 – Total Frames (F=3) and Friends(N=2)
        Second line 2 5 6 – Prices of Frames
    
    Explanation:
        First person
        o purchases Frame of 5 so its cost is
        (0+1)*5 = 5
        o Purchases Frame of 2 so its cost is
        (1+1)*2 = 4
        
        Second Person
        o Purchases Frame of 6 so its cost is
        (0+1)*6 = 6
        
        Total Cost of Frames = 5 + 4 + 6 = 15
    
Sample 2
    input:
        3 2
        5 6 2
    output:
        15

 */
package Elite;
import java.util.*;
public class BuyingFrames {
	
	// This function returns the minimum value for buying all the frames
	
	private static int minCostCalculation(LinkedList<Integer> prices,int frames,int friends) {
		int minCost = 0;
		
		//Sorting the prices Linked list in reverse order
		Collections.sort(prices, Collections.reverseOrder());
		
		//Using a for loop to run the outer loop that many number of times which are equal to no. of friends and the inside loop
		// increments the value of j by that much to skip so that each friend first buys a max value frame in order and so on...
		
		for(int i=0;i<friends;i++) {
			int k=0;
			for(int j=i;j<prices.size();j+=friends) {
				minCost+=(k+1)*prices.get(j);
				k++;
			}	
		}
		return minCost;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Taking the necessary inputs
		int frames = sc.nextInt();
		int friends = sc.nextInt();
		LinkedList<Integer> prices = new LinkedList<Integer>();
        for(int i=0;i<frames;i++) {
        	prices.add(sc.nextInt());
        }
        
        //Printing the value returned from the function which is calculating the minimum cost
        System.out.println(minCostCalculation(prices,frames,friends));
	}
}