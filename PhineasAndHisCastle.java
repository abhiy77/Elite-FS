/* 04/04/2020 - HOME
 * 
Phineas is Building a castle in his backyard to impress Isabella ( strange, isn't it? ). 
He has got everything delivered and ready. Even the ground floor has been finished. 
Now is time to make the upper part. This is where the things become interesting. 
As Ferb is sleeping in the house after a long day painting the fence (and you folks helped him, didn't ya!),
Phineas has to do all the work himself. He is good at this, 
and all he wants you to do is operate the mini crane to lift the stones. 
Stones for the wall has been cut and ready waiting for you to lift them up.

Now we don't have Ferb to operate the mini crane, in which he is an expert, 
we got to do the job as quick as possible. 
We are given the maximum lifting capacity of the crane, and the weight of each stone. 
Since it's a mini crane, we cannot place more then 2 stones (of any possible size) at a time, 
or it will disturb the balance of the crane. 
we need to find out in how many turns we can deliver the stones to Phineas, 
who is building the castle.

INPUT: first line gives M, the maximum lifting capacity of the crane. 
second line , first integer N of next line gives the number of stones, 
followed by N numbers, specifying the weight of individual stone X.

OUTPUT:print the minimum number of turns the crane is operated for all stones to be lifted.

Sample Output:
        6
        5 3 5 4 2 1

Sample Output:
        3

Explanation:
    Minimum number of turns required are 3.
    One of the way of transporting stones in 3 turns is to transport as (1,5),(2,3) and (4).


 * 
 */

package Elite;
import java.util.*;
public class PhineasAndHisCastle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int capacity = sc.nextInt();
		int stones = sc.nextInt();
		int turns = 0;
		int weights[] = new int[stones];
		for(int i=0;i<stones;i++) {
			weights[i] = sc.nextInt();
		}	
		Arrays.sort(weights);
		
		for(int i= weights.length-1;i>=0;i--) {
			if(weights[i] <= capacity) {
				int same = -1;
				for(int j =i-1;j>=0;j--) {
					if(weights[j] + weights[i] <= capacity) {
						same = j;
						break;
					}
				}
				if(same >= 0) {
					weights[same] = capacity + 1;
				}
				turns++;
			}
		}
		System.out.println(turns);
	}
}