/* ELITE DAY - 104
 * REFERENCE - LEETCODE (Minimize Rounding Error To Meet Target)
 */
package Elite;
import java.util.*;

class MeetTarget {
    public static String minimizeError(String[] prices, int target) {
        float res = 0;
        PriorityQueue<Double> diffHeap = new PriorityQueue<>();        
        for (String s : prices) {
            float f = Float.valueOf(s);
            double low = Math.floor(f);
            double high = Math.ceil(f);
            
            if (low != high)
                diffHeap.offer((high-f)-(f-low)); 
            res += f-low; 
            target -= low; 
        }
        
        if (target < 0 || target > diffHeap.size())
            return "-1";
        while (target-- > 0)
            res += diffHeap.poll();
        
		return String.format("%.3f", res);
    }
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String[] prices=sc.nextLine().split(" ");
		int t=sc.nextInt();
		System.out.println(minimizeError(prices,t));
	}
}
