// 17/01/2020
package Elite;
import java.util.*;
class Interval implements Comparable<Interval>{
	int start,end;
	public Interval(int start,int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Interval o) {
		return-( start-o.start);
	}
	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
}
public class MergeIntervals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Interval arr[] = new Interval[n];
		for(int i=0;i<n;i++) {
			arr[i] =new Interval(sc.nextInt(),sc.nextInt());
		}
		
		Arrays.sort(arr);
	//	System.out.println(Arrays.toString(arr));
		int index = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i].end >= arr[index].start) {
				arr[index].start = arr[i].start;
				arr[index].end = Math.max(arr[index].end, arr[i].end);
			}
			else {
				arr[++index] = arr[i];
			}
		}
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, index+1)));
	}
}