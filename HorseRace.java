/* 01/04/2020 - HOME
 * Ameeta Mehra owns S horses. He wants to keep only horses that can run very fast. 
He decides which horses are fast by making them race against each other. 
If a horse comes in last, then Ameeta Mehra will sell it.

The race course consists of N checkpoints and E roads. Ameeta Mehra positions his horses at 
the first S checkpoints i.e., checkpoints 1 to S. The checkpoint N is chosen as the finish line. 
The horses need 1 unit of time to cross one road. 
If the horses have two or more paths to choose, then they choose the one which is shortest. 
The horses start the race at the same instant. When a horse reaches checkpoint N, it finishes 
the race.

Find the total number of horses that Ameeta Mehra will sell i.e., 
the number of horses that come in last.

NOTE : The roads are bidirectional.

Input Format:
-------------
The first line of the input consists of S (the number of horses), N (the number of checkpoints) 
and E (the number of roads) Each of the next E lines contains a and b, indicating that there is 
a road between checkpoints a and b.

Output Format:
--------------
Print a single integer, the number horses that come in last.

Constraints
-----------
1 ≤ S < N ≤ 300000
1 ≤ E ≤ 300000
1 ≤ a , b ≤ N

Sample Input:
        3 5 4
        1 5
        2 4
        3 4
        5 4
Sample Output:
        2

Explanation

    There are 3 horses, each starting at checkpoint 1, 2 and 3 respectively. 
    Checkpoint 5 is the finish line. The horse starting at checkpoint 1 finishes the race first, 
    in 1 unit of time. The horses at 2 and 3 come in last and finish the race at the same instant. 
    Hence, Ameeta Mehra will sell 2 horses.
    
case=1
input=2 6 5
1 5
2 4
5 4
3 4
4 6
output=1

case=2
input=3 6 7
1 4
2 5
3 4
4 5
5 6
4 6
2 6
output=2

case=3
input=3 6 5
1 4
2 4
3 4
4 5
5 6
output=3

case=4
input=5 12 16
1 6
2 8
3 6
3 7
4 7
4 9
5 7
5 6
6 8
7 8
7 9
9 10
10 11
11 12
1 7
2 7
output=4

case=5
input=5 12 13
1 6
2 8
3 6
3 7
4 7
4 9
5 6
6 8
7 9
10 11
11 12
1 7
2 7
output=5

case=6
input=5 12 14
1 6
3 7
4 7
4 9
5 7
5 6
6 8
7 8
7 9
9 10
10 11
11 12
1 7
2 7
output=4

case=7
input=5 11 12
1 6
2 8
3 6
3 7
4 7
5 6
6 8
7 8
7 9
9 10
10 11
11 10
output=2

case=8
input=4 5 5
1 2
2 3
3 4
4 5
1 4
output=1

 */
package Elite;
import java.util.*;
public class HorseRace {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int horses = sc.nextInt();
		int checkpoints = sc.nextInt();
		int roads = sc.nextInt();
		int arr[][] = new int[checkpoints][checkpoints];
		for(int[] a : arr) {
			Arrays.fill(a, 100000);
		}
		for(int i = 0;i<roads;i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		for(int k=0;k<checkpoints;k++) {
			for(int i = 0; i < checkpoints;i++) {
				for(int j = 0;j<checkpoints;j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0;i<horses;i++) {
			list.add(arr[checkpoints-1][i]);
		}
//		for(int i = 0;i<arr.length;i++) {
//			for(int j = 0;j<arr.length;j++) {
//				if(arr[i][j] == 100000)System.out.print("0 ");
//				else System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(list);
		int max = Collections.max(list);
		int count = 0;
		for(int i = 0; i< list.size();i++) {
			if(list.get(i) == max)count++;
		}
		System.out.println(count);
	}
}