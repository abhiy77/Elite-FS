/* 14/02/2020
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, 
and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Time Complexity: O(n)

Example 1:
	Input: 1 2 3
	Output: [1, 2, 4]
	Explanation: The array represents the integer 123.

Example 2:
	Input: 4 3 2 1
	Output: [4, 3, 2, 2]
	Explanation: The array represents the integer 4321.

 */
package Elite;
import java.util.*;
public class AddOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] digits = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		for(int i=digits.length-1;i>=0;i--){
	        if(digits[i]+1 == 10 ){
	            digits[i]=0;
	            if(i == 0){
	               int temp[] = new int[digits.length+1];
	               temp[0] = 1;
	               for(int j=0;j<digits.length;j++)
	                    temp[j+1] = digits[j];
	                System.out.println(Arrays.toString(temp));
	            }
	        }
	        else if(digits[i]+1 != 10){
	            digits[i]+=1;
	            System.out.println(Arrays.toString(digits));
	            System.exit(1);
	        } 
	    }
	}
}