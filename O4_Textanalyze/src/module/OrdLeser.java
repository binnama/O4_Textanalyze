package module;

import java.io.*;

// Innlesing av ett og ett ord fra en fil

public class OrdLeser
{
    StreamTokenizer sT;

    // Konstruktør: Åpner og initerer fil for lesing
    public OrdLeser(String filnavn)
    {
    try
	{
	    sT = new StreamTokenizer(
		new BufferedReader(
		    new InputStreamReader(
			new FileInputStream(filnavn))));
	}
	catch (FileNotFoundException e) {};
    }

    // Returnerer neste ord fra filen
    // Returnerer null når alle ord er lest
 public String nesteOrd()
    {
    try
    {
        int x = sT.nextToken();
        while (sT.ttype != sT.TT_WORD)
        {
	    if (x == sT.TT_EOF)
	    return null;
	    x = sT.nextToken();
	}
    }
    catch (IOException e) {};

    String ord = sT.sval.toUpperCase();
    // Fiks: Tokenizer tar med punktum som del av ord
    if (ord.charAt(ord.length()-1) == '.')
    ord = ord.substring(0, ord.length()-1);
    return ord;
 }

    // Testprogram som viser bruk av en OrdLeser
    // Skriver ut alle ordene på en tekstfil
public static void main (String argv[])
{
    OrdLeser oL = new OrdLeser("ga.txt");
    String ord = oL.nesteOrd();
    while (ord != null)
    {
        System.out.println(ord);
        ord = oL.nesteOrd();
    }
    }
}
