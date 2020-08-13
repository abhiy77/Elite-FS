/* 17/04/2020 - HOME
 * A 10*10 Crossword grid is provided to you, along with a set of words (or names of places) 
which need to be filled into the grid. Cells are marked either + or -. Cells marked 
with a - are to be filled with the word list.

The following shows an example crossword from the input crossword grid and the list of words to fit, :

Input 	   		Output

++++++++++ 		++++++++++
+------+++ 		+POLAND+++
+++-++++++ 		+++H++++++
+++-++++++ 		+++A++++++
+++-----++ 		+++SPAIN++
+++-++-+++ 		+++A++N+++
++++++-+++ 		++++++D+++
++++++-+++ 		++++++I+++
++++++-+++ 		++++++A+++
++++++++++ 		++++++++++

POLAND;LHASA;SPAIN;INDIA

Input Format:
Each of the first 10 lines represents crossword[i], each of which has 10 characters, crossword[i][j].
The last line contains a string consisting of semicolon delimited words[i] to fit.

Output Format:
Position the words appropriately in the 10*10 grid, then return your array of strings for printing.

Sample Input1:
	+-++++++++
	+-++++++++
	+-++++++++
	+-----++++
	+-+++-++++
	+-+++-++++
	+++++-++++
	++------++
	+++++-++++
	+++++-++++
	LONDON;DELHI;ICELAND;ANKARA

Sample Output1:
	+L++++++++
	+O++++++++
	+N++++++++
	+DELHI++++
	+O+++C++++
	+N+++E++++
	+++++L++++
	++ANKARA++
	+++++N++++
	+++++D++++
	
	
Sample Input2:
	+-++++++++
	+-++++++++
	+-------++
	+-++++++++
	+-++++++++
	+------+++
	+-+++-++++
	+++++-++++
	+++++-++++
	++++++++++
	AGRA;NORWAY;ENGLAND;GWALIOR
Sample Output2:
	+E++++++++
	+N++++++++
	+GWALIOR++
	+L++++++++
	+A++++++++
	+NORWAY+++
	+D+++G++++
	+++++R++++
	+++++A++++
	++++++++++


Sample Input3:
	XXXXXX-XXX
	XX------XX
	XXXXXX-XXX
	XXXXXX-XXX
	XXX------X
	XXXXXX-X-X
	XXXXXX-X-X
	XXXXXXXX-X
	XXXXXXXX-X
	XXXXXXXX-X
	ICELAND;MEXICO;PANAMA;ALMATY

Sample Output3:
	XXXXXXIXXX
	XXMEXICOXX
	XXXXXXEXXX
	XXXXXXLXXX
	XXXPANAMAX
	XXXXXXNXLX
	XXXXXXDXMX
	XXXXXXXXAX
	XXXXXXXXTX
	XXXXXXXXYX
	
	
	========= Testcases Program-2 =========
case =1
input =+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
LONDON;DELHI;ICELAND;ANKARA
output =+L++++++++
+O++++++++
+N++++++++
+DELHI++++
+O+++C++++
+N+++E++++
+++++L++++
++ANKARA++
+++++N++++
+++++D++++

case =2
input =+-++++++++
+-++++++++
+-------++
+-++++++++
+-++++++++
+------+++
+-+++-++++
+++++-++++
+++++-++++
++++++++++
AGRA;NORWAY;ENGLAND;GWALIOR
output =+E++++++++
+N++++++++
+GWALIOR++
+L++++++++
+A++++++++
+NORWAY+++
+D+++G++++
+++++R++++
+++++A++++
++++++++++

case =3
input =+-++++++++
+-++-+++++
+-------++
+-++-+++++
+-++-+++++
+-++-+++++
++++-+++++
++++-+++++
++++++++++
----------
CALIFORNIA;NIGERIA;CANADA;TELAVIV
output =+C++++++++
+A++T+++++
+NIGERIA++
+A++L+++++
+D++A+++++
+A++V+++++
++++I+++++
++++V+++++
++++++++++
CALIFORNIA

case =4
input =+-++++++++
+-++-+++++
+-------++
+-++-++-++
+-++-++-++
+-++-++-++
++++-++-++
+--------+
++++++++++
----------
CALIFORNIA;LASVEGAS;NIGERIA;CANADA;TELAVIV;ALASKA
output =+C++++++++
+A++T+++++
+NIGERIA++
+A++L++L++
+D++A++A++
+A++V++S++
++++I++K++
+LASVEGAS+
++++++++++
CALIFORNIA

case =5
input =+-++++++++
+-++++++++
+-------++
+-++++++++
+-----++++
+-+++-++++
+++-----++
+++++-++++
+++++-++++
+++++-++++
SYDNEY;TURKEY;DETROIT;EGYPT;PARIS
output =+S++++++++
+Y++++++++
+DETROIT++
+N++++++++
+EGYPT++++
+Y+++U++++
+++PARIS++
+++++K++++
+++++E++++
+++++Y++++

case =6
input =+----+++++
++++-+++++
++++-+++++
++++------
++++-+++-+
++++-+++-+
++++-+++-+
++++-+++-+
++++-+++++
++++++++++
TREE;ELEPHANTS;PICKLE;LEMON
output =+TREE+++++
++++L+++++
++++E+++++
++++PICKLE
++++H+++E+
++++A+++M+
++++N+++O+
++++T+++N+
++++S+++++
++++++++++

case =7
input =+-++++++++
+-------++
+-++-+++++
+-------++
+-++-++++-
+-++-++++-
+-++------
+++++++++-
++++++++++
++++++++++
ANDAMAN;MANIPUR;ICELAND;ALLEPY;YANGON;PUNE
output =+M++++++++
+ANDAMAN++
+N++L+++++
+ICELAND++
+P++E++++P
+U++P++++U
+R++YANGON
+++++++++E
++++++++++
++++++++++

case =8
input =XXXXXX-XXX
XX------XX
XXXXXX-XXX
XXXXXX-XXX
XXX------X
XXXXXX-X-X
XXXXXX-X-X
XXXXXXXX-X
XXXXXXXX-X
XXXXXXXX-X
ICELAND;MEXICO;PANAMA;ALMATY
output =XXXXXXIXXX
XXMEXICOXX
XXXXXXEXXX
XXXXXXLXXX
XXXPANAMAX
XXXXXXNXLX
XXXXXXDXMX
XXXXXXXXAX
XXXXXXXXTX
XXXXXXXXYX

 */
