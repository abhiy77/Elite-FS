/* 08/09/2020 - (ELITE DAY - 117)
 * 
 * There are N celebrities participated in Go-Green Campaign,
All of them joined together and each one planted a tree on a flat land at different positions.
 
Now, your task is to find the maximum number of trees in single straight line.

Input Format:
-------------
Line-1 -> An integers N, number of trees planted.
Next N lines -> Two space separated integers, position of the tree.

Output Format:
--------------
Print an integer as result.


Sample Input:
-------------
6
1 1
3 2
5 3
4 1
2 3
1 4

Sample Output:
--------------
4

Explanation:
------------

Y
|
|  "
| 	  "		   "
|		 "
|  "		"	
------------------- X
0  1  2  3  4  5

" -> Tree


 */
package Elite;
import java.util.*;

public class MaxPointsOnALine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int points[][] = new int[n][2];
		for(int i=0;i<n;i++) {
			points[i][0] = sc.nextInt();
			points[i][1] = sc.nextInt();
		}
		if(n < 2) System.out.println(n);
		else {
			HashSet<String> set = new HashSet<>();
			int max = 1;
			
			for(int i=0;i<n && !set.contains(points[0]+"-"+points[1]);i++){
	            int arr[] = points[i];
	            int currMax = 1;
	            int same = 0;
	            HashMap<Double,Integer> map = new HashMap<>();
	            for(int j=i+1;j<n;j++){
	                if(isSame(arr,points[j])){
	                    same++;
	                }
	                else{
	                    double slope = getSlope(arr,points[j]);
	                    //System.out.println(i+" "+j + " " + slope);
	                    map.put(slope,map.getOrDefault(slope,1) + 1);
	                    currMax = Math.max(currMax,map.get(slope));
	                }
	            }
	           max = Math.max(max,currMax + same);
	           set.add(arr[0] + "-" + arr[1]); 
	        }
	        System.out.println(max);
		}
	}
	
	public static boolean isSame(int arr1[],int arr2[]){
        return arr1[0] == arr2[0] && arr1[1] == arr2[1];
    }
    
    public static double getSlope(int arr1[],int arr2[]){
        if(arr1[0] == arr2[0])return Double.MAX_VALUE;
        else if(arr1[1] == arr2[1]) return 0;
        else return ((double) arr2[1] - arr1[1] )/ ((double) arr2[0] - arr1[0]);
    }
}
