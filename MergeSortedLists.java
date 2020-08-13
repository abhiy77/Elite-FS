package Elite;
/*
 * 03/01/2020 
 * 
 * Problem:(Problem No.32 from Linked List) 
 * Given two sorted Linked Lists, we need to merge them into the third list in sorted order.
 * 
 * 
	Sample Input : 
    10 20 30 40 50 -1
	15 25 35 45 -1

	Sample Output : 
	10 15 20 25 30 35 40 45 50
 * 
 * 
 */
import java.util.Scanner;

class MyListNodes {
	public MyListNodes next;
	public int data;

	// Creates an empty node.
	public MyListNodes() {
		next = null;
		data = Integer.MIN_VALUE;
	}

	// Creates a node storing the specified data.
	public MyListNodes(int data) {
		next = null;
		this.data = data;
	}

	// Returns the node that follows this one.
	public MyListNodes getNext() {
		return next;
	}

	// Sets the node that follows this one.
	public void setNext(MyListNodes node) {
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

class MyLinkedList2 {
	// This class has a default constructor:
	public MyLinkedList2() {
		length = 0;
	}

	// Length of the linked list
	private int length = 0;
	// This is the only field of the class. It holds the head of the list
	MyListNodes head;

	// Insert a node at the end of the list
	public synchronized void insertAtEnd(MyListNodes node) {
		if (head == null)
			head = node;
		else {
			MyListNodes p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(node);
		}
		length++;
	}



	// Return the current length of the list.
	public int length() {
		return length;
	}

}

public class MergeSortedLists {
	
	
	// static ListNode head;
		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			int tempData = -1;

			// create a linked list
			MyLinkedList2 list1 = new MyLinkedList2();

			// add nodes one by one till you find end of the character
			while ((tempData = sc.nextInt()) != -1) {
				// add nodes to the linked list
				list1.insertAtEnd(new MyListNodes(tempData));
			}
			
			// create a linked list
			MyLinkedList2 list2 = new MyLinkedList2();

			// add nodes one by one till you find end of the character
			while ((tempData = sc.nextInt()) != -1) {
				// add nodes to the linked list
				list2.insertAtEnd(new MyListNodes(tempData));
			}

			// create a linked list
			MyLinkedList2 mergedList = new MyLinkedList2();

			// call merge two lists iterative function
			mergedList.head = mergeTwoLists(list1.head,list2.head);
			
			while(mergedList.head != null){
			    System.out.print(mergedList.head.getData() + " ");
			    mergedList.head = mergedList.head.getNext();
			}

		}
	
	
	public static MyListNodes mergeTwoLists(MyListNodes head1, MyListNodes head2) {
       MyListNodes x = null;
       if(head1.data < head2.data){
           x = head1;
           head1 = head1.next;
       }
       else{
           x = head2;
           head2 = head2.next;
       }
       MyListNodes temp = x;
       while(head1!=null && head2 != null){
           if(head1.data < head2.data) {
               x.next = head1;
               head1 = head1.next;
           }
           else{
               x.next = head2;
               head2 = head2.next;
           }
           x=x.next;
       }
       while(head1 != null){
           x.next = head1;
           head1 = head1.next;
           x = x.next;
       }
       while(head2 != null){
           x.next = head2;
           head2= head2.next;
           x = x.next;
       }
       return temp;
    }
}
