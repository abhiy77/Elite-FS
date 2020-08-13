/* 28/04/2020 - HOME
 * Given an array of stick lengths, use 3 of them to construct a non-degenerate triange 
with the maximum possible perimeter. 
Print the lengths of its sides as 3 space-separated integers in non-decreasing order.

If there are several valid triangles having the maximum perimeter:
	- Choose the one with the longest maximum side.
	- If more than one has that maximum, choose from them the one with the longest minimum side.
	- If more than one has that maximum as well, print any one them.
	- If no non-degenerate triangle exists, print -1.

For example, assume there are stick lengths sticks=[1,2,3,4,5,10]. 
The triplet (1,2,3) will not form a triangle. 
Neither will (4,5,10) or (2,3,5), so the problem is reduced to (2,3,4) and (3,4,5). 
The longer perimeter is 3+4+5=12.

Input Format
	- The first line contains single integer n, the size of array sticks.
	- The second line contains n space-separated integers sticks[i], each a stick length.

Output Format
	- Print the lengths of the 3 chosen sticks as space-separated integers in non-decreasing order.
	- If no non-degenerate triangle can be formed, print -1.

Sample Input1:
5
1 1 1 3 3
Sample Output1:
1 3 3
Explanation1:
There are 2 possible unique triangles:
	1 1 1
	1 3 3
The second triangle has the largest perimeter, 
so we print its side lengths on a new line in non-decreasing order.

Sample Input2:
3
1 2 3
Sample Output2:
-1
Explanation2:
The triangle (1,2,3) is degenerate and thus can't be constructed, 
so we print -1 on a new line.

Sample Input3:
6
1 1 1 2 3 5
Sample Output3:
1 1 1
Explanation3:
The triangle (1,1,1) is the only valid triangle.

========= Testcases Program-1 =========
case =1
input =5
1 1 1 3 3
output =1 3 3

case =2
input =3
1 2 3
output =-1

case =3
input =8
1 4 7 8 9 15 24 39
output =8 9 15

case =4
input =6
1 1 1 2 3 5
output =1 1 1

case =5
input =7
1 2 4 6 8 11 12
output =8 11 12

case =6
input =10
3 7 9 13 15 28 45 76 103 189
output =45 76 103

case =7
input =6
1 3 5 7 15 24
output =3 5 7

case =8
input =9
7 10 16 27 44 67 112 179 292
output =27 44 67

 */
package Elite;
import java.util.*;

public class FormingTriangleWithMaximumPerimeter{
    
    public static boolean formTriangle(int a,int b,int c){
        if(a + b <= c || b+c <= a || c+a <= b) return false;
        return true;
    }
    
    public static int findPerimeter(int a,int b,int c){
        return a + b + c;
    }
    
    public static void main (String[] args) {
        LinkedList<Triangle> triangles = new LinkedList<>();
        int maxPerimeter = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(maxPerimeter <= (arr[i] + arr[j] + arr[k]) && formTriangle(arr[i],arr[j],arr[k])){
                        maxPerimeter = findPerimeter(arr[i],arr[j],arr[k]);
                        triangles.add(new Triangle(arr[i],arr[j],arr[k]));
                    }
                }
            }
        }
        Collections.sort(triangles);
        if(triangles.size() == 0) System.out.println(-1);
        else{
            Triangle t = triangles.get(0);
            int temp[] = {t.a,t.b,t.c};
            Arrays.sort(temp);
            System.out.println(Arrays.toString(temp));
        }
    }
}

class Triangle implements Comparable<Triangle>{
    int a,b,c;
    
    Triangle(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int compareTo(Triangle t2){
        if(a + b + c != t2.a + t2.b + t2.c) return ((t2.a + t2.b + t2.c) - (a + b + c));
        int max1 = Math.max(a,Math.max(b,c));
        int max2 = Math.max(t2.a,Math.max(t2.b,t2.c));
        if(max1 != max2) return max2 - max1;
        if(max1 == max2){
            int min1 = Math.min(a,Math.min(b,c));
            int min2 = Math.min(t2.a,Math.min(t2.b,t2.c));
            if(min1 != min2) return min2 - min1;
        }
        return ((t2.a + t2.b + t2.c) - (a + b + c));
    }
}