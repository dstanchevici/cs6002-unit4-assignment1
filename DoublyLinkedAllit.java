class ListItem {
    String data;
    ListItem next;
    ListItem prev;
}


public class DoublyLinkedAllit {

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

    public int size ()
    {	
	int size = 0;
	ListItem listPtr = front;
	while (listPtr != null) {
	    size ++;
	    listPtr = listPtr.next;
	}
	return size;
    }
    
    public void printList ()
    {
	ListItem listPtr = front;
	while (listPtr != null) {
	    System.out.print (" " + listPtr.data);
	    listPtr = listPtr.next;
	}
	System.out.println ();
    }

}
