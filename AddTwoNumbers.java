package Elite;
/* 14/02/2020 

Given two numbers represented by two lists, 
write a function that returns sum list. 
The sum list is list representation of addition of two input numbers.

Sample Input : 
5 6 3 -1
8 4 2 -1

Sample Output : 
3 1 6

Explanation:
  First List: 5->6->3  // represents number 365
  Second List: 8->4->2 //  represents number 248

  Resultant list: 3->1->6  // represents number 613
 */
import java.util.Scanner;

class MyListNode4 {
	public MyListNode4 next;
	public int data;

	// Creates an empty node.
	public MyListNode4() {
		next = null;
		data = Integer.MIN_VALUE;
	}

	// Creates a node storing the specified data.
	public MyListNode4(int data) {
		next = null;
		this.data = data;
	}

	// Returns the node that follows this one.
	public MyListNode4 getNext() {
		return next;
	}

	// Sets the node that follows this one.
	public void setNext(MyListNode4 node) {
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

class MyLinkedList5 {
	// This class has a default constructor:
	public MyLinkedList5() {
		length = 0;
	}

	// Length of the linked list
	private int length = 0;
	// This is the only field of the class. It holds the head of the list
	MyListNode4 head;

	// Insert a node at the end of the list
	public synchronized void insertAtEnd(MyListNode4 node) {
		if (head == null)
			head = node;
		else {
			MyListNode4 p, q;
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
		MyListNode4 temp = head.getNext();
		while (temp != null && temp.data !=-1) {
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

public class AddTwoNumbers {

	// static ListNode head;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tempData = -1;

		// create a linked list
		MyLinkedList5 list1 = new MyLinkedList5();
		MyLinkedList5 list2 = new MyLinkedList5();

		// add nodes one by one till you find end of the character
		while ((tempData = sc.nextInt()) != -1) {
			// add nodes to the linked list
			list1.insertAtEnd(new MyListNode4(tempData));
		}
		// add nodes one by one till you find end of the character
		while ((tempData = sc.nextInt()) != -1) {
			// add nodes to the linked list
			list2.insertAtEnd(new MyListNode4(tempData));
		}

		// create a linked list
		MyLinkedList5 resultList = new MyLinkedList5();

		resultList.head = addTwoReversedNumbers(list1.head, list2.head);

		System.out.println(resultList.toString());

	}

	public static MyListNode4 addTwoReversedNumbers(MyListNode4 l1, MyListNode4 l2) {
        MyListNode4 l = new MyListNode4();
        MyListNode4 temp = l;
        int carry = 0;
        while(l1 != null && l2 != null){
            int num = l1.data + l2.data + carry;
            carry = (num)/10;
            l.data = num%10;
            l.next = new MyListNode4();
            l = l.next;
            l1 = l1.next; l2=l2.next;
        }
        while(l1 !=null){
            int num = l1.data + carry;
            carry = (num)/10;
            l.data = num%10;
            l.next = new MyListNode4();
            l = l.next;
            l1 = l1.next; 
        }
        while(l2 !=null){
            int num = l2.data + carry;
            carry = (num)/10;
            l.data = num%10;
            l.next = new MyListNode4();
            l = l.next;
            l2=l2.next;
        }
        if(carry ==1) l.data = 1;
        else l.data = -1;
        return temp;
	}
}
