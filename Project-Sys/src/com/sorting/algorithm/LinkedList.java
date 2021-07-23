package com.sorting.algorithm;

import com.Employee;

// creating the linked list class
/**
 * @author hussain.tahir
 *
 * @param <T>
 */
public class LinkedList<T> {
	
// creating the inner node class here
	private static class Node<T> {

		private T data;

		private Node next;

		public Node(T data) {
			this.data = data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public T getData() {
			return this.data;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getNext() {
			return this.next;
		}
	}
	
	private int size = 0;
	private Node head;

	public LinkedList() {
		this.size = 0;
	}

	// insertion methods
	public void addFirst(T data) {
		Node<T> node = new Node<>(data);
		node.setNext(head);
		head = node;
		size++;
	}

	public void addLast(T data) {
		Node currentNode = head;

		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}

		Node<T> node = new Node<>(data);

		node.setNext(null);
		currentNode.setNext(node);
		size++;
	}

	public int insertAt(T data, int position) {

		if (position > size + 1) {
			return -1;
		}

		Node currentNode = head;

		for (int i = 1; i <= position - 2; i++) {
			currentNode = currentNode.getNext();
		}

		Node<T> node = new Node<>(data);

		if (currentNode.getNext() != null) {
			node.setNext(currentNode.getNext());
		}
		currentNode.setNext(node);
		size++;

		return 1;
	}

	// display linked list
	public void display() {

		Node currentNode = head;

		while (currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}

		System.out.println("\n");
	}

	public int size() {
		return this.size;
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
	
	public void reverse() {
		Node first=head;
		Node current=first.next;
		first.next=null;
		//		current.next=null;
//		20 -> 56 -> 67
		
		Node next=null;
		
		Node previous=current;
		
//		current=first.next;
		while(current!=null) {
			
//			previous=current;
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
			
			System.out.println(current.data);
			
//			String emp2=current.data.toString();
			

		}
		
//		 tail=first;
		 
		
	}
	
	// main function
		/**
		 * @param args
		 */
		/**
		 * @param args
		 */
		/**
		 * @param args
		 */
		/**
		 * @param args
		 */
		/**
		 * @param args
		 */
		public static void main(String[] args) {

			LinkedList<Employee> linkedList = new LinkedList();

			// Add nodeslinkedList to the list
			linkedList.addFirst(new Employee("Tahir", "Male", 34));
			linkedList.addLast(new Employee("Rashid", "Male", 31));
			linkedList.insertAt(new Employee("Farwa", "Female", 23),1);
			linkedList.insertAt(new Employee("Tahir Hussain", "Male", 23),2);
			linkedList.insertAt(new Employee("Hafsa", "Male", 23),3);
			//linkedList.insertAt(new Employee("Atiba", "Female", 24),2);

			// Displays the nodes present in the list
//			linkedList.display();

			linkedList.display();
			System.out.println();
			
			
			linkedList.set(2, new Employee("Aftab","Male",28));
			linkedList.display();

//			linkedList.deleteAt(2);
//			linkedList.display();

			System.out.println("-------------------------- Linked List Reversing-------------------------");
			linkedList.reverse();
			
			linkedList.display();
		}
	}