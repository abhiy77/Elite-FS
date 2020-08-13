/* 14/05/2020 - HOME
Nagi Reddy has to design problems for the finishing school.
He has collected all the programs and assigned them a grade based on 
the difficulty level of the program. He has also defined a set of conditions 
   a) The student can solve any number of programs in a day.
   b) The programs need to be solved in such a way that there is 
      atleast "K" differential in the grade of consecutive problems.

You need to tell us how many days you will take to solve all the probelms.


Input Format:
    - First line contains two integers N and K, 
    - next line contains N space seperated integers g1,g2,...,gn, represents Grades. 

Output Format:
    - An integer, the minimum number of days in which all problems can be solved.


Sample Input :
3 2
5 4 7
Sample Output :
2 

( 5 and 7 can be solved in 1 day and 4 can be solved next day)

Sample Input:
5 1
5 3 4 5 6

Sample output: 
1 
( 5->3->4->5->6)  Remember the minimum differential is 1 here.


*********Testcases******
case =1
input =8 51
49 57 3 95 98 100 44 40
output =3

case =2
input =3 2
5 4 7
output =2

case =3
input =83 932
76 739 407 266 255 500 108 240 240 982 462 229 183 96 226 418 758 895 835 823 818 886 991 836 833 173 594 978 344 628 909 771 718 667 36 972 166 495 563 757 476 376 338 658 471 563 428 581 809 614 403 626 851 393 814 36 565 759 13 260 386 273 30 455 291 417 427 808 264 989 565 91 717 254 101 187 168 528 767 976 493 521 953
output =75

case =4
input =51 521
902 282 921 54 756 810 289 219 394 761 453 286 493 750 490 255 663 629 646 613 841 42 467 108 396 54 214 176 465 616 48 366 898 320 772 653 129 412 872 874 172 324 511 17 425 1000 271 88 981 916 52
output =20

case =5
input =41 335
47 387 431 691 217 983 847 186 493 215 852 815 953 341 242 931 754 865 191 255 631 187 673 763 288 73 698 326 222 390 661 621 777 443 311 993 425 510 530 270 76
output =5

case =6
input =67 826
358 670 4 658 725 626 306 508 885 270 532 470 460 305 990 191 666 852 52 208 409 763 79 207 829 761 86 269 355 452 446 712 122 801 370 846 427 27 705 663 296 236 132 107 541 121 650 558 324 701 117 733 815 196 291 643 308 376 263 14 180 61 78 301 861 447 498
output =62

case =7
input =47 23
272 275 479 40 198 420 783 440 633 538 815 452 610 682 243 297 219 313 82 499 513 845 591 880 111 459 813 826 114 611 849 386 885 679 777 83 450 911 874 82 448 41 885 57 74 479 354
output =2

case =8
input =68 958
460 21 995 89 855 395 306 918 831 952 838 334 77 210 173 40 311 863 458 6 997 670 181 563 872 974 190 610 323 410 567 782 430 914 871 637 308 528 906 490 832 743 823 908 304 348 947 966 210 756 972 558 426 504 472 649 478 662 258 152 423 177 934 852 90 156 840 749
output =65


*/
package Elite;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemSolving{
	static int N;
	static int K;
	static boolean cbn[][]; // can be next
	static int prev[];
	static boolean visited[];

	
	public static void main(String[] args) {	
		Scanner s = new Scanner(new InputStreamReader(System.in));
		
			N = s.nextInt();
			K = s.nextInt();
			cbn = new boolean[N][N];
			prev = new int[N];
			visited = new boolean[N];

			int[] rating = new int[N];
			for(int i = 0; i < N; i++) {
				rating[i] = s.nextInt();
			}
			
			for (int i = 0; i < rating.length; i++) {
				for (int j = i + 1; j < rating.length; j++) {
					if (Math.abs(rating[i] - rating[j]) >= K) {
						cbn[i][j] = true;
					}
				}
			}
			
			System.out.println(solve());
	}

	static boolean FindNextDfs(int a) {
		if (a < 0)
			return true;
		if (visited[a])
			return false;
		visited[a] = true;
		for (int i = 0; i < N; i++)
			if (cbn[a][i]) {
				if (FindNextDfs(prev[i])) {
					prev[i] = a;
					return true;
				}
			}
		return false;
	}

	static int solve() {
		Arrays.fill(prev, -1);
		int ret = 0;
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited, false);
			if (!FindNextDfs(i))
				ret++;
		}
		return ret;
	}

}
