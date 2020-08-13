/* 02/03/2020
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
There are no duplicates in the list. One of the integers is missing in the list.
Write an efficient code to find the missing integer.

Example :

Input:1 2 4 6 3 7 8
Output: 5

Time Complexity :O(n)
 */
package Elite;
import java.util.*;

class MissingNumber{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int n = arr.length+2;
        int count = (n*(n-1))/2,result =0;
        for(int i=0;i<arr.length;i++){
            result+=arr[i];
        }
        System.out.println(count-result);
    }
}