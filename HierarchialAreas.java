// 17/01/2020
package Elite;
import java.util.*;
public class HierarchialAreas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		HashMap<String,HashSet<String>> areas = new HashMap<>();
		for(int i=0;i<num;i++) {
			String str[] = sc.nextLine().split("-");	
			
			if(areas.containsKey(str[0])) {
				HashSet<String> set = areas.get(str[0]);
				for(int j=1;j<str.length;j++) {
					set.add(str[j]);
				}
				areas.put(str[0], set);
			}

			else {
				HashSet<String> set = new HashSet<>();
				for(int j=1;j<str.length;j++) {
					set.add(str[j]);
				}
				areas.put(str[0], set);
			}
		}
		
		for(Map.Entry<String, HashSet<String>> entry : areas.entrySet()) {
	    	   String str = entry.getKey();
	           HashSet<String> set = entry.getValue();
	           for(String s : set){
	        	   if(areas.containsKey(s)) {
	        		   HashSet<String> set2 = areas.get(s);
	        		   set2.addAll(set);
	        		   areas.put(str,set2);
	        	   }   
	           }
		}
       String area1 = sc.nextLine().trim();
       String area2 = sc.nextLine().trim();
       
       String smallest = null;
       for(Map.Entry<String, HashSet<String>> entry : areas.entrySet()) {
    	   String str = entry.getKey();
    	   if(areas.get(str).contains(area1) && areas.get(str).contains(area2)) {
    		   if(smallest == null || areas.get(smallest).contains(str)) {
    			   smallest = str;
    		   }
    	   }
       }
       System.out.println(smallest);
	}
}