/* 24/01/2020
 * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.

Example 1:
    Input: 1 2 3 1
    Output: true

Example 2:

Input: 1 2 3 4
Output: false
Example 3:

Input: 1 1 1 3 3 4 3 2 4 2
Output: true
 
NOTE: Time complexity Should be O(nlogn) or O(n)
 */
package Elite;
import java.util.*;

public class FindDuplicates{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input[] = sc.nextLine().split(" ");
        int temp[] = Arrays.asList(input).stream().mapToInt(Integer :: parseInt).toArray();
        Integer arr[] = Arrays.stream(temp).boxed().toArray(Integer [] :: new);
        HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));

        if(set.size() == arr.length){
            System.out.println(false);
        }
        else System.out.println(true);
    }
}