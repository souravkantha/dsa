package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.Node;

public class BSTSerializerDeserializer {
	
	public static List<Integer>  serialize(Node root) {
		
		
		List<Integer> result = new LinkedList<>();
		
		return serializeHelper(root, result);
		
	}
	
	/**
	 * 
	 * @param root
	 * @param result
	 * @return
	 */
	private static List<Integer> serializeHelper(Node root, List<Integer> result) {
		
		// will perform in-order traversal and add element in the Integer array
		
		if(root != null) {
			
			serializeHelper(root.getLeftChild(), result);
			
			// add in the result list
			result.add(root.getData());
			
			serializeHelper(root.getRightChild(), result);
			
			return result;
			
		}
		
		return null;
		
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static Node deserialize(List<Integer> input) {
		
		return deserializerHelper(input, 0, input.size() - 1);
	}

	/**
	 * 
	 * @param input
	 * @param low
	 * @param high
	 * @return
	 */
	public static Node deserializerHelper(List<Integer> input, int low, int high) {
		
		if(low <= high) {
			
			int mid = low + (high - low) / 2;
			
			Node root = new Node(input.get(mid));
			
			root.setLeftChild(deserializerHelper(input, low, mid - 1));
			
			root.setRightChild(deserializerHelper(input, mid + 1, high));
			
			return root;
			
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param tree
	 */
	public static void printBinaryTreeByLevel(Node tree) {
		
		if(tree != null) {
			
			Queue<Node> queue = new LinkedList<>();
			
			
			queue.offer(null);
			queue.offer(tree);
			
			int levelCtr = 0;
			
			while(!queue.isEmpty()) {
				
				Node polledItem = queue.poll();
				
				if(polledItem == null && !queue.isEmpty()) {
					
					queue.offer(null);
					System.out.println();
					System.out.print("Level -> " + ++levelCtr);
					System.out.print("     ");
					
				} else {
					
					if(polledItem != null) {
						System.out.print(polledItem);
						System.out.print(" ");
						if(polledItem.getLeftChild() != null)
							queue.offer(polledItem.getLeftChild());
						
						if(polledItem.getRightChild() != null)
							queue.offer(polledItem.getRightChild());
						}
				}
				
			}
			
		}
		
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 *         >>> Deserialized <<<
		 *         
		 *            4
		 *        /       \
		 *      2           6
		 *    /  \        /    \
		 *  1     3      5      7
		 *                       \
		 *                        10
		 *                        
		 *          >>> Serialized (keeping sort order as-is) <<<    
		 * 
		 * 1, 2, 3, 4, 5, 6, 7, 10
		 *                        
		 */               
		
		Node originalTree = new Node(4);
		
		originalTree.setLeftChild(new Node(2));
		originalTree.getLeftChild().setLeftChild(new Node(1));
		originalTree.getLeftChild().setRightChild(new Node(3));
		
		originalTree.setRightChild(new Node(6));
		originalTree.getRightChild().setLeftChild(new Node(5));
		originalTree.getRightChild().setRightChild(new Node(7));
		
		originalTree.getRightChild().getRightChild().setRightChild(new Node(10));
		
		List<Integer> serializedData = serialize(originalTree);
		
		serializedData.forEach(value -> System.out.print(value + " "));
		System.out.println();
		
		
		Node deserializedTree = deserialize(serializedData);
		
		Boolean compareResult = BinaryTreeSerializerDeserializer.compareBinaryTrees(originalTree, deserializedTree);
		
		System.out.println("Deserialisation successful -> " + compareResult);
		
		printBinaryTreeByLevel(deserializedTree);
		
		
	}

}
