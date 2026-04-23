package prj5;

import java.util.Comparator;

/**
 * A generic doubly linked list that supports insertion sort.
 *
 * @param <T> the type of data stored in the list
 */
public class DoublyLinkedList<T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private Comparator<T> comparator;

    /**
     * Creates an empty list.
     */
    public DoublyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
        comparator = null;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size
     */
    public int size()
    {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param data the element to add
     */
    public void add(T data)
    {
        Node<T> newNode = new Node<T>(data);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }

        size++;
    }

    /**
     * Gets the element at a specific index.
     *
     * @param index the index
     * @return the element at the index
     */
    public T get(int index)
    {
        checkIndex(index);

        Node<T> current = head;
        for (int i = 0; i < index; i++)
        {
            current = current.getNext();
        }

        return current.getData();
    }

    /**
     * Checks if the list contains a value.
     *
     * @param data the value to search for
     * @return true if found, false otherwise
     */
    public boolean contains(T data)
    {
        Node<T> current = head;

        while (current != null)
        {
            if (current.getData().equals(data))
            {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    /**
     * Removes all elements from the list.
     */
    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Sets the comparator used for sorting.
     *
     * @param comp the comparator
     */
    public void setComparator(Comparator<T> comp)
    {
        comparator = comp;
    }

    /**
     * Returns the head node (for testing/debugging).
     *
     * @return the head node
     */
    public Node<T> getHead()
    {
        return head;
    }

    /**
     * Sorts the list using insertion sort.
     */
    public void insertionSort()
    {
        if (head == null || head.getNext() == null || comparator == null)
        {
            return;
        }

        Node<T> sortedHead = null;
        Node<T> current = head;

        while (current != null)
        {
            Node<T> nextNode = current.getNext();

            current.setNext(null);
            current.setPrevious(null);

            sortedHead = insertSorted(sortedHead, current);
            current = nextNode;
        }

        head = sortedHead;

        tail = head;
        while (tail != null && tail.getNext() != null)
        {
            tail = tail.getNext();
        }
    }

    /**
     * Inserts a node into a sorted list.
     *
     * @param sortedHead the head of the sorted list
     * @param newNode the node to insert
     * @return the new head of the sorted list
     */
    private Node<T> insertSorted(Node<T> sortedHead, Node<T> newNode)
    {
        if (sortedHead == null)
        {
            return newNode;
        }

        if (comparator.compare(newNode.getData(),
            sortedHead.getData()) <= 0)
        {
            newNode.setNext(sortedHead);
            sortedHead.setPrevious(newNode);
            return newNode;
        }

        Node<T> current = sortedHead;

        while (current.getNext() != null
            && comparator.compare(newNode.getData(),
                current.getNext().getData()) > 0)
        {
            current = current.getNext();
        }

        Node<T> after = current.getNext();
        current.setNext(newNode);
        newNode.setPrevious(current);
        newNode.setNext(after);

        if (after != null)
        {
            after.setPrevious(newNode);
        }

        return sortedHead;
    }

    /**
     * Validates an index.
     *
     * @param index the index
     */
    private void checkIndex(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(
                "Index out of bounds: " + index);
        }
    }
}