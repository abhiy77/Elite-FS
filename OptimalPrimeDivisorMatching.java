/* 24/03/2020 - HOME
 * Mr. Abby loves his new friend jadu.Jadu has come from different planet.
As Jadu is not fit for our planet Earth,he is destined to go. 
But jadu agrees to be on planet Earth if Mr.Abby solves one of this mysterious problem 
which he has been pondering over from a long time. So jadu seeks your help!!

You are given N and M,where N is the size of the array. 
S is a set of elements from 1 to M. You need to assign/match each number of an array to 
any one of its distinct prime divisors and the corresponding prime divisor must be present 
in the set S. Once assigned/matched,the corresponding prime divisor gets deleted from the set 
automatically. You have to find the optimal assignment/matching such as to maximize 
the count of numbers assigned/matched
Input Format:
-------------
First line contains N and M.
Next line follows N integers which implies elements of an array.

Output Format:
--------------
Print the maximum matching possible as explained.


Sample Input:
    4 10
    10 60 40 55

Sample Output:
    3

Explanation:
    Here N=4,M=10.
    S = {1,2,3,4,5,6,7,8,9,10}
    Lets find prime divisors first.
    For 10 = {2,5},
    60 = {2,3,5},
    40 = {2,5},
    55 = {5}.
    One of the optimal matching is 2 for 10,3 for 60 and 5 for 40. 
    
Sample Input:
    5 15
    65 72 343 56 712
Sample Output:
    4
Explanation:
    Here N=5,M=15.
    S = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}
    Lets find prime divisors first.
    For 65 = {5,13},
    72 = {2,3},
    343 = {7},
    56 = {2,7},
    712 = {2,89}
    One of the optimal matching is 5 for 65,3 for 72, 7 for 343 and 2 for 56. 

 */
package Elite;
import java.util.*;
public class OptimalPrimeDivisorMatching {
	
	public static boolean isPrime(int i) {
		if(i <=1 ) return false;
		for(int j=2;j<=Math.sqrt(i);j++) {
			if(i%j == 0) return false;
		}
		return true;
	}

	public static LinkedList<Integer> getPrimeDivisors(int num,int range) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1;i<=range;i++) {
			if(isPrime(i) && num% i == 0) list.add(i);
		}
		return list;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Integer arr[] = new Integer[n];
		int count = 0;
		HashMap<Integer,LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
		for(int i=0;i<n;i++) { 
			int x = sc.nextInt();  
			arr[i] = x;                
			map.put(x, getPrimeDivisors(x,m));
		}
		Arrays.sort(arr);
		System.out.println(map);
		boolean visited[] = new boolean[m+1];
		for(int i=0;i<arr.length;i++) {
        	LinkedList<Integer> list = map.get(arr[i]);
        	Collections.sort(list,Collections.reverseOrder());
        	for(int j=0;j<list.size();j++) {          
        		if(!visited[list.get(j)]) {        
        			visited[list.get(j)] = true;  count++;
        		    break;
        		}
        	}
        }
		System.out.println(count);
	}
}