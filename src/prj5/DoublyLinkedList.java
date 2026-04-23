package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * data structure for all of our information
 * 
 * @param <T>
 * @author cades29
 * @version Apr 22, 2026
 */
public class DoublyLinkedList<T>
{
    // ~ Fields ................................................................
    private Node<T> firstNode;
    private Node<T> lastNode;
// private CompareMonth comparator;
    private int numberOfEntries;

    // ~ Constructors ..........................................................
    /**
     * creates the DoublyLinkedList object
     */
    public DoublyLinkedList()
    {
        firstNode = null;
        lastNode = null;
// comparator = null;
        numberOfEntries = 0;
    }


    // ~Public Methods ........................................................
    /**
     * sorts the list by use of a comparator
     */

    /**
     * sorts the list by a comparator
     * 
     * @param comp
     * the comparator used to sort the list
     */
    public void insertionSort(Comparator<T> comp) {
        if (comp == null || numberOfEntries < 2) {
            return;
        }

        Node<T> currentNode = firstNode.getNext();

        while (currentNode != null) {
            T currentData = currentNode.getData();
            Node<T> compareNode = currentNode.getPrevious();

            while (compareNode != null && comp.compare(
                compareNode.getData(), currentData) > 0) {
                compareNode.getNext().setData(compareNode.getData());
                compareNode = compareNode.getPrevious();
            }

            if (compareNode == null) {
                firstNode.setData(currentData);
            }
            else {
                compareNode.getNext().setData(currentData);
            }

            currentNode = currentNode.getNext();
        }
    }
    


    /**
     * adds an entry to the front of the list
     * 
     * @param newEntry
     * @return true/false
     */
    public boolean add(T newEntry)
    {
        if (numberOfEntries == 0)
        {
            Node<T> newNode = new Node<T>(null, newEntry, null);
            firstNode = newNode;
            lastNode = newNode;
            numberOfEntries++;
            return true;
        }
        Node<T> newNode = new Node<T>(null, newEntry, firstNode);
        firstNode.setPrevious(newNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }


    /**
     * removes an item from a specific location
     * 
     * @param index
     * @return true/false
     */
    public boolean remove(int index)
    {
        if (index < 0 || index >= numberOfEntries)
        {
            throw new IndexOutOfBoundsException();
        }
        else if (numberOfEntries == 1)
        {
            firstNode = null;
            lastNode = null;

            numberOfEntries--;
            return true;
        }
        else if (index == 0)
        {
            firstNode.getNext().setPrevious(null);
            firstNode = firstNode.getNext();

            numberOfEntries--;
            return true;
        }
        else if (index == numberOfEntries - 1)
        {
            lastNode.getPrevious().setNext(null);
            lastNode = lastNode.getPrevious();

            numberOfEntries--;
            return true;
        }
        else
        {
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index; i++)
            {
                currentNode = currentNode.getNext();
            }
            currentNode.getPrevious().setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(currentNode.getPrevious());

            numberOfEntries--;
            return true;
        }
    }


    /**
     * removes a specific item from the linked list
     * 
     * @param anEntry
     * @return true/false
     */
    public boolean remove(T anEntry)
    {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < numberOfEntries; i++)
        {
            if (currentNode.getData().equals(anEntry))
            {
                this.remove(i);
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }


    /**
     * searches the list for an item
     * 
     * @param anEntry
     * @return true/false
     */
    public boolean contains(T anEntry)
    {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < numberOfEntries; i++)
        {
            if (currentNode.getData().equals(anEntry))
            {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }


    /**
     * returns the number of entries in the list
     * 
     * @return numberOfEntries
     */
    public int size()
    {
        return numberOfEntries;
    }

    // -------------------------------------------------------------------------
    /**
     * node class with double sided references
     * 
     * @param <T>
     * @author cades29
     * @version Apr 22, 2026
     */
    private class Node<T>
    {
        private Node<T> previous;
        private T data;
        private Node<T> next;

        /**
         * creates a Node object
         * 
         * @param pre
         * @param entry
         * @param after
         */
        public Node(Node<T> pre, T entry, Node<T> after)
        {
            previous = pre;
            data = entry;
            next = after;
        }


        /**
         * changes the previous node
         * 
         * @param prev
         */
        public void setPrevious(Node<T> prev)
        {
            previous = prev;
        }


        /**
         * returns the previous node
         * 
         * @return previous
         */
        public Node<T> getPrevious()
        {
            return previous;
        }


        /**
         * changes the data value
         */
        public void setData(T data)
        {
            this.data = data;
        }


        /**
         * returns data
         * 
         * @return data
         */
        public T getData()
        {
            return data;
        }


        /**
         * changes the next node
         * 
         * @param next
         */
        public void setNext(Node<T> next)
        {
            this.next = next;
        }


        /**
         * returns the next node
         * 
         * @return next
         */
        public Node<T> getNext()
        {
            return next;
        }
    }
}
