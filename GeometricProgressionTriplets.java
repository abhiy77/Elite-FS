/* 09/06/2020 - HOME
 *  HACKERRANK - COUNT TRIPLETS
 */
package Elite;
import java.util.*;

public class GeometricProgressionTriplets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long r = sc.nextLong();
		long arr[] = new long[n];
		long ans = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		HashMap<Long,Long> left = new HashMap<>();
		HashMap<Long,Long> right = new HashMap<>();
		for(int i=0;i<n;i++) {
			right.put(arr[i],right.getOrDefault(arr[i], new Long(0)) + 1);
		}
		//System.out.println(right);
		for(int i=0;i<n;i++) {
			//System.out.println(left);
			right.put(arr[i],right.get(arr[i]) - 1);
			if(arr[i] % r == 0) {
				if(left.containsKey(arr[i]/r) && right.containsKey(arr[i] * r)) {
					ans += left.get(arr[i]/r) * right.get(arr[i] * r);
				}
			}
			left.put(arr[i], left.getOrDefault(arr[i], new Long(0)) + 1);
		}
		System.out.println(ans);
	}
}