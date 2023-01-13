package trees;

import util.Node;

public class DFSTraversal {
	
	/**
	 *            1
	 *        /       \
	 *      2            3
	 *                /    \
	 *              4        5
	 *               \      /  \
	 *               100   21   22
	 *               
	 * Output: 1, 2, 3, 4, 100, 5, 21, 22
	 * 
	 * @param root
	 */
	public static void preorderTraversal(Node root) {
		
		if(root == null) {
			return;
		}
		
		System.out.println(root); // compute here
		
		preorderTraversal(root.getLeftChild());
		
		preorderTraversal(root.getRightChild());
	}
	
	/**
	 *            1
	 *        /       \
	 *      2            3
	 *                /    \
	 *              4        5
	 *               \      /  \
	 *               100   21   22
	 *               
	 *               
	 * Output: 2, 1, 4, 100, 3, 21, 5, 22
	 * 
	 * @param root
	 */
	public static void inorderTraversal(Node root) {
		
		if(root == null) {
			return;
		}
		
		inorderTraversal(root.getLeftChild());
		
		System.out.println(root); // compute here
		
		inorderTraversal(root.getRightChild());
	}
	
	public static void main(String[] args) {
		
		// Create a binary tree (this is not a BST)
		
				Node root = new Node(1);
				
				root.setLeftChild(new Node(2));
				
				root.setRightChild(new Node(3));
				
				root.getRightChild().setLeftChild(new Node(4));
				
				root.getRightChild().setRightChild(new Node(5));
				
				root.getRightChild().getLeftChild().setRightChild(new Node(100));
				
				
				root.getRightChild().getRightChild().setLeftChild(new Node(21));
				root.getRightChild().getRightChild().setRightChild(new Node(22));
				
				
				preorderTraversal(root);
				System.out.println("**");
				inorderTraversal(root);
	}

}
