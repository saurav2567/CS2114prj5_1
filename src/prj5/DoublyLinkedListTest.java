package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  tests the DoublyLinkedList class
 * 
 *  @author cades29
 *  @version Apr 22, 2026
 */
public class DoublyLinkedListTest extends TestCase
{
    //~ Fields ................................................................
    private DoublyLinkedList<String> list;
    
    //~ Constructors ..........................................................
    /**
     * sets up the list
     */
    public void setUp() {
        list = new DoublyLinkedList<String>();
    }
    
    //~Public  Methods ........................................................
    /**
     * tests insertionSort
     */
    public void testsInsertionSort() {
        
    }
    
    /**
     * tests add()
     */
    public void testsAdd() {
        assertTrue(list.add("Hello"));
        assertTrue(list.add("World"));
    }
    
    /**
     * tests remove by index
     */
    public void testsRemoveByIndex() {
        IndexOutOfBoundsException exception = null;
        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);
        
        IndexOutOfBoundsException exception2 = null;
        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            exception2 = e;
        }
        assertNotNull(exception2);
        
        list.add("Hello");
        list.add("World");
        list.add("Test");
        list.add("This");
        assertTrue(list.remove(2));
        assertTrue(list.remove(2));
        assertTrue(list.remove(0));
        assertTrue(list.remove(0));
    }
    
    /**
     * tests remove by value
     */
    public void testsRemoveByValue() {
        assertFalse(list.remove("Hello"));
        
    }
}
