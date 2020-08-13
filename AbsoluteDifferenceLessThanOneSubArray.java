/* 07/04/2020 - HOME
 * Given an array of integers, find and print the maximum number of integers 
you can select from the array such that the absolute difference between 
any two of the chosen integers is less than or equal to 1. 

For example, if your array is a=[1, 1, 2, 2, 4, 4, 5, 5, 5]. 
you can create two subarrays meeting the criterion: [1, 1, 2, 2] and [4, 4, 5, 5, 5]. 
The maximum length subarray has 5 elements.

Input Format:
The first line contains a single integer n, the size of the array a.
The second line contains n space-separated integers a[i] .

Output Format
A single integer denoting the maximum number of integers you can choose from the array
such that the absolute difference between any two of the chosen integers is <= 1.

Sample Input 0
	6
	4 6 5 3 3 1
Sample Output 0
	3

Explanation 0
We choose the following multiset of integers from the array: {4,3,3}. 
Each pair in the multiset has an absolute difference <=1 (i.e., |4-3|=1 and |3-3|=0 ), 
so we print the number of chosen integers, 3, as our answer.

Sample Input 1
	6
	1 2 2 3 1 2
Sample Output 1
	5
Explanation 1
	We choose the following multiset of integers from the array: {1,2,2,1,2}. 
	Each pair in the multiset has an absolute difference  (i.e., |1-2|=1, |1-1|=0, and |2-2|=0), 
	so we print the number of chosen integers, 5, as our answer.
	
	
	========= Testcases Program-2 =========
case =1
input =6
4 6 5 3 3 1
output =3

case =2
input =6
1 2 2 3 1 2
output =5

case =3
input =6
98 3 99 1 97 2
output =2

case =4
input =73
4 2 3 4 4 9 98 98 3 3 3 4 2 98 1 98 98 1 1 4 98 2 98 3 9 9 3 1 4 1 98 9 9 2 9 4 2 2 9 98 4 98 1 3 4 9 1 98 98 4 2 3 98 98 1 99 9 98 98 3 98 98 4 98 2 98 4 2 1 1 9 2 4
output =22

case =5
input =100
14 18 17 10 9 20 4 13 19 19 8 15 15 17 6 5 15 12 18 2 18 7 20 8 2 8 11 2 16 2 12 9 3 6 9 9 13 7 4 6 19 7 2 4 3 4 14 3 4 9 17 9 4 20 10 16 12 1 16 4 15 15 9 13 6 3 8 4 7 14 16 18 20 11 20 14 20 12 15 4 5 10 10 20 11 18 5 20 13 4 18 1 14 3 20 19 14 2 5 13
output =15

case =6
input =98
7 12 13 19 17 7 3 18 9 18 13 12 3 13 7 9 18 9 18 9 13 18 13 13 18 18 17 17 13 3 12 13 19 17 19 12 18 13 7 3 3 12 7 13 7 3 17 9 13 13 13 12 18 18 9 7 19 17 13 18 19 9 18 18 18 19 17 7 12 3 13 19 12 3 9 17 13 19 12 18 13 18 18 18 17 13 3 18 19 7 12 9 18 3 13 13 9 7
output =30

case =7
input =100
66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66
output =100

case =8
input =100
9 6 13 16 5 18 4 10 3 19 4 5 8 1 13 10 20 17 15 10 6 10 13 20 18 17 7 10 6 5 16 18 13 20 19 7 16 13 20 17 4 17 8 19 12 7 17 1 18 3 16 4 5 3 15 17 6 17 14 11 11 7 11 6 15 15 12 6 17 19 8 6 13 9 10 19 14 18 7 9 11 16 11 20 4 20 10 7 8 4 2 12 11 8 12 13 19 8 8 5
output =13

 */
package Elite;
import java.util.*;
public class AbsoluteDifferenceLessThanOneSubArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		HashMap<Integer,Integer> map = new HashMap<>();
		int max = 1;
		for(int i=0;i<n;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(map);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			for(Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
				if(entry.getKey() == entry2.getKey()) continue;
				else if(Math.abs(entry.getKey() - entry2.getKey() ) <= 1){
					max = Math.max(max, entry.getValue()+entry2.getValue());
				}
			}
		}
		System.out.println(max == 1 ? arr.length : max);
	}
}