package Elite;
import java.util.*;
public class CrosswordGridOfWords {
	static char grid[][];
	static HashMap<Integer,ArrayList<StartPoint>>map;
	static List<String> words;
	
	public static boolean fitCrossword(int k) {
		if(k == words.size()) {
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}
			return true;
		}
		
		String word = words.get(k);
		ArrayList<StartPoint> list = map.get(word.length());
		LinkedList<Integer> temp = new LinkedList<>();
		
		for(StartPoint point : list) {
			int x = (point.down ? 1 : 0);
			int y = (point.down ? 0 : 1);
			
			for(int i=0;i<word.length();i++) {
				if(grid[point.x + i * x][point.y + i*y] != '-') {
					if(grid[point.x + i * x][point.y + i*y] != word.charAt(i)) {
						break;
					}
				}
				else {
					grid[point.x + i * x][point.y + i*y] = word.charAt(i);
					temp.add(i);
				}
				if(i == word.length() -1) {
					if(fitCrossword(k+1)) return true;
				}
			}
			for(int num : temp) {
				grid[point.x + num*x][point.y + num*y] = '-';
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		grid = new char[10][10];
		for(int i=0;i<10;i++) {
			grid[i] = sc.nextLine().toCharArray();
		}
		map = new HashMap<>();
		words = Arrays.asList(sc.nextLine().split(";"));
		System.out.println(Arrays.deepToString(grid));
		System.out.println(words);
		for(int y= 0;y<10;y++) {
			for(int x=0;x<10;x++) {
				if(grid[x][y] == '-') {
					if(x == 0 || grid[x-1][y] == '+') {
						StartPoint point = new StartPoint(x, y, true);
						for(int i=x;i<10;i++) {
							if(grid[i][y] == '-') {
								point.length++;
							}
							else break;
						}
						ArrayList<StartPoint> list = map.get(point.length);
						if(list == null) {
							list = new ArrayList<>();
							map.put(point.length, list);
						}
						list.add(point);
					}
					
					if(y == 0 || grid[x][y-1] == '+') {
						StartPoint point = new StartPoint(x, y, false);
						for(int i=y;i<10;i++) {
							if(grid[x][i] == '-') {
								point.length++;
							}
							else break;
						}
						ArrayList<StartPoint> list = map.get(point.length);
						if(list == null) {
							list = new ArrayList<>();
							map.put(point.length, list);
						}
						list.add(point);
					}	
				}
			}
		}
		if(!fitCrossword(0))System.out.println(-1);
	}
}

class StartPoint{
int x,y,length;
boolean down;
	public StartPoint(int x, int y, boolean down) {
		this.x = x;
		this.y = y;
		this.down = down;
	}
}