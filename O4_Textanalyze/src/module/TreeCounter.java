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
		if (ord.charAt(ord.length() - 1) == '.')
		ord = ord.substring(0, ord.length() - 1);
		return ord;
	}
	//Slutt Jans kode

	// Makes an empty node-class
	class Node {
		String word;
		Node left;
		Node right;

		Node(String word) {
			this.word = word;
			right = null;
			left = null;
		}
	}
}
