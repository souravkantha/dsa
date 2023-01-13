package trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import util.Node;

public class BinaryTreeSerializerDeserializer {
	
	// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
	
	public static List<Integer> serialize(Node root) {
		
		List<Integer> serialisedTree = new LinkedList<>(); 
		
		// BFS - Level Order Traversal
		
		Queue<Node> traversalQueue = new LinkedList<>();
		
		traversalQueue.add(root);
		
		while(!traversalQueue.isEmpty()) {
			
			Node polled = traversalQueue.poll();
			
			if(polled != null) {
			
			serialisedTree.add(polled.getData());
			
			traversalQueue.add(polled.getLeftChild());
			traversalQueue.add(polled.getRightChild());
			
		    } else {
		    	
		    	serialisedTree.add(null);
		    	
		    }
		    	
			
		}
		
		return serialisedTree;
	}
	
	
	public static Node deserialise(final List<Integer> input) {
		
		if(!input.isEmpty()) {
			
//			int len = input.size() - 1;
//			
//			return deserialiserHelper(input, len);
			
			Stack<Node> stack = new Stack<>();
			
			Iterator<Integer> iter = input.iterator();
			
			Node root = null;
					
			if(iter.hasNext()) {
				Integer data = iter.next();
				
				if(data != null) {
					root = new Node(data);
					stack.push(root);
			    }
			}
			
			for(; iter.hasNext();  ) {
				
				 Node poppedNode = stack.pop();
				 
				 Node left = null;
				 
				 Node right = null;
				
				Integer data = iter.next();
				
				if(data != null) {
					left = new Node(data);
			    }
				
				 if(iter.hasNext()) {
						 data = iter.next();
						
						if(data != null) {
							right = new Node(data);
					    }
				}
				
				if(right != null)
					stack.push(right);
				
				if(left != null)
					stack.push(left);
				
				poppedNode.setLeftChild(left);
				poppedNode.setRightChild(right);
				
				
			}
			
			return root;
			
		}
		
		return null;
	}
	
	static int ctr = 0;
	
	/**
	 * 1 , 2 , 3 , null , null , null , null
	 * 
	 * @param input
	 * @param len
	 * @return
	 */
	
	private static Node deserialiserHelper( List<Integer> input, int len) {
		
		System.out.println("ctr:: -> "+ ctr);
		
		if(input.get(ctr) == null) {
			
			return null;
		}
			
				Node root = new Node(input.get(ctr));
				 
				ctr = ctr + 1;
				root.setLeftChild(deserialiserHelper(input , len));
			
				ctr = ctr + 1;
				root.setRightChild(deserialiserHelper(input, len));
			
			return root;
			
	}
	
	
	public static Boolean compareBinaryTrees(Node tree1, Node tree2) {
		
		Queue<Node> firstQueue = new LinkedList<>();
		Queue<Node> secondQueue = new LinkedList<>();
		
		Boolean compareResult = false;
		
		firstQueue.add(tree1);
		secondQueue.add(tree2);
		
		while(!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
			
			Node firstQNode = firstQueue.poll();
			Node secondQNode = secondQueue.poll();
			
			//System.out.println(firstQNode + "::" +  secondQNode);
			
			if(firstQNode == null && secondQNode == null) {
				
				compareResult = true;
				
			} else if((firstQNode == null && secondQNode != null) || (firstQNode != null && secondQNode == null)) {
				
				compareResult = false;
				return compareResult;
				
			} else {
				
				compareResult = firstQNode.getData() == secondQNode.getData(); // if both nodes value same then true otherwise false
				
				if(!compareResult)
					return compareResult;
				
				firstQueue.add(firstQNode.getLeftChild());
				
				firstQueue.add(firstQNode.getRightChild());
				
				secondQueue.add(secondQNode.getLeftChild());
				
				secondQueue.add(secondQNode.getRightChild());
				
			}
			
			
		}
		
		return compareResult;
		
	}
	
	
	public static void main(String[] args) {
		
		// Create a binary tree (this is not a BST)
		
		Node root = new Node(1);
		
		root.setLeftChild(new Node(2));
		
		root.setRightChild(new Node(3));
		
		root.getRightChild().setLeftChild(new Node(4));
		
		root.getRightChild().getLeftChild().setRightChild(new Node(100));
		
		root.getRightChild().setRightChild(new Node(5));
		
		root.getRightChild().getRightChild().setRightChild(new Node(22));
		
	
		Node root1 = new Node(1);
		
		root1.setLeftChild(new Node(2));
		
		root1.setRightChild(new Node(3));
		
		
		  root1.getRightChild().setLeftChild(new Node(4));
		  
		  root1.getRightChild().setRightChild(new Node(5));
		  
		  root1.getRightChild().getRightChild().setRightChild(new Node(292));
		 
		
		
		
		List<Integer> serialisedList = serialize(root);
		
		for (Iterator<Integer> iterator = serialisedList.iterator(); iterator.hasNext();) {
			Integer i =  iterator.next();
			System.out.print(i +" , ");
			
		}
		System.out.println();
		
		// Deserialize the list to tree back
		
		Node deserializedTree = deserialise(serialisedList);
		
		System.out.println();
		
		serialisedList = serialize(deserializedTree);
		
		for (Iterator<Integer> iterator = serialisedList.iterator(); iterator.hasNext();) {
			Integer i =  iterator.next();
			System.out.print(i +" , ");
			
		}
		
		System.out.println();
		System.out.println("****Compare Tree Result********");
		System.out.println(compareBinaryTrees(root, deserializedTree));
		
		
	}
	
	
	

}
