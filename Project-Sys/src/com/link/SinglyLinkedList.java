package com.link;

import com.Employee;

public class SinglyLinkedList {

	// the first node of the linked list is known as head, and last node of the
	// linked list is tail
	public Node head = null;
	// tail is the last node of the linked list
	public Node tail = null;

	// accepts the object and add create the new node
	public void add(Object data) {

		// creating a new node
		Node node = new Node(data);

		// if there is not a first node head, then run if body
		if (head == null) {
			// both head and tail will point the first value
			head = node;
			tail = node;
		} else {

			// tail.next will point the new node
			tail.next = node;
			// current node is the tail, implies that it is the last node
			tail = node;
		}
	}

	public void deleteAt(int index) {
		Node currentNode = head;
		Node previous = null;
		int counter = 0;

		if (head == null) {
			return;
		}
		while (currentNode != null && counter != index) {
			previous = currentNode;
			currentNode = currentNode.next;
			counter++;
		}

		if (currentNode != null) {
			// Since the key is at current Node and trying to unlink the current node from the linked list
			previous.next = currentNode.next;

			System.out.println(" index: "+index + " found and deleted");
		}
	}
/*	
	public void set(int index, Object data) {
		Node currentNode = head;
		Node previous = null;
		int counter = 0;

		if (head == null) {
			return;
		}
		
		while (currentNode != null && counter != index) {
			previous = currentNode;
			currentNode = currentNode.next;
			counter++;
		}

		if (currentNode != null) {
			// Since the key is at current Node and trying to unlink the current node from the linked list
			previous = new Node(data);
			previous.next=currentNode.next;
			currentNode=previous.next;
			
			System.out.println(" index: "+index + " found and deleted");
		}
	}
	*/

	public void set(int index, Object data) {
		Node currentNode = head;
		Node previous = null;
		int counter = 0;

		if (head == null) {
			return;
		}
		
		while (currentNode != null) {
			
			if(index==counter) {
				previous=currentNode;
				currentNode.data=data;
				currentNode=currentNode.next;
			}else {
				previous = currentNode;
				currentNode = currentNode.next;
			}
			counter++;
		}
	}

	// show the node values iteratively
	public void display() {
		// Node current will point to head
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of singly linked list: ");
		while (current != null) {
			// Prints each node by incrementing pointer
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// show the node values iteratively
	public int counter() {
		// Node current will point to head
		Node current = head;
		int counter=0;
 		System.out.println("Nodes of singly linked list: ");
		while (current != null) {
			// Prints each node by incrementing pointer
			System.out.print(current.data + " ");
			current = current.next;
			counter++;
		}
		System.out.println();
	return counter;
	}

	
	public void reverse() {
		Node first=head;
		Node current=first.next;
		first.next=null;
 
		
		Node previous=first;
		
//		current=first.next;
		while(current!=null) {
			
//			previous=current;
			Node next=current.next;
			current.next=previous;
			previous=current;
			current=next;
			

		}
		
		 tail=first;
		 tail.next=null;
		 head=previous;
		
	}
	
	// main function
	public static void main(String[] args) {

		SinglyLinkedList linkedList = new SinglyLinkedList();

		// Add nodeslinkedList to the list
		linkedList.add(new Employee("Tahir", "Male", 34));
		linkedList.add(new Employee("Rashid", "Male", 31));
		linkedList.add(new Employee("Farwa", "Female", 23));
		linkedList.add(new Employee("Atiba", "Female", 24));

		// Displays the nodes present in the list
//		linkedList.display();

		linkedList.set(1, new Employee("Aftab","Male",28));
		linkedList.display();

//		linkedList.deleteAt(2);
//		linkedList.display();

		linkedList.reverse();
		linkedList.display();
	}
}
// create node class
class Node {
	Object data;
	Node next;

	public Node(Object data) {
		this.data = data;
		this.next = null;
	}
}