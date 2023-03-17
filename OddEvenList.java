
import java.util.*;

class DualListItem {
    int data;
    DualListItem next;
    DualListItem nextSameKind;
}


public class OddEvenList {

    static DualListItem front = null;
    static DualListItem rear = null;// Good practice, but by default, these global variables are initialized to null.
    static DualListItem firstOdd, firstEven; // These are initialized to null.

    public static void main (String[] argv)
    {
	
	int[] A = {10, 12, 3, 5, 8, 6, 11, 9};
	//int[] A = makeRandomArray (10);

	// Debugging
	//System.out.print ("Array: ");
	//System.out.println (Arrays.toString(A));
	
	addToListSorted (A);
	printList ();

	makeOddLinks ();
	makeEvenLinks ();

	print ("Odd numbers", firstOdd);
	print ("Even numbers", firstEven);

    }

    
    static void addToListSorted (int[] A)
    {
	// For first array item 
	front = rear = new DualListItem ();
	front.data = A[0];

	// For nodes betw which to insert a new one
	DualListItem beforeInserted, afterInserted;

	// For data after A[0]
	for (int i=1; i<A.length; i++) {

	    // Find nodes between which to insert a new one.
	    beforeInserted = afterInserted = front;
	    while ( (afterInserted != null) && (afterInserted.data < A[i]) ) {
		beforeInserted = afterInserted;
		afterInserted = afterInserted.next;
	    }

	    DualListItem insertedItem = new DualListItem ();
	    insertedItem.data = A[i];

	    // Insert in front
	    if (afterInserted == front) {
		insertedItem.next = front;
		front = insertedItem;
	    }
	    // Insert at rear
	    else if (afterInserted == null) {
		rear.next = insertedItem;
		rear = insertedItem;
	    }
	    // Insert in middle
	    else {
		beforeInserted.next = insertedItem;
		insertedItem.next = afterInserted;
	    }

	    
	}
    } // end-of-addToListSorted()

    
    static void printList ()
    {
	DualListItem ptr = front;
	System.out.print ("Full list:");
	while (ptr != null) {
	    System.out.print (" " + ptr.data);
	    ptr = ptr.next;
	}
	System.out.println ();
    }

    
   
    static int[] makeRandomArray (int n)
    {
	if (n < 3) {
	    n = 3;
	}
	int[] A = new int [n];
	A[0] = 1;                 // At least one odd, one even.
	A[1] = 2;
	Random rand = new Random ();
	for (int i=2; i<n; i++) {
	    int k = 10 + rand.nextInt (100);
	    A[i] = k;
	}	
	return A;
    }

    
    static void makeOddLinks ()
    {
        DualListItem ptr, lastOdd;
	//System.out.println ("ptr w/o initialization=" + ptr); // Error
	/*
	  OddEvenList.java:42: error: variable ptr might not have been initialized
	  System.out.println ("ptr w/o initialization=" + ptr);
	                                                ^
	 */
	
	ptr = lastOdd = front;
	//System.out.println ("ptr=" + ptr); // DualListItem@58644d46
	//System.out.println ("lastOdd=" + lastOdd); // DualListItem@58644d46
	//System.out.println ("front=" + front); // DualListItem@58644d46
	while (ptr != null) {
	    // Find firstOdd
	    if ( (firstOdd == null) && (ptr.data % 2 != 0) ) {
		firstOdd = ptr;
		lastOdd = firstOdd;
	    } 

	    // Find others, linking and keeping track of the last one
	    else if (ptr.data % 2 != 0) {
		lastOdd.nextSameKind = ptr;
		lastOdd = ptr;
	    }
	    
	    ptr = ptr.next;
	}

	//System.out.println ("firstOdd=" + firstOdd.data);
	//System.out.println ("lastOdd=" + lastOdd.data);

    }


    static void makeEvenLinks ()
    {
        DualListItem ptr, lastEven;
	
	ptr = lastEven = front;
	while (ptr != null) {
	    // Find firstEve
	    if ( (firstEven == null) && (ptr.data % 2 == 0) ) {
		firstEven = ptr;
		lastEven = firstEven;
	    } 

	    // Find others, linking and keep track of the last one
	    else if (ptr.data % 2 == 0) {
		lastEven.nextSameKind = ptr;
		lastEven = ptr;
	    }
	    
	    ptr = ptr.next;
	}

	//System.out.println ("firstEven=" + firstEven.data);
	//System.out.println ("lastEven=" + lastEven.data);


    }


    static void print (String message, DualListItem first)
    {
	DualListItem ptr = first;
	System.out.print (message + ":");
	while (ptr != null) {
	    System.out.print (" " + ptr.data);
	    ptr = ptr.nextSameKind;
	}
	System.out.println ();
    }
    

}
