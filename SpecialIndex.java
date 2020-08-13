/* 20/02/2020
 * Kishore interested in maths, 
He has an array of integers. He wanted to find out 'special index' position in that array.

He defines, Special index as, sum of the integers on left side of the index should be equal to 
sum of the integers on right side of the index

If no such index exists, we should return -1. 
If there are multiple special indexes, you should return the left-most special index.

Example 1:
    Input=  1 7 3 6 5 6
    Output= 3
    Explanation: 
        The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to 
        the sum of numbers to the right of index 3.
        Also, 3 is the first index where this occurs.
     
Example 2:
    Input: 1 2 3
    Output: -1
    Explanation: 
        There is no index that satisfies the conditions in the problem statement.
     

Note:
Array may contain negative numbers also.

 */
package Elite;
import java.util.*;

class SpecialIndex{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int input[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int left = 0,right=0,n=input.length;
        for(int i=1;i<n;i++)right+=input[i]; 
        for(int i=1;i<n;i++){
            left+=input[i-1];
            right-=input[i];
            if(left == right){
                System.out.println(i);
                System.exit(1);
            }
        }
        System.out.println(-1);
    }
}