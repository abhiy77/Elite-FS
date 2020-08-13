/* 27/03/2020 - HOME
 * Andrea and Maria each have a deck of numbered cards in a pile face down. 
They play a game where they each alternately discard and flip the cards on the pile 
from top to bottom. 

At the beginning of the game, someone will call out “Even” or “Odd”. 
The first move depends on which is called. 
If “Even” is called, the players top cards are flipped so they can see the face value. 
If instead “Odd” is called, the top card is removed from each deck and discarded, 
then each flips her next card. 

Andrea subtracts the value of Maria’s card from her own and adds the result to her score. 
Likewise, Maria subtracts the value of Andrea’s card from her own and 
adds the result to her score. 

From this point forward, each alternately discards then flips a card. 
Each time two cards are flipped, the players scores are computed as before. 
Once all the cards have been played, whoever has the most points wins. 

As an example, Maria’s cards, face down are [3,5,6] and Andrea’s are [4,5,7]. 
After calling “Even” at random, they each compare their first cards. 
Maria’s points are 3-4 =-1, and Andrea’s are 4-3=1. 
They discard the 5’s and turn over their third cards. 
Maria receives 6-7=-1 point and Andrea receives 7-6=1 point. Maria’s score is -2, 
Andrea’s is +2 so Andrea wins. 

You must determine the name of the winner if there is one, otherwise they tie. 
Return Andrea, Maria or Tie. 

Input Format:
-------------
number of andrea cards
read all andrea cards
number of maria cards
read all maria cards
read the string either Odd or Even

Output Format:
--------------
Print a string denoting the outcome of the game. 
Print "Andrea" if Andrea won, or Print "Maria" if Maria won. 
If their scores are tied, Print "Tie" instead. 

Sample-1:
Input:
    3
    1 2 3
    3
    2 1 3
    Even

Output:
    Maria

Explanation:
    In this game, andrea =[1,2,3] and maris=[2,1,3]. Because s=Even, 
    the only cards flipped are at indexes 0 and 2. 
    
    When i=0, Andrea gets a[0]-m[0]=1-2 =-1 point and Maria gets m[0]-a[0]=2-1 = 1 point.
    When i=2, Andrea gets a[2]-m[2]=3-3=0 points and Maria gets m[2]-a[2]=3-3 = 0 points. 
    
    At the end of play, Andrea’s cumulative score is -1 and Maria’s is 1 so Maria wins. 


Sample-2:
Input:
    3
    3 15 6
    3
    3 5 6
    Even
Output:
    Tie
    
 */
package Elite;
import java.util.*;
public class MariaAndAndreaCardGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int andreaCards = sc.nextInt();
		sc.nextLine();
		int arr1[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int mariaCards = sc.nextInt();
		sc.nextLine();
		int arr2[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		String turn = sc.nextLine();
		int i = (turn.equals("Even") ? 0 : 1);
		int mariaScore = 0 , andreaScore = 0;
		while(i < arr1.length) {
				andreaScore += arr1[i]-arr2[i];
				mariaScore  += arr2[i]-arr1[i];
				i+=2;
		}
		if(mariaScore == andreaScore) System.out.println("Tie");
		else if(mariaScore > andreaScore)System.out.println("Maria");
		else System.out.println("Andrea");
	}
}