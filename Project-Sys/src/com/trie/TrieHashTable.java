package com.trie;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class TrieHashTable {
	
	class Node {
		// id is the phrase id
		private int id = -1;
		private String data=null;
		private Hashtable<String, Node> child=new Hashtable<String, Node>();
//		private HashMap<String, Node> child = new HashMap<String, Node>();

		public Node() {
		
		}

		public Node(int id) {
			this.id = id;
		}
		
		public String getData() {
			return this.data;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		

		public Hashtable<String, Node> getChild() {
			return child;
		}

		public void setChild(Hashtable<String, Node> child) {
			this.child = child;
		}

		public void setData(String data) {
			this.data = data;
		}
		
	}

	public TrieHashTable () {

		
		
	}
	
	public void insertPhrase(Node root, String phrase, int id) {
		// a pointer to traverse the trie without damaging
		// the original reference
		Node node = root;

		// break phrase into words
		String[] words = phrase.split(" ");
		
		// start traversal at root
		for (int i = 0; i < words.length; ++i) {
			// if the current word does not exist as a child
			// to current node, add it
			if (node.getChild().contains(words[i]))
				node.child.put(words[i], new Node());
			
			
			// move traversal pointer to current word
			node = node.child.get(words[i]);

			// if current word is the last one, mark it with
			// phrase Id
			if (i == words.length - 1)
				node.id = id;
		}
	}

	public boolean searchPhrases(Node root, String textBody) {
		// a pointer to traverse the trie without damaging
		// the original reference
		Node node = root;

		// a list of found ids
		List<Integer> foundPhrases = new ArrayList<Integer>();

		// break text body into words
		String[] words = textBody.split(" ");
		int counter=0;
		
		// starting traversal at trie root and first
		// word in text body
		for (int i = 0; i < words.length;) {
			// if current node has current word as a child
			// move both node and words pointer forward
			if (node.getChild().containsKey(words[i])) {
				// move trie pointer forward
				System.out.println("=============  "+words[i]+" ===============");
				if(node.getChild().get(words[i]).data !=null) {
					System.out.println(node.getChild().get(words[i]).data);
				}
				node = node.child.get(words[i]);
				counter++;
				// move words pointer forward
				++i;
			} else {
				// current node does not have current
				// word in its children

				// if there is a phrase Id, then the previous
				// sequence of words matched a phrase, add Id to
				// found list
				if (node.id != -1)
					foundPhrases.add(node.id);

				if (node == root) {
					// if trie pointer is already at root, increment
					// words pointer
					++i;
				} else {
					// if not, leave words pointer at current word
					// and return trie pointer to root
					node = root;
				}

			}
		}

		// one case remains, word pointer as reached the end
		// and the loop is over but the trie pointer is pointing to
		// a phrase Id
		if (node.id != -1)
			foundPhrases.add(node.id);
	return counter==words.length;
	}

	public static void main(String[] args) {
		
	TrieHashTable trie=	new TrieHashTable();
		
	}
}