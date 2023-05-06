package trees;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	
	Character val;
	TrieNode parent;
	Map<Character, TrieNode> nodeMap;
	boolean endOfWord;
	
	TrieNode() {
		nodeMap = new HashMap<>();
	}
	
}

public class Trie {
	
	
	private TrieNode root;
	
	public Trie() {
		
		root = new TrieNode();
		root.parent = null;
		root.val = null;
	}
	
	public boolean contains(String prefix) {
		
		TrieNode currNode = root;
		boolean doesContains = false;
		
		for (Character c : prefix.toCharArray()) {
			
			if (currNode.nodeMap.containsKey(c)) {
				
				currNode = currNode.nodeMap.get(c);
				doesContains = true;
				
			} else {
				
				return false;
			}
			
		}
		
		
		return doesContains;
		
	}
	
	public boolean searchWord(String word) {
		
		
		if(word == null)
			return false;
		
		TrieNode currNode = root;
		
		for (Character c : word.toCharArray()) {
			
			if (currNode.nodeMap.containsKey(c)) {
				
				currNode = currNode.nodeMap.get(c);
				
				
			} else {
				
				return false;
			}
			
		}
		
		if (currNode.endOfWord) {
			
			return true;
		}
		
		
		return false;
		
	}
	
	public void addWord(final String word) {
		
		TrieNode currNode = root;
		
		for (Character c : word.toCharArray()) {
			
			currNode = add(c, currNode, Boolean.FALSE);
			
		}
		
		currNode.endOfWord = Boolean.TRUE;
		
	}
	
	private TrieNode add(Character c, TrieNode currNode, boolean endOfWord) {
		
		if (!currNode.nodeMap.containsKey(c)) {
			
			TrieNode newNode = new TrieNode();
			currNode.nodeMap.put(c, newNode);
			
			// set parent node
			newNode.parent = currNode;
			newNode.val = c;
			
			currNode = newNode;
			currNode.endOfWord = endOfWord;
			
		} else {
			
			currNode = currNode.nodeMap.get(c);
		}
		
		return currNode;
		
	}
	
	public boolean removeWord(final String word) {
		
		
		TrieNode currNode = root;
		
		for (Character c : word.toCharArray()) {
			
			if (!currNode.nodeMap.containsKey(c)) {
				
				return false; // word does not exist
			} else {
				
				currNode = currNode.nodeMap.get(c);
				
			}
			
			
		}
		
		if (currNode.endOfWord) {
			
			// mark currnode end of word as false if there exist another char in the map otherwise remove the node
			
			if (currNode.nodeMap.isEmpty()) {
				
				Character childNodeVal = null;
				
				while (currNode.nodeMap.isEmpty()) {
					
					childNodeVal = currNode.val;
					currNode = currNode.parent;
					
					
				}
				
				currNode.nodeMap.remove(childNodeVal);
				
			} else {
				
				currNode.endOfWord = false;
				
			}
			
			return true;
		} 
		
		return false;
		
	}
	
	public static void main(String[] args) {
		
		
		
		
		// Test
		
		Trie trie = new Trie();
		trie.addWord("abcd");
		trie.addWord("abd");
		
		
		  System.out.println( trie.searchWord("abcd")); // should return true
		  
		  System.out.println( trie.searchWord("abc")); // should return false
		  
		  System.out.println( trie.contains("abc")); // should return true
		  
		  System.out.println( trie.contains("abd")); // should return true
		  
		  System.out.println( trie.contains("")); // should return false
		  
		  System.out.println( trie.searchWord(null)); // should return false
		  
		  System.out.println( trie.searchWord("sdsds")); // should return false
		  
		  System.out.println( trie.removeWord("asjshns")); // should return false
		  
		  System.out.println( trie.removeWord("abc")); // should return false
		  
		  System.out.println( trie.removeWord("abcd")); // should return true
		 		
		System.out.println( trie.contains("abd")); // should return true
		
	}
	

}
