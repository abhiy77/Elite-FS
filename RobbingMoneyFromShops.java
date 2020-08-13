/*  05/03/2020
The robber has found himself a new place for his robbery again. 
There is only one entrance to this area, called the "root." 

Besides the root, each shop has one and only one parent shop. 
After a tour, the smart robber realized that "all shops in this place forms a binary tree". 
It will automatically contact the police if two directly-linked shops were broken into on the same night.

Determine the maximum amount of money the robber can rob tonight without alerting the police.



Note: -1 represents "no node"

Sample Input 1:     
7
13 12 13 -1 13 -1 11

Sample Output 1: 
37

Explanation: 
     13
    / \
   12  13
    \   \ 
     13  11
Maximum amount of money the robber can rob = 13 (root)+ 13(leaf) + 11 (leaf) = 37.

================================================================================

Sample Input 2: 
7
13 14 15 11 13 -11 11

Sample Output 2: 
29

Explanation: 

     13
    / \
  14   15
  / \   \ 
 11 13   11

Maximum amount of money the robber can rob = 14 + 15  = 29.
*/
/*
The robber has found himself a new place for his robbery again. 
There is only one entrance to this area, called the "root." 

Besides the root, each shop has one and only one parent shop. 
After a tour, the smart robber realized that "all shops in this place forms a binary tree". 
It will automatically contact the police if two directly-linked shops were broken into on the same night.

Determine the maximum amount of money the robber can rob tonight without alerting the police.



Note: -1 represents "no node"

Sample Input 1:     
7
13 12 13 -1 13 -1 11

Sample Output 1: 
37

Explanation: 
     13
    / \
   12  13
    \   \ 
     13  11
Maximum amount of money the robber can rob = 13 (root)+ 13(leaf) + 11 (leaf) = 37.

================================================================================

Sample Input 2: 
7
13 14 15 11 13 -11 11

Sample Output 2: 
29

Explanation: 

     13
    / \
  14   15
  / \   \ 
 11 13   11

Maximum amount of money the robber can rob = 14 + 15  = 29.

======================================================================================


case=1
input=7
3 2 3 -1 3 -1 1
output=7

case=2
input=7
3 4 5 1 3 -1 1
output=9

case=3
input=15
5 7 9 -1 3 2 -1 -1 17 -1 15 20 13 14 15
output=64

case=4
input=18 
5 7 9 -1 3 2 25 -1 50 -1 17 45 -1 15 20 13 14 15
output=113

case=5
input=8 
3 25 50 17 45 15 20 13 14 15
output=112

case=6
input=7
3 4 5 1 3 15 20
output=42

 * 
 */
package Elite;
import java.util.*;

//MyBinaryTreeNode Class containing left and right child of current node and data value
class MyBinaryTreeNode7 {

	public int data;
	public MyBinaryTreeNode7 left;
	public MyBinaryTreeNode7 right;

	public MyBinaryTreeNode7(int data) {
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

	public MyBinaryTreeNode7 getLeft() {
		return left;
	}

	public void setLeft(MyBinaryTreeNode7 left) {
		this.left = left;
	}

	public MyBinaryTreeNode7 getRight() {
		return right;
	}

	public void setRight(MyBinaryTreeNode7 right) {
		this.right = right;
	}
}

class BinaryTree7 {

	// Root of BinaryTree
	MyBinaryTreeNode7 root;

	// Function to insert nodes in level order
	public MyBinaryTreeNode7 insertLevelOrder(int[] arr, MyBinaryTreeNode7 root, int i) {

		// Base case for recursion
		if (i < arr.length) {

			if (arr[i] == -1)
				return null;

			MyBinaryTreeNode7 temp = new MyBinaryTreeNode7(arr[i]);
			root = temp;

			// insert left child
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

			// insert right child
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2);

		}
		return root;
	}

	/*
	 * dfs all the nodes of the tree, 
	 * each node return two number, int[] num, 
	 * num[0] is the max value while rob this node, 
	 * num[1] is max value while not rob this value. 
	 * Current node return value only depend on its children's value. 
	 */
	public int robbery(MyBinaryTreeNode7 root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
     }
    private int[] dfs(MyBinaryTreeNode7 x) {
        if (x == null) return new int[2];
        int[] left = dfs(x.getLeft());
        int[] right = dfs(x.getRight());
        int[] res = new int[2];
        res[0] = left[1] + right[1] + x.getData();
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}

public class RobbingMoneyFromShops {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int numOfNodes = sc.nextInt();
		BinaryTree7 bt = new BinaryTree7();
		int arr[] = new int[numOfNodes];
		for (int i = 0; i < numOfNodes; i++)
			arr[i] = sc.nextInt();
		
		//creating a binary tree
		bt.root = new MyBinaryTreeNode7(arr[0]);
		bt.root = bt.insertLevelOrder(arr, bt.root, 0);
		
		//call rob function 
		System.out.println(bt.robbery(bt.root));
	}
}