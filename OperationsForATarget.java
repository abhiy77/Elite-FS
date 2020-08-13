/* 23/03/2020 - HOME
 * You have 4 cards each containing a number from 1 to 99. 
You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 1729.

Example 1:
Input: 85 19 10 20
Output: true
Explanation: (85*20) + (19+10) = 1729

Example 2:
Input: 17 99 21 2
Output: false


Note:
You cannot concatenate numbers together. For example, if the input is [17, 10, 1, 9], 
we cannot write this as 1710+19.

 */
package Elite;
import java.util.*;
public class OperationsForATarget {
	
	public static boolean findCombination(int[] arr,char[] operations,int sum,boolean[] visited) {
		if(sum == 1729) {
			return true;
		}
		for(int i=0;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				for(int j=0;j<operations.length;j++) {
					if(findCombination(arr, operations,operation(operations,operations[j],sum,arr[i]) , visited)) return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}
	
	public static int operation(char[] operations,char c,int x,int y) {
		switch(c) {
			case '+': return x+y;
			case '-': return x-y;
			case '*': return x*y;
			case '/': return x/y;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		char operations[] = {'+','-','*','/'};
		boolean visited[] = new boolean[arr.length];
		for(int i=0;i<arr.length;i++) {
			visited[i] = true;
			if(findCombination(arr,operations,arr[i],visited)) {
				System.out.println(true);
				System.exit(1);
			}
			visited[i] = false;
		}
		System.out.println(false);
	}
}