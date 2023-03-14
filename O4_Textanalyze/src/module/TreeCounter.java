package module;


import java.io.*;

public class TreeCounter {

	// Jans kode
	StreamTokenizer sT;

	// Konstruktør: Åpner og initerer fil for lesing
	public void OrdLeser(String filnavn) {
		try {
			sT = new StreamTokenizer(
				new BufferedReader(
					new InputStreamReader(
						new FileInputStream(filnavn))));
		}catch (FileNotFoundException e) {
		}
	}

	// Returnerer neste ord fra filen
	// Returnerer null når alle ord er lest
	public String nesteOrd() {
		try {
			int x = sT.nextToken();
			while (sT.ttype != sT.TT_WORD) {
				if (x == sT.TT_EOF)
				return null;
				x = sT.nextToken();
			}
		} catch (IOException e) {
		}

		String ord = sT.sval.toUpperCase();
		// Fiks: Tokenizer tar med punktum som del av ord
		// Denne dealer med alle spesialtegn på en fancy måte. Takk for hjelpen, hjelpelærer
		ord = ord.replaceAll("[^\\p{L}+$]", "");
		if (ord.isEmpty())
			return nesteOrd();
		return ord;
	}
	//Slutt Jans kode

	//https://www.youtube.com/watch?v=M6lYob8STMI
	Node root;

	public void addNode(int key, String word) {

		Node newWord = new Node(key, word);

		if (root == null)
			root = newWord;

		else {
			Node focusWord = root;
			Node parent;

			while(true) {
				parent = focusWord;

			}
		}
	}

	class Node {
		int key;
		String word;

		Node left;
		Node right;

		Node (int key, String word) {
			this.key = key;
			this.word = word;
		}

	}


/*
	// Makes an empty node-class
	public static class Node {
		String word;
		Node left;
		Node right;

		public Node(String word) {
			this.word = word;
			right = null;
			left = null;
		}
	}

	public Node root;
	public binaryWordTree() {
		this.root = null;
	}

	public void addRecursive(String word) {
		this.root = addRecursive(root, word);
	}
	private Node addRecursive (Node current, String word) {

		if (current == null)
			return new Node(word);

		if (word <= current.word) {
			current.left = addRecursive(current.left, word);
		}
		if (word >= current word) {
			current.right == addRecursive(current.right, word);
		}
		else {
			// When the value already exists
			return current;
		}
		return current;
	}

	public void add(String word) {
		root = addRecursive(root, word);
	}

	/*
	private binaryWordTree createBinaryTree() {
		binaryWordTree bt = new binaryWordTree();

		return bt;
	}
	 */

}
