/* 05/03/2020
 * Given a singly linked list, remove all the nodes which have a greater value 
 on right side.

Examples:
a) The list 12->15->10->11->5->6->2->3->NULL should be changed 
to 15->11->6->3->NULL. 
Note that 12, 10, 5 and 2 have been deleted because there is a greater 
value on the right side.

When we examine 12, we see that after 12 there is one node with value greater 
than 12 (i.e. 15), so we delete 12.
When we examine 15, we find no node after 15 that has value greater than 15 
so we keep this node.
When we go like this, we get 15->11->6->3

	Sample Input : 
    12 15 10 11 5 6 2 3 -1

	Sample Output : 
	15 11 6 3
 * 
 * 
 */
package Elite;
import java.util.Scanner;

class MyListNode7 {
	public MyListNode7 next;
	public int data;

	// Creates an empty node.
	public MyListNode7() {
		next = null;
		data = Integer.MIN_VALUE;
	}

	// Creates a node storing the specified data.
	public MyListNode7(int data) {
		next = null;
		this.data = data;
	}

	// Returns the node that follows this one.
	public MyListNode7 getNext() {
		return next;
	}

	// Sets the node that follows this one.
	public void setNext(MyListNode7 node) {
		next = node;
	}

	// Returns the data stored in this node.
	public int getData() {
		return data;
	}

	// Sets the data stored in this node.
	public void setData(int elem) {
		data = elem;
	}

	// Sets the data stored in this node.
	public String toString() {
		return Integer.toString(data);
	}
}

class MyLinkedList7{
	// This class has a default constructor:
	public MyLinkedList7() {
		length = 0;
	}

	// Length of the linked list
	private int length = 0;
	// This is the only field of the class. It holds the head of the list
	MyListNode7 head;

	// Insert a node at the end of the list
	public synchronized void insertAtEnd(MyListNode7 node) {
		if (head == null)
			head = node;
		else {
			MyListNode7 p, q;
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
			return result + "";
		}
		result = result + head.getData();
		MyListNode7 temp = head.getNext();
		while (temp != null) {
			result = result + " " + temp.getData();
			temp = temp.getNext();
		}
		return result + "";
	}

	// Return the current length of the list.
	public int length() {
		return length;
	}
}

public class DeleteLesserNodes {

	// static ListNode head;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tempData = -1;

		// create a linked list
		MyLinkedList7 list = new MyLinkedList7();

		// add nodes one by one till you find end of the character
		while ((tempData = sc.nextInt()) != -1) {
			// add nodes to the linked list
			list.insertAtEnd(new MyListNode7(tempData));
		}

		// create a linked list
		MyLinkedList7 remainingNodes = new MyLinkedList7();

		remainingNodes.head = delLesserNodes(list.head);

		while(remainingNodes.head != null) {
			System.out.print(remainingNodes.head.data+" ");
			remainingNodes.head = remainingNodes.head.next;
		}
	}
	
	static MyListNode7 delLesserNodes(MyListNode7 head) {
	    MyListNode7 retHead = new MyListNode7(-1),move = retHead;
	    while(head != null){
	        MyListNode7 curr = head.next;
	        int val = head.data;
	        while(curr != null){
	            if(head.data > curr.data) curr = curr.next;
	            else break;
	        }
	        if(curr == null){
	        MyListNode7 next = new MyListNode7(head.data);
	        move.next = next;
	        move = move.next;
	        }
	        head = head.next;
	    }
	    return retHead.next;
	}
}