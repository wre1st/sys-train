package com.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.trie.TrieHashTable.Node;

public class Main {

	public static void main(String[] args) {
		TrieHashTable trie = new TrieHashTable();
		while (true) {
			try {
 
				Node parent = trie.new Node(2);
				Node systems = trie.new Node();
				Node aboutUs = trie.new Node();
				aboutUs.setData("Committed to global digital excellence\r\n"
						+ "A beacon of innovation. A collective of brilliant and dedicated minds. The artisans of your digital tomorrow.\r\n"
						+ "\r\n" + "Pakistan’s premier technology organization\r\n"
						+ "With a four-decade track record of successful solutions to complex business problems, the Systems group of companies is a global force for digitally driven change.");

				aboutUs.getChild().put("Us", trie.new Node());
				systems.getChild().put("About", aboutUs);

				Node child = trie.new Node();
				child.getChild().put("Limited", systems);

				Node ltd = trie.new Node();
				ltd.setData("Systems Limited: Enabling a digital tomorrow");
				child.getChild().put("Ltd", ltd);

				parent.getChild().put("Systems", child);

				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("Enter Phrase:");
				String value = reader.readLine();

				if (trie.searchPhrases(parent, value)) {
					System.out.println("Found");
				}

			} catch (IOException io) {
				System.out.println(io);
			}
		}

	}
}