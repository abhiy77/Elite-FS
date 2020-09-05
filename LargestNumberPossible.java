/* 04/09/2020 - (ELITE DAY - 115)
 * Manasa is playing with numbers. She is given a list of integers.
She is appending the numbers together, in such a way
the newly formed number should be the highest possible number.

Help Manasa with a program, to find the highest possible number.

Note: The result may be long, please maintain the number as string.

Input Format:
-------------
Space separated integers nums[], list of numbers.

Output Format:
--------------
Print the highest possible number.


Sample Input-1:
---------------
10 2

Sample Output-1:
----------------
210


Sample Input-2:
---------------
3 30 34 5 9

Sample Output-2:
----------------
9534330

 */
package Elite;
import java.util.*;

class LargestNumberPossible{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr[] = sc.nextLine().split(" ");
        Arrays.sort(arr,new Comparator<String>(){
            
            public int compare(String s1,String s2){
                String temp1 = s1+s2;
                String temp2 = s2+s1;
                if(temp1.compareTo(temp2) > 0)return -1;
                return 1;
            }
        });
        
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "");
        }
    }
}