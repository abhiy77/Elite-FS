/* 06/05/2020 - HOME
 * Input Format:
    - First line contains two Integers N and L, 
      N number of strings and L length of each string
    - Next N lines conatins a string and an integer, 
      where ith line contains string S[i] and value associated V[i]
Output Format:
    - An integer, finally calculated value

Sample Input:
7 3
abb 2
aaa -3
bba -1
zyz -4
abb 5
aaa 7
xyx 4

Sample Output:
12

 */
package Elite;
import java.util.*;
public class LargestScorePalindromicString {
	
	public static boolean isPalindrome(String str) {
		int i=0,j = str.length()-1;
		while(i < j) {
			if(str.charAt(i++) != str.charAt(j--)) return false;
		}
		return true;
	}
	
	public static String reverse(String str) {
		return new StringBuffer(str).reverse().toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String temp="";
		int tempScore = 0;
		HashMap<String,PriorityQueue<Integer>> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			String str = sc.next();
			int score = sc.nextInt();
			if(isPalindrome(str)) {
				if(!temp.equals(str) && score > tempScore || temp.equals("")) {
					temp = str;
					tempScore = score;
				}
				else if(temp.equals(str) && score > 0) {
					temp = "";
					tempScore = 0;
				}	
			}
			if(!map.containsKey(str)) {
				PriorityQueue<Integer> queue = new PriorityQueue<>((x,y) -> (y-x));
				map.put(str, queue);
			}
			map.get(str).offer(score);
		}
		if(!temp.equals(""))map.remove(temp);
		int result = (temp.isEmpty() ? 0 : tempScore);
		while(true) {
			System.out.println(map);
			int flag = 0;
			for(Map.Entry<String, PriorityQueue<Integer>> entry : map.entrySet()) {
				String key = entry.getKey();
				if(isPalindrome(key)) {
					PriorityQueue<Integer> queue1 = map.get(key);
					while(queue1.size() >= 2) {
						int x = queue1.poll();
						int y = queue1.poll();
						if(x + y < 0) break;
						else {
							flag = 1;
							result += x+y;
						}
					}
				}
				else if(map.containsKey(reverse(key))) {
					PriorityQueue<Integer> queue1 = map.get(key);
					PriorityQueue<Integer> queue2 = map.get(reverse(key));
					while(!queue1.isEmpty() && !queue2.isEmpty()) {
						int diff = queue1.poll() + queue2.poll();
						if(diff < 0) break;
						else {
							flag = 1;
							result += diff;
						}
					}
				}
			}
			if(flag == 0) break;
		}
		System.out.println(map);
		System.out.println(result);
	}
}