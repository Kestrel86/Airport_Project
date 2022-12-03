public interface LinkedListWithIterator extends ListInterface<T>, Iterable<T>
{
    public Iterator<T> getIterator();    
}

// pg 517