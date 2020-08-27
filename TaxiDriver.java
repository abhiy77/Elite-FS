/* 27/08/2020 - (ELITE DAY 112)
 * 
 * UBER driver has a vehicle, daily he used go in only one direction.
Capacity of the vehicle is S (no of seats except driver seat), 

Given a list of N bookings, booking[i]= [ num_customers, pickup, drop ].
booking indicates, number of customers to pick up, and pick up, droping points.

Initially the vehicle is empty.

Return true if and only if it is possible to pick up and drop off all customers of all bookings.

Input Format:
-------------
Line-1 -> Two integers N and S, number of bookings and number of seats in the vehicle.
Next N Lines -> three space separated integers, num_customers, pickup point, dropping point

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 5
2 1 5
3 3 7

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 4
2 1 5
3 3 7

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 11
3 2 7
3 7 9
8 3 9

Sample Output-3:
----------------
true

 */
package Elite;
import java.util.*;

public class TaxiDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int max = Integer.MIN_VALUE;
		TaxiInterval arr[] = new TaxiInterval[n];
		for(int i=0;i<n;i++) {
			arr[i] = new TaxiInterval(sc.nextInt(), sc.nextInt(), sc.nextInt());
			max = Math.max(arr[i].end, max);
		}
		int res[] = new int[max+2];
		for(int i=0;i<n;i++) {
			res[arr[i].start] += arr[i].customers;
			res[arr[i].end] -= arr[i].customers;
		}
		System.out.println(Arrays.toString(res));
		for(int i=1;i<res.length;i++) {
			res[i] += res[i-1];
		}
		//System.out.println(Arrays.toString(res));
		int flag = 0;
		for(int i=0;i<res.length;i++) {
			if(res[i] > s) {
				flag = 1;
				break;
			}
		}
		System.out.println(flag == 0 ? "true" : "false");
	}
}

class TaxiInterval{
	int customers,start,end;
	
	TaxiInterval(int customers,int start,int end){
		this.customers = customers;
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "TaxiInterval [customers=" + customers + ", start=" + start + ", end=" + end + "]";
	}
	
}