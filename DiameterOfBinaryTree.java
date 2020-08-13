package Elite;

/*
The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
write a program to find Diameter of a given Binary Tree .
Note:Construction of a complete binary tree is based on level order fashion.
 

Sample Input :     
6
1 2 3 4 5 6

Sample Output : 
5

Explanation: 4-2-1-3-6 or 5-2-1-3-6
			  1
			/   \
		   2     3
      	  / \   / 
     	 4   5  6

 * 
 */

import java.util.Scanner;

//MyBinaryTreeNode Class containing left and right child of current node and data value
class MyBinaryTreeNode1 {

	public int data;
	public MyBinaryTreeNode1 left;
	public MyBinaryTreeNode1 right;

	public MyBinaryTreeNode1(int data) {
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

	public MyBinaryTreeNode1 getLeft() {
		return left;
	}

	public void setLeft(MyBinaryTreeNode1 left) {
		this.left = left;
	}

	public MyBinaryTreeNode1 getRight() {
		return right;
	}

	public void setRight(MyBinaryTreeNode1 right) {
		this.right = right;
	}

}

class BinaryTree2 {
    
    public static int leftMax = 0,rightMax = 0;

	// Root of BinaryTree
	MyBinaryTreeNode1 root;

	// Function to insert nodes in level order
	public MyBinaryTreeNode1 insertLevelOrder(int[] arr, MyBinaryTreeNode1 root, int i) {
		// Base case for recursion
		if (i < arr.length) {
			MyBinaryTreeNode1 temp = new MyBinaryTreeNode1(arr[i]);
			root = temp;

			// insert left child
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

			// insert right child
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
		}
		return root;
	}
	
	 int height(MyBinaryTreeNode1 root) {
		if(root == null) return 0;
		
		return (1 + Math.max(height(root.left),height(root.right)));
	}
	
	int diameter(MyBinaryTreeNode1 root) {
		if(root == null) return 0;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		int leftDiameter = diameter(root.left);
		int rightDiameter = diameter(root.right);
		
		return Math.max(leftHeight+rightHeight+1,Math.max(leftDiameter, rightDiameter));
	}

	
//	int diameter(MyBinaryTreeNode1 root,int c,boolean left) {
//		if(root == null){
//		    if(leftMax < c && left) {
//		        leftMax = c;
//		    }
//		    else if(rightMax < c && !left){
//		        rightMax = c;
//		    }
//		    return c;
//		}
//		
//		diameter(root.left,c+1,left);
//		diameter(root.right,c+1,!left);
//		return rightMax+leftMax+1;
//	}
}

public class DiameterOfBinaryTree {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int numOfNodes = sc.nextInt();
		BinaryTree2 bt = new BinaryTree2();
		int arr[] = new int[numOfNodes];
		for (int i = 0; i < numOfNodes; i++)
			arr[i] = sc.nextInt();
		bt.root = new MyBinaryTreeNode1(arr[0]);
		bt.root = bt.insertLevelOrder(arr, bt.root, 0);
		System.out.println(bt.diameter(bt.root));
	}
}