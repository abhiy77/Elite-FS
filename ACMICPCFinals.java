/* 09/04/2020 - HOME
 * There are a number of people who will be attending ACM-ICPC World Finals. 
Each of them may be well versed in a number of topics. 

Given a list of topics known by each attendee, 
you must determine the maximum number of topics a 2-person team can know. 
Also find out how many ways a team can be formed to know that many topics.
Lists will be in the form of bit strings, where each string represents an attendee and 
each position in that string represents a field of knowledge, 1 if its a known field or 0 if not.

For example, given three attendees' data as follows:
	10101
	11110
	00010

These are all possible teams that can be formed:
Members 	Subjects
(1,2)   	[1,2,3,4,5]
(1,3)   	[1,3,4,5]
(2,3)   	[1,2,3,4]
In this case, the first team will know all 5 subjects. 
They are the only team that can be created knowing that many subjects.

Input Format:
	- The first line contains two space-separated integers n and m, 
	where n represents the number of attendees and m represents the number of topics.

	- Each of the next n lines contains a binary string of length m. 
	If the 'i'th line's 'j'th character is 1, then the 'i'th person knows the 'j'th topic.

Output Format
	- On the first line, print the maximum number of topics a 2-person team can know.
	- On the second line, print the number of ways to form a 2-person team that knows 
	the maximum number of topics.

Sample Input
	4 5
	10101
	11100
	11010
	00101
Sample Output
	5 2
Explanation
Calculating topics known for all permutations of 2 attendees we get:
    (1,2) --> 4
    (1,3) --> 5
    (1,4) --> 3
    (2,3) --> 4
    (2,4) --> 4
    (3,4) --> 5
The 2 teams (1, 3) and (3, 4) know all 5 topics which is maximal.

                -------------Testcases 2 ---------------
case =1
input =4 5
10101
11100
11010
00101
output =5 2

case =2
input =6 5
11101
10101
11001
10111
10000
01110
output =5 6

case =3
input =6 7
1101010
1010111
1100010
1011110
1000001
0111101
output =7 5

case =4
input =8 7
1101010
1010111
1100010
1011110
1000001
0111101
0101010
1010101
output =7 8

case =5
input =10 10
1011101010
0101010110
1010101010
1110010001
1010101110
0001001010
1001010101
0001010100
1111010101
0101001001
output =10 3

case =6
input =10 14
10111010110100
01010110100110
10101011101010
10001110010001
10101011100101
00010010101010
10010101000101
00010101001110
11110100101101
01010100101001
output =13 1

case =7
input =10 10
1111011110
1010111011
0110110111
0111011011
0111101111
0111101110
0010101010
1110111010
1010011011
0011011011
output =10 8

case =8
input =8 12
101110101100
010101101110
101010111010
100011010001
101011100101
000110101010
100101000101
000101010110
output =11 4
 */
package Elite;
import java.util.*;
public class ACMICPCFinals {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		String arr[] = new String[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLine();
		}
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				int count = 0;
				String str1 = arr[i];
				String str2 = arr[j];
				for(int k=0;k<str1.length();k++) {
					if(str1.charAt(k) == '1' || str2.charAt(k) == '1') count++;
				}
				map.put(count, map.getOrDefault(count, 0) + 1);
			}
		}
		Map.Entry<Integer, Integer> entry = map.pollLastEntry();
		System.out.println(entry.getKey() + " " + entry.getValue());
	}
}