/* 18/02/2020
 * Given a positive integer n, 
find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) 
which sum to n.

Example 1:
    Input: 12
    Output: 3 
    Explanation: 12 = 4 + 4 + 4.

Example 2:
    Input: 13
    Output: 2
    Explanation: 13 = 4 + 9.
 */
package Elite;
import java.util.*;

class LeastNumberOfPerfectSquareNumbers{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while(num*num <= n){
            list.add(num*num);
            num++;
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<list.size();j++){
              if(list.get(j) <=i){
                  dp[i] = Math.min(dp[i],1+dp[i-list.get(j)]);
              }  
        }
    }
      //  System.out.println(Arrays.toString(dp));
        System.out.println(dp[dp.length-1]);
    }
}