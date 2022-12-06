import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedListWithIterator()
    {
        initializeDataFields();
    }
    
}

// pg 517