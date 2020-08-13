// 23/01/2020
package Elite;
import java.util.*;

public class NewLanguage {
	
	    public static LinkedHashSet<Character> findRank(HashMap<Character,Integer> rank) {
	    	LinkedHashSet<Character> set = new LinkedHashSet<>();
	    	for(Map.Entry<Character, Integer> entry : rank.entrySet()) {
	    		if(entry.getValue() == 0) {
	    			set.add(entry.getKey());
	    		}
	    	}
	    	return set;
	    }
        public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String str[] = sc.nextLine().split(" ");
			HashMap<Character,LinkedHashSet<Character>> link = new HashMap<>();
			HashMap<Character,Integer> rank = new HashMap<>();
			for(int i=0;i<str.length-1;i++) {
				int j=0,k=0;
				while(j < str[i].length() && k <str[i+1].length()) {
					if(!rank.containsKey(str[i].charAt(j))) {
						rank.put(str[i].charAt(j), 0);
					}
					if(!rank.containsKey(str[i+1].charAt(k))) {
						rank.put(str[i+1].charAt(k), 0);
					}
					if(str[i].charAt(j) != str[i+1].charAt(k)) {
						if(link.containsKey(str[i+1].charAt(k)) && link.get(str[i+1].charAt(k)).contains(str[i].charAt(j))) {
							System.out.println(-1);
							System.exit(-1);
						}
						else {
							
							if(link.containsKey(str[i].charAt(j))) {
								if(!link.get(str[i].charAt(j)).contains(str[i+1].charAt(k))) {
									LinkedHashSet<Character>set = link.get(str[i].charAt(j));
									set.add(str[i+1].charAt(k));
									link.put(str[i].charAt(j),set);
									rank.put(str[i+1].charAt(k), rank.get(str[i+1].charAt(k)) +1);
								}				

							}
							else {
								LinkedHashSet<Character> set = new LinkedHashSet<>();
								set.add(str[i+1].charAt(k));
								link.put(str[i].charAt(j),set);
								rank.put(str[i+1].charAt(k), rank.get(str[i+1].charAt(k)) +1);
							}
						}
					}
					j++; k++;
				}
			}
			
			LinkedHashSet<Character> set = findRank(rank);
			if(set.isEmpty()) {
				System.out.println(-1);
				System.exit(-1);
			}
			System.out.println(link);
			System.out.println(rank);
			Queue<Character> queue = new LinkedList<Character>();
			queue.addAll(set);
			set.clear();
			StringBuffer sb = new StringBuffer();
			while(!queue.isEmpty()) {
				System.out.println(queue);
				char c = queue.poll();
				rank.put(c,-1);
				if(!sb.toString().contains(""+c))sb.append(""+c);
				if(!link.containsKey(c)) {
					break;
				}
				LinkedHashSet<Character> temp = link.get(c);
				for(Character ch : temp) {
					rank.put(ch, rank.get(ch)-1);
					if(rank.get(ch) == 0) {
						queue.add(ch);
					}
				}
			}
			while(!queue.isEmpty()) {
				char c = queue.poll();
				if(!sb.toString().contains(""+c))sb.append(""+c);
			}
			System.out.println(sb.toString());
		}
	}

/*public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String str[] = sc.nextLine().split(" ");
    LinkedHashMap<Character,LinkedList<Character>> adjList = new LinkedHashMap<>();
    HashMap<Character,Integer> rank = new HashMap<>();
	for(int i=0;i<str.length;i++) {
		String s = str[i];
		for(int j=0;j<s.length()-1;j++) {
			if(!rank.containsKey(s.charAt(j))) {
				rank.put(s.charAt(j), 0);
			}
			if(!rank.containsKey(s.charAt(j+1))) {
				rank.put(s.charAt(j+1), 0);
			}
			if(s.charAt(j) == s.charAt(j+1)) {
				continue;
			}
			if(adjList.isEmpty() || !adjList.containsKey(s.charAt(j))) {
				LinkedList<Character> list = new LinkedList<>();
				list.add(s.charAt(j+1));
				adjList.put(s.charAt(j), list);
				
			}
			else {
				LinkedList<Character> list = adjList.get(s.charAt(j));
				list.add(s.charAt(j+1));
				adjList.put(s.charAt(j), list);
			}
			rank.put(s.charAt(j+1), rank.get(s.charAt(j+1)) + 1);
		}	
	}
	
	
	System.out.println(rank);
	System.out.println(adjList);*/