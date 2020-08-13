package Elite;
import java.util.*;

public class WhoWinsTheGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		int len = 0;
		int seq[] = new int[n];
		Arrays.fill(seq, 1);
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j] && seq[i] < seq[j] + 1) {
					seq[i] = seq[j] + 1;
				}
			}
		}
        for(int i=0;i<n;i++) {
        	len = Math.max(len, seq[i]);
        }
        System.out.println(len);
        if(((n - len - 2) + (len)) % 2 == 0) System.out.println("Amith");
        else System.out.println("Gopal");
//        if((n - len) % 2 == 0)System.out.println("Gopal");
//        else System.out.println("Amit");
	}
}