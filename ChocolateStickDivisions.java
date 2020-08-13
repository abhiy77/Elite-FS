/* 23/04/2020 - HOME
 * 
You recently received a bag of chocolate sticks for Halloween. 
To prevent you from compulsively eating all the chocolate sticks in one go, 
your dietician devises the following fun game.

In each move, you choose one of the sticks from your bag. 
Then, you either eat it, or break it into some number of equally-sized parts 
and save the pieces for later. The lengths of all sticks must always be integers, 
so breaking a stick into d parts is possible only if d is a divisor of the stick's length, and d>1.
Note that this means that a stick of length 1 cannot be broken anymore, and can only be eaten.

For example, a chocolate stick of length 4 will be dealt with as shown below.
				-----------------
				|   |   |   |   |
				-----------------
1move			/			\	
				---------  	---------		
				|   |   |   |   |   |   		
				--------- 	---------   		
2moves	        /    \       /      \       
			-----   -----	-----   ----- 
			|   |   |   |   |   |   |   |		
			-----   -----	-----   -----   		
4moves to eat all choco sticks.

A total of 7 Moves required
			
			
Given the chocolate sticks you received, 
determine the length of the longest sequence of moves you can perform.


Input Format:
The first line contains one integer n which is the number of chocolate sticks.
The second line contains n space-separated integers a1,a2,a3,a4,..,an,
the lengths of the chocolate sticks.

Output Format:
Print a single integer which is the maximum number of moves you can perform.

Sample Input1:
1
6
Sample Output1:
10

Explanation1:
You break a chocolate stick into three equal parts (1 move), 
then break each of them in half (3 moves), 
and then eat all six sticks (6 moves). 
This gives you 10 moves.
					-------------------
					|  |  |  |  |  |  |
					-------------------
1move			    /	     |		\
				-------   -------  	-------
				|  |  |   |  |  |  	|  |  |
				-------   -------  	-------
3moves	        /   \      /   \      /   \   
			----  ----  ----  ----  ----  ----
			|  |  |  |  |  |  |  |	|  |  |  |
			----  ----  ----  ----  ----  ----
6 moves to eat all.


Sample Input2:
3
1 7 24
Sample Output2:
55
Explanation2:
You make 1 move using the stick of length 1, 
then 8 moves using the stick of length 7, and 
in the end 46 moves using the stick of length 24. 
This gives 55 moves in total.


========= Testcases Program-3 =========
case =1
input =1
6
output =10

case =2
input =3 
1 7 24
output =55

case =3
input =7
10 7 5 12 2 8 9
output =83

case =4
input =27
656498 874575 10 7 5 12 2 8 820864 6 835290 559277 608745 983061 766719 9 13 608745 15 11 686788 759627 14 1 3 4 686788
output =13684318

case =5
input =43
914940 968264 723885 651393 681739 680798 823214 815258 3 952841 948937 2 860801 883376 563454 1 517201 600602 724072 5 658168 612515 4 647985 589924 850440 869895 632273 813438 621425 614858 737974 597142 554746 964647 649264 576975 845136 768468 5 690006 2 199999
output =39483486

case =6
input =20
914940 968264 723885 651393 681739 680798 823214 815258 3 952841 948937 2 860801 883376 563454 1 517201 600602 724072 5
output =18118848

case =7
input =25
132757 87242 704842 959781 528239 359477 24404 563247 436452 540569 994993 634991 212439 60676 145161 703540 513856 77796 671519 480700 839713 834435 564555 817058 379252
output =17052374

case =8
input =30
8522 6969 471 8169 7578 3828 6774 8606 2818 6885 8360 8914 5775 2878 4997 2557 7567 7837 1767 2305 5282 1103 7376 8275 2639 4600 5236 793 1494 8183
output =232837
 */
package Elite;
import java.util.*;
public class ChocolateStickDivisions {
	
	public static int maxMovesPossible(int num) {
		LinkedList<Integer> primes = new LinkedList<>();
		for(int i=2; i*i <= num;i++) {
			while(num % i == 0) {
				primes.add(i);
				num /= i;
			}
		}
		if(num > 1) primes.add(num);
		Collections.sort(primes,Collections.reverseOrder());
		int moves = 1;
		int curr = 1;
		for(int x : primes) {
			curr *= x;
			moves += curr;
		}
		return moves;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int moves = 0;
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			moves += maxMovesPossible(x);
		}
		System.out.println(moves);
	}
}