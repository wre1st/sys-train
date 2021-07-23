package com.linked;

// importing necessary classes
import java.util.*;


/*
 * 
 * 
 * 
 * 
 * 
 * @author Systems Limited
 */
// A linked list node
class ListNode {
	int data;
	ListNode next;

	ListNode(int d) {
		data = d;
		next = null;
	}
}

// A binary tree node
class Node {
	int data;
	// left and right subtrees
	Node left, right = null;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

// creating the Binary Search Tree
public class BST {

	// creating the linked list node
	ListNode head;
	// the root node of the binary search tree
	Node root;

	void push(int new_data) {
		// allocate node and assign data
		ListNode new_node = new ListNode(new_data);

		// link the old list off the new node
		new_node.next = head;

		// move the head to point to the new node
		head = new_node;
	}

	// converting the list to binary
	Node listToBinary(Node node) {

		Queue<Node> q = new LinkedList<Node>();

		// Base Case
		if (head == null) {
			node = null;
			return null;
		}

		// The first node is always the root node, and add it to the queue
		node = new Node(head.data);
		q.add(node);

		// advance the pointer to the next node
		head = head.next;

		// until the end of linked list is reached, do the
		// following steps
		while (head != null) {
			// 2.a) take the parent node from the q and
			// remove it from q
			Node parent = q.peek();
			Node pp = q.poll();

			// 2.c) take next two nodes from the linked list.
			// We will add them as children of the current
			// parent node in step 2.b. Push them into the
			// queue so that they will be parents to the
			// future nodes
			Node leftChild = null, rightChild = null;
			leftChild = new Node(head.data);
			q.add(leftChild);
			head = head.next;
			if (head != null) {
				rightChild = new Node(head.data);
				q.add(rightChild);
				head = head.next;
			}

			// 2.b) assign the left and right children of
			// parent
			parent.left = leftChild;
			parent.right = rightChild;
		}

		return node;
	}

	// Utility function to traverse the binary tree
	// after conversion
	void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	// Inorder (Left, Root, Right)
	public void inOrderTraverseTree(Node root) {

		if (root != null) {

			// Traverse the left node

			preorderTraverseTree(root.left);

			// Visit the currently focused on node

			System.out.print(root.data + " ");

			// Traverse the right node

			preorderTraverseTree(root.right);

		}

	}

	// Preorder (Root, Left, Right)
	public void preorderTraverseTree(Node root) {

		if (root != null) {

			System.out.print(root.data + " ");

			preorderTraverseTree(root.left);
			preorderTraverseTree(root.right);

		}

	}

	// Postorder (Left, Right, Root)
	public void postOrderTraverseTree(Node root) {

		if (root != null) {

			preorderTraverseTree(root.left);
			preorderTraverseTree(root.right);

			System.out.print(root.data + " ");

		}

	}

	// Driver program to test above functions
	public static void main(String[] args) {
		BST tree = new BST();
		tree.push(23);
		tree.push(74);
		tree.push(32);
		tree.push(67);
		tree.push(33);
		tree.push(5);
		tree.push(10);
		Node node = tree.listToBinary(tree.root);

		System.out.println("\n Inorder Traversal ");
		tree.inorderTraversal(node);

		System.out.println("\n Post order Traversal ");
		tree.postOrderTraverseTree(node);

		System.out.println("\n Pre Order order Traversal ");
		tree.preorderTraverseTree(node);
	}
}