/* 05/05/2020 - HOME
 * 
Input Format:
-------------
    - First line contains two integers N and K,
      N is the number of students and K is the total number of subjects. 
    - The next N line contains space seperated K integers denoting 
      the marks obtained by the students in k subjects. 
    - The next line contains one integer XN which indicates the number of subjects to be 
      considered and space seperated XN integers distinct integers(x1,x2,x3 ..) 
      indicating the subjects to be considered arranged priority wise.

Output Format:
-------------
    - Prints the unique id of the worst performer of the class.

Sample Input :
---------------
3 3
50 60 70
40 60 80
50 60 61
3 1 2 3

Sample Output :
---------------
2

NOTE: If there is a tie among few students then
the student with the smallest id will be the worst performer.
 */
package Elite;
import java.util.*;

public class WorstPerformer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Student[] marks = new Student[n+1];
		for(int i=1;i<=n;i++) {
			Student student = new Student(i);
			int arr[] = new int[k];
			for(int j=0;j<k;j++) {
				arr[j] = sc.nextInt();
			}
			student.arr = arr;
			marks[i] = student;
		}
		int subjects = sc.nextInt();
		int priority[] = new int[subjects];
		for(int i=0;i<subjects;i++) {		
			priority[i] = sc.nextInt() - 1;
		}
		
		List<Student> list = new LinkedList<>();
		PriorityQueue<Student> queue = new PriorityQueue<>();
		
		for(int i=0;i<subjects;i++) {
			List<Integer> temp = new LinkedList<>();
			if(list.isEmpty()) {
				for(int j=1;j<=n;j++) {
					list.add(marks[j]);
					temp.add(marks[j].arr[priority[i]]);
				}
			}
			else {
				for(int j=0;j<list.size();j++) {
					temp.add(list.get(j).arr[priority[i]]);
				}
			}
			int min = Collections.min(temp);
			
			for(int j=0;j<list.size();j++) {
				if(list.get(j).arr[priority[i]] == min) queue.offer(list.get(j));
			}
			if(queue.size() == 1) {
				list.clear();
				System.out.println(queue.peek().id);
				break;
			}
			else {
				list.clear();
				list.addAll(queue);
				queue.clear();
			}
		}
		if(list.size() > 1) System.out.println(list.get(0).id);
	}
}

class Student implements Comparable<Student>{
	int id;
	int[] arr;
	Student(int id){
		this.id = id;
	}
	@Override
	public int compareTo(Student o) {
		return this.id - o.id;
	}
	
	@Override
	public String toString() {
		return "[ " +this.id + " " + Arrays.toString(this.arr) + " ]";
	}
}