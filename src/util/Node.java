package util;


public class Node {
	
	Integer data;
	Node leftChild;
	Node rightChild;
	
	public Node(Integer data) {
		
		this.data = data;
	}
	
	public String toString() {
		
		return this.data + "";
	}
	
	public boolean equals(Node otherObj) {
		
		if(otherObj == null)
			return false;
		
		return this.data == otherObj.data;
		
	}
	
	public Node(int data, Node leftChild, Node rightChild) {
		
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		
	}
	
	public Node getLeftChild() {
		return this.leftChild;
	}
	
	public Node getRightChild() {
		return this.rightChild;
	}
	
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	public Integer getData() {
		return this.data;
	}
	
	public void setData(Integer data) {
		this.data = data;
	}
	
}