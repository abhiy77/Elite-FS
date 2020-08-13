/* 14/04/2020 - HOME
 * Jim's Burgers has a line of hungry customers. 
Orders vary in the time it takes to prepare them. 
Determine the order the customers receive their orders. 
Start by numbering each of the customers from 1 to n, front of the line to the back. 
You will then be given an order number and a preparation time for each customer.

The time of delivery is calculated as the sum of the order number and the preparation time. 
If two orders are delivered at the same time, 
assume they are delivered in ascending customer number order.

For example, there are n=5 customers in line. 
They each receive an order number order[i] and a preparation time prep[i].:
Customer		1		2		3		4		5
Order No		8		5		6		2		4
Prep time		3		6		2		3		3
Calculate:
Serve time	    11	    11	    8		5		7

We see that the orders are delivered to customers in the following order:
Order by:
Serve time	5		7		8		11	    11
Customer	4		5		3		1		2

Input Format:
The first line contains an integer n, the number of customers.
Each of the next n lines contains two space-separated integers,
an order number and prep time for customer[i].

Output Format:
Print a single line of n space-separated customer numbers 
(recall that customers are numbered from 1 to n)
that describes the sequence in which the customers receive their burgers. 
If two or more customers receive their burgers at the same time, 
print their numbers in ascending order.

Sample Input-1
3
1 3
2 3
3 3
Sample Output-1
1 2 3

Explanation-1
Jim has the following orders:
1. Order[1]=1, prep[1]=3. This order is delivered at time t=1+3=4 .
2. Order[2]=2, prep[2]=3. This order is delivered at time t=2+3=5 .
3. Order[3]=3, prep[3]=3. This order is delivered at time t=3+3=6 .
The orders were delivered in the same order as the customers stood in line.
The index in order[i] is the customer number and is what is printed. 
In this case, the customer numbers match the order numbers.

Sample Input-2
5
8 1
4 2
5 6
3 1
4 3
Sample Output-2
4 2 5 1 3

Explanation-2
Jim has the following orders:
1. Order[1]=8, prep[1]=1. This order is delivered at time t=8+1=9.
1. Order[2]=4, prep[2]=2. This order is delivered at time t=4+2=6.
1. Order[3]=5, prep[3]=6. This order is delivered at time t=5+6=11.
1. Order[4]=3, prep[4]=1. This order is delivered at time t=3+1=4.
1. Order[5]=4, prep[5]=3. This order is delivered at time t=4+3=7.
When we order these by ascending fulfillment time, we get:

t=4: customer 4.
t=6: customer 2.
t=7: customer 5.
t=9: customer 1.
t=11: customer 3.
We print the ordered numbers in the bulleted listed above as 4 2 5 1 3.

Note: Any orders fulfilled at the same time must be listed by ascending order number.

========= Testcases Program-2 =========
case =1
input =3
1 3
2 3
3 3
output =1 2 3

case =2
input =5
8 1
4 2
5 6
3 1
4 3
output =4 2 5 1 3

case =3
input =2
1 1
1 1
output =1 2

case =4
input =25
122470 725261
193218 693005
355776 603340
830347 284246
974815 823134
251206 572501
55509 927152
299590 651593
222305 641645
984018 463771
494787 286091
217190 833029
820867 380896
744986 630663
875880 667
449199 520904
924615 511326
862614 890277
959638 373599
685864 923011
922324 407528
157354 943714
380643 714960
269853 608576
290422 195768
output =25 11 6 1 9 15 24 2 8 3 16 7 12 23 22 4 13 21 19 14 17 10 20 18 5

case =5
input =5
8 3
5 6
6 2
2 3
4 3
output =4 5 3 1 2

case =6
input =10
86 53
38 91
96 51
96 95
74 86
42 7
60 59
99 69
72 41
11 34
output =10 6 9 7 2 1 3 5 8 4

case =7
input =15
28 44
44 59
87 15
13 11
13 71
25 32
55 25
43 52
42 15
33 36
79 93
55 53
96 67
71 48
63 19
output =4 6 9 10 1 7 15 5 8 3 2 12 14 13 11

case =8
input =20
226 988
725 401
905 276
590 784
511 241
422 398
149 147
888 418
126 167
216 773
685 295
919 551
622 534
736 980
907 213
926 755
892 255
146 937
918 356
922 793
output =9 7 5 6 11 10 18 15 2 17 13 3 1 19 8 4 12 16 20 14

 */
package Elite;
import java.util.*;

public class JimsBurgers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Customer> customers = new LinkedList<>();
		for(int i=0;i<n;i++) {
			int orderNum = sc.nextInt();
			int prepTime = sc.nextInt();
			customers.add(new Customer(i+1, orderNum, prepTime));
		}
		Collections.sort(customers);
		for(Customer customer : customers) {
			System.out.print(customer.index + " ");
		}
	}
}

class Customer implements Comparable<Customer>{
	int index,orderNo,prepTime;

	public Customer(int index,int order_no, int prep_time) {
		this.index = index;
		this.orderNo = order_no;
		this.prepTime = prep_time;
	}

	@Override
	public int compareTo(Customer o) {
		int sum1 = orderNo + prepTime;
		int sum2 = o.orderNo + o.prepTime;
		if(sum1 == sum2) return index - o.index;
		else return sum1 - sum2;
	}
}