/* ELITE DAY - 106
The ancient sumerians had built a very elaborate reservoir system consisting of 
rows and rows of reservoirs, all reservoirs have same capacity X. 

The first row has one reservoir, second row has two reservoirs and 
third row has three reservoirs and so on.

There are altogether 100 rows. Water is drawn from the river at X liters each time.
The way water flows is that,
After the first drawing of water the reservoir on the first row is filled
After the second draw from the river, the reservoirs in the second row are half filled each.
After third draw from the river, both the reservoirs in the second row fully filled.
After the fourth draw from the river the three reservoirs in the third row are filled 
to an extent 1/4, 1/2, 1/4.

Given N draws from the river, determine how full the jth reservoir in the ith row.

The row are number from (0,0)  onwards,
The first row is row =0, reservoir = 0
The second row is row =1 reservoirs are 0 and 1. so on...


Input Format:
-----------------
Three space seperated integers, N, i, j

Output Format:
------------------
Print a double value as result


Sample Input-1:
-------------------
2 1 1

Sample Output-1:
---------------------
0.5


Sample Input-2:
-------------------
4 2 2

Sample Output-2:
---------------------
0.25


-------Testcases-------
case =1
input =4 2 2
output =0.25

case =2
input =2 1 1
output =0.5

case =3
input =12 4 2
output =1.0

case =4
input =25 8 3
output =0.171875

case =5
input =50 13 7
output =0.15869140625

case =6
input =12 5 2
output =0.1875

case =7
input =283 40 19
output =0.47468486870639026

case =8
input =390 50 25
output =0.4660915887835415


*/
package Elite;
import java.util.Scanner;

public class ReservoirSystem{	
	public static double reservoirSystem(int poured, int res_row, int reservoir) {
        double[] res = new double[res_row + 2];
        res[0] = poured;
        for (int row = 1; row <= res_row; row++)
            for (int i = row; i >= 0; i--)
                res[i + 1] += res[i] = Math.max(0.0, (res[i] - 1) / 2);
        return Math.min(res[reservoir], 1.0);
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int i=sc.nextInt();
		int j=sc.nextInt();
		System.out.println(reservoirSystem(N,i,j));
	}
}
