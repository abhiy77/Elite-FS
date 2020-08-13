/* 29/05/2020 - HOME
 * We define a modified Fibonacci sequence using the following definition:
Given terms T[i] and T[i+1]. term T[i+2] is computed using the following relation:
    T[i+2] = T[i] + pow(T[i+1],2).
    
For example, if term and t1=0, term t2=1, term t3= 0+pow(1,2)=1, 
    term t4 = 1 + pow(1,2) =2, term t5= 1 + pow(2,2) =5 and  so on.
    
Given three integers t1, t2 and n, compute and print term tn of a modified Fibonacci sequence.

Note: The value of tn may exceed the range of a 64-bit integer.  

Input Format:
    - Three space-separated integers describing the respective values of t1, t2 and n.
    
Output Format:
    - Print a single integer denoting the value of term tn.

Sample Input:
    0 1 5
Sample Output:
    5
    
For Explanation look above example.
 */
package Elite;
import java.util.*;
import java.math.*;

public class ModifiedFibonacciSequence {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger first = new BigInteger(scan.next());
        BigInteger second = new BigInteger(scan.next());
        int n = scan.nextInt();
        BigInteger third = new BigInteger("0");
        
        for(int i = 2; i < n; i++) {
            third = first.add(second.multiply(second));
            first = second;
            second = third;
        }
        scan.close();
        System.out.println(third);
    }
}