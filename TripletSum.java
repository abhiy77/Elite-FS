/* 06/03/2020
 * 
 Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a triplet present in array, then print the triplet and return true. Else return false. 
 
 
 For example, 
 
Input: 12 3 4 1 6 9
24
 
output:12 3 9

Input: 17 5 21 12 3 4 11 26 9
57
 
output:-1
 
 
-----------------------------------------------------

case =1 
input =32 3 4 1 6 19
52
output =[1, 19, 32]

case =2 
input =8 75 61 17 5 21 12 3 4 11 26 9
58
output =[11, 21, 26]

case =3 
input =10 20 15 30 40 50 60 70 80 90
60
output =[10, 20, 30]

case =4
input =5 10 20 12 40 25 15
30
output =[5, 10, 15]


case =5
input =7 14 22 35 42 50 56 1 83 
84
output =[7, 35, 42]

case =6
input =17 5 21 12 3 4 11 26 9
57
output =-1

 
 */
package Elite;
import java.util.*;

public class TripletSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		int n = arr.length;
		int target = sc.nextInt();
		for(int i=0;i<n-2;i++) {
			int j = i+1 , k = n-1;
			while(j < k) {
				int sum = arr[i] + arr[j] + arr[k];
				if(sum == target) {
					System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
					System.exit(1);
				}
				else if(sum < target) j++;
				else k--;
			}
		}
		System.out.println(-1);
	}
}