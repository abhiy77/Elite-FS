/* 29/05/2020 - HOME
 * 
 * HACKER RANK - ALICE BOB SILLY GAME
 * 
 * Two players playing a game with the following rules:
* The game starts with an integer, N, that's used to build a set of N distinct 
  integers in the inclusive range from 1 to N.
* RAM always plays first, and the two players move in alternating turns.
* During each move, the current player chooses a prime number, P, from set. 
  The player then removes P and all of its multiples from set.
* The player who is unable to make a move loses the game.

RAM and NAG are the playes, if RAM wins print "RAM", otherwise print "NAG".

Note: Each player always plays optimally, meaning they will not make a move that 
causes them to lose the game if some better, winning move exists.

Input Format:
-------------
The first line contains an integer, N, denote the set range.

Output Format:
--------------
Print the name of the winner on a new line. 

Sample Input-1:
1
Sample Output-1:
NAG

Sample Input-2
5
Sample Output-2:
RAM
 */
package Elite;
import java.util.*;

public class RemovingPrimeNumberGame {
    public static boolean[] bS(int n){
         
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int factor = 2; factor*factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        boolean[] s  = bS(100000);
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int count =0;
            for(int i = n;i>0;i--){
                if(s[i])count++;
            }
            if(count%2==0){
                System.out.println("NAG");
            }
            else{
                System.out.println("RAM");                
            }
        }
    }
}