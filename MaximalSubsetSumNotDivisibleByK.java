/* 15/04/2020 - HOME
 * 
Given a set of distinct integers, print the size of a maximal subset of S 
where the sum of any 2 numbers in S' is not evenly divisible by k.

For example, the array S={19,10,12,24,25,22} and k=4. 
One of the arrays that can be created is S'[0]={10,12,25}. 
Another is S'[1]={19,22,24}. 
After testing all permutations, the maximum length solution array has 3 elements.

Input Format:
	- The first line contains 2 space-separated integers, n and k, 
	  the number of values in S and the non factor.
	- The second line contains n space-separated integers describing S[i], 
	  the unique values of the set.
Note: All of the given numbers are distinct.

Output Format:
Print the size of the largest possible subset (S').

Sample Input
4 3
1 7 2 4

Sample Output
3

Explanation
The sums of all permutations of two elements from S={1,7,2,4} are:
	1 + 7 = 8
	1 + 2 = 3
	1 + 4 = 5
	7 + 2 = 9
	7 + 4 = 11
	2 + 4 = 6
We see that only S'={1,7,4} will not ever sum to a multiple of 3.

========= Testcases Program-2 =========
case =1
input =4 3
1 7 2 4
output =3

case =2
input =5 5
2 7 12 17 22
output =5

case =3
input =10 5
770528134 663501748 384261537 800309024 103668401 538539662 385488901 101262949 557792122 46058493
output =6

case =4
input =5 1
1 2 3 4 5
output =1

case =5
input =10 4
1 2 3 4 5 6 7 8 9 10
output =5

case =6
input =15 7
278 576 496 727 410 124 338 149 209 702 282 718 771 575 436
output =11

case =7
input =13 11
582740017 954896345 590538156 298333230 859747706 155195851 331503493 799588305 164222042 563356693 80522822 432354938 652248359
output =11

case =8
input =6 9
422346306 940894801 696810740 862741861 85835055 313720373
output =5

 */
package Elite;
import java.util.*;
public class MaximalSubsetSumNotDivisibleByK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int mod[] = new int[k];
		for(int i=0;i<n;i++) {
			mod[arr[i] % k]++;
		}
		if(k%2 == 0) {
			mod[k/2] = Math.min(mod[k/2], 1);
		}
		System.out.println(Arrays.toString(mod));
		int ans = Math.min(mod[0], 1);
		for(int i=1;i<=k/2;i++) {
			ans += Math.max(mod[i], mod[k-i]);
		}
		System.out.println(ans);
	}
}