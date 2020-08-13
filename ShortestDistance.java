package Elite;
//30/12/2019
import java.util.*;

class ShortestDistance{
    public static void BFS(int[][] area , int[][] dist , int row , int col , int rows ,int cols){
        Queue <Coor> queue = new LinkedList<>();

        int arr[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        int visited[][] = new int[rows][cols];
        int depth[][] = new int[rows][cols];

        queue.add(new Coor(row , col));
        depth[row][col] = 0;
        visited[row][col] = 1;

        while(!queue.isEmpty()){
            Coor c = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                if(c.x + arr[i][0] >= 0 && c.y + arr[i][1] >= 0 && c.x + arr[i][0] < rows && c.y + arr[i][1] < cols){
                    if(visited[c.x + arr[i][0]][c.y + arr[i][1]] != 1 && area[c.x + arr[i][0]][c.y + arr[i][1]] == 0){

                        queue.add(new Coor(c.x + arr[i][0] , c.y + arr[i][1]));

                        visited[c.x + arr[i][0]][c.y + arr[i][1]] = 1;
                       
                        depth[c.x + arr[i][0]][c.y + arr[i][1]] = depth[c.x][c.y] + 1;
                        dist[c.x + arr[i][0]][c.y + arr[i][1]] += depth[c.x][c.y] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int input[][] = new int[rows][cols];
        int dist[][] = new int[rows][cols];

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                input[i][j] = sc.nextInt();

                if(input[i][j] == 1 || input[i][j] == 2) dist[i][j] = 10000;
                else dist[i][j] = 0;
            }
        }
         
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(input[i][j] == 1) BFS(input , dist , i , j , rows , cols);
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(dist[i][j] < min) min = dist[i][j];
            }
        }
        System.out.println(min);
        sc.close();
    }
}

class Coor{
    int x , y;

    Coor(int x , int y){
        this.x = x;
        this.y = y;
    }
}