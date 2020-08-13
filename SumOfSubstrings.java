/* 26/05/2020 - HOME
 * Input Format:
    - An integer as a string without leading zeros.

Output Format:
    - A single line which is sum of the substrings.
    
Sample Input:
25
Sample Output:
32

Sample Input:
1234
Sample Output:
1670


 */
package Elite;
import java.util.*;

class SumOfSubstrings{
    public static int sum = 0;
    
    public static void recurse(String num,int i){
        if(i == num.length()) return;
        for(int j = i;j<num.length();j++){
            sum += Integer.parseInt(num.substring(i,j+1));
           // System.out.println(num.substring(i,j+1));   
        }
        recurse(num,i+1);
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        recurse(num,0);
        System.out.println(sum);
    }
}