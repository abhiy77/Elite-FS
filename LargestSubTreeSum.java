package Elite;

/* 17/01/2020
Problem: Given a binary tree of 7 nodes, find subtree with maximum sum in tree.


	          1
            /   \
           2      3
          / \    / \
         4   5  6   7
         
Sample Input 1:       
1 2 3 4 5 6 7

Sample Output 1: 
28

Explanation 1:
As all the tree elements are positive,
the largest subtree sum is equal to
sum of all tree elements.


              1
            /    \
          -2      3
          / \    /  \
         4   5  -6   2
 
Sample Input 2:
1 -2 3 4 5 -6 2


Sample Output 2:
7

Explanation 2:
Subtree with largest sum is : -2
                             /  \ 
                            4    5
Also, entire tree sum is also 7.

*/

import java.util.Scanner;

class MyBinaryTreeNode2 { 

	public int data;	
	public MyBinaryTreeNode2 left;
	public MyBinaryTreeNode2 right;
	
	public MyBinaryTreeNode2(int data){
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
	public MyBinaryTreeNode2 getLeft() {
		return left;
	}
	public void setLeft(MyBinaryTreeNode2 left) {
		this.left = left;
	}
	public MyBinaryTreeNode2 getRight() {
		return right;
	}
	public void setRight(MyBinaryTreeNode2 right) {
		this.right = right;
	}

	
} 

class BinaryTree3{
    
    int max = Integer.MIN_VALUE;
    
	// Root of BinaryTree 
	MyBinaryTreeNode2 root;
	
	public int findSum(MyBinaryTreeNode2 root){
	    if(root == null)
	        return 0;
	    int x = root.data+findSum(root.left)+findSum(root.right);
	    max = Integer.max(x,max);
	    return x;
	}
	
	
	public int findLargestSubtreeSum(MyBinaryTreeNode2 root){
		
		findSum(root);
		return max;
		
	}
	
	
}
public class LargestSubTreeSum {

	
	public static void main(String args[]) 
	{ 
		BinaryTree3 tree = new BinaryTree3(); 
		
		Scanner sc = new Scanner(System.in);
		
		
		//creating a binary tree
		tree.root = new MyBinaryTreeNode2(sc.nextInt()); 
		tree.root.setLeft(new MyBinaryTreeNode2(sc.nextInt())); 
		tree.root.setRight(new MyBinaryTreeNode2(sc.nextInt())); 
		tree.root.getLeft().setLeft(new MyBinaryTreeNode2(sc.nextInt())); 
		tree.root.getLeft().setRight(new MyBinaryTreeNode2(sc.nextInt())); 
		tree.root.getRight().setLeft(new MyBinaryTreeNode2(sc.nextInt())); 
		tree.root.getRight().setRight(new MyBinaryTreeNode2(sc.nextInt())); 

		System.out.println(tree.findLargestSubtreeSum(tree.root)); 

	}
	
}

