/* 04/04/2020 - HOME
 * 
Bob the builder has constructed some walls of various length in a line. 
Now, he wants to count the total number of walls constructed and report that number to his boss.
But the report that Bob made was wrong because he counted the total number of walls by
standing on the leftmost side of the first wall. So he was only able to see some walls 
and not all because others were hidden behind. 
Can you predict the number of walls counted by Bob.

Input
First line contains T denoting the number of test cases.
First line of each test case contains N denoting the actual no of walls.
Second line of each test case contains N integers (A1...An) denoting the height of each walls.

Output
For each test case print a single integer denoting the total no of walls as counted by 
Bob each in a new line.

Sample input :
    5
    1 3 2 5 4
Sample Output :
    3

Explanation :
    Bob will only be able to see the walls of length 1,3 and 5

 */
package Elite;
import java.util.*;
public class BobCountingWalls {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int max = arr[0],count = 1;
		for(int i=1;i<n;i++) {
			if(max < arr[i]) {
				max = arr[i];
				count++;
			}
		}
		System.out.println(count);
	}
}