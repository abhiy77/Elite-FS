/* 17/01/2020
 
Given a non-negative integer, Return its encoding number as string.

The encoding is done by converting the integer to a string using 
a secret function that you should deduce from the following table:
-----------
| n | f(n)|
|---------|
| 0 |     |
| 1 | 0   |
| 2 | 1   |
| 3 | 00  |
| 4 | 01  |
| 5 | 10  |
| 6 | 11  |
| 7 | 000 |
-----------

Example 1:
	Input=	23
	Output= 1000

Example 2:
	Input=	107
	Output= 101100

*/

package Elite;
import java.util.*;
public class EncodingNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int val =(int)(Math.log(num+1)/Math.log(2));

	    int n = 0;
	    for(int i=0;i<val;i++) {
	    	n+=Math.pow(2, i);
	    }
	    String s = "";
	    for(int i=0;i<(val-Integer.toBinaryString(num-n).length());i++){
	       s=s.concat("0");
	    }
	    System.out.println(s+Integer.toBinaryString(num-n));
	}
}
