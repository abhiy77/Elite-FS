package Elite;
import java.util.*;
import java.util.stream.Collectors;
public class LongestSubstringWIth2DifferentCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int count=0,max = Integer.MIN_VALUE;
		HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<str.length();i++) {
            System.out.println(map);
        	if(map.size() < 2) {
        		map.put(str.charAt(i), i);
        		count++;
        	}
        	else if(map.containsKey(str.charAt(i))) {
        		map.put(str.charAt(i),i);
        		count++;
        	}
        	else {
        		int min = Collections.min(map.values());
        		Character c = null;
        	    for(Map.Entry<Character, Integer> entry : map.entrySet()) {
        	    	if(entry.getValue() == min) {
        	    		 c = entry.getKey();
        	    	}
        	    }
        	    map.remove(c);
        	    map.put(str.charAt(i), i);
        	    max = Math.max(max, count);
        	    count =0;
        	    i = min;
        	} 	
        }
       System.out.println(Math.max(count, max));
	}
}