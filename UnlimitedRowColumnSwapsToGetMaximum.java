/* 06/04/2020 - HOME
 * Sean invented a game involving a 2n*2n matrix where each cell of the matrix contains an integer.
He can reverse any of its rows or columns any number of times. 
The goal of the game is to maximize the sum of the elements in the n*n submatrix 
located in the upper-left quadrant of the matrix.

Given the initial configurations for  matrices, 
help Sean reverse the rows and columns of each matrix in the best possible way 
so that the sum of the elements in the matrix's upper-left quadrant is maximal.

For example, given the matrix:
1 2
3 4
It is 2*2 so we want to maximize the top left 1*1 matrix. Reverse row 1:
1 2
4 3
And now reverse column :
4 2
1 3
The maximal sum is 4.

Input Format:
The first line contains an integer, .
Each of the next 2n lines contains 2n space-separated integers matrix[i][j] in row i of the matrix.

Output Format:
An integer, print the maximum possible sum of the elements in the matrix's upper-left quadrant.

Sample Input:
2
112 42 83 119
56 125 56 49
15 78 101 43
62 98 114 108

Sample Output:
414

Explanation:
	We can perform the following operations to maximize the sum of the n*n submatrix 
	in the upper-left corner:
	Reverse column2( [83, 56, 101, 114 ] ), resulting in the matrix:
				112 42 114 119
				56 125 101 49
				15 78 56 43
				62 98 83 108
	Reverse row0( [112, 42, 114, 119 ] ), resulting in the matrix:
				119 114 42 112
				56 125 101 49
				15 78 56 43
				62 98 83 108
	When we sum the values in the  submatrix,  in the upper-left quadrant, 
	we get 119+114+56+125 = 414.

========= Testcases Program-3 =========	
	
case =1
input =2
112 42 83 119
56 125 56 49
15 78 101 43
62 98 114 108
output =414

case =2
input =3
3542 2126 2650 83 2400 46
3511 4087 1922 1335 55 2220
394 1500 580 2656 2525 3703
902 2862 2403 410 2328 9
1025 3347 4088 287 1 3928
3650 865 3045 2901 4002 3025
output =32021

case =3
input =2
517 37 380 3727
3049 1181 2690 1587
3227 3500 2665 383
4041 2013 384 965
output =12781

case =4
input =8
3141 1054 2544 110 4092 3968 1855 427 1914 2701 118 3343 3311 4086 152 25
956 1276 1106 1450 2196 1173 2027 3733 3971 192 983 5 2195 364 633 1416
1213 865 3952 3003 3382 1878 1552 1029 3723 1291 403 679 3265 594 1178 1135
478 358 4060 3 3313 433 1425 2068 4 1533 2152 948 3129 1 3297 2473
3746 3981 2096 2830 2051 1953 500 175 2900 1 6 1892 3767 2779 535 2518
3859 3766 318 2915 1665 1493 312 739 3248 3911 271 1417 241 2653 1128 705
3348 2621 2745 1555 1954 2350 491 1253 1007 0 2519 965 3593 3280 468 1514
6 3130 1093 2936 3380 1089 4022 3257 3155 5 888 4081 2186 880 2897 2118
2049 9 1483 1965 1459 412 1173 2189 808 1424 2713 1824 319 3201 746 1895
1989 1840 4090 13 2636 2213 3839 3656 4067 9 2391 3230 2295 1702 3173 1739
2697 313 3160 3023 496 1155 1060 661 1697 3586 0 2446 573 4091 3392 716
94 4058 1228 4 4 1835 2471 1605 795 3776 3558 3094 2048 3653 2834 3079
1174 1958 1672 3871 90 1889 3850 2249 364 3203 3925 3701 70 2963 3402 6
632 2625 4087 3491 3882 4040 553 4056 3992 487 1010 1471 3221 3985 2154 2877
838 866 3677 249 1416 2873 2257 2631 1642 1876 3082 3732 3557 507 893 304
565 4 1303 3480 431 336 735 615 1861 804 1486 2925 0 2432 2592 2204
output =210789

case =5
input =3
533 6 1754 2605 1389 1523
381 916 2941 2569 2339 3450
359 1963 707 2009 3323 1762
2369 2243 1062 2495 108 1579
4011 978 147 2229 837 2199
920 2658 821 1126 466 4086
output =26827

case =6
input =4
2869 79 1122 3951 1239 3594 3092 1550
2088 4078 2660 1909 4091 7 49 3063
3240 437 1726 3783 2344 3063 3193 3070
2085 4087 2987 3601 3671 564 1181 2415
2546 1 2887 3012 3046 2217 2238 3199
3987 619 4036 4077 2326 2979 4044 3705
3893 2540 3933 3561 3177 801 2616 1289
326 5 6 3621 1427 3641 3672 3740
output =61087

case =7
input =3
4089 1714 459 3709 2113 773
969 2435 2197 1766 852 1278
2235 1228 429 1771 1832 3673
2728 2050 1747 3488 2439 4086
3451 3472 1816 2635 1365 4091
2772 2673 3237 2672 1182 2357
output =30682

case =8
input =2
107 54 128 15
12 75 110 138
100 96 34 85
75 15 28 112
output =488	
 */
package Elite;
import java.util.*;
public class UnlimitedRowColumnSwapsToGetMaximum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int arr[][] = new int[2*n][2*n];
		for(int i=0;i<2*n;i++) {
			String str[] = sc.nextLine().split(" ");
			for(int j=0;j<str.length;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		int sum = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int r1 = i;
				int r2 = 2*n-i-1;
				int c1 = j;
				int c2 = 2*n-j-1;
				sum += Math.max(Math.max(arr[r2][c1], arr[r2][c2]), Math.max(arr[r1][c1], arr[r1][c2]) );
			}
		}
		System.out.println(sum);
	}
}