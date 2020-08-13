/* 27/02/2020
 * 
 * 
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf 
 * path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:
Sample input: 5 4 8 11 13 4 7 2 -1 -1 -1 1
22

output :
true

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1


return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
package Elite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class TreeNode {

	public int data;
	public TreeNode2 left;
	public TreeNode2 right;

	public TreeNode(int data) {
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


class BinaryTree6 {

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

	/* Has Path Sum */
	public boolean hasPathSum(TreeNode2 root, int sum) {
		System.out.println(sum);
	    if(sum < 0 || root == null) return false;
	    if(root.left == null && root.right == null && sum-root.data == 0) return true;

	    
	    if(hasPathSum(root.left,sum-root.data)) return true;
	    if(hasPathSum(root.right,sum-root.data)) return true;
	    
	    return false;   
	}	  
}

public class SumBinaryTree {

	public static void main(String args[] ) throws IOException {

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BinaryTree6 bt=new BinaryTree6();
		
		String str = br.readLine();
		String[] numbers = str.split(" ");
		int[] arr = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();

		bt.root = new TreeNode2(arr[0]);
		bt.root = bt.insertLevelOrder(arr, bt.root, 0);
		int sum=Integer.parseInt(br.readLine());
		System.out.println(bt.hasPathSum(bt.root,sum));
		}	  
}