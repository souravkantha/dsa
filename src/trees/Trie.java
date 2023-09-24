package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class TrieNode {

	Character val;
	TrieNode parent;
	Map<Character, TrieNode> nodeMap;
	boolean endOfWord;

	TrieNode() {
		nodeMap = new HashMap<>();
	}

}

record Tuple(TrieNode node, Boolean val) {
}

/**
 * @author Sourav Kantha
 *
 */
public class Trie {

	private TrieNode root;

	public Trie() {

		root = new TrieNode();
		root.parent = null;
		root.val = null;
	}

	public void addWord(final String word) {

		TrieNode currNode = root;

		for (Character c : word.toCharArray()) {

			currNode = add(c, currNode, Boolean.FALSE);

		}

		currNode.endOfWord = Boolean.TRUE;

	}
	
	public boolean contains(String prefix) {

		return containsNode(prefix).val();

	}
	
	public List<String> autoSuggest(String prefix) {
		
		List<String> autoSuggestedList = new ArrayList<>();
		Tuple t = containsNode(prefix);
		
		if (Objects.nonNull(t.node())) {
			
			 TrieNode currNode = t.node();
			 
			 autoSuggestedList =
					 fetchAllPossibleWords(autoSuggestedList, currNode, new StringBuilder(prefix));
		}
			
		return autoSuggestedList;
		
	}
	
	public boolean searchWord(String word) {

		if (word == null)
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

			// mark currnode end of word as false if there exist another char in the map
			// otherwise remove the node

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

	private Tuple containsNode(String prefix) {

		Tuple t = new Tuple(null, Boolean.FALSE);
		TrieNode currNode = root;
		boolean doesContains = false;

		for (Character c : prefix.toCharArray()) {

			if (currNode.nodeMap.containsKey(c)) {

				currNode = currNode.nodeMap.get(c);
				doesContains = true;
				t = new Tuple(currNode, doesContains);

			} else {

				t = new Tuple(null, Boolean.FALSE);
			}

		}

		return t;

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

	private List<String> fetchAllPossibleWords(List<String> suggestedList, TrieNode currNode, StringBuilder prefix) {
		
		if (currNode.endOfWord != true && !currNode.nodeMap.isEmpty()) {
			
			Iterator<Character> iter = currNode.nodeMap.keySet().iterator();
			while(iter.hasNext()) {
				
				Character c = iter.next();
				fetchAllPossibleWords(suggestedList, currNode.nodeMap.get(c), new StringBuilder(prefix).append(currNode.nodeMap.get(c).val));
				
			}
			
		} else {
			
			suggestedList.add(new StringBuilder(prefix).toString());
		}
		
		return suggestedList;
		
	}


	public static void main(String[] args) {

		// Test

		Trie trie = new Trie();
		trie.addWord("abcd");
		trie.addWord("abde");
		trie.addWord("afde");
		
		System.out.println(trie.autoSuggest("abc"));
		
		System.out.println(trie.contains("abf")); // should return false

		System.out.println(trie.searchWord("abcd")); // should return true

		System.out.println(trie.searchWord("abc")); // should return false

		System.out.println(trie.contains("abc")); // should return true

		System.out.println(trie.contains("abd")); // should return true

		System.out.println(trie.contains("")); // should return false

		System.out.println(trie.searchWord(null)); // should return false

		System.out.println(trie.searchWord("sdsds")); // should return false

		System.out.println(trie.removeWord("asjshns")); // should return false

		System.out.println(trie.removeWord("abc")); // should return false

		System.out.println(trie.removeWord("abcd")); // should return true

		System.out.println(trie.searchWord("abd")); // should return false

	}

}
