package Elite;

/* 06/01/2010

A binary number is represented as a series of 0's and 1's.
In this challenge, the series will be in the form of a singly-linked list.
Each node instance, a LinkedListNode has a value, val. and a pointer to the 
next node, next. Given a reference to the head of a singly-linked list,
convert the binary number represented to a decimal number.

Example:
        binary linked list
        0->1->0->0->1->1->null
        linked list corresponding to the binary number = (010011) base 2
        decimal number = (19) base 10

Sample Input :
6
0 1 0 0 1 1

Sample Output : 
19

Explanation:
(010011) base 2 = (19) base 10


/*

A binary number is represented as a series of 0's and 1's.
In this challenge, the series will be in the form of a singly-linked list.
Each node instance, a LinkedListNode has a value, val. and a pointer to the 
next node, next. Given a reference to the head of a singly-linked list,
convert the binary number represented to a decimal number.

Example:
        binary linked list
        0->1->0->0->1->1->null
        linked list corresponding to the binary number = (010011) base 2
        decimal number = (19) base 10

Sample Input :
6
0 1 0 0 1 1

Sample Output : 
19

Explanation:
(010011) base 2 = (19) base 10


*/
import java.util.Scanner;

class Node{
    Node next = null;
    int data;
    Node(){
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class BinaryNumberInLinkedList {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int noOfElements = sc.nextInt();
        Node curr=new Node(),temp = curr;
	    for(int i=0;i<noOfElements;i++){
	          curr.data = sc.nextInt();
	          curr.next = new Node();
	          curr = curr.next;
	    }
	    curr = temp;
	    int decimal_num  = 0;
	    for(int i=noOfElements-1 ; i>=0;i--){
	        decimal_num += ((int)Math.pow(2,i) * temp.data);
	        temp = temp.next;
	    }
	    System.out.println(decimal_num);
	}
}
