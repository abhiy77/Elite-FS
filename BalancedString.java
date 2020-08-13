/* 20/06/2020 - HOME
 * LEETCODE - BALANCED STRING
 */
package Elite;
import java.util.*;

public class BalancedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char arr[] = sc.nextLine().toCharArray();
		HashMap<Character,Integer> map = new HashMap<>();
		map.put('A',0);  map.put('B', 0);   map.put('C', 0);  map.put('D',0);
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], map.get(arr[i]) + 1);
		}
		int len = arr.length/4;
		int minSize = n;
		int start = 0;
		for(int i = 0; i < arr.length;i++) {
			char c = arr[i];
			map.put(c, map.get(c) -1 );
			
			while(len >= map.get('A') && len >= map.get('B') && len >= map.get('C') && len >= map.get('D') && start < n) {
				minSize = Math.min(minSize, i - start +1);
                char temp = arr[start];
                map.put(temp, map.get(temp)+1);
                start++;
			}
		}
		System.out.println(minSize);
	}
}