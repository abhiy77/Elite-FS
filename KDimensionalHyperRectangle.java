/* 29/04/2020 - HOME
 * Let there be a K-dimensional Hyperrectangle, 
where each dimension has a length of n1,n2,...nk.
Each of the Hyperrectangle's unit cells is addressed at (i,j,k,...) 
and has a value which is equivalent to GCD(i,j,k,...) where 1 <= i <= n1 , 1 <= j <= n2 ....

The goal is to sum all the GCD(i,j,k,...) cell values and 
print the result modulo 10^9 + 7. Note that indexing is from 1 to N and not 0 to N-1.

Input Format:
The first line being K (K-dimension) and 
the second line contains K space separated integers 
	- indicating the size of each dimension - n1 n2 n3 ... nk

Output Format
Print the sum of all the hyperrectangle cell's GCD values modulo 10^9 + 7.

Constraints
2 <= K <= 500
1 <= nk <= 100000

Sample Input #01
2
4 4
Sample Output #01
24

Sample Input #02
2
3 3
Sample Output #02
12

Sample Input #03
3
3 3 3
Sample Output #03
30

Explanation #01
It's a 4X4 2-dimension Rectangle. 
The (i,j) address and GCD values of each element at (i,j) will look like

1,1 1,2 1,3 1,4            		1 1 1 1  
2,1 2,2 2,3 2,4  => GCD(i,j) 	1 2 1 2  
3,1 3,2 3,3 3,4            		1 1 3 1  
4,1 4,2 4,3 4,4            		1 2 1 4  
Sum of these values is 24

Explanation #02
Similarly for 3X3 GCD (i,j) would look like

1,1 1,2 1,3               1 1 1  
2,1 2,2 2,3  => GCD(i,j)  1 2 1  
3,1 3,2 3,3               1 1 3  
Sum is 12

Explanation #03
Here we have a 3-dimensional 3X3X3 Hyperrectangle or a cube. 
We can write it's GCD (i,j,k) values in 3 layers.

1,1,1 1,1,2 1,1,3  |  2,1,1 2,1,2 2,1,3  |  3,1,1 3,1,2 3,1,3  
1,2,1 1,2,2 1,2,3  |  2,2,1 2,2,2 2,2,3  |  3,2,1 3,2,2 3,2,3  
1,3,1 1,3,2 1,3,3  |  2,3,1 2,3,2 2,3,3  |  3,3,1 3,3,2 3,3,3  
                
                GCD (i,j,k)

1 1 1              |  1 1 1              |  1 1 1  
1 1 1              |  1 2 1              |  1 1 1  
1 1 1              |  1 1 1              |  1 1 3  

Total Sum = 30

========= Testcases Program-2 =========
case =1
input =2
4 4
output =24

case =2
input =2
3 3
output =12

case =3
input =3
3 3 3
output =30

case =4
input =20
100 110 120 130 140 150 160 170 180 190 200 210 220 230 240 250 260 270 280 290
output =477233070

case =5
input =25
1000 1100 1200 1350 1460 1570 1680 1790 1800 1910 2020 2210 2230 2340 2450 2560 2670 2780 2890 2900 3250 3450 3680 3920 4500
output =678400223

case =6
input =15
2 2 2 2 3 3 3 3 4 4 4 4 5 5 5
output =41472128

case =7
input =10
11 12 13 14 15 16 17 18 19 20
output =910646256

case =8
input =4
2 3 4 5
output =124
s
 */
package Elite;
import java.util.*;

public class KDimensionalHyperRectangle {
    final static long mod=1000000007;
    public static void main(String[]args)
    {
        Scanner in=new Scanner(System.in);
		int k=in.nextInt();
		int[]a=new int[k];
		for(int i=0;i<k;i++)
			a[i]=in.nextInt();
		int maxGCD=Integer.MAX_VALUE;
		for(int i=0;i<k;i++)
			maxGCD=Math.min(maxGCD,a[i]);
		long[]res=new long[maxGCD+1];
		for(int d=maxGCD;d>=1;d--)
		{
			long mul=1;
			for(int i=0;i<k;i++)
			{
				mul=mul*(a[i]/d);
				if(mul>=mod)
					mul%=mod;
			}
			res[d]=mul;
			for(int z=2;z*d<=maxGCD;z++)
			{
				res[d]-=res[z*d];
				if(res[d]<0)
					res[d]+=mod;
			}
		}
		long tot=0;
		for(int d=maxGCD;d>=1;d--)
		{
			tot=(tot+res[d]*d)%mod;
		}
		System.out.println(tot);
    }
}