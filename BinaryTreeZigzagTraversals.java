/* 03/03/2020
 * 
/*
Problem: Write a program to display Zigzag order traversal of a given n nodes tree.

		       	  1
		       /	 \  
		      /       \
		     /   	   \
		    2      	    3
		  /   \    	  /   \
		 4     5  	 6     7
	    / \   / \   / \   / \
       8  9  10 11  12 13 14 15
 
Sample Input:15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

Sample Output:
1 3 2 4 5 6 7 15 14 13 12 11 10 9 8

*/
package Elite;

import java.util.*;

// MyBinaryTreeNode Class containing left and right child of current node and data value
class MyBinaryTreeNode11 {

	public int data;
	public MyBinaryTreeNode11 left;
	public MyBinaryTreeNode11 right;

	public MyBinaryTreeNode11(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public MyBinaryTreeNode11 getLeft() {
		return left;
	}

	public void setLeft(MyBinaryTreeNode11 left) {
		this.left = left;
	}

	public MyBinaryTreeNode11 getRight() {
		return right;
	}

	public void setRight(MyBinaryTreeNode11 right) {
		this.right = right;
	}

}

class BinaryTree11 {

	// Root of BinaryTree
	MyBinaryTreeNode11 root;

	
		// Function to insert nodes in level order
		public MyBinaryTreeNode11 insertLevelOrder(int[] arr, MyBinaryTreeNode11 root, int i) {

			// Base case for recursion
			if (i < arr.length) {

				if (arr[i] == -1)
					return null;

				MyBinaryTreeNode11 temp = new MyBinaryTreeNode11(arr[i]);
				root = temp;

				// insert left child
				root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

				// insert right child
				root.right = insertLevelOrder(arr, root.right, 2 * i + 2);

			}
			return root;
		}

		
		
	public void zigzagTreeOrder(boolean level,Stack<MyBinaryTreeNode11> stack1,Stack<MyBinaryTreeNode11> stack2) {
		while(!stack1.isEmpty()) {
			MyBinaryTreeNode11 node = stack1.pop();
			System.out.print(node.data + " ");
			if(level) {
				if(node.left !=null) stack2.add(node.left);
				if(node.right != null) stack2.add(node.right);
			}
			else {
				if(node.right != null) stack2.add(node.right);
				if(node.left !=null) stack2.add(node.left);
			}
		}
		if(stack2.isEmpty()) return;
		zigzagTreeOrder(!level, stack2, stack1);
	}
}// end of BinaryTree

public class BinaryTreeZigzagTraversals {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int numOfNodes = sc.nextInt();
		BinaryTree11 bt = new BinaryTree11();
		int arr[] = new int[numOfNodes];
		for (int i = 0; i < numOfNodes; i++)
			arr[i] = sc.nextInt();
		bt.root = new MyBinaryTreeNode11(arr[0]);
		bt.root = bt.insertLevelOrder(arr, bt.root, 0);
		Stack<MyBinaryTreeNode11> stack1 = new Stack<>();
		stack1.add(bt.root);
	    Stack<MyBinaryTreeNode11> stack2 = new Stack<>();
		bt.zigzagTreeOrder(true,stack1,stack2);  
	}
}