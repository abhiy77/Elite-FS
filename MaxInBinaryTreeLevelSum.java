/* 20/01/2020
Problem: Given a Binary Tree having positive and negative nodes, 
the task is to find maximum sum level in it.

		              4
                    /   \
                   2    -5
                  / \    /\
                -1   3 -2  6

Sample Input :
7
4 2 -5 -1 3 -2 6

Output: 
6

Explanation :
Sum of all nodes of 0'th level is 4
Sum of all nodes of 1'th level is -3
Sum of all nodes of 2'th level is 6
Hence maximum sum is 6

*/

package Elite;
import java.util.*;

class MyBinaryTreeNode3 {

	public int data;
	public MyBinaryTreeNode3 left;
	public MyBinaryTreeNode3 right;

	public MyBinaryTreeNode3(int data) {
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

	public MyBinaryTreeNode3 getLeft() {
		return left;
	}

	public void setLeft(MyBinaryTreeNode3 left) {
		this.left = left;
	}

	public MyBinaryTreeNode3 getRight() {
		return right;
	}

	public void setRight(MyBinaryTreeNode3 right) {
		this.right = right;
	}

}

class BinaryTree4 {

	// Root of BinaryTree
	MyBinaryTreeNode3 root;

	// Function to insert nodes in level order
	public MyBinaryTreeNode3 insertLevelOrder(int[] arr, MyBinaryTreeNode3 root, int i) {
		// Base case for recursion
		if (i < arr.length) {
			MyBinaryTreeNode3 temp = new MyBinaryTreeNode3(arr[i]);
			root = temp;

			// insert left child
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

			// insert right child
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
		}
		return root;
	}

    public int max = 0;
	public int maxSumInBinaryTreeLevel(MyBinaryTreeNode3 root) {
         Queue<MyBinaryTreeNode3> queue = new LinkedList<>();
         queue.add(root);
         int num = 0,max = 0,temp = 0,i=0;
         while(!queue.isEmpty()){
             MyBinaryTreeNode3 node = queue.poll();
             num++;
            temp+= node.data;
             if(num == Math.pow(2,i)){
                 max = Integer.max(max,temp);
                 temp = 0;
                 num = 0;
                 i++;
             }
             if(node.left!= null)queue.add(node.left);
             if(node.right!= null)queue.add(node.right);
         }
         return max;
	}
}

public class MaxInBinaryTreeLevelSum {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int numOfNodes = sc.nextInt();
		BinaryTree4 bt = new BinaryTree4();
		int arr[] = new int[numOfNodes];
		for (int i = 0; i < numOfNodes; i++)
			arr[i] = sc.nextInt();
		bt.root = new MyBinaryTreeNode3(arr[0]);
		bt.root = bt.insertLevelOrder(arr, bt.root, 0);

		System.out.println(bt.maxSumInBinaryTreeLevel(bt.root));     
	}
}