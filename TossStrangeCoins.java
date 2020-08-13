/* ELITE DAY - 104
 * REFERENCE - LEETCODE (Toss Strange Coins)
 */
package Elite;
import java.util.Scanner;

public class TossStrangeCoins{
	public static double probabilityOfHeads(double[] prob, int target) {
        double[] dp = new double[target + 1];
        dp[0] = 1.0;
        for (int i = 0; i < prob.length; ++i)
            for (int k = Math.min(i + 1, target); k >= 0; --k)
                dp[k] = (k > 0 ? dp[k - 1] : 0) * prob[i] + dp[k] * (1 - prob[i]);
        return dp[target];
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		double prob[]=new double[n];
		for(int i=0;i<n;i++)
			prob[i]=sc.nextDouble();
		int target=sc.nextInt();
		
		System.out.println(probabilityOfHeads(prob,target));
	}
}