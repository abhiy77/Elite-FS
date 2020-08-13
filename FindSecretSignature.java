/* ELITE DAY 101
 * REFERENCE - LEETCODE - Find Permutation
 */
package Elite;
import java.util.Scanner;
import java.util.Arrays;
public class FindSecretSignature {
    public static int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++)
            res[i] = i + 1;
        int i = 1;
        while (i <= s.length()) {
            int j = i;
            while (i <= s.length() && s.charAt(i - 1) == 'D')
                i++;
            reverse(res, j - 1, i);
            i++;
        }
        return res;
    }
    public static void reverse(int[] a, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            int temp = a[i + start];
            a[i + start] = a[end - i - 1];
            a[end - i - 1] = temp;
        }
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s = sc.next();
		System.out.println(Arrays.toString(findPermutation(s)));
	}
}