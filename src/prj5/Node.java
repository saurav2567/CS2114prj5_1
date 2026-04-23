package prj5;

/**
 * Represents a node in a doubly linked list.
 *
 * @param <T> the type of data stored in the node
 */
public class Node<T>
{
    private T data;
    private Node<T> next;
    private Node<T> previous;

    /**
     * Creates a new node with the given data.
     *
     * @param data the data to store in the node
     */
    public Node(T data)
    {
        this.data = data;
    }

    /**
     * Gets the data stored in this node.
     *
     * @return the data
     */
    public T getData()
    {
        return data;
    }

    /**
     * Sets the data for this node.
     *
     * @param data the new data
     */
    public void setData(T data)
    {
        this.data = data;
    }

    /**
     * Gets the next node.
     *
     * @return the next node
     */
    public Node<T> getNext()
    {
        return next;
    }

    /**
     * Sets the next node.
     *
     * @param next the next node
     */
    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    /**
     * Gets the previous node.
     *
     * @return the previous node
     */
    public Node<T> getPrevious()
    {
        return previous;
    }

    /**
     * Sets the previous node.
     *
     * @param previous the previous node
     */
    public void setPrevious(Node<T> previous)
    {
        this.previous = previous;
    }
}