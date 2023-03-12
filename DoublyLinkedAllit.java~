class ListItem {
    String data;
    ListItem next;
    ListItem prev;
}


public class DoublyLinkedList {

    ListItem front = null;
    ListItem rear = null;

    public void addToList (String s)
    {
	if (front == null) {
	    front = rear = new ListItem ();
	    front.data = s;
	    rear.prev = null; // For clarity
	}
	else {
	    ListItem nextOne = new ListItem ();
	    nextOne.data = s;
	    nextOne.next = null; // For clarity
	    nextOne.prev = rear; // Backward link
	    rear.next = nextOne; // Forward link
	    rear = nextOne;
	}
    }
    
    public void remove (String name)
    {
	/*** Node is in front ***/ 
	
	if ( front.data.equals(name) ){
	    front = front.next;
	    front.prev = null;
	    return;
	}

	
	/*** Node is in rear ***/ 
	
	if ( rear.data.equals(name) ){
	    rear = rear.prev;
	    rear.next = null;
	    return;
	}

	
	/*** Node is neither front nor rear ***/
	
	// Find node with name to be removed
	ListItem listPtr = front;
	while (listPtr != null) {
	    if (listPtr.data.equals(name)) {
		break;
	    }
	    listPtr = listPtr.next;
	}

	// Remove node be relinking adjacent nodes
	ListItem prevNode = listPtr.prev;
	ListItem nextNode = listPtr.next;
	prevNode.next = nextNode;
	nextNode.prev = prevNode;
    }

    public void printList ()
    {
	System.out.println ("List:");
	ListItem listPtr = front;
	while (listPtr != null) {
	    System.out.print (" " + listPtr.data);
	    listPtr = listPtr.next;
	}
	System.out.println ();
    }

    public void printReverse ()
    {
	System.out.println ("List in reverse:");
	ListItem listPtr = rear;
	while (listPtr != null) {
	    System.out.print (" " + listPtr.data);
	    listPtr = listPtr.prev;
	}
	System.out.println ();
    }

    public String get (int i)
    {
	ListItem listPtr = front;
	for (int j = 1; j <= i; j++) {
	    listPtr = listPtr.next;
	}
	return listPtr.data;
    }
}
