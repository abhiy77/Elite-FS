package Elite;
import java.util.*;

class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Pair pair){
		if(this.x == pair.x) return this.y - pair.y;
		return this.x - pair.x;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	
}
public class LexicographicSwapSubstrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int pairs = sc.nextInt();
		boolean visited[] = new boolean[input.length()];
		TreeSet<Pair> set = new TreeSet<>() ;
		for(int i=0;i<pairs;i++) {
			int x = sc.nextInt(), y =sc.nextInt();
			if(x > y) {x = x+y ; y= x-y; x= x-y;}
			set.add(new Pair(x,y));
		}
		System.out.println(set);
		LinkedList<TreeSet<Integer>> list = new LinkedList<>();
		
		for(Pair pair : set) {
			if(list.isEmpty()) {
				TreeSet<Integer> treeset = new TreeSet<>();
				treeset.add(pair.x); treeset.add(pair.y);
				list.add(treeset);
			}
			else {
				int flag = 0;
				for(TreeSet<Integer> ts : list) {
					if(ts.contains(pair.x) || ts.contains(pair.y)) {
						ts.add(pair.x);  ts.add(pair.y); flag = 1;
					}
					if(flag == 1) break;
				}
				if(flag == 0) {
					TreeSet<Integer> treeset = new TreeSet<>();
					treeset.add(pair.x); treeset.add(pair.y);
					list.add(treeset);
				}
			}
			visited[pair.x] = true;
			visited[pair.y] = true;
		}
		LinkedList<String> groups = new LinkedList<>();
		for(int i=0;i<list.size();i++) {
			TreeSet<Integer> ts = list.get(i);
			StringBuffer sb= new StringBuffer();
			for(Integer e : ts) {
				sb.append(input.charAt(e));
			}
			char arr[] = sb.toString().toCharArray();
			Arrays.sort(arr);
			String s = "";
			for(int j=0;j<arr.length;j++) {
				s = s.concat(arr[j]+"");
			}
			groups.add(s);
		}
		StringBuffer sb = new StringBuffer();
	   
		for(int i=0;i<input.length();i++) {
			if(visited[i] == true) {
				int count = 0;
				for(TreeSet<Integer> ts : list) {
				 if(ts.contains(i)){
					 sb.append(groups.get(count).charAt(0));
					 String s = groups.get(count);
					 s = s.substring(1);
					 groups.set(count,s);
					 break;
				 }
				 count++;
				}
			}
			else {
				sb.append(input.charAt(i)+"");
			}
		}
		System.out.println(sb.toString());	
	}
}