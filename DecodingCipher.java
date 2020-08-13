/* 28/05/2020 - HOME
 * REFERENCE - (Cipher - HACKERRANK )
 * 
Jack and Daniel are friends. They want to encrypt their conversations so that they can save themselves from interception
by a detective agency so they invent a new cipher.
Every message is encoded to its binary representation. Then it is written down times, shifted by 0,1,2,... k-1 bits.
Each of the columns is XORed together to get the final encoded string.


 * 
*******Testcases*******
case =1
input =6 2
1110001
output =101111

case =2
input =7 4
1110100110
output =1001010

case =3
input =17 3
1010111011101000101
output =11100101001110111

case =4
input =185 48
0101001101011000110011010101000111011011111110001001110101111011010001000110110010100010101101100000001001101100110010111001010111010101010110011011100101000100000011111100001010011010111010001000101011110100101100101001010111001001
output =01111010111101001010101111111001001101100000010010101001001100100100110110100011110001011110100110101010011010001110001111111100111110100001110011001111100011101110101111011111001011011

case =5
input =7 4
1001101011
output =1101101

case =6
input =14 3
1001110100100110
output =11001010111010

case =7
input =18 4
101000101011100101010
output =111111000010011110

case =8
input =20 3
1101010101010101010110
output =10101010101010101010

*/
package Elite;
import java.util.Scanner;

public class DecodingCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        char[] s = scanner.nextLine().toCharArray();
        char[] b = new char[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                sum ^= (b[i - k] - '0');
            }
            b[i] = (char) ('0' + (sum ^ (s[i] - '0')));
            sum ^= (b[i] - '0');
        }
        System.out.println(b);
        scanner.close();
    }
}