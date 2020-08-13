/* 06/01/2020
 * Given a string 'S' represents a format.

In the given format, Each letter in the word has 1 or more options.  
If there is one option, the letter is represented as it is.  
If there is more than one option, then curly braces delimit the options.  

-> For example, {a,b,c} represents options a, b, c.
-> For example, {a,b}c{d,e} represents the list acd, ace, bcd, bce

Return all words that can be formed in this manner, in lexicographical order.

Example 1:
		input=	{b}c{e,g}k
		output=	bcek bcgk

Example 2:
		input=	{b,a}{d,c}
		output=	ac ad bc bd

Example 3:
		input=	{xyz}a{c,b}
		output= xyzab xyzac

 */
package Elite;
import java.util.*;
public class RecursiveLexicographicOrder {
	
	public static void recurse(String str,PriorityQueue<String> list,int i,String x) {
		
		if(i == str.length()) {
			list.add(x);	
		}
		else if(str.charAt(i) == '{') {
			i++;
		    LinkedList<String> temp = new LinkedList<>();
		    while(str.charAt(i) != '}') {
	    			StringBuilder sb = new StringBuilder();
		    		while(str.charAt(i) != ',' && str.charAt(i) != '}') {
		    			sb.append(str.charAt(i));  i++;
		    		}
		    		if(str.charAt(i) == ',') {
		    			temp.add(sb.toString());
		    		}
		    		else if(str.charAt(i) == '}') {
		    			temp.add(sb.toString()); break;
		    		}
		    	i++;
		    }
		    i++;
		    for(int j=0;j<temp.size();j++) {
		    	recurse(str, list, i,x+temp.get(j));
		    }
		}
		else {
			recurse(str, list, i+1,x+str.charAt(i));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		PriorityQueue<String> list = new PriorityQueue<>();
        recurse(str,list,0,"");
        while(!list.isEmpty()) {
        	System.out.print(list.poll() + " ");
        }   
	}
}