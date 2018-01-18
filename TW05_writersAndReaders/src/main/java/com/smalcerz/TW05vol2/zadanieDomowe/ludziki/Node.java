package com.smalcerz.TW05vol2.zadanieDomowe.ludziki;

public class Node {
	
	
	//value
	private Person person;
	
	
	//pointers
	private Node leftNode;
	private Node rightNode;
	
	
	public Node(Person person, Node leftNode) {
		this.person = person;
		this.leftNode = leftNode;//fifo is made from left to right so only way to set right node is via setter
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public Node getLeftNode() {
		return leftNode;
	}


	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}


	public Node getRightNode() {
		return rightNode;
	}


	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	

}
