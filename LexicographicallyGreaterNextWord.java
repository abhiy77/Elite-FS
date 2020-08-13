/* 09/04/2020 - HOME
 * Lexicographical order is often known as alphabetical order when dealing with strings. 
A string is greater than another string if it comes later in a lexicographically sorted list.

Given a word, create a new word by swapping some or all of its characters. 
This new word must meet two criteria:
	- It must be greater than the original word
	- It must be the smallest word that meets the first condition
For example, given the word "abcd", the next largest word is "abdc".

Input Format:
    The first line of input contains a string (without spaces and contains lowercase alphabets).
Output Format:
    For each test case, output the string meeting the criteria. 
    If no answer exists, print "no answer".

Sample Input :
	dhck
Sample Output :
	dhkc
Explanation :
	dhkc is the next string greater than dhck.

Sample Input:
	fedcbabcd
Sample Output:
	fedcbabdc
	
	----------------Testcases  - 3     ------------
case =1
input =dhck
output ="dhkc"

case =2
input =fedcbabcd
output ="fedcbabdc"

case =3
input =zyyyvvvvvuttsrqqokjjheedccb
output ="no answer"

case =4
input =chntqzcpvrhvzvpywuhxombxcsjlpsergz
output ="chntqzcpvrhvzvpywuhxombxcsjlpserzg"

case =5
input =bvulomthrfugqfbaknxginokekuemgb
output ="bvulomthrfugqfbaknxginokekugbem"

case =6
input =phoatpygffol
output ="phoatpygflfo"

case =7
input =dkuwfemegcc
output ="dkuwfemgcce"

case =8
input =bdmkhyleclldykvysxkfttkipzdmkexxhmdtdabxjzuxgyvlzyhebe
output ="bdmkhyleclldykvysxkfttkipzdmkexxhmdtdabxjzuxgyvlzyheeb"

 */
package Elite;
import java.util.*;
public class LexicographicallyGreaterNextWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char word[] = sc.nextLine().toCharArray();
		int n = word.length;
		for(int i=n-1;i>=1;i--) {
			if(word[i] > word[i-1]) {
				char min = 'z';
				int index = i;
				for(int j=i;j<n;j++) {
					if(word[j] > word[i-1] && word[j] < min) {
						min = word[j]; index = j;
					}
				}
				char temp = word[i-1];
				word[i-1] = word[index];
				word[index] = temp;
				Arrays.sort(word, i, n);
				for(int j=0;j<n;j++) {
					System.out.print(word[j]);
				}
				System.exit(1);
			}
		}
		System.out.println("no answer");
	}
}