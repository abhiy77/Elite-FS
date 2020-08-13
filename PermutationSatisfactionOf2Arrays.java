/* 16/04/2020 - HOME
 * 
Consider two n-element arrays of integers, A and B. 
You want to permute them into some A' and B' such that the relation A'[i] + B'[i] >=k 
holds for all i where 0<=i<n. 
For example, if A=[0,1], B=[0,2], and k=1, a valid A', B' satisfying our relation would be
A'=[1,0] and b'=[0,2],  1+0>=1 and 0+2>=1.

You are given two arrays A, B and k. 
Print YES on a new line if some permutation A', B' satisfying the relation above exists. 
Otherwise, print NO.

Input Format:
	- The first line contains two space-separated integers  and , 
	  the size of both arrays  and , and the relation variable.
	- The second line contains  space-separated integers .
	- The third line contains  space-separated integers .

Output Format
	- Print YES if valid permutations exist. 
	  Otherwise, print NO.

Sample Input1:
3 10
2 1 3
7 8 9
Sample Output1:
YES
Explanation1:
A=[2,1,3], B=[7,8,9], and k=10. We permute these into A'=[1,2,3] and B'=[9,8,7] 
so that the following statements are true:
	->1+9=10
	->2+8=10
	->3+7=10
Thus, we print YES on a new line.

Sample Input2:
4 5
1 2 2 1
3 3 3 4
Sample Output2:
NO
Explanation2:
A=[1,2,2,1], B=[3,3,3,4], and k=5. To permute A and B into a valid A' and B', 
we would need at least three numbers in A to be greater than 1; 
as this is not the case, we print NO on a new line.

========= Testcases Program-2 =========
case =1
input =5 5
2 3 1 1 1
1 3 4 3 3
output ="NO"

case =2
input =10 9
1 5 1 4 4 2 7 1 2 2
8 7 1 7 7 4 4 3 6 7
output ="NO"

case =3
input =10 9
3 6 8 5 9 9 4 8 4 7
5 1 0 1 6 4 1 7 4 3
output ="YES"

case =4
input =3 10
2 1 3
7 8 9
output ="YES"

case =5
input =4 5
1 2 2 1
3 3 3 4
output ="NO"

case =6
input =8 91
18 73 55 59 37 13 1 33
81 11 77 49 65 26 29 49
output ="NO"

case =7
input =18 94
84 2 50 51 19 58 12 90 81 68 54 73 81 31 79 85 39 2
53 102 40 17 33 92 18 79 66 23 84 25 38 43 27 55 8 19
output ="YES"

case =8
input =11 59
15 16 44 58 5 10 16 9 4 20 24
37 45 41 46 8 23 59 57 51 44 59
output ="YES"


 */
package Elite;
import java.util.*;
public class PermutationSatisfactionOf2Arrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for(int i=0;i<n;i++) a[i] = sc.nextInt();
		for(int i=0;i<n;i++) b[i] = sc.nextInt();
		boolean visited[] = new boolean[n];
		Arrays.sort(b);
		for(int i=0;i<n;i++) {
			int curr = -1;
			for(int j=n-1;j>=0;j--) {
				if(a[i] + b[j] >= k && !visited[j]) {
					curr = j;
				}
				else if(a[i] + b[j] < k) break;
			}
			if(curr == -1) {
				System.out.println("NO");
				System.exit(1);
			}
			visited[curr] = true;
		}
		System.out.println("YES");
	}
}