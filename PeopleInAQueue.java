/* 24/02/2020
 * Suppose you have a random list of people standing in a queue. 
Each person is described by a pair of integers (h, k), 
where h is the height of the person and 
k is the number of people in front of this person who have a height greater than or equal to h.

Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

 
Example

    Input:6
    7 0
    4 4
    7 1
    5 0
    6 1
    5 2
    
    Output:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
package Elite;
import java.util.*;
public class PeopleInAQueue {
	
	public static boolean compare(Person p,LinkedList<Integer> temp) {
		if(p.count > temp.size()) return false;
		int count = 0;
		for(int t : temp) {
			if(p.height <= t) count++;
		}
		if(count == p.count) return true;
		return false;
	}
	
	public static LinkedList<Person> sortInPlace(LinkedList<Person> list) {
		LinkedList<Person> temp = new LinkedList<>();
		System.out.println(list);
		temp.add(list.get(0));
		for(int i=1;i<list.size();i++) {
			Person p = list.get(i);
			if(p.count == 0) {
				temp.add(0,p);
				continue;
			}
			int count = 0 ;
			int j=0;
			for(;j<list.size();j++) {
				if(p.height <= list.get(j).height)count++;
				if(p.count <= count) break;
			}
				if(temp.size() < count) temp.add(p);
				else temp.add(j+1,p);

			System.out.println("Temp : " + temp);
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Person> list = new LinkedList<>();
		for(int i=0;i<n;i++) {
			list.add(new Person(sc.nextInt(),sc.nextInt()));
		}
		Collections.sort(list);
		System.out.println(sortInPlace(list));
	}
}

class Person implements Comparable<Person>{
	int height,count;
	
	public Person(int height,int count) {
		this.height = height;
		this.count = count;
	}

	@Override
	public int compareTo(Person o) {
		if(height == o.height) return count-o.count;
		else return o.height-height;
	}
	
	public String toString() {
		return "["+height+","+count+"]";
	}
}