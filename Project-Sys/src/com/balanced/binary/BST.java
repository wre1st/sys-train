package com.balanced.binary;

import java.util.Collections;
import java.util.LinkedList;


// Java program to print BST in given range

public class BST {
	// A binary tree node
	class Node {
		
		int data;
		Node left, right;
		
		Node(int d) {
			data = d;
			left = right = null;
		}
	}
	static Node root;

	

	public static void main(String[] args) {
		
		BST tree = new BST();
/*		LinkedList<Integer> link=new LinkedList();
		link.add(6);
		link.add(8);
		link.add(1);
		link.add(4);
		link.add(2);
		link.add(9);
		link.add(5);
		link.add(3);
		link.add(7);
*/		
		LinkedList<Integer> link=new LinkedList();
		link.add(3);
		link.add(1);
		link.add(4);
		link.add(2);
		
		Collections.sort(link);
		
		
		int n = link.size();
		root = tree.bst(link, 0, n - 1);
		
		
		System.out.println("\nBalanced Binary Tree In-Order Traversal");
		tree.inOrder(root);

		
		System.out.println("\nBalanced Binary Tree Pre-Order Traversal");
		tree.preOrder(root);


		System.out.println("\nBalanced Binary Tree Post-Order Traversal");
		tree.postOrder(root);

	}
	
	// Inorder (Left, Root, Right)
	public void inOrder(Node root) {
		if (root != null) {
			// Traverse the left node
			preOrder(root.left);
			// Visit the currently focused on node
			System.out.print(root.data + " ");
			// Traverse the right node
			preOrder(root.right);
		}

	}


	/* A utility function to print preorder traversal of BST */
	// Preorder (Root, Left, Right)
	void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	
	
		// Postorder (Left, Right, Root)
		public void postOrder(Node root) {

			if (root != null) {
				preOrder(root.left);
				preOrder(root.right);
				System.out.print(root.data + " ");
			}

		}
	
	/* A function that constructs Balanced Binary Search Tree
	from a sorted array */
	Node bst(LinkedList<Integer> link, int start, int end) {

		/* Base Case */
		if (start > end) {
			return null;
		}

		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		Node node = new Node(link.get(mid));

		/* 
		 * 
		 * Recursively construct the left subtree and make it
		left child of root 
		
		*/
		node.left = bst(link, start, mid - 1);

		/* Recursively construct the right subtree and make it
		right child of root */
		node.right = bst(link, mid + 1, end);
		
		return node;
	}
}