/* 03/06/2020 - HOME
 * REFERENCE - FUN GAME HACKERRANK
 */
package Elite;
import java.util.*;

public class FunGame {
    static int choice(int a[], int b[], boolean visited[]){
        int maxGain=-1;
        int index=0;
        for(int i=0;i< a.length ;i++){
            if((maxGain<(a[i]+b[i]))&&( !visited[i] )){
                index=i;                
                maxGain=a[i]+b[i];
            }            
        }
        return index;
    }
    
    static void playgame(Scanner sc){
        int pointsA=0, pointsB=0;
        int n=sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        
        int[] b = new int[n];
        for(int i=0;i<n;i++)
            b[i]=sc.nextInt();
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        for(int i=0;i<n;i++){
            if(i%2==0){
                int index=choice(a, b, visited);
                visited[index]=true;
                pointsA += a[index];
            }
            else{
                int index=choice(a, b, visited);
                visited[index]=true;
                pointsB += b[index];
            }            
        }
        if(pointsA>pointsB)
            System.out.println("First");
        else if(pointsB>pointsA)
            System.out.println("Second");
        else
            System.out.println("Tie");            
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        playgame(sc);
    }
}