/* 18/06/2020 - HOME
 * Input Format:
Line-1 -> An integer N, the number of pairs in the array .
Next N lines -> contains integer and string, the integers with their associated strings.

Output Format:
--------------
Print the strings in their correct order, space-separated on one line


Sample Input-2:
---------------
4
0 a
1 b
0 c
1 d
Sample output-2:
----------------
- c - d


Sample Input-2:
---------------
9
2 our
3 college 
4 name
5 is
1 keshav
2 memorial
3 institute
4 of
5 technology

Sample Output-2:
----------------
keshav - memorial - institute - of - technology



 */
package Elite;
import java.util.*;

public class StableSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		TreeMap<Integer,List<Item12>> map = new TreeMap<>();
		for(int i=0;i<n;i++) {
			String str[] = sc.nextLine().split(" ");
			int num = Integer.parseInt(str[0]);
			String temp = str[1];
			if(!map.containsKey(num)) {
				map.put(num, new LinkedList<>());
			}
			map.get(num).add(new Item12(temp,(i<n/2 ? true : false)));
		}
		for(Map.Entry<Integer, List<Item12>> entry : map.entrySet()) {
			int num = entry.getKey();
			List<Item12> list = entry.getValue();
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i).topHalf ? "- " : list.get(i).str + " ");
			}
		}
	}
}

class Item12{
	boolean topHalf;
	String str;
	Item12(String str,boolean topHalf){
		this.str = str;
		this.topHalf = topHalf;
	}
}
