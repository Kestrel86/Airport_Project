//
//  Name:   Valdez, Andrew
//  Homework:   Project #3
//  Due:    12/12/22
//  Course: CS-2400-02-1
//
//  Description:
//  QueueInterface is the ADT set that holds methods that will be defined and used.

public interface QueueInterface<T> 
{
    /**
     * Adds a new entry to the back of this queue.
     * @param newEntry An object to be added.
     */
    public void enqueue(T newEntry);
    
    /**
     * Removes and returns the entry at the front of this queue.
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    public T dequeue();

    /**
     * Retrieves the entry at the front of this queue.
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation
     */
    public T getFront();

    /**
     * Detects whether this queue is empty.
     * @return True if the queue is empty, or false otherwise.
     */
    public boolean isEmpty();

    /**
     * Removes all entries from this queue.
     */
    public void clear();
}
