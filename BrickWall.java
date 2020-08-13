/* 27/03/2020 - HOME
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
The bricks have the same height but different width. 
You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. 
Each row is a list of integers representing the width of each brick in this row 
from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. 
You need to find out how to draw the line to cross the least bricks and 
return the number of crossed bricks.

Note:
-	You cannot draw a line just along one of the two vertical edges of the wall, 
	in which case the line will obviously cross no bricks.
-	The width sum of bricks in different rows are the same.

Example-1:
Input: 
6				//No of Rows of bricks
                // Each row contains the width of bricks
1 2 2 1         
3 1 2
1 3 2
2 4
3 1 2
1 3 1 1

Output: 
2

Explanation:

    -----------------
    |  |    |    |  |
    -----------------
    |      |  |     |
    -----------------
    |  |      |     |
    -----------------
    |   |           |
    -----------------
    |      |  |     |
    -----------------
    |  |      |  |  |
    -----------------
    
    if you draw a line from right side at width 2, only two bricks will crossed 
    
    
Example-2:
Input:
3
6 3 1
2 5 3
1 4 3 2

Output:
2

===== testcases program-1 =====
case=1
input=6
1 2 3
3 1 2
1 3 2
2 4
5 1
2 3 1
output=4

case=2
input=6
1 2 2 1
3 1 2
1 3 2
2 4
3 2 1
1 3 1 1
output=3

case=3
input=8
1 2 2 1 1 1
3 1 2 1 1
1 3 2 1 1
2 3 3
3 1 2 1 1
1 3 1 1 1 1
3 1 2 1 1
1 3 1 1 1 1
output=1

case=4
input=3
6 3 1
2 5 3
1 4 3 2
output=2

case=5
input=6
3 5 2 4
4 2 1 1 1 5
3 2 1 2 1 5
6 2 1 5
6 8
1 2 3 4 4
output=1

case=6
input=5
3 1 4 2
5 5
2 3 4 1
1 2 3 4
4 1 2 3
output=2

case=7
input=6
1 2 2 1 1 1
1 3 2 1 1
2 3 3
3 1 2 1 1
1 3 1 1 1 1
3 1 2 1 1
output=1

case=8
input=4
6 3 1 4
4 2 5 3
1 4 6 1 2
2 3 4 5
output=2
 */
package Elite;
import java.util.*;
import java.util.stream.Collectors;

public class BrickWall{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        sc.nextLine();
        LinkedList<List<Integer>> list = new LinkedList<>();
        for(int i=0;i<rows;i++){
            List<Integer> temp = Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
            temp.remove(temp.size()-1);
            list.add(temp);
        }
        //System.out.println(list);
        for(int i=0;i<list.size();i++) {
        	List<Integer> temp = list.get(i);
        	for(int j=1;j<temp.size();j++) {
        		temp.set(j, temp.get(j)+temp.get(j-1));
        	}
        }
      //  System.out.println(list);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<list.size();i++) {
        	List<Integer> temp = list.get(i);
        	for(int j=0;j<temp.size();j++) {
        		map.put(temp.get(j), map.getOrDefault(temp.get(j),0)+1); 
        	}
        }
       // System.out.println(map);
        int max = Integer.MIN_VALUE;
        int key = map.firstKey();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if(entry.getValue() > max) {
        		max = entry.getValue();
        		key = entry.getKey();
        	}
        }
       System.out.println(rows-max);
    }
}