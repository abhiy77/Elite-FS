/* 10/09/2020 - (ELITE DAY - 118)
 * 
 * Ram and Sam are number, both of them have a number each, of length P and Q.
They are planned to create a new number, which is the biggest number of length K,
Where K is <= P+Q.

You will be given the digit arrays of those two numbers.
for example, Ram's number is 123 and Sam;s number is 3765 and K is 4
you will be given as, [1,2,3] and [3,7,6,5], -> bigggest number possible is [7,6,5,3]

Please help Ram and Sam, find out the biggest possible number of K length, 
without changing the relative order of the digits in their arrays.

Input Format:
-------------
Line-1 -> Two integers P and Q.
Line-2 -> P space separated digits, Ram's Number
Line-3 -> Q space separated digits, Sam's Number
Line-4 -> K, length of the biggest number.

Output Format:
--------------
Print the array of digits, of the biggest number.


Sample Input-1:
---------------
3 4
5 7 6
0 0 1 0
5

Sample Output-1:
----------------
[7, 6, 0, 1, 0]


Sample Input-2:
---------------
2 2
2 5
4 5
3

Sample Output-2:
----------------
[5, 4, 5]

 */
package Elite;
import java.util.*;

public class BiggestNumber {
	
	public static int[] maxNumber(int[] A, int[] B, int k) {
		
        int m = A.length, n = B.length;
        if (m+n < k) return new int[0];

        String[][][] dp = new String[m+1][n+1][k+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= k; l++) {
                    if (i+j < l) dp[i][j][l] = "";
                    else {
                        String chooseAi = (i == 0 || l == 0) ? "" : dp[i-1][j][l-1] + A[i-1];
                        String chooseBj = (j == 0 || l == 0) ? "" : dp[i][j-1][l-1] + B[j-1];
                        String maxChoose = max(chooseAi, chooseBj);

                        String ignoreAi = (i == 0) ? "" : dp[i-1][j][l];
                        String ignoreBj = (j == 0) ? "" : dp[i][j-1][l];
                        String ignoreBoth = (i == 0 || j == 0) ? "" : dp[i-1][j-1][l];
                        String maxIgnore = max(max(ignoreAi, ignoreBj), ignoreBoth);

                        dp[i][j][l] = max(maxChoose, maxIgnore);
                    }
                }
            }
        }

        return convert(dp[m][n][k]);
    }

    private static String max(String s1, String s2) {
        return (s1.compareTo(s2) < 0) ? s2 : s1;
    }

    private static int[] convert(String s)  {
        int n = s.length(), res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = s.charAt(i)-'0';
        }
        return res;
    }
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int q = sc.nextInt();
		sc.nextLine();
		int num1[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int num2[] = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int k = sc.nextInt();
		int dp[][][] = new int[num1.length][num2.length][k+1];
		System.out.println(Arrays.toString(maxNumber(num1, num2, k)));
	}
}