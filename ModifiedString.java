/* 30/07/2020 - ELITE DAY - 110
 * Somesh is given a task to you on Strings.
You have given a string S ([a-z]), and an integer array Arr[]
Now your task is to modify 'S' in such way:
replace the 'i+1' characters in the string, with next i-th character in alphabetic order(cyclic).

For example, if S="art", Arr[]=[2,3,5], 
    i=0: modify('a') = 'c' , S="crt".
    i=1: modify('c') = 'f', modify('r') = 'u', S="fut".
    i=2: modify('f') = 'k', modify('u') = 'z', modify('t') = 'y', S="kzy"
Finally modified string is kzy. 

Note: if arr[i]=3 modify('z') ='c'

Return the final modified string after all such modifications to S are applied.

Input Format:
-------------
Line-1 -> A String S,  string length is L
Line-2 -> L space separated integers.

Output Format:
--------------
Print modifed String.
 */
package Elite;
import java.util.*;

public class ModifiedString{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        char arr[] = sc.nextLine().toCharArray();
        int temp[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int cum[] = new int[arr.length];
        cum[temp.length - 1] = temp[temp.length-1];
        for(int i=temp.length-2;i>=0;i--){
            cum[i] = (cum[i+1] + temp[i])%26;
        }
        for(int i=0;i<cum.length;i++){
                int num = (cum[i] + (arr[i]-'a')) % 26;
                arr[i] = (char)('a' + num);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "");
        }
    }
}