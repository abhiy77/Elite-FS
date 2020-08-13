package Elite;
import java.util.Scanner;
/* 10/01/2020

* For a given K value (K > 0), Reverse a Linked List in groups of size K.
* 

Sample Input : 
10 20 30 40 50 60 -1
3

Sample Output : 
30 20 10 60 50 40
   
* 
* 
*/

class MyListNode2 {
	public MyListNode2 next;
	public int data;

	// Creates an empty node.
	public MyListNode2() {
		next = null;
		data = Integer.MIN_VALUE;
	}

	// Creates a node storing the specified data.
	public MyListNode2(int data) {
		next = null;
		this.data = data;
	}

	// Returns the node that follows this one.
	public MyListNode2 getNext() {
		return next;
	}

	// Sets the node that follows this one.
	public void setNext(MyListNode2 node) {
		next = node;
	}

	// Returns the data stored in this node.
	public int getData() {
		return data;
	}

	// Sets the data stored in this node.
	public void setdata(int elem) {
		data = elem;
	}

	// Sets the data stored in this node.
	public String toString() {
		return Integer.toString(data);
	}
}

class MyLinkedList3 {
	// This class has a default constructor:
	public MyLinkedList3() {
		length = 0;
	}

	// Length of the linked list
	private int length = 0;
	// This is the only field of the class. It holds the head of the list
	MyListNode2 head;

	// Insert a node at the end of the list
	public synchronized void insertAtEnd(MyListNode2 node) {
		if (head == null)
			head = node;
		else {
			MyListNode2 p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(node);
		}
		length++;
	}

	// Return a string representation of this collection, in the form
	// "str1" "str2" ....
	public String toString() {
		String result = "";
		if (head == null) {
			return "NULL";
		}
		result = result + head.getData();
		MyListNode2 temp = head.getNext();
		while (temp != null) {
			result = result + " " + temp.getData();
			temp = temp.getNext();
		}
		
		return result;
	}

	// Return the current length of the list.
	public int length() {
		return length;
	}

}

public class ReverseKNodes{

   public static MyListNode2 reverseKNodes(MyListNode2 head, int k){
   	// Write Your code here
   	MyListNode2 curr=head,next=null,prev=null;
   	int count=0;
   	while(curr!=null && count!=k)
   	{
   	        count++;
   	        next=curr.getNext();
   	        curr.setNext(prev);
   	        prev=curr;
   	        curr=next;
   	}
   	
   	if(next!=null)
   	{
   	    head.setNext(reverseKNodes(next,k));
   	}
   	return prev;
   }

   public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tempData = -1;

		// create a linked list
		MyLinkedList3 list = new MyLinkedList3();

		// add nodes one by one till you find end of the character
		while ((tempData = sc.nextInt()) != -1) {
			// add nodes to the linked list
			list.insertAtEnd(new MyListNode2(tempData));
		}
		
		int k=sc.nextInt();
		
		list.head = reverseKNodes(list.head,k);
		System.out.println(list.toString());

	}
}