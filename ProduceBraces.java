package Elite;

/*
 * 
 * 
 * 
 * 
 * 

 Write a Program to print all the combinations of  well-formed braces form the given no of
 pairs of braces.
 
 Note: Print List in Sorted Order(Ascending)
 
 input :2
Output: [{{}},{}{}]


 */

import java.util.*;

public class ProduceBraces {

	    public static void generateBraces(LinkedList<String> list, int open,int close,int max,String curr) {
	      if(curr.length() == 2*max){
	          list.add(curr);
	          return;
	      }
	      if(open < max){
            generateBraces(list,open+1,close,max,curr+"A");
        }
        if(close < open){
            generateBraces(list,open,close+1,max,curr+"B");
        }
	      
	    }
	    public static void main(String args[] ) {
			 Scanner sc = new Scanner(System.in);
				int n=Integer.parseInt(sc.next());
                LinkedList<String> list = new LinkedList<>();
			    generateBraces(list,0,0,n,"");
			    System.out.println(list);
		}	
}