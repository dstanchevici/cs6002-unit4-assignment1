
import java.util.*;

public class Alliteration {

    public static void main (String[] argv)
    {
	//String filename = "testtext.txt";
	//String filename = "testtext2.txt";
	//String filename = "alice.txt";
	String filename = "sherlockholmes.txt";
	LinkedList<String> longest = findLongestAlliteration (filename);
	System.out.println ("Longest alliteration in " + filename + ": " + longest);
    }

    static LinkedList<String> findLongestAlliteration (String filename)
    {
	LinkedList<String> currentAllit = new LinkedList<> ();
	LinkedList<String> longestAllit = currentAllit;
	
	IOTool.openFileByWord (filename);
	String w = IOTool.getNextWord().toLowerCase();
	char currentChar = w.charAt (0);
		
	while (w != null) {

	    if ( w.charAt(0) == currentChar) {
		currentAllit.add (w.toLowerCase());
	    }
	    else {
		if ( currentAllit.size() > longestAllit.size() ) {
		    longestAllit = currentAllit;
		    currentAllit = new LinkedList<> ();
		}
		currentAllit = new LinkedList<> ();
		currentAllit.add (w.toLowerCase());
		currentChar = w.charAt (0);
	    }
	    // Debugging
	    //System.out.println ("-----------------------");
	    //System.out.println ("Current: " + currentAllit);
	    //System.out.println ("Longest: " + longestAllit);

	    w = IOTool.getNextWord ();
	
	} // end-of-while

	if ( currentAllit.size() > longestAllit.size() ) {
	    return currentAllit;
	}
	return longestAllit;
	
    } // end-findLongestAlliteration()

}
