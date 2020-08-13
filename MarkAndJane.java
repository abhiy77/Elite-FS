/* 14/04/2020 - HOME
 * Mark and Jane are very happy after having their first child. 
Their son loves toys, so Mark wants to buy some. 
There are a number of different toys lying in front of him, tagged with their prices. 
Mark has only a certain amount to spend, 
and he wants to maximize the number of toys he buys with this money.

Given a list of prices and an amount to spend, 
what is the maximum number of toys Mark can buy? 

For example, if prices=[1,2,3,4] and Mark has k=7 to spend, he can buy items [1,2,3] for 6, 
or [3,4] for 7 units of currency. He would choose the first group of 3 items.

Input Format:
	- The first line contains two integers, n and k, the number of priced toys and 
	  the amount Mark has to spend.
	- The next line contains n space-separated integers prices[i]

Note:A toy can't be bought multiple times.

Output Format:
	- An integer that denotes the maximum number of toys Mark can buy for his son.

Sample Input
	7 50
	1 12 5 111 200 1000 10
Sample Output
	4
Explanation
He can buy only 4 toys at most. These toys have the following prices: 1,12,5,10


========= Testcases Program-3 =========
case =1
input =7 50
1 12 5 111 200 1000 10
output =4

case =2
input =4 7
1 2 3 4
output =3

case =3
input =5 15
3 7 2 9 4
output =3

case =4
input =10 124
78 64 30 17 83 39 43 18 30 48
output =4

case =5
input =20 1024
350 803 965 568 123 636 473 268 201 284 199 312 622 155 109 640 141 827 574 839
output =6

case =6
input =15 1024
674 682 789 232 971 920 573 109 898 200 393 147 210 499 336
output =5

case =7
input =25 1575
334 996 112 932 293 442 905 796 231 193 290 659 454 399 636 462 259 371 966 778 247 765 811 518 147
output =7

case =8
input =25 5432
941 855 895 910 620 897 799 909 831 798 597 540 720 696 618 859 945 617 780 712 686 964 764 633 960
output =8

 */
package Elite;
import java.util.*;
public class MarkAndJane {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int toys = 0;
		int i = 0;
		while(k >= arr[i]) {
			toys++; 
			k -= arr[i]; i++;
		}
		System.out.println(toys);
	}
}