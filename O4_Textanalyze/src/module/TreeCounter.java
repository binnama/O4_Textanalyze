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
		// Denne dealer med alle spesialtegn på en fancy måte. Takk for hjelpen, hjelpelærer (+1)
		ord = ord.replaceAll("[^\\p{L}+$]", "");
		if (ord.isEmpty())
			return nesteOrd();
		return ord;
	}
	//Slutt Jans kode

	public Node root;

	public void addNode(String word) {

		if (root == null)
			root = new Node(word);

		else {
			//root.count = 1;
			Node focusWord = root; // Setter 'root' siden det er der det starter
			Node parent;

			while (true) {
				parent = focusWord;

				// https://www.geeksforgeeks.org/java-program-to-sort-names-in-an-alphabetical-order/
				// Sammenligner ordene med hverandre i alfabetisk rekkefølge
				if (word.compareTo(focusWord.word) < 0) {
					focusWord = focusWord.left;

					if (focusWord == null) {
						parent.left = new Node(word);
						return;
					}

				} else if (word.compareTo(focusWord.word) == 0) {
					focusWord.count++;
					break;

				} else {
					focusWord = focusWord.right;

					if (focusWord == null) {
						parent.right = new Node(word);
						return;
					}
				}
			}
		}
	}

	// Fra minst til størst
	public static void inOrderTraverse(Node focusWord) {
		//System.out.println(focusWord);
		if(focusWord != null) {
			// Traverserer venstre side
			inOrderTraverse(focusWord.left);
			System.out.println(focusWord);

			// Traverserer høyre side
			inOrderTraverse(focusWord.right);
		}
	}

	class Node {
		String word;
		int count = 1;
		Node left;
		Node right;

		Node (String word) {
			this.word = word;
			//this.count = count;
		}

		public String toString() {
			return "Word: " + word + ", value: " + count;
		}
	}
	// To count duplicates
	// https://www.geeksforgeeks.org/how-to-handle-duplicates-in-binary-search-tree/
}
