/* 14/02/2020
 * /*
 * 
 You are given coins of different denominations and a total amount of money amount. 
 Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: 1 2 5
11
Output: 3 

Explanation: 11 = 5 + 5 + 1

Example 2:

Input: 2
3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.
 */
package Elite;
import java.util.*;

class Coins{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int num = sc.nextInt();
        int output[] = new int[num+1];
        Arrays.fill(output,Integer.MAX_VALUE-1);
        output[0] = 0;
        for(int i=1;i<output.length;i++){
            for(int j=0;j<arr.length;j++){
              if(arr[j] <=i){
                  output[i] = Math.min(output[i],1+output[i-arr[j]]);
              }  
        }
    }
       // System.out.println(Arrays.toString(output));
        System.out.println(output[output.length-1] <= num ? output[output.length-1] : "-1");
    }
}