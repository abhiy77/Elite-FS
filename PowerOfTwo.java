/* 29/05/2020 - HOME
 * Laya and Riya have developed a numbers game. 
They pick a number and check to see if it is a power of 2. 
    - If it is, they divide it by 2. 
    - If not, they reduce it by the next lower number which is a power of 2.
    
Whoever reduces the number to 1 wins the game. Laya always starts.

Given an initial value, determine who wins the game.

For example, let the initial value N=132. It's Laya's turn so she first determines 
that is not a power of 2. The next lower power of is 128, so she subtracts that from 132
and passes 4 to Riya. 4 is a power of 2, so Riya divides it by 2 and passes 2 to Laya.
Likewise, 2 is a power so she divides it by 2 and reaches 1. Laya wins the game.

Input Format:
-------------
    - Line contains an integer N, the initial value for the game.

Output Format:
    - Print the winner's name on a new line in the form Laya or Riya.
    
Sample Input:
6
Sample Output:
Riya

Explanation:
6 is not a power of 2 so Louise reduces it by the largest power of 2 less than 6:6-4=2 .
2 is a power of 2 so Riya divides by 2 to get and wins the game.
 */
package Elite;
import java.util.*;

class PowerOfTwo{
    
    public static LinkedList<Integer> getPowersOfTwo(int n){
        LinkedList<Integer> list = new LinkedList<>();
        if(n < 2) return list;
        list.add(2);
        int count = 2;
        int num = 0;
        while((num = (int)Math.pow(2,count)) <= n){
            list.add(num);
            count++;
        }
        return list;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean laya = true;
        LinkedList<Integer> list = getPowersOfTwo(n);
        while(n > 1){
            if(list.contains(n)){
                n/=2;
            }
            else{
                while(n < list.peekLast()){
                    list.pollLast();
                }
                n -= list.pollLast();
            }
            laya = !laya;
        }
        System.out.println(laya ? "Riya" : "Laya");
    }
}