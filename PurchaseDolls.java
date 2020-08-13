/* ELITE DAY - 109

You have started online shopping to purchase dolls.
Initially you have M amount in your wallet and few coupons.

You can purchase the dolls using the wallet or Coupons, 
each Coupon can be used at most once, has a value coupon[i].

There are two ways to reedem your coupon(s).
1. If you have at least coupon[i] amount in your wallet, you can purchase 1 doll, 
    using money from wallet and coupon get redeemed.
	
2. If you have at least 1 doll, you can redeem the coupon and 
    add the amount to wallet, you will lost 1 doll.

Finally, print the highest number of dolls you can have after using any number of coupons.

Note: Initially you will have 0 dolls.

Input Format:
----------------
Line-1: Two integers M and N, money in wallet and number of coupons
Line-2: N space seperated integers, coupon[i].

Output Format:
------------------
Print an integer as result.


Sample Input-1:
--------------------
150 2
100 200

Sample Output-1:
---------------------
1


Sample Input-2:
--------------------
200 4
100 200 300 400

Sample Output-2:
---------------------
2

Explanation:
---------------
Initially wallet is 200 and dolls=0 
step-1- coupon[0]=100, <= wallet. so way-1, purchase the doll. wallet becomes=100 dolls=1
step-2- coupon[3]=400, > wallet, num of dolls=1. so way-2, add coupon amount to wallet. wallet becomes=500 dolls=0
step-3- coupon[1]=200, <=wallet. so way-1, purchase the doll. wallet becomes=300 dolls=1
step-3- coupon[2]=300, <=wallet. so way-1, purchase the doll. wallet becomes=0 dolls=2

*/
package Elite;
import java.util.*;

public class PurchaseDolls
{
	public static int numOfDolls(int[] coupons, int M) {
        Arrays.sort(coupons);
        int res = 0, points = 0, i = 0, j = coupons.length - 1;
        while (i <= j) {
            if (M >= coupons[i]) {
                M -= coupons[i++];
                res = Math.max(res, ++points);
            } else if (points > 0) {
                points--;
                M += coupons[j--];
            } else {
                break;
            }
        }
        return res;
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int coupons[]=new int[n];
		for(int i=0;i<n;i++)
			coupons[i]=sc.nextInt();
		System.out.println(numOfDolls(coupons, m));
	}
}