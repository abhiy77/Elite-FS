/*30/01/2020
 * Given an array nums of n integers where n > 1,  
return an array output such that output[i] is equal 
to the product of all the elements of nums except nums[i].

Example:
	Input:  1 2 3 4
	Output: 24 12 8 6
 * 
 */
package Elite;
import java.util.*;

class ProductOfNumbers{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int str[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer :: parseInt).toArray();
        int arr1[] = new int[str.length];
        int arr2[] = new int[str.length];
        arr1[0] = 1;  arr2[arr2.length-1] = 1;
        for(int i=1;i<arr1.length;i++){
            arr1[i] = str[i-1] * arr1[i-1];
            arr2[str.length -1 - i] = arr2[str.length - i] * str[str.length -i];
        }
        for(int i=0;i<str.length;i++){
            System.out.println((arr1[i] * arr2[i] )+ " ");
        }
    }
}