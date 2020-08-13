/* 16/04/2020 - HOME
 * 
Alice is a kindergarten teacher. She wants to give some candies to the children in her class.
All the children sit in a line and each of them has a rating score according to 
his or her performance in the class.  Alice wants to give at least 1 candy to each child. 
If two children sit next to each other, 
then the one with the higher rating must get more candies. 
Alice wants to minimize the total number of candies she must buy.

For example, assume her students' ratings are [4, 6, 4, 5, 6, 2]. 
She gives the students candy in the following minimal amounts: [1, 2, 1, 2, 3, 1]. 
She must buy a minimum of 10 candies.

Input Format
	The first line contains an integer, n, the size of arr.
	Next line contains n space seperated integers indicating the rating of the students at position i.

Output Format
	Output a single line containing the minimum number of candies Alice must buy.

Sample Input1:
3
1 2 2
Sample Output1:
4
Explanation1:
Here 1, 2, 2 is the rating. Note that when two children have equal rating, 
they are allowed to have different number of candies. 
Hence optimal distribution will be 1, 2, 1.


Sample Input2:
10
2 4 2 6 1 7 8 9 2 1
Sample Output2:
19
Explanation2:
Optimal distribution will be 1,2,1,2,1,2,3,4,2,1

Sample Input3:
8
2 4 3 5 2 6 4 5
Sample Output3:
12
Explanation3:
Optimal distribution will be 1,2,1,2,1,2,1,2.

========= Testcases Program-1 =========
case =1
input =6
4 6 4 5 6 2
output =10

case =2
input =3
1 2 2
output =4

case =3
input =10
2 4 2 6 1 7 8 9 2 1
output =19

case =4
input =8
2 4 3 5 2 6 4 5
output =12

case =5
input =15
77 73 30 61 35 87 83 28 30 76 36 79 90 37 20
output =29

case =6
input =25
3 1 8 8 8 8 8 6 4 4 6 1 2 5 1 0 6 2 4 4 0 5 3 0 9
output =42

case =7
input =20
3 1 8 8 8 8 8 6 4 4 6 1 2 5 1 0 6 2 4 4
output =32

case =8
input =30
1 7 2 3 4 3 4 4 7 0 4 4 5 3 7 3 2 2 3 6 0 0 7 8 9 2 4 1 6 8
output =54

 */
package Elite;
import java.util.*;

class AliceCandyDistribution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int chocolates[] = new int[n];
        Arrays.fill(chocolates,1);
        int chocs = 0;
        if(arr[0] > arr[1]) chocolates[0]++;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
            	chocolates[i] = Math.max(chocolates[i+1], chocolates[i-1]) + 1;
            }
            else if(arr[i] > arr[i-1]) {
            	chocolates[i] = chocolates[i-1] + 1;
            	if(arr[i] < arr[i+1] && chocolates[i] >= chocolates[i+1])chocolates[i+1]++;
            }
            else if( arr[i] > arr[i+1]) {
            	chocolates[i] = chocolates[i+1] + 1;
            	if(arr[i] < arr[i-1] && chocolates[i] >= chocolates[i-1])chocolates[i-1]++;
            }
        }
        if(arr[n-1] > arr[n-2]) chocolates[n-1]++;
        
        for(int i=0;i<arr.length;i++){
            chocs += chocolates[i];
        }
        //System.out.println(Arrays.toString(chocolates));
        System.out.println(chocs);
    }
}