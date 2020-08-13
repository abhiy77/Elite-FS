/* 22/04/2020 - HOME
 * There are N groups of friends, and each group is numbered from 1 to N. 
The ith group contains Ai people.
They live near a bus stop, and only a single bus operates on this route. 
An empty bus arrives at the bus stop and all the groups want to travel by the bus.

However, group of friends do not want to get separated. 
So they enter the bus only if the bus can carry the entire group.

Moreover, the groups do not want to change their relative positioning while travelling. 
In other words, group 3 cannot travel by bus, unless group 1 and group 2 have either 
(a) already traveled by the bus in the previous trip or 
(b) they are also sitting inside the bus at present.

You are given that a bus of size X can carry X people simultaneously.

Find the size X of the bus so that (1) the bus can transport all the groups 
and (2) every time when the bus starts from the bus station, 
there is no empty space in the bus (i.e. the total number of people present inside the bus is equal to )?

Input Format:
The first line contains an integer  N. The second line contains N space-separated integers A1,A2,A3...An .
Output Format:
Print all possible sizes of the bus in an increasing order.

Sample Input:
8
1 2 1 1 1 2 1 3
Sample Output:
3 4 6 12
Sample Explanation:
In the above example,  A1= 1,  A2= 2,  A3= 1,  A4= 1, A5 = 1, A6 = 2, A7 = 1, A8 = 3.

If x = 1 : In the first trip, A1 go by the bus. There will be no second trip because 
the bus cannot accommodate group 2. Hence "x = 1" is not the required answer.

If x = 2 : No bus trip is possible. That's because A1 cannot go alone, 
as one seat will be left vacant in the bus. And, A1 & A2 cannot go together, 
because the bus is cannot accommodate both the groups simultaneously.

If x = 3 : In the first trip,  a1 & a2 go by the bus. In the second trip A3, A4 & A5 go by the bus. 
In the third trip, A6 & A7 go by the bus. In the fourth trip, A8 go by the bus.

If x = 4 : In the first trip, A1, A2 & A3 go by the bus. In the second trip, A4, A5 & A6 go by the bus. 
In the third trip, A7 & A8 go by the bus.

Similarly you can figure out the output for x= 5, 6 & 7.

========= Testcases Program-2 =========
case =1
input =4
1 1 1 1
output =1 2 4

case =2
input =8
1 2 1 1 1 2 1 3
output =3 4 6 12

case =3
input =10
2 2 1 1 1 1 1 2 1 2
output =7 14

case =4
input =100
1 2 2 1 2 1 1 2 1 1 1 2 2 1 1 1 2 2 2 1 2 1 1 1 1 1 2 1 2 1 2 1 2 1 2 1 1 1 2 1 1 1 1 1 2 2 1 2 1 2 1 2 2 2 1 2 1 2 2 1 1 2 2 1 1 2 2 2 1 1 2 1 1 2 2 1 2 1 1 2 2 1 2 1 1 2 2 1 1 1 1 2 1 1 1 1 2 2 2 2
output =29 145

case =5
input =12
1 1 2 1 2 1 1 2 1 2 1 1
output =4 8 16

case =6
input =15
1 1 1 2 2 2 3 2 1 1 2 2 3 2 2
output =9 27

case =7
input =8
1 2 1 2 1 2 1 2
output =3 6 12

case =8
input =7
1 2 3 2 3 2 1
output =14



 */
package Elite;
import java.util.*;
public class FriendGroupsBusTrip {
	
	public static boolean isPossible(int[] arr,int val) {
		int num = 0;
		for(int i=0;i<arr.length;i++) {
			if(num + arr[i] > val) return false;
			else if(num + arr[i] == val) num = 0;
			else if(num + arr[i] < val) num += arr[i];
		}
		if(num != 0) return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		for(int i=1;i<=sum;i++) {
			if(isPossible(arr,i)) {
				System.out.print(i + " ");
			}
		}
	}
}