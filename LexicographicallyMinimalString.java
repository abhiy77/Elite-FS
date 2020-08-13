/* 07/05/2020
 * 
Input Format
    - The first line contains string a
    - The second line contains string b.

Output Format:
    - The lexicographically minimal string

Sample Input
JACK
DANIEL

Sample Output
DAJACKNIEL


Sample Input:
ABACABA
ABACABA

Sample Output:
AABABACABACABA
 */
package Elite;
import java.util.*;

public class LexicographicallyMinimalString{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int i=0,j=0;
        while(i < a.length() && j < b.length()){
            int x = a.charAt(i) - b.charAt(j);
            if(x>0){
                System.out.print(b.charAt(j++));
            }
            else if(x < 0){
                System.out.print(a.charAt(i++));
            }
            else{
                int q = i+1,y = j+1;
                while(q < a.length() && y < b.length() && a.charAt(q) == b.charAt(y)){
                    q++; y++;
                }
                if(q == a.length() || a.charAt(q) < b.charAt(y)){
                    System.out.print(a.charAt(i++));
                }
                else if(a.charAt(q) > b.charAt(y)){
                    System.out.print(b.charAt(j++));
                }
            }
        }
        while(i < a.length()){
            System.out.print(a.charAt(i++));
        }
        while(j < b.length()){
            System.out.print(b.charAt(j++));
        }
    }
}