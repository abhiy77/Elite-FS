/* 03/04/2020 - HOME
 * 
N cars are going to the same destination along a one lane road.  
The destination is target miles away.

Each car i has a constant speed speed[i] (in miles per hour), 
and initial position position[i] miles towards the target along the road.

A car can never pass another car ahead of it, but it can catch up to it, 
and drive bumper to bumper at the same speed.

The distance between these two cars is ignored - they are assumed to have the same position.

A car fleet is some non-empty set of cars driving at the same position and same speed.  
Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, 
it will still be considered as one car fleet.


How many car fleets will arrive at the destination?

Input: 
    5
    10 8 0 5 3
    2 4 1 1 3
    12

Output: 
    3

Explanation:
    num Of cars  = 5 , position = [10,8,0,5,3], speed = [2,4,1,1,3],target = 12.
    
    The cars starting at 10 and 8 become a fleet, meeting each other at 12.
    The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
    The cars starting at 5 and 3 become a fleet, meeting each other at 6.
    Note that no other cars meet these fleets before the destination, so the answer is 3.

========= TestCases Prog-2 =========
case =1
input =5
10 8 0 5 3
2 4 1 1 3
12
output =3

case =2
input =6
10 20 30 40 50 60
1 2 3 4 5 6
20
output =6

case =3
input =6
0 8 5 3 10 8
2 4 3 4 5 6
14
output =5

case =4
input =8
0 8 5 3 10 11 13 20
2 4 3 19 5 6 7 8
25
output =7

case =5
input =2
2 5
3 2
10
output =2

case =6
input =8
12 8 2 6 9 4 8 5
2 4 1 2 5 1 2 3
12
output =6

case =7
input =8
12 8 2 6 9 4 8 5
2 4 1 2 1 1 2 3
12
output =4

case =8
input =9
12 8 2 6 9 4 8 5 3
2 4 1 2 1 2 2 3 2
12
output =5
 */
package Elite;
import java.util.*;

class Car {
	int position;
	double time;

	Car(int p, double t) {
		position = p;
		time = t;
	}
}

public class CarFleets {

	public static int carFleet(int target, int[] position, int[] speed) {
		int N = position.length;
		Car[] cars = new Car[N];
		for (int i = 0; i < N; ++i)
			cars[i] = new Car(position[i], (double) ((target - position[i]) )/ speed[i]);
		Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

		int ans = 0, t = N;
		while (--t > 0) {
			if (cars[t].time < cars[t - 1].time)
				ans++; // if cars[t] arrives sooner, it can't be caught
			else
				cars[t - 1] = cars[t]; // else, cars[t-1] arrives at same time as cars[t]
		}

		return ans + (t == 0 ? 1 : 0); // lone car is fleet (if it exists)
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numOfCars = sc.nextInt();
		int[] position = new int[numOfCars];
		int[] speed = new int[numOfCars];

		for (int i = 0; i < numOfCars; i++)
			position[i] = sc.nextInt();

		for (int i = 0; i < numOfCars; i++)
			speed[i] = sc.nextInt();

		int target = sc.nextInt();
		System.out.println(carFleet(target, position, speed));

	}
}



//public class CarFleets {
//	
//	public static boolean check(HashMap<Integer,LinkedList<Integer>> map, int num,int item) {
//		LinkedList<Integer> list = map.get(num);
//		for(int i=0;i<list.size();i++) {
//			if(list.get(i) < item) return true;
//		}
//		return false;
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int cars = sc.nextInt();
//		sc.nextLine();
//		int position[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
//		int speed[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
//		int target = sc.nextInt();
//		int fleets = 0;
//		HashMap<Integer,LinkedList<Integer>> map = new HashMap<>();
//		HashMap<Integer,Boolean> visited = new HashMap<>();
//		for(int i=0;i<position.length;i++) {
//			visited.put(i,false);
//		}
//		for(int i=0;i<position.length;i++) {
//			if(map.containsKey(position[i])) {
//				map.get(position[i]).add(i);
//			}
//			else {
//				LinkedList<Integer> list = new LinkedList<>();
//				list.add(i);
//				map.put(position[i], list);
//			}
//		}
//		System.out.println(map);
//		
//		while(!visited.isEmpty()) {
//			for(int i=0;i<position.length;i++) {
//				if(!visited.containsKey(i)) continue;
//				int num = position[i] + speed[i];
//				System.out.println(num);
//				if(num > target) {
//					if(visited.get(i) == false) fleets++;
//					visited.remove(i);
//					map.get(position[i]).remove((Object)i);
//					if(map.get(position[i]).isEmpty()) {
//						map.remove(position[i]);
//					}
//				}
//				else {
//					if(map.containsKey(num) && check(map,num,i)) {
//						map.get(num).add(i);
//						fleets++;
//						for(int j=0;j<map.get(num).size();j++) {
//							visited.put(map.get(num).get(j),true);
//						}
//						
//					}
//					else {
//						LinkedList<Integer> list = new LinkedList<>();
//						list.add(i);
//						map.put(num, list);
//					}
//					map.get(position[i]).remove((Object)i);
//					if(map.get(position[i]).isEmpty()) {
//						map.remove(position[i]);
//					}
//					System.out.println(map);
//				}
//				position[i] = num;
//			}
//		}
//		System.out.println(fleets);
//	}
//}