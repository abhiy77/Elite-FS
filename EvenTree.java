/*01/06/2020 - HOME
 * HACKERRANK - EVEN TREE
 * 
 */
package Elite;
import java.util.Scanner;

public class EvenTree {
	static boolean[][] a;
	static boolean[][] v;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		a = new boolean[n][n];
		v = new boolean[n][n];
		int f, t;
		for (int i = 0; i < m; i++) {
			f = in.nextInt() - 1;
			t = in.nextInt() - 1;
			a[f][t] = a[t][f] = true;
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i][j]) {
					v[i][j] = v[j][i] = true;
					if (dfs(i) % 2 == 0 && dfs(j) % 2 == 0) {
						cnt++;
						a[i][j] = a[j][i] = false;
					} else {
						v[i][j] = v[j][i] = false;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	public static int dfs(int cur) {
		int tot = 1;
		for (int i = 0; i < a.length; i++)
			if (a[cur][i] && !v[cur][i]) {
				v[cur][i] = v[i][cur] = true;
				tot += dfs(i);
				v[cur][i] = v[i][cur] = false;
			}
		return tot;
	}
}