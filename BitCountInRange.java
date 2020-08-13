/* 03/02/2020
 * Given two positive integer number start,end.(start <= end)
For every numbers i in the range start <= i <= end 
calculate the number of 1's in their binary representation 
and return them as an array.

Example 1:
Input: 0 2
Output: 0 1 1

Example 2:
Input:3 7
Output: 2 1 2 2 3

NOTE:
Do not use bitCount() or other default methods.

can you get the solution with linear time O(n)?
 */
package Elite;
import java.util.*;

class BitCountInRange{
    
    public static int countBits(int num){
        int count = 0;
        if(num == 0) return count;
        
        while(num > 0){
            int ans = num & 1;
            if(ans == 1) count++;
            num >>=1;
        }
       return count; 
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        for(int i=start;i<=end;i++){
            System.out.print(countBits(i)+" ");
        }
    }
}