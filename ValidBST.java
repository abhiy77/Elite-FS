/* 02/03/2020
 * 
 Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input:2 1 3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input:5 1 4 -1 -1 3 6
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
package Elite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


class TreeNode2 {

	public int data;
	public TreeNode2 left;
	public TreeNode2 right;

	public TreeNode2(int data) {
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

	public TreeNode2 getLeft() {
		return left;
	}

	public void setLeft(TreeNode2 left) {
		this.left = left;
	}

	public TreeNode2 getRight() {
		return right;
	}

	public void setRight(TreeNode2 right) {
		this.right = right;
	}

}
class BinaryTree9 {

	// Root of BinaryTree
	TreeNode2 root;

	// Function to insert nodes in level order
	public TreeNode2 insertLevelOrder(int[] arr, TreeNode2 root, int i) {
		// Base case for recursion
		if (i < arr.length) {
			TreeNode2 temp = new TreeNode2(arr[i]);
			root = temp;
			if (arr[i] == -1)
				return null;

			// insert left child
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

			// insert right child
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
		}
		return root;
	}

	 public boolean isLeaf(TreeNode2 t) {
	        return t.left == null && t.right == null;
	    }

	    public void addLeaves(List<Integer> res, TreeNode2 root) {
	        if (isLeaf(root)) {
	            res.add(root.data);
	        } else {
	            if (root.left != null) {
	                addLeaves(res, root.left);
	            }
	            if (root.right != null) {
	                addLeaves(res, root.right);
	            }
	        }
	    }
	    // valid bst code
	    
	 
	    	public  boolean isValidBST(TreeNode2 root) {   
		    if(root.left == null && root.right == null ) return true;
		    if(root.left!= null && root.left.data > root.data || root.right != null && root.right.data < root.data) return false;
		    if(isValidBST(root.left)) return true;
		    if(isValidBST(root.right)) return true;
		    return false;
		  }
}

public class ValidBST {

	
	  
	  public static void main(String args[]) throws IOException
	    { 
	    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 		String str = br.readLine();
	 		
	 		String[] numline = str.split(" ");
	 		int[] arr = Arrays.asList(numline).stream().mapToInt(Integer::parseInt).toArray();
	     
			BinaryTree9 bt = new BinaryTree9();
			bt.root = new TreeNode2(arr[0]);
			bt.root = bt.insertLevelOrder(arr, bt.root, 0);

			System.out.println(bt.isValidBST(bt.root));

		}
}