import java.util.Iterator;
import java.util.List;

public interface ListWithIteratorInterface<T> extends Iterable<T>
{
    public Iterator<T> getIterator();
}
