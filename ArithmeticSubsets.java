/* 19/09/2020 - (ELITE DAY - 123)
 * 
 * There are n boxes of balls in a row, every i-th box contains balls[i] balls.

A series of boxes is called Arithmetic, if it consists of at least three boxes and
if the difference between the number of balls in any two consecutive boxes is same.

A subset of boxes is called Arithmetic Subset,
if subset[i], subset[i+1], subset[i+2], ..., subset[j] is Arithmetic.

Your task is to findout the number of Arithmetic Subsets in the row of boxes.

Input Format:
-------------
Line-1 : An integer N, number of boxes.
Line-2 : N space separated integers balls[i], i-th box contains balls[i] balls. 

Output Format:
--------------
Print an integer, number of Arithmetic Subsets.


Sample Input:
---------------
4
1 2 3 4

Sample Output:
----------------
3

Explanation:
------------
Arithmetic Subsets are: [1,2,3], [2,3,4], [1,2,3,4].


Sample Input:
---------------
5
1 3 5 7 9

Sample Output:
----------------
6

Explanation:
------------
Arithmetic Subsets are: [1,3,5], [3,5,7], [5,7,9], [1,3,5,7], [3,5,7,9], [1,3,5,7,9].

******* Program-1 *******
case =1
input =10
1 3 5 7 9 12 13 14 15 16
output =12

case =2
input =5
1 3 5 7 9
output =6

case =3
input =15
2 4 6 8 10 12 14 16 18 20 22 24 26 28 30
output =91

case =4
input =13
32 29 26 23 20 17 14 11 8 5 2 -1 -4
output =66

case =5
input =20
1 3 5 7 9 11 13 15 17 19 21 23 2 4 6 8 10 12 14 16
output =76

case =6
input =25
5 10 15 20 25 30 35 40 2 5 8 11 14 17 20 23 26 29 32 35 38 1 2 3 4 5
output =90

case =7
input =4
1 2 3 4
output =3

case =8
input =25
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 20 22 24 26 28 30 32
output =157


 */
package Elite;
import java.util.*;

public class ArithmeticSubsets{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        if(n <= 2){
            System.out.println(0);
        }
        else{
            int count = 0;
            int diff = -1;
            int streak = -1;
            for(int i=1;i<n;i++){
                int temp = arr[i] - arr[i-1];
                if(diff == -1){
                    diff = temp;
                    streak = 1;
                }
                else if(temp == diff){
                    streak++;
                }
                else{
                    diff = temp;
                    if(streak > 1)count += (streak*(streak-1)/2);
                    streak = 1;
                }
            }
            if(streak > 1) count += (streak * (streak-1)/2);
            
            System.out.println(count);
        }   
    }
}