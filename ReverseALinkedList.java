package Elite;
/*  30/12/2019
 * Problem: Reverse a singly linked list.
 *
 * Sample Input and Output:
 *
Sample Input :
    15 4 85 10 -1

Sample Output :
Given Linked List
15 4 85 10
Reversed Linked List
10 85 4 15
 *
 *
 */
import java.util.*;

class MyListNode1 {
public MyListNode1 next;
public int data;

// Creates an empty node.
public MyListNode1() {
next = null;
data = Integer.MIN_VALUE;
}

// Creates a node storing the specified data.
public MyListNode1(int data) {
next = null;
this.data = data;
}

// Returns the node that follows this one.
public MyListNode1 getNext() {
return next;
}

// Sets the node that follows this one.
public void setNext(MyListNode1 node) {
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

class MyLinkedList1 {
// This class has a default constructor:
public MyLinkedList1() {
length = 0;
}

// Length of the linked list
private int length = 0;
// This is the only field of the class. It holds the head of the list
MyListNode1 head;

// Insert a node at the end of the list
public synchronized void insertAtEnd(MyListNode1 node) {
if (head == null)
head = node;
else {
MyListNode1 p, q;
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
MyListNode1 temp = head.getNext();
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

public class ReverseALinkedList {

// static ListNode head;
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
int tempData = -1;

// create a linked list
MyLinkedList1 list = new MyLinkedList1();

// add nodes one by one till you find end of the character
while ((tempData = sc.nextInt()) != -1) {
// add nodes to the linked list
list.insertAtEnd(new MyListNode1(tempData));
}

System.out.println("Given Linked List");
System.out.println(list.toString());

// call reverse list iterative function
list.head = reverseListIterative(list.head);
System.out.println("Reversed Linked List ");
System.out.println(list.toString());

}


public static MyListNode1 reverseListIterative(MyListNode1 head) {
   // Write Your Code Here
   if(head == null || head.next == null) return head;
   else{
        MyListNode1 curr = head.next;
        MyListNode1 prev = head;
        MyListNode1 nex = null;
        head.next = null;
        while(curr.next != null){
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        curr.next = prev;
        return nex;
   }
}
}
