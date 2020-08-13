/* 04/04/2020 - HOME
 * 
We have to paint n boards of length {A1, A2, .. An}. 
There are k painters available and each takes 1 unit time to paint 1 unit of board. 
The problem is to find the minimum time to get this job done under the constraints 
that any painter will only paint continuous sections of boards, say board {2, 3, 4} 
or only board {1} or nothing but not board {2, 4, 5}.

Sample Input : 
        10 10 10 10
        2

Sample Output : 
        20

Explanation:
k = 2, A = {10, 10, 10, 10} 
Here we can divide the boards into 2
equal sized partitions, so each painter 
gets 20 units of board and the total
time taken is 20. 

Sample Input :
        10 20 30 40
        2

Sample Output : 
        60

Explanation:
    k = 2, A = {10, 20, 30, 40}
    Here we can divide first 3 boards for
    one painter and the last board for 
    second painter.
   
 ----------TESTCASES---------------------
    
    case =1
input=10 20 30 40
3
output=40

case =2
input=10 10 10 10
3
output=20

case =3
input=10 10 10 10
4
output=10

case =4
input=50 10 20 30 40 80 40
5
output=80

case =5
input=50 10 20 30 40 80 40
3
output=120

case =6
input=59 76 27 18 79 48 38 13 15 42
3
output=156

case =7
input=85 83 84 59 63 40 85 75 35 55 63 49 60 14 29
5
output=206

case =8
input=82 80 81 85 15 20 59 34 28 40 36 18 73 44 41 63 45 19 71 56
6
output=181


 * 
 */
package Elite;
import java.util.*;
public class PaintingBoards {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int boards[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int k = sc.nextInt();
		int max = Integer.MIN_VALUE,sum = 0;
		for(int i=0;i<boards.length;i++) {
			max = Math.max(max, boards[i]);
			sum += boards[i];
		}
		int i = max,j=sum,result = 0;
		while(i <= j) {
			int mid = (i+j)/2;
		//	System.out.print("Mid : "+mid);
			int cuts = 0,val = 0;
			for(int z=0;z<boards.length;z++) {
				val += boards[z];
				if(val > mid) {
					val = 0; cuts++; z--;
				}
			}
			if(val > 0) cuts++;
			if(cuts <= k) {
				//System.out.println(" Success");
				result = mid;
				j = mid-1;
			}
			else {
				//System.out.println(" Failure");
				i = mid+1;
			}
		}
		System.out.println(result);
	}
}