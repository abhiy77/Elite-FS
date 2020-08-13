/* 11/03/2020
 * Given a number N denoting the number of rows. 
The task is to print the zigzag pattern with N rows as shown in 
the below example.

Note: Based type of 'N' (i.e Priority Order is 1. Prime 2. Even 3. Odd)
Example-1:
Input : 
        6
Output : 
        1 
        3 2 
        4 5 6 
        10 9 8 7 
        11 12 13 14 15
        21 20 19 18 17 16

Example-2:
Input : 
        3
Output : 
        1 
        3 2 
        6 5 4 
        
Example-3:
Input : 
        9
Output : 
        1 
        2 3 
        6 5 4
        7 8 9 10
        15 14 13 12 11
        16 17 18 19 20 21 
        28 27 26 25 24 23 22
        29 30 31 32 33 34 35 36 
        45 44 43 42 41 40 39 38 37

 */
package Elite;
import java.util.*;
public class PrintPattern {
	
	public static boolean isPrime(int n) {
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int elements = 1, num = 1;
		if(n <=0) System.out.println(-1);
		else if(n==1) System.out.println(1);
		else {
			LinkedList<LinkedList<Integer>> list = new LinkedList<>();
			for(int i=1;i<=n;i++) {
				LinkedList<Integer> temp = new LinkedList<>();
				for(int j=0;j<elements;j++) {
					temp.add(num);num++;
				}
			   elements++;
			   list.add(temp);
			}
			if(isPrime(n)) {
				System.out.println(list);
			}
			
			else if(n%2==0) {
				for(int i=1;i<=n;i++) {
					if(i%2 == 0) {
						LinkedList<Integer> temp = list.get(i-1);
						for(int j=temp.size()-1;j>=0;j--) {
							System.out.print(temp.get(j) + " ");
						}
						System.out.println();
					}
					else {
						LinkedList<Integer> temp = list.get(i-1);
						for(int j=0;j<temp.size();j++) {
							System.out.print(temp.get(j) + " ");
						}
						System.out.println();
					}
				}
			}
			else {
				for(int i=1;i<=n;i++) {
					if(i%2 == 1) {
						LinkedList<Integer> temp = list.get(i-1);
						for(int j=temp.size()-1;j>=0;j--) {
							System.out.print(temp.get(j) + " ");
						}
						System.out.println();
					}
					else {
						LinkedList<Integer> temp = list.get(i-1);
						for(int j=0;j<temp.size();j++) {
							System.out.print(temp.get(j) + " ");
						}
						System.out.println();
					}
				}
			}
		}
	}
}