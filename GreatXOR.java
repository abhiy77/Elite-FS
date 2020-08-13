/* 09/06/2020 - HOME
 * HACKERRANK - THE GREAT XOR
 */
package Elite;
import java.util.*;

public class GreatXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            // your code goes here
            long b = 1;
            long total = 0;
            while(b < x) {
                if((b & x) == 0) {
                    total += b;
                }
                b = b * 2;
            }
            System.out.println(total);
        }
    }
}