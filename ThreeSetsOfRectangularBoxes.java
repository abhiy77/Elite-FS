/* 20/03/2020 - HOME
 * You have three SETs of Rectangular Boxes where each Rectangular Box has the same length and width, 
but they may vary in height. In each SET, Rectangular Box is placed one on another
You can change the height of a SET by removing its topmost Rectangular Box any number of times.

Find the maximum possible height of the SETs such that all of the SETs are exactly the same height. 
This means you must remove zero or more Rectangular Boxes from 
the top of zero or more of the three SETs until they're all the same height, then print the height. 
The removals must be performed in such a way as to maximize the height.

Note: An empty SET is still a SET.

Input Format :
The first line contains three space-separated integers n1, n2, and n3, describing the respective number of Rectangular Boxs in SETs 1, 2 and 3. 
The subsequent lines describe the respective heights of each Rectangular Box in a SET from top to bottom:
The second line contains n1  space-separated integers describing the Rectangular Box heights in SET . 
The third line contains  n2 space-separated integers describing the Rectangular Box heights in SET . 
The fourth line contains  n3 space-separated integers describing the Rectangular Box heights in SET . 

Note: In each line The first element is the top of the SET, 
second element will be below the first and so on.

Sample Input
------------
5 3 4
3 2 1 1 1
4 3 2
1 1 4 1

Sample Output
-------------
5

 */
package Elite;
import java.util.*;
import java.util.stream.Collectors;
public class ThreeSetsOfRectangularBoxes{
	
		public static List<Integer> cumulativeSum(List<Integer> list){
			List<Integer> temp = new LinkedList<>();
			temp.add(list.get(list.size()-1));
			for(int i = list.size()-2;i>=0;i--) {
				temp.add(list.get(i) + temp.get(temp.size()-1));
			}
			Collections.reverse(temp);
			return temp;
		}
	
	
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		sc.nextLine();
		List<Integer> temp1 = cumulativeSum(Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList()));
		List<Integer> temp2 = cumulativeSum(Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList()));
		List<Integer> temp3 = cumulativeSum(Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList()));
		HashSet<Integer> set1 = new HashSet<>(temp1);
		HashSet<Integer> set2 = new HashSet<>(temp2);
		HashSet<Integer> set3 = new HashSet<>(temp3);
		set1.retainAll(set2);
		set1.retainAll(set3);
		System.out.println(set1.isEmpty() ? "0" :Collections.max(set1));
	}
}