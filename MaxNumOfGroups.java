/* 06/03/2020
 * 
It is morning and jhonny is very happy to go to the school today.  
The school is organizing a picnic for all its students. 
There are a total of N students labeled from 1 to N in the school. 
Each student i has a compatiability factor of Xi.

It is time for the picnic and all students stand in a line. 
Jhonny is given the responsbility of splitting the student line into many groups. 
A set of consecutive students standing in a line can form a group. 
For the picnic to be sage jhonny ensures that each group has atleast 2 people with same compatibility factor.

Help Jhonny find the maximum number of groups he can create. 


Input format 
------------
Input - N denoting the number of students 
Input2[]- An array of N elements where the ith element denote the compatibility factor of ith student. 


Output format
------------- 
For the given input your code should output the maximum number of groups jhonny can create.

Sample Input 
2
1 1

Output 
1


Sample Input2
3
1 2 3

Output 
0
-----------------------------------------------------------------------

case=1
input=4
1 5 6 8
output=0


case=2
input=5
2 2 4 4 6
output=2


case=3
input=6
2 2 1 1 4 4
output=3


case=4
input=8
2 2 1 1 6 6 4 4
output=4


case=5
input=11
9 9 9 6 6 2 2 3 3 1 1
output=5

case=6
input=11
1 2 1 1 1 2 3 2 3 2 2
output=4

case=7
input=10
1 2 1 1 2 2 2 2 2 3
output=3

 * 
 */
package Elite;
import java.util.*;

public class MaxNumOfGroups {
    
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numOfStudents = sc.nextInt();
		
		int maxGroups = 0;
		int prev = -1;
		for (int i = 0; i < numOfStudents; i++) {
			int temp = sc.nextInt();
			if (prev == temp) {
				maxGroups++;
				prev = -1;
			} else {
				prev = temp;
			}
		}
		System.out.println(maxGroups);
	}
}