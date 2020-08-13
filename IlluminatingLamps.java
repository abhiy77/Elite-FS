/* 25/06/2020 - HOME
 * *********** Program TestCases ************
case =1
input =3
3 2 5
output =5

case =2
input =4
1 2 3 1
output =4

case =3
input =10
2 9 2 2 9 4 5 6 7 9
output =33

case =4
input =15
3 8 4 4 7 5 1 3 7 1 8 1 7 3 8
output =47

case =5
input =15
37 64 52 14 72 74 72 84 33 56 56 31 51 67 62
output =410

case =6
input =20
13 93 14 47 40 96 71 56 17 30 69 99 81 89 24 73 57 41 88 15
output =671

case =7
input =10
979 262 112 232 139 943 885 329 302 609
output =2483

case =8
input =20
760 931 933 959 139 127 150 731 134 846 624 293 880 416 689 344 787 972 971 691
output =6921

Given some lamps with their illuminating powers which are arranged in a circle and a constraint to be followed which is when a lamp is 
switched on , its adjacent lights have to be switched off , determine the maximum possible power we can generate by switching on the lamps.
 */
package Elite;
import java.util.*;
public class IlluminatingLamps 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		int[] arr=Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		if(n<=3)
		{
			int max=Arrays.stream(arr).max().getAsInt();
			System.out.println(max);
		}
		else 
		{
			int[] dp=new int[n];
			Arrays.fill(dp, 0);
			dp[0]=arr[0];
			dp[1]=arr[0];
			for(int i=2;i<n-1;i++)
			{
				dp[i]=Math.max(arr[i]+dp[i-2], dp[i-1]);
			}
			int t=dp[n-2];
			Arrays.fill(dp, 0);
			dp[1]=arr[1];
			dp[2]=arr[1];
			for(int i=3;i<n;i++)
			{
				dp[i]=Math.max(arr[i]+dp[i-2], dp[i-1]);
			}
			System.out.println(Math.max(t,dp[n-1]));
		}
	}
}