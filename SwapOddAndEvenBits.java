/* 03/04/2020 - HOME
 * 
 * 
Write a program to swap odd and even bits in an integer with as few instructions as
possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc)

Sample Input: 
    23
Output: 
    43

Explanation:
    Binary Representation of 23 is  = 0 0 0 1 0 1 1 1
    Binary Representation of 43 is  = 0 0 1 0 1 0 1 1
    Before swap (0 0) (0 1) (0 1) (1 1)
    After swap  (0 0) (1 0) (1 0) (1 1) is equal to 43.

Sample Input: 
    256
Output: 
    512

Explanation:
    Binary Representation of 256 is  = 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0
    Binary Representation of 512 is  = 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0


 * 
 */
package Elite;
import java.util.*;

class SwapOddAndEvenBits{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = Integer.toBinaryString(num);
        StringBuffer temp = new StringBuffer();
        int x = str.length()/8;
        for(int i=0;i<8*(x+2)-str.length();i++) {
        	temp.append("0");
        }
        str = temp.toString() + str;
        temp.delete(0, temp.length());
        for(int i = 1;i<str.length();i+=2) {
        	temp.append(str.charAt(i)+""+str.charAt(i-1));
        }
        System.out.println(Integer.parseInt(temp.toString(),2));
    }
}