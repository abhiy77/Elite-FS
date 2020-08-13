//31/01/2020
package Elite;
import java.util.*;
public class ContiguousSubArrayBitwiseOr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer :: parseInt).toArray();
		Set<Integer> result = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        curr.add(0);
        for(int x : arr){
            Set<Integer> temp = new HashSet<>();
            for(int y : curr){
                temp.add(x|y);
            }
            temp.add(x);
            curr = temp;
            result.addAll(curr);
        }
        System.out.println(result.size());
	}
}