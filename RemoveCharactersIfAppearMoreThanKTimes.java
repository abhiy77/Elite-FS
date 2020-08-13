/* 11/05/2020 - HOME
 * Input Format:
    - First line contains 2 integers N and K.
    - Second line contains the string S, comprising of only lowercase alphabets.

Output Format:
    - Print the required string.

Sample input :
10 3
abcaacbccb

Sample output :
abcaacbcb
 */
package Elite;
import java.util.*;

public class RemoveCharactersIfAppearMoreThanKTimes{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)){
               map.put(c,1);
               System.out.print(c);
            } 
            else if(map.get(c) < k){
                map.put(c,map.get(c) + 1);
                System.out.print(c);
            } 
            else continue;
        }
    }
}