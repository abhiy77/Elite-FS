/* 24/02/2020
 * 
Given a linked list of 0s, 1s and 2s, sort it.

Sample Input : 
0 1 2 2 0 0 1 0 2 2 1 1 -1

Sample Output : 
0 0 0 0 1 1 1 1 2 2 2 2

 * 
 *
 * 
 */
package Elite;
import java.util.Scanner;

class MyListNode6 {
	public MyListNode6 next;
	public int data;

	// Creates an empty node.
	public MyListNode6() {
		next = null;
		data = Integer.MIN_VALUE;
	}

	// Creates a node storing the specified data.
	public MyListNode6(int data) {
		next = null;
		this.data = data;
	}

	// Returns the node that follows this one.
	public MyListNode6 getNext() {
		return next;
	}

	// Sets the node that follows this one.
	public void setNext(MyListNode6 node) {
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

class MyLinkedList6 {
	// This class has a default constructor:
	public MyLinkedList6() {
		length = 0;
	}

	// Length of the linked list
	private int length = 0;
	// This is the only field of the class. It holds the head of the list
	MyListNode6 head;

	// Insert a node at the end of the list
	public synchronized void insertAtEnd(MyListNode6 node) {
		if (head == null)
			head = node;
		else {
			MyListNode6 p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(node);
		}
		length++;
	}

	// Return a string representation of this collection, in the form
	// "str1" "str2" ....
	public String toString() {
	    StringBuffer sb = new StringBuffer();
	    while(head != null){
	        sb.append(head.data + " ");
	        head = head.next;
	    }
	    return sb.toString();
	  
	}

	// Return the current length of the list.
	public int length() {
		return length;
	}

}

public class SortLinkedList {

	// static ListNode head;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tempData = -1;

		// create a linked list
		MyLinkedList6 list = new MyLinkedList6();

		// add nodes one by one till you find end of the character
		while ((tempData = sc.nextInt()) != -1) {
			// add nodes to the linked list
			list.insertAtEnd(new MyListNode6(tempData));
		}

		// create a linked list
		MyLinkedList6 sortedList = new MyLinkedList6();

		sortedList.head = sortLinkedList(list.head);

        System.out.println(sortedList.toString());		

	}

	static MyListNode6 sortLinkedList(MyListNode6 head) {
	    MyListNode6 temp = head;
	    int count0 =0,count1=0,count2=0;
	    while(temp!=null){
	        if(temp.data == 0)count0++;
	        if(temp.data == 1)count1++;
	        if(temp.data == 2)count2++;
	        temp = temp.next;
	    }
	    temp = head;
	    while(temp!=null){
	        if(count0 > 0){
	            temp.data = 0; count0--;
	        }
	        else if(count1 > 0){
	            temp.data = 1; count1--;
	        }
	        else if(count2 > 0){
	            temp.data = 2; count2--;
	        }
	        temp = temp.next;
	    }
	    return head;
	}

}