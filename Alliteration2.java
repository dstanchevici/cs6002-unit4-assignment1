// Alliteration problem with my own linked list DoublyLinkedAllit


public class Alliteration2 {

    public static void main (String[] argv)
    {
	String filename = "testtext.txt";
	//String filename = "testtext2.txt";
	//String filename = "alice.txt";
	//String filename = "sherlockholmes.txt";
	DoublyLinkedAllit longest = findLongestAlliteration (filename);
	System.out.println ("Longest alliteration in " + filename + ": ");
	longest.printList();
    }

    static DoublyLinkedAllit findLongestAlliteration (String filename)
    {
	DoublyLinkedAllit longestAllit = new DoublyLinkedAllit ();
	DoublyLinkedAllit currentAllit = new DoublyLinkedAllit ();
	
	IOTool.openFileByWord (filename);
	String w = IOTool.getNextWord().toLowerCase();
	char currentChar = w.charAt (0);
		
	while (w != null) {

	    if ( w.charAt(0) == currentChar) {
		currentAllit.addToList (w.toLowerCase());
	    }
	    else {
		if ( currentAllit.size() > longestAllit.size() ) {
		    longestAllit.clearList ();
		    longestAllit = currentAllit.deepCopyList ();
		    currentAllit.clearList ();
		}
		currentAllit.clearList ();
		currentAllit.addToList (w.toLowerCase());
		currentChar = w.charAt (0);
	    }
	    // Debugging
	    //System.out.println ("-----------------------");
	    //System.out.println ("Current: " + currentAllit.printList());
	    //System.out.println ("Longest: " + longestAllit.printList());

	    w = IOTool.getNextWord ();
	
	} // end-of-while

	if ( currentAllit.size() > longestAllit.size() ) {
	    return currentAllit;
	}
	return longestAllit;
	
    } // end-findLongestAlliteration()

    /*    
    static DoublyLinkedAllit deepCopyList (DoublyLinkedAllit source)
    {
	DoublyLinkedAllit target = new DoublyLinkedAllit ();
	for (String s: source) {
	    target.addToList (s);
	}
	return target;
    }
    */
}
