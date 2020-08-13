/* 02/06/2020 - HOME
 * Input Format:
-------------
Line-1 -> contains the string S.
Line-2 -> contains an integer q.
Next q lines -> contains two space-separated integers b,e for each query.

Output Format:
--------------
For each query, print an integer denoting the answer

Sample Input:
-------------
abcbc
3
1 4
1 3
2 4
Sample Output:
--------------
2
3
1

 */
package Elite;
import java.util.*;
import java.math.*;

class NumberOfMaxPalindromicStrings{
    
    public static BigDecimal factorial(BigDecimal b){
    	//System.out.println(b.toString());
    	int x = b.intValue();
    	BigDecimal bd = new BigDecimal("1");
        for(int i=2;i<=x;i++){
            bd = bd.multiply(BigDecimal.valueOf(i));
        }
        return bd;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int queries = sc.nextInt();
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<queries;i++){
            String temp = str.substring(sc.nextInt()-1,sc.nextInt());
            int[] arr = new int[26];
            for(int j=0;j<temp.length();j++){
            	arr[temp.charAt(j) - 'a']++;
            }
            boolean flag = false;
            int count = 0,odd = 0;
            BigDecimal b = new BigDecimal("1");
            for(int j=0;j<26;j++){
            	if(arr[j] == 0) continue;
                if(arr[j] % 2 != 0){
                    flag = true;
                    odd++;
                    if(arr[j] > 1){
                        int val = (arr[j] - 1);
                        count += val;
                        b = b.divide(factorial(BigDecimal.valueOf(val/2)));
                    }
                }
                else if(arr[j] % 2 == 0){
                    count += arr[j];
                    if(arr[j]/2 > 1) {
                    	b = b.divide(factorial(BigDecimal.valueOf(arr[j]/2)));
                    }
                }
            }
            odd--;
            if(flag) count += 1;
            b = b.multiply(factorial(BigDecimal.valueOf(count/2)));
            if(odd > 0){
                b = b.add(BigDecimal.valueOf(b.intValue()*odd));
            }
            System.out.println(b.intValue()); 
        }
    }
}