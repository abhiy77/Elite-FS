/* 11/07/2020 - HOME
 * Input Format:
-------------
Line-1 -> contains a Word W
Line-2 -> Space seperated Words, WordArray[]

Output Format:
--------------
Print a String in the specified format


Sample Input-1:
---------------
abcdefghijklmno
abc fghij mn

Sample Output-1:
----------------
<i>abc</i>de<i>fghij</i>kl<i>mn</i>o



Sample Input-2:
---------------
abcdefghijk
abc def fghij

Sample Output-2:
----------------
<i>abcdefghij</i>k
 */
package Elite;
import java.util.*;

public class ImportantWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String words[] = sc.nextLine().split(" ");
		List<IntervalWord> intervals = new LinkedList<>();
		for(int i=0;i<words.length;i++) {
			int j = 0;
			while(str.indexOf(words[i],j) != -1 && j < str.length()) {
				int index = str.indexOf(words[i], j);
				intervals.add(new IntervalWord(index,index+words[i].length()-1));
				j = index+words[i].length()+1;
			}
		}
		intervals.add(new IntervalWord(intervals.get(intervals.size()-1).end+1,str.length()));
		//System.out.println(intervals);
		Collections.sort(intervals);
		int n = intervals.size();
		int j = 0;
		for(int i=0;i<n-1;i++) {
			if(intervals.get(i).end < intervals.get(i+1).start) {
				intervals.set(j, intervals.get(i));
				j++;
			}
			else if(intervals.get(i).end >= intervals.get(i+1).start) {
				intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
				intervals.set(j, intervals.get(i));
				i++;
				j++;
			}
		}
		//System.out.println(intervals + ""+j);
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0,intervals.get(0).start));
		for(int i=0;i<j;i++) {
			IntervalWord interval = intervals.get(i);
			sb.append("<i>"+str.substring(interval.start,interval.end+1)+"</i>");
			if (i != j-1)sb.append(str.substring(interval.end+1,intervals.get(i+1).start));
		}
		sb.append(str.substring(intervals.get(j-1).end+1));
		System.out.println(sb.toString().replaceAll("</i><i>",""));
	}
}

class IntervalWord implements Comparable<IntervalWord>{
	int start,end;

	public IntervalWord(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(IntervalWord o) {
		if(this.end == o.end) {
			return this.start - o.start;
		}
		else return this.end - o.end;
	}

	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}
}
