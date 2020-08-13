/* 02/03/2020
 * 
Write a Program to find the common string(s) of 2 arrays of strings.
 

Input:ram Laxman krishna
ram Seetha raju

Output: ram

Explanation :
First line of input represents strings(without space) array 1
Second line of input represents strings(without space) array 2
output is common strings between two array i.e ram.
length of 2 arrays of strings can be different also.

print in lexographic order.
 */
package Elite;
import java.util.*;
public class IntersectionOfTwoLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list1 = Arrays.asList(sc.nextLine().split(" "));
		List<String> list2 = Arrays.asList(sc.nextLine().split(" "));
		LinkedList<String> output = new LinkedList<>(); 
		Collections.sort(list1); Collections.sort(list2);
		int i=0,j=0;
		while(i < list1.size() && j<list2.size()) {
			if(list1.get(i).equals(list2.get(j))) {
				output.add(list1.get(i));
				i++; j++;
			}
			else if(list1.get(i).compareTo(list2.get(j)) > 1) {
				j++;
			}
			else i++;
		}
		System.out.println(output);
	}
}