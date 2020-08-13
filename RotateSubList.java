/* 06/03/2020
 * 
 Given a linked list and two positions 'm' and 'n'.
 The task is to rotate the sublist from position m to n, to the right by k places.


Sample Input : 
11 12 13 14 15 16 -1
2 5 2

Sample Output : 
11 14 15 12 13 16

Explanation:
Rotate the sublist 12 13 14 15 towards right 2 times
then the modified list are: 11 14 15 12 13 16
--------------------------------------------------------------------

case=1
input=11 12 13 14 15 16 -1
2 5 7
output=11 13 14 15 12 16


case=2
input=11 12 13 14 15 16 -1
1 5 10
output=11 12 13 14 15 16

case=3
input=11 12 13 14 15 16 -1
1 6 10
output=13 14 15 16 11 12

case=4
input=11 15 16 -1
2 3 11
output=11 16 15

case=5
input=21 25 28 44 75 98 55 44 55 11 15 16 -1
2 10 7
output=21 44 75 98 55 44 55 11 25 28 15 16


 * 
 * 
 */
package Elite;
import java.util.*;

class MyListNode3 {
	public MyListNode3 next;
	public int data;

	// Creates an empty node.
	public MyListNode3() {
		next = null;
		data = Integer.MIN_VALUE;
	}

	// Creates a node storing the specified data.
	public MyListNode3(int data) {
		next = null;
		this.data = data;
	}

	// Returns the node that follows this one.
	public MyListNode3 getNext() {
		return next;
	}

	// Sets the node that follows this one.
	public void setNext(MyListNode3 node) {
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

class MyLinkedList4 {
	// This class has a default constructor:
	public MyLinkedList4() {
		length = 0;
	}

	// Length of the linked list
	private int length = 0;
	// This is the only field of the class. It holds the head of the list
	MyListNode3 head;

	// Insert a node at the end of the list
	public synchronized void insertAtEnd(MyListNode3 node) {
		if (head == null)
			head = node;
		else {
			MyListNode3 p, q;
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
		MyListNode3 temp = head.getNext();
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

public class RotateSubList {

	// static ListNode head;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tempData = -1;

		// create a linked list
		MyLinkedList4 list = new MyLinkedList4();

		// add nodes one by one till you find end of the character
		while ((tempData = sc.nextInt()) != -1) {
			// add nodes to the linked list
			list.insertAtEnd(new MyListNode3(tempData));
		}
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();

		rotateSubList(list.head, m, n, k);
	}

	static void rotateSubList(MyListNode3 A, int m, int n, int k) {
		int size = n - m + 1;

		// If k is greater than size of sublist then
		// we will take its modulo with size of sublist
		if (k > size) {
			k = k % size;
		}

		// If k is zero or k is equal to size or k is
		// a multiple of size of sublist then list
		// remains intact
		if (k == 0 || k == size) {
			MyListNode3 head = A;
			while (head != null) {
				System.out.print(head.getData());
				head = head.getNext();
			}
			return;
		}

		MyListNode3 link = null; // m-th node
		if (m == 1) {
			link = A;
		}

		// This loop will traverse all node till
		// end node of sublist.
		MyListNode3 c = A; // Current traversed node
		int count = 0; // Count of traversed nodes
		MyListNode3 end = null;
		MyListNode3 pre = null; // Previous of m-th node
		while (c != null) {
			count++;

			// We will save (m-1)th node and later
			// make it point to (n-k+1)th node
			if (count == m - 1) {
				pre = c;
				link = c.getNext();
			}
			if (count == n - k) {
				if (m == 1) {
					end = c;
					A = c.getNext();
				} else {
					end = c;

					// That is how we bring (n-k+1)th
					// node to front of sublist.
					pre.setNext(c.getNext());
				}
			}

			// This keeps rest part of list intact.
			if (count == n) {
				MyListNode3 d = c.getNext();
				c.setNext(link);
				end.setNext(d);
				MyListNode3 head = A;
				while (head != null) {
					System.out.print(head.getData() + " ");
					head = head.getNext();
				}
				return;
			}
			c = c.getNext();
		}
	}
}