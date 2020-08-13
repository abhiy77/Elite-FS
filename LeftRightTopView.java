/* 03/03/2020
Given a Binary Tree, print Right view of it. 
Right view of a Binary Tree is set of nodes visible when 
tree is visited from Right side. 

Note: -1 represents "no node"

Sample Input :     
11
1 2 3 4 5 -1 6 -1 8 9 10

Sample Output : 
1 2 4 8 
1 3 6 10 
4 2 1 3 6

Explanation: 
                 1
               /   \
              2     3
             / \     \
            4   5     6
             \ / \
             8 9 10
             
Left View :1 2 4 8
Right View: 1 3 6 10
Top View: 4 2 1 3 6
          
 * 
 */
package Elite;
import java.util.*;
//MyBinaryTreeNode Class containing left and right child of current node and data value
class MyBinaryTreeNode10 {

	public int data;
	public MyBinaryTreeNode10 left;
	public MyBinaryTreeNode10 right;

	public MyBinaryTreeNode10(int data) {
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

	public MyBinaryTreeNode10 getLeft() {
		return left;
	}

	public void setLeft(MyBinaryTreeNode10 left) {
		this.left = left;
	}

	public MyBinaryTreeNode10 getRight() {
		return right;
	}

	public void setRight(MyBinaryTreeNode10 right) {
		this.right = right;
	}

}

class BinaryTree10 {

	// Root of BinaryTree
	MyBinaryTreeNode10 root;

	// Function to insert nodes in level order
	public MyBinaryTreeNode10 insertLevelOrder(int[] arr, MyBinaryTreeNode10 root, int i) {

		// Base case for recursion
		if (i < arr.length) {

			if (arr[i] == -1)
				return null;

			MyBinaryTreeNode10 temp = new MyBinaryTreeNode10(arr[i]);
			root = temp;

			// insert left child
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

			// insert right child
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2);

		}
		return root;
	}

	

	
	//  function to print left view
			void leftView(MyBinaryTreeNode10 node,StringBuffer sb,int level) {
				if(node == null) return;
			    if(level > sb.length()){
			        sb.append(node.data);
			    }
			    leftView(node.left,sb,level+1);
			    leftView(node.right,sb,level+1);
			}
			

	//  function to print right view
		void rightView(MyBinaryTreeNode10 node,StringBuffer sb,int level) {
		    if(node == null) return;
		    if(level > sb.length()){
		        sb.append(node.data);
		    }
		    rightView(node.right,sb,level+1);
		    rightView(node.left,sb,level+1);
		}
		
		
		
		 // function should print the topView of 
	    public void topView(MyBinaryTreeNode10 root,int level,boolean left) { 
	    	if(root == null) {
	    		return;
	    	}
            if(root != null && left) {
            	topView(root.left, level+1,left);
            	System.out.print(root.data+" ");
            }
            if(level > 1 && left) return;
            if(level == 1)left = !left;
            if(root.right != null && !left) {
            	System.out.print(root.right.data+" ");
            	topView(root.right, level+1,left);
            }
            if(level > 1)left = !left;
        }
}
 class LeftRightTopView {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int numOfNodes = sc.nextInt();
		BinaryTree10 bt = new BinaryTree10();
		int arr[] = new int[numOfNodes];
		for (int i = 0; i < numOfNodes; i++)
			arr[i] = sc.nextInt();
		bt.root = new MyBinaryTreeNode10(arr[0]);
		bt.root = bt.insertLevelOrder(arr, bt.root, 0);
		StringBuffer sb= new StringBuffer();
		bt.leftView(bt.root,sb,1);
		System.out.println(sb);
		sb.delete(0, sb.length());
		bt.rightView(bt.root,sb,1);
		System.out.println(sb);
		sb.delete(0, sb.length()-1);
		bt.topView(bt.root,1,true);
		System.out.println(sb);
	}
}