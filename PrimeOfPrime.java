/* 25/06/2020 - HOME
 * A number is said to be Prime Of Prime if it has only 2,3 or 5 as its prime factors
 * Given an integer n , find the nth prime of prime;
 * Note : 1 is a Prime of Prime
 * 
 */
package Elite;
import java.util.*;
public class PrimeOfPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if( n > 2000)System.out.println("Not valid");
		else if(n == 1)System.out.println(1);
		int i = 0, j = 0 , k = 0;
		List<Long> list = new LinkedList<>();
		list.add((long)1);
		n--;
		while(n > 0) {
			long num = Math.min(list.get(i) * 2,Math.min(list.get(j) * 3,list.get(k) * 5));
			if(num == list.get(i) * 2) i++;
			else if(num == list.get(j) * 3) j++;
			else if(num == list.get(k) * 5)k++;
			if(!list.contains(num)) {
				list.add(num);
				n--;
			}
		}
		System.out.println(list.get(list.size()-1));
	}
}