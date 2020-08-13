/* 27/02/2020
 * Write a program to print all permutations of a given string

Example-1:
    Input=  ABC
    Output= ABC ACB BAC BCA CBA CAB

Example-2:
    Input=  aaa                                                                                                                     
    Output= aaa aaa aaa aaa aaa aaa                                                                                                 
   
Note:
input String contains [A-Za-z]
print output in lexicographic order
 */
package Elite;
import java.util.*;

class AllPermutations{
 
    public static LinkedList<String> findPermutations(String str){
    	if(str.length() == 2) {
    		LinkedList<String> temp = new LinkedList<>();
    		temp.add(str);  temp.add(""+str.charAt(1)+str.charAt(0));
    		System.out.println(temp);
    		return temp;
    	}
    	LinkedList<String> temp = findPermutations(str.substring(1));
    	LinkedList<String> list = new LinkedList<>();
    	for(int i=0;i<temp.size();i++) {
    		for(int j=0;j<temp.get(i).length();j++) {
    			System.out.println(temp.get(i).substring(0,j)+str.charAt(0)+ temp.get(i).substring(j));
        		list.add(temp.get(i).substring(0,j)+str.charAt(0)+ temp.get(i).substring(j));
    		}
    		list.add(temp.get(i)+str.charAt(0));
    	}
    	return list;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(findPermutations(str));
    }
}