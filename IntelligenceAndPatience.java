/* ELITE DAY - 107

In a class of N students, each student has different levels of IQ and 
different levels of patience. Each student is numbered from 0 to N-1.

To identify a student with number A, call him "Student A".

The teacher has created 'N-1' IQ pairs based on his observation of the students.
Each IQ pair (a,b), indicates Student 'a' is more  intelligent than Student 'b'.

The teacher also has a measure of  the patience of the students in the form of a list of  'N' integers.
patience[i]=p, indicates Student 'i' has patience 'p'.

Now your task is to find the Result[i]= r, r is least patience student, among all the students
who has more or equal IQ than Student[i], 'i' is in range of [0..N-1].

Input Format:
----------------
Line-1 -> an integers N, number of students
Next 'N-1' lines -> two space seperated integers, indicates a pair (a, b).
Last Line -> N space seperated integers, patience levels of students

Output Format:
------------------
Print space seperated Result[i], where 'i' is in [0 .. N-1].


Sample Input-1:
-------------------
6
1 3
2 4
3 5
0 3
3 4
4 2 6 8 3 1

Sample Output-1:
---------------------
0 1 2 1 1 5

Explanation:
---------------
For Result[4]:
	Student 0, 1 has more IQ than Student 3, which has more IQ than Student 4.
	Among students 0,1,3,4,  'student 1' has less patience.
For Result[5]:
	Student 0, 1 has more IQ than Student 3, which has more IQ than Student 5.
	Among students 0,1,3,5,  'student 5' has less patience.

Sample Input-2:
-------------------
8
1 0
2 1
3 1
3 7
4 3
5 3
6 3
3 2 5 4 6 1 7 0

Sample Output-2:
---------------------
5 5 2 5 4 5 6 7

*/
package Elite;
import java.util.*;

public class IntelligenceAndPatience
{
	static HashMap<Integer, List<Integer>> IQ2 = new HashMap<>();
    static int res[];
    public static int[] intelligenceAndPatience(int[][] IQ, int[] patience) {
        int n = patience.length;
        for (int i = 0; i < n; ++i) IQ2.put(i, new ArrayList<Integer>());
        for (int[] v : IQ) IQ2.get(v[1]).add(v[0]);
        res = new int[n]; Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) dfs(i, patience);
        return res;
    }

    static int dfs(int i, int[] patience) {
        if (res[i] >= 0) return res[i];
        res[i] = i;
        for (int j : IQ2.get(i)) if (patience[res[i]] > patience[dfs(j, patience)]) res[i] = res[j];
        return res[i];
    }
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		
		int IQ[][]=new int[n-1][2];
		int patience[]=new int[n];
		
		for(int i=0;i<n-1;i++){
			IQ[i][0]=sc.nextInt();
			IQ[i][1]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
			patience[i]=sc.nextInt();
		int[] result=intelligenceAndPatience(IQ,patience);
		for(int i:result)
		System.out.print(i+" ");
	}

}