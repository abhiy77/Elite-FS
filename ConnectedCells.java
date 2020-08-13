/* 01/06/2020 - HOME
 * HACKERRANK - CONNECTED CELLS IN A GRID
 */
package Elite;
import java.util.*;

public class ConnectedCells {
    static boolean[][] visited;
    static int[][] matrix;
    private static void solve(int[][] m) {
        int biggest = 0;
        matrix = m;
        visited = new boolean[m.length][m[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (!visited[i][j]) {
                    int area = dfs(i, j);
                    if (area > biggest) biggest = area;
                }
            }
        }
        System.out.println(biggest);
    }
    private static int dfs(int i, int j) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length) return 0;
        if (matrix[i][j] == 0) return 0;
        if (visited[i][j]) return 0;
        visited[i][j] = true;
        int[][] neighbors = {{i-1, j-1}, {i-1,j}, {i-1, j+1}, {i, j-1}, {i, j+1}, {i+1, j-1}, {i+1,j}, {i+1,j+1}};
        int result = 1;
        for (int n = 0; n < neighbors.length; n++) {
            result += dfs(neighbors[n][0], neighbors[n][1]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }
        solve(board);
    }
}