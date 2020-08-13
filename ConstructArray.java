/* 01/06/2020 - HOME
 * HACKERRANK - CONSTRUCT THE ARRAY
 */
package Elite;
import java.util.*;

public class ConstructArray {
    static long countArray(int n, int k, int x) {
        long mod = 1000000007;
        long val1 = 1;
        for (long i=2;i<=n;i++) {
            if (i % 2 == 0) {
                val1 = ((val1 - 1)%mod) * ((k-1)%mod);
            } else {
                val1 = ((val1 + 1)%mod) * ((k-1)%mod);
            }
            val1 = val1 % mod;
        }
        long valRest = n % 2 == 0 ? val1+1 : val1-1;
        if (x==1) {
            return val1;
        }
        return valRest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        long answer = countArray(n, k, x);
        System.out.println(answer);
        in.close();
    }
}