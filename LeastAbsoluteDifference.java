/* 20/03/2020 - HOME
 * Given an Array of N integer elements, 
find the pair of elements that have the least absolute difference between them. 
If there are multiple pairs, find them all.


Input Format
------------
The first line contains a single integer n, the length of arr.
The second line contains n space-separated integers, arr[i].

Output Format
-------------
Output the pairs of elements with the smallest difference. 
If there are multiple pairs, output all of them in ascending order, 
all on the same line with just a single space between each pair of numbers. 
A number may be part of two pairs when paired with its predecessor and its successor.

Example-1:
	Input :
		12
		-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470 
	Output :
		-520 -470 -20 30

	Explanation :
		(-470) - (-520) = 30 - (-20) = 50, which is the smallest difference.

Example-2:
	Input :
		4
		5 4 3 2
	Output :
		2 3 3 4 4 5
	Explanation :
		Here, the minimum difference will be 1. 
		Valid pairs are (2, 3), (3, 4), and (4, 5). 
		We print the elements of each pair, space-separated on a single line.


 */
package Elite;
import java.util.*;
public class LeastAbsoluteDifference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
	    Collections.sort(list,Collections.reverseOrder());
		TreeMap<Integer,LinkedList<Pair2>> map = new TreeMap<>();
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				int x = list.get(i);
				int y = list.get(j);
				int num = x-y;
				if(!map.isEmpty() && num > map.firstKey()) continue;
				if(map.containsKey(num)) {
					map.get(num).add(new Pair2(y,x));
				}
				else {
					LinkedList<Pair2> queue= new LinkedList<>();
					queue.add(new Pair2(y,x));
					map.put(num, queue);
				}
			}
		}
		LinkedList<Pair2> queue = map.pollFirstEntry().getValue();
		Collections.sort(queue);
		for(Pair2 pair : queue) {
			System.out.print(pair+" ");
		}
	}
}

class Pair2 implements Comparable<Pair2>{
	int x,y;
	Pair2(int x,int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair2 o) {
		if(x == o.x) return y - o.y;
		else return x - o.x;
	}
	
	@Override
	public String toString() {
		return this.x+" "+this.y;
	}
}