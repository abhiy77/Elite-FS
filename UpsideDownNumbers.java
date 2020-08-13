/* 02/07/2020 - HOME
 * REFERENCE - STROBOGRAMMATIC NUMBER GEEKS FOR GEEKS
 */
package Elite;
import java.util.*;
public class UpsideDownNumbers {
	
	public static List<String> getUpsideDowns(int n,int len) {
		if(n == 0) return new LinkedList<String>();
		else if(n == 1) {
			List<String> temp = new LinkedList<>();
			temp.add("0"); temp.add("1"); temp.add("8");
			return temp;
		}
		if(len > 2 && n == 2) {
			List<String> temp = new LinkedList<>();
			temp.add("00"); temp.add("11"); temp.add("88"); temp.add("69"); temp.add("96");
			return temp;
		}
		List<String> nums = getUpsideDowns(n-2,len);
		List<String> ans = new LinkedList<>();
		for(String elem : nums) {
			if(n != len) ans.add("0" + elem + "0");
			ans.add("1" + elem + "1");
			ans.add("6" + elem + "9");
			ans.add("8" + elem + "8");
			ans.add("9" + elem + "6");
		}
		if(nums.isEmpty()) {
			ans.add("11"); ans.add("69"); ans.add("88"); ans.add("96");
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> list = getUpsideDowns(n,n);
		Collections.sort(list);
		System.out.println(list);
	}
}