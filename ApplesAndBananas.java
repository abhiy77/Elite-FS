 /* 21/01/2020
 * 
 You are playing the following Apples and Bananass game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "Apples") and how many digits match the secret number but locate in the wrong position (called "Bananass"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the Apples and B to indicate the Bananass. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 Apple and 3 Bananas. The Apple is 8, the Bananas are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a Apple, the 2nd or 3rd 1 is a Bananas.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.



 */

package Elite;
import java.util.*;

class ApplesAndBananas{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        String secret = sc.nextLine();
        String guess = sc.nextLine();
        int a =0,b = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<secret.length();i++){
            char x = secret.charAt(i);
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }
            else{
                map.put(x,1);
            }
        }
        
        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i) == guess.charAt(i)){
                a++;
                map.put(secret.charAt(i),map.get(secret.charAt(i))-1);
            }
            else if(map.containsKey(guess.charAt(i))){
                 char x = guess.charAt(i);
                if(map.get(x) > 0){
                    map.put(x,map.get(x)-1);
                    b++;
                }
            }
        }
        System.out.println(a+"A"+b+"B");
    }
}