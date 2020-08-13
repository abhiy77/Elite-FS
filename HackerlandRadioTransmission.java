/* 13/04/2020 - HOME
 * Hackerland is a one-dimensional city with houses aligned at integral locations 
along a road. The Mayor wants to install radio transmitters on the roofs of 
the city's houses. Each transmitter has a fixed range meaning it can transmit 
a signal to all houses within that number of units distance away.

Given a map of Hackerland and the transmission range, determine the minimum 
number of transmitters so that every house is within range of at least one transmitter. 
Each transmitter must be installed on top of an existing house.

For example, assume houses are located at x = [1,2,3,5,9] and 
the transmission range k=1.
3 antennae at houses 2 and 5 and 9 would provide complete coverage. 
There is no house at location 7 to cover both 5 and 9. Ranges of coverage, 
are [1,2,3],[5], and [9]. 

Input Format
------------
The first line contains two space-separated integers n and k, the number of houses
and the range of each transmitter. 
The second line contains n space-separated integers describing the respective 
locations of each house x[i].

Output Format
-------------
Print a single integer denoting the minimum number of transmitters needed to cover 
all of the houses.

Sample Input: 
	8 2
	7 2 4 6 5 9 12 11

Sample Output:
	3

Explanation:
        _________________     _____________________     ___
                |                      |                 |
<-------o-------*---o----o----o--------*----------o------*------------------------->
	|	|	|	|	|	 |	  |    |   |   |	  |	     |	    |	   |	  |
	1	2	3	4	5	 6	  7	   8   9   10	 11	     12     13	   14	  15

We can cover the entire city by installing 3 transmitters on houses at locations 4, 9, and 12.


------------------Testcases------------------------------

case =1
input =7 2
7 1 4 8 5 12 11
output =4

case =2
input =5 1
1 2 3 4 6
output =3

case =3
input =10 2
5 1 2 7 9 8 6 10 13 17 
output =5

case =4
input =8 2
7 2 4 6 5 9 12 11
output =3

case =5
input =5 1
1 2 3 4 5
output =2

case =6
input =8 2
2 2 2 2 1 1 1 1
output =1

case =7
input =20 3
6 1 17 19 20 13 20 14 11 10 10 9 1 8 1 9 15 2 1 15
output =4

case =8
input =15 4
4 1 7 18 14 8 19 2 7 1 8 8 1 5 1
output =2
 */
package Elite;
import java.util.*;
public class HackerlandRadioTransmission {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int houses = sc.nextInt();
		int power = sc.nextInt();
		LinkedList<Integer> locations = new LinkedList<>();
		for(int i=0;i<houses;i++) {
			int in = sc.nextInt();
			if(!locations.contains(in))locations.add(in);
		}
		Collections.sort(locations);
		//System.out.println(locations);
		int transmitters = 0;
		int i = 0;
		while(i < locations.size()) {
			int curr = locations.get(i);
			int temp = curr;
			for(int j =curr + power; j>= curr;j--) {
				if(locations.contains(j)) {
					temp = j;
					break;
				}
			}
			if(temp == curr) {
				i++;
			}
			else {
				int temp2 = temp;
				for(int j =temp + power; j>= temp;j--) {
					if(locations.contains(j)) {
						temp2 = j;
						break;
					}
				}
				i = locations.indexOf(temp2) + 1;
			}
			transmitters++;
		}
		System.out.println(transmitters);
	}
}