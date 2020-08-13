/* 28/04/2020 - HOME
 * Consider a string, S, of n lowercase English letters where each character, 
Si denotes the letter at index i in S. 
We define an (a,b,c,d) palindromic tuple of S to be a sequence of indices
in S satisfying the following criteria:
	-Sa=Sd, meaning the characters located at indices a and d are the same.
	-Sb=Sc, meaning the characters located at indices b and c are the same.
	-a, b, c, and d are ascending in value and are valid indices within string .
Given S, find and print the number of (a,b,c,d) tuples satisfying the above conditions. 

Input Format:
	-A single string denoting S.
NOTE: It is guaranteed that  only contains lowercase English letters.

Output Format:
	-Print the the number of (a,b,c,d) tuples satisfying the given conditions. 
	As this value can be quite large, print it modulo 1000000007.

Sample Input1:
kkkkkkz
Sample Output1:
15

Explanation1:
The letter z will not be part of a valid tuple because you need
at least two of the same character to satisfy the conditions defined above. 
Because all tuples consisting of four k's are valid, 
we just need to find the number of ways that we can choose four of the six k's. 
This means our answer is 6P4 mod 1000000007=15.

Sample Input2:
ghhggh
Sample Output2:
4

Explanation2:
The valid tuples are: (0,1,2,3), (0,1,2,4), (1,3,4,5), (2,3,4,5)
Thus, our answer is 4.

Sample Input3:
akakak
Sample Output3:
2

Explanation3:
Tuples possible are (1,2,4,5) and (0,1,3,4) 

========= Testcases Program-3 =========
case =1
input =akakak
output =2

case =2
input =ghhggh
output =4

case =3
input =kkkkkkz
output =15

case =4
input =abbabababba
output =72

case =5
input =nnnnkkkknnnnnkkkkkk
output =696

case =6
input =redivider
output =6

case =7
input =transmission
output =5

case =8
input =qwertywertyertyrty
output =42
 */
package Elite;
import java.util.*;
public class ValidStringTuples {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = str.length();
		int tuples =0;
		for(int i=0;i<n-3;i++) {
			int j = i+3;
			while(j < n) {
				if(str.charAt(i) == str.charAt(j)) {
					for(int k=i+1;k<=j-1;k++) {
						int l = k+1;
						while(l < j) {
							if(str.charAt(k) == str.charAt(l)) {
								//System.out.println(i + " " + k + " " + l + " " + j);
								tuples++;
							}
							l++;
						}
					}
				}
				j++;
			}
		}
		System.out.println(tuples);
	}
}