
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
	LinkedList<String> longestAllit = new LinkedList<> ();
	LinkedList<String> currentAllit = new LinkedList<> ();
	
	IOTool.openFileByWord (filename);
	String w = IOTool.getNextWord();
	currentAllit.add (w.toLowerCase());
	char currentChar = w.charAt (0);
		
	while (w != null) {
	    w = IOTool.getNextWord ();
	    
	    // Even w/ while (w != null), the last w is always null
	    // So I'm adding this second checker.
	    if (w != null && w.charAt(0) == currentChar) {
		currentAllit.add (w.toLowerCase());
	    }
	    else if (w != null && w.charAt(0) != currentChar) {
		if ( currentAllit.size() > longestAllit.size() ) {
		    longestAllit.clear ();
		    longestAllit = deepCopyList (currentAllit);
		    currentAllit.clear ();
		}
		currentAllit.clear ();
		currentAllit.add (w.toLowerCase());
		currentChar = w.charAt (0);
	    }
	    else if ( (w == null) && ( currentAllit.size() > longestAllit.size() )  ) {
		longestAllit.clear ();
		longestAllit = deepCopyList (currentAllit);
		currentAllit.clear ();	
	    }
	    // Debugging
	    //System.out.println ("-----------------------");
	    //System.out.println ("Current: " + currentAllit);
	    //System.out.println ("Longest: " + longestAllit);
	
	} // end-of-while
	
	return longestAllit;	
    } // end-findLongestAlliteration()

    
    static LinkedList<String> deepCopyList (LinkedList<String> source)
    {
	LinkedList<String> target = new LinkedList<> ();
	for (String s: source) {
	    target.add (s);
	}
	return target;
    }
}
