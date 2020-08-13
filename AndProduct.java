/* 03/06/2020 - HOME
 * HACKERRANK - AND PRODUCT
 */
package Elite;
import java.util.*;

class AndProduct {
   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       solve(in);
       in.close();
   }

   public static void solve(Scanner in){
       long a,b,count,ans,athbit,bthBit;
		a = in.nextLong();
		b = in.nextLong();
		ans = 0L;
		int bits = (int)(Math.log(b)/Math.log(2));
		System.out.println(bits);
		for (int j = 0; j <= bits; j++) {
			count = 1L << j;
			System.out.println(count);
			athbit = a & count;
			bthBit = b & count;
			System.out.println(athbit + " " + bthBit);
			if(athbit != 0 && bthBit != 0 && (b-a) <=count){
				ans = ans | count;
			}
		}
		System.out.println(ans);
   }
}