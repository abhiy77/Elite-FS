/* 07/04/2020 - HOME

You are a real estate broker in ancient Knossos. You have M unsold houses, 
and each house 'j' has an area, Xj , and a minimum price, Yj . 

You also have N clients, and each client 'i' wants a house with an area greater than Ai and 
a price less than or equal to Pi.

Each client can buy at most one house, and each house can have at most one owner. What is the
maximum number of houses you can sell?

Input Format:
- The first line contains two space-separated integers describing the respective values of N(the number of
  clients) and M(the number of houses).
- Each line 'i' of the N subsequent lines contains two space-separated integers describing the respective
  values of Ai and Pi for client 'i'.
- Each line 'j' of the M subsequent lines contains two space-separated integers describing the respective
  values of Xj and Yj for house 'j'.
  
Constraints:
1<=N,M<=1000
1<=Ai,Pi<=10000000, where 0<=i<N
1<=Xj,Yj<=10000000, where 0<=j<M

Output Format:
Print a single integer denoting the maximum number of houses you can sell.


Sample Input 0
		3 3
		5 110
		9 500
		20 400
		10 100
		2 200
		30 300
Sample Output 0
		2

Explanation 0
Recall that each client 'i' is only interested in some house 'j' where Xj > Ai and Yj <= Pj. 
The statements below depicts which clients will be interested in which houses:
	- A0=5 and P0=110, interested in X0=10 and Y0=100
	- A1=9 and P1=500, interested in X0=10 and Y0=100 and X2=30 and Y2=300
	- A2=30 and P2=400, interested in X2=30 and Y2=300

Client 0 will be interested in house 0 because it has more than A0=5 units of space and
costs lessthan P0=100. Both of the other houses are outside of this client's price range.

Client 1 will be interested in houses 0 and 2, as both these houses have more than
A1=9 units of space and cost less than P1=500 . 
They will not be interested in the remaining house because it's too small.

Client 2 will be interested in house 2 because it has more than units A2=20 of space and
costs lessthan P2=400. They will not be interested in the other two houses because they are too small.

    All three clients are interested in the same two houses, 
    so you can sell at most two houses in the following scenarios:
        Client 0 buys house 0 and client 1 buys house 2.
        Client 1 buys house 0 and client 2 buys house 2.
        Client 0 buys house 0 and client 2 buys house 2.
    Thus, we print the maximum number of houses you can sell, 2, on a new line


========= Testcases Program-3 =========
case =1
input =3 3
5 110
9 500
20 400
10 100
2 200
30 300
output =2

case =2
input =4 4
5 110
9 500
20 400
15 350
10 100
2 200
13 350
30 300
output =3

case =3
input =5 5
5 110
9 500
12 270
20 400
15 350
10 100
2 200
13 350
30 300
14 250
output =4

case =4
input =5 4
5 110
9 500
12 270
20 400
15 350
10 100
2 200
30 300
14 250
output =3

case =5
input =4 5
9 500
12 270
20 400
15 350
10 100
2 200
13 350
30 300
14 250
output =3

case =6
input =5 6
9 500
7 150
12 270
20 400
15 350
10 100
2 200
13 350
30 300
15 220
14 250
output =4

case =7
input =7 8
9 500
7 150
9 210
17 420
12 270
20 400
15 350
10 100
2 200
12 350
13 350
30 300
18 400
15 220
14 250
output =5

case =8
input =9 10
9 500
7 150
9 210
24 500
17 420
12 270
30 560
20 400
15 350
10 100
2 200
12 350
13 350
30 300
25 450
28 580
18 400
15 220
14 250
output =6

 */
package Elite;
import java.util.*;
public class RealEstateBroker {
	
	public static int assignHouses(LinkedList<LinkedList<Integer>> adjList, int source, boolean[] visited,int[] assigned) {
		if(source == -1) return 1;
		if(visited[source]) return 0;
		visited[source] = true;
		LinkedList<Integer> list = adjList.get(source);
		for(int item : list) {
			if(assignHouses(adjList, assigned[item], visited, assigned) == 1) {
				assigned[item] = source;
				System.out.println("Assigned for client "+ source + " house " + item);
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int clients = sc.nextInt();
		int houses = sc.nextInt();
		int A[] = new int[clients];
		int P[] = new int[clients];
		int X[] = new int[houses];
		int Y[] = new int[houses];
		for(int i=0;i<clients;i++) {
			A[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		for(int i=0;i<houses;i++) {
			X[i] = sc.nextInt();
			Y[i] = sc.nextInt();
		}
		int assigned[] = new int[houses];
		Arrays.fill(assigned, -1);
		LinkedList<LinkedList<Integer>> adjList = new LinkedList<>();
		for(int i=0;i<clients;i++) {
			adjList.add(new LinkedList<>());
		}
		for(int i=0;i<clients;i++) {
			for(int j=0;j<houses;j++) {
				if(A[i] < X[j] && P[i] >= Y[j]) adjList.get(i).add(j);
			}
		}
		int ans = 0;
		System.out.println(adjList);
		for(int i=0;i<clients;i++) {
			boolean visited[] = new boolean[clients];
			System.out.println("Going to assign for client "+ i);
			ans+=assignHouses(adjList,i,visited,assigned);
		}
		System.out.println(ans);
	}
}