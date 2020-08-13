/* 09/06/2020 - HOME
 * HACKERRANK - THE POWER SUM
 */
package Elite;
import java.util.*;

public class PowerSum {
	int count=0;
	int sum;
	int pow;
    public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int x=in.nextInt();
		int n=in.nextInt();
        PowerSum p=new PowerSum();
        p.sum=x;
        p.pow=n;
        int N=(int)Math.pow(x, (1.0/n));
        p.getcount(p.sum,N,true);
        p.getcount(p.sum,N,false);
        System.out.println(p.count);
        in.close();
	}
    void getcount(int sum1,int n,boolean lenyani){
    	
    	if(lenyani==true){
    		sum1=sum1-(int)Math.pow(n, pow);
    	
    	}
    	if(sum1<0) return;
    	if(sum1==0){
    		count++;
    		return;
    	}
    	if(n==1) return;
    	getcount(sum1,n-1,true);
    	getcount(sum1,n-1,false);
    }
}