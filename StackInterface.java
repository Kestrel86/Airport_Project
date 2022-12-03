//
//  Name:   Valdez, Andrew
//  Homework:   Project #3
//  Due:    12/12/22
//  Course: CS-2400-02-1
//
//  Description:
//  StackInterface is the ADT set that holds methods that will be defined and used.

public interface StackInterface<T> 
{
    /**
     * Adds a new entry to the top of this stack
     * @param newEntry An object to be added to the stack
     */
    public void push(T newEntry);
    
    /**
     * Removes and returns this stack's top entry
     * @return The object at the top of the stack
     * @throws EmptyStackException if the stack is empty before the operation
     */
    public T pop();
    /**
     * Retrieves this stack's top entry
     * @return The object at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek();
    /**
     * Detects whether this stack is empty
     * @return True if the stack is empty
     */
    public boolean isEmpty();
    /**
     * Removes all entries from this stack
     */
    public void clear();
}