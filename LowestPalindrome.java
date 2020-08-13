package Elite;
/* 28/05/2020 - HOME
*******Testcases*******
case =1
input =6 2
092282
output =082280

case =2
input =9 4
123456789
output =123454321

case =3
input =4 3
1234
output =0220

case =4
input =5 2
13456
output =13431

case =5
input =4 1
0110
output =-1

case =6
input =4 1
3943
output =3443

case =7
input =4 4
3943
output =0000

case =8
input =6 3
092282
output =002200

*/
import java.util.Scanner;

public class LowestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] c = sc.next().toCharArray();
        boolean[] ch = new boolean[n];
        for (int i = 0; i < n/2; ++i) {
            if (c[i] != c[n - i - 1]) {
                c[i] = c[n - i - 1] = (char)Math.min(c[i], c[n - i - 1]);
                ch[i] = true;
                --k;
            }
        }
        if (k < 0) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < n/2; ++i) {
            if (c[i] != '0') {
                if (ch[i] && k > 0) {
                    c[i] = c[n - i - 1] = '0';
                    --k;
                }
                if (!ch[i] && k > 1) {
                    c[i] = c[n - i - 1] = '0';
                    k -= 2;
                }
            }
        }
        if (n % 2 == 1 && k > 0) {
            c[n/2] = '0';
        }
        System.out.println(new String(c));
    }
}