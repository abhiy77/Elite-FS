package Elite;
//02/01/2020
import java.util.*;
public class MinCostToConnectSticks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> queue = new PriorityQueue<>((x,y) ->x-y);
        int n = sc.nextInt();
        int cost = 0;
        for(int i=0;i<n;i++) {
        	queue.add(sc.nextInt());
        }
        
        while(queue.size()>1) {
        	int temp= queue.poll() + queue.poll();
        	cost+=temp;
        	queue.add(temp);
        }
        System.out.println(cost);
	}
}
