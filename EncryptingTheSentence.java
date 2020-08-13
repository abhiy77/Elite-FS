/* 08/04/2020 - HOME
An English text needs to be encrypted using the following encryption scheme.
First, the spaces are removed from the text. Let L be the length of this text.
Then, characters are written into a grid, whose rows and columns have the following constraints:
	floor(sqrt(L))<=row<=column<=ceil(sqrt(L))

For example, the sentence s="if man was meant to stay on the ground god would have given us roots,
 after removing spaces is 54 characters long.
sqrt(54) is between 7 and 8, so it is written in the form of a grid with 7 rows and 8 columns.

		ifmanwas  
		meanttos          
		tayonthe  
		groundgo  
		dwouldha  
		vegivenu  
		sroots

Ensure that rows * columns >= L
If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. rows * columns.
The encoded message is obtained by displaying the characters in a column, inserting a space, 
and then displaying the next column and inserting a space, and so on. 
For example, the encoded message for the above rectangle is:
	imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
You will be given a message to encode and print.

Input Format:
One line of text, the string S

Output Format
Print the encoded message on one line as described.

Sample Input:
	haveaniceday
Sample Output:
	hae and via ecy
Explanation:
	L=12, sqrt(12) is between 3 and 4.
	Rewritten with 3 rows and 4 columns:
			have
			anic
			eday

Sample Input:
	feedthedog    
Sample Output:
	fto ehg ee dd
Explanation:
	L=10, sqrt(10)  is between 3 and 4.
	Rewritten with  rows and  columns:
		feed
		thed
		og
	

Sample Input:
	chillout
Sample Output:
	clu hlt io
Explanation:
	L=8, sqrt(8)  is between 2 and 3.
	Rewritten with 3 columns and 3 rows (2*3=6 < 8 so we have to use 3*3.)
		chi
		llo
		ut
		
	========= Testcases Program-3 =========
case =1
input =haveaniceday
output ="hae and via ecy"

case =2
input =feedthedog
output ="fto ehg ee dd"

case =3
input =chillout
output ="clu hlt io"

case =4
input =ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots
output ="imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau"


case =5
input =iffactsdontfittotheorychangethefacts
output ="isieae fdtonf fotrga anoyec cttctt tfhhhs"

case =6
input =hxfcbvrqssbjavupuhby
output ="hvbp xrju fqah csvb bsuy"

case =7
input =roqfqeylxuyxjfyqterizzkhgvngapvudnztsxeprfp
output ="rlyzatp oxqkps quthvx fyegue qxrvdp ejinnr yfzgzf"

case =8
input =bgwdyygtmwhtwhusfedckrgybozfjaukgsngqvzftiypqukxypbkghjiwkphkjtsdizueaz
output ="bwdfqujs ghcjvkid wtkazxwi dwrufykz yhgktppu yuygibhe gsbsykka tfonpgjz mezgqht"


*/
package Elite;
import java.util.*;

public class EncryptingTheSentence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine().replace(" ", "");
		int length = sentence.length();
		int low = (int) Math.floor(Math.sqrt(length));
		int high = (int) Math.ceil(Math.sqrt(length));
		while(low * high < length) {
			if(high - low == 0) high++;
			else low++;
		}
		char arr[][] = new char[low][high];
		int row = 0, col = 0;
		for(int i=0;i<sentence.length();i++) {
			if(col == high) {
				col = 0 ; row++;
			}
			arr[row][col] = sentence.charAt(i);
			col++;
		}
		for(int i=0;i<high;i++) {
			for(int j = 0;j<low;j++) {
				if(arr[j][i] != '\u0000') {
					System.out.print(arr[j][i]);
				}
			}
			System.out.print(" ");
		}
	}
}