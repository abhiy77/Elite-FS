/* 08/04/2020 - HOME
St. Martins School has decided to run a trial for a system that supplies the students 
with packed lunch boxes for lunchtime.

The system is designed as follows:
There are N premade lunch boxes for N Students, and they are placed on top of each other. 
The lunch boxes can be either in Rectangle shape or Circle in shape. 
Each student has his/her own preference for the type of lunchbox that they want. 
There are the correct number of circular and rectangular lunch boxes 
to satisy each student .

The Students stand in a random ordered line as soon as it is lunch time. 
If the student at the head of the line finds that the top tiffin in the stack is not of their 
preference they will go back and rejoin the queue at the end.

Estimate the number of students who will  not be able to eat lunch.

Input format:
Input1 : N, denoting the number of Children and lunch boxes. 
Input2 : An array of N elements, each element can be either 0(Rectangle) or 
1(circle) denoting the type of lunch box from top to bottom. 
Input3 : An array of N elements, each element denoting the preference 
0(Rectangle) or 1(Circle) of a student from 
the start till end of the queue.


Output Format: 
For the given input, your code should output the number of students 
who will not be able to eat lunch

Sample Input1
    4 - Number of children and lunch boxes
    0 0 1 0 - Types of lunch boxes
    1 0 0 0 - Preferences of a student 
Output1
    0

Sample Input2
    6
    0 1 1 0 1 0
    1 1 1 0 1 0
output2
    1

========= Testcases Program-2 =========
case =1
input =6
0 1 1 0 1 0
1 1 1 0 1 0
output =1

case =2
input =4
0 0 1 0
1 0 0 0
output =0

case =3
input =8
1 0 0 1 0 0 1 0
0 0 0 1 0 0 0 1
output =2

case =4
input =15
1 0 1 1 1 0 1 0 1 1 1 0 1 1 0
0 0 0 0 0 0 1 0 1 1 1 1 1 1 1
output =3

case =5
input =12
1 1 1 0 1 0 1 1 1 0 1 1
1 1 0 1 0 0 0 1 0 0 1 0
output =5

case =6
input =18
0 0 0 1 1 0 1 1 1 0 1 0 0 1 0 1 1 0
0 0 0 1 1 0 1 0 1 0 1 1 0 1 1 0 0 0
output =2

case =7
input =10
1 0 1 0 0 1 1 1 0 1
0 0 1 0 1 0 0 0 0 1
output =4

case =8
input =15
0 1 1 1 0 0 0 0 1 1 0 1 0 1 0
0 0 1 0 0 1 0 1 0 1 0 1 0 1 1
output =0
*/
package Elite;
import java.util.*;

public class StMartinLunchBoxTrials {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> lunchBoxes = new LinkedList<Integer>();
		Queue<Integer> children = new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			lunchBoxes.offer(sc.nextInt());
		}
		for(int i=0;i<n;i++) {
			children.offer(sc.nextInt());
		}
		int size = children.size();
		while(children.size() > 0 && size > 0) {
			if(lunchBoxes.peek() != children.peek()) {
				size--;
				children.offer(children.poll());
			}
			else {
				lunchBoxes.poll();
				children.poll();
				size = children.size();
			}
		}
		System.out.println(children.size());
	}
}