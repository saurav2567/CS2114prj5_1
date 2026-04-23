package prj5;

import student.TestCase;
import java.util.Comparator;

/**
 * Tests for DoublyLinkedList.
 */
public class DoublyLinkedListTest extends TestCase
{
    private DoublyLinkedList<Integer> list;

    /**
     * Sets up test data.
     */
    public void setUp()
    {
        list = new DoublyLinkedList<Integer>();
    }

    /**
     * Tests adding elements.
     */
    public void testAdd()
    {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals((Integer)1, list.get(0));
        assertEquals((Integer)2, list.get(1));
        assertEquals((Integer)3, list.get(2));
    }

    /**
     * Tests contains method.
     */
    public void testContains()
    {
        list.add(5);
        list.add(10);

        assertTrue(list.contains(5));
        assertFalse(list.contains(99));
    }

    /**
     * Tests clearing the list.
     */
    public void testClear()
    {
        list.add(1);
        list.add(2);

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    /**
     * Tests insertion sort.
     */
    public void testInsertionSort()
    {
        list.add(3);
        list.add(1);
        list.add(2);

        list.setComparator(new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return a - b;
            }
        });

        list.insertionSort();

        assertEquals((Integer)1, list.get(0));
        assertEquals((Integer)2, list.get(1));
        assertEquals((Integer)3, list.get(2));
    }

    /**
     * Tests sorting with duplicates.
     */
    public void testSortDuplicates()
    {
        list.add(2);
        list.add(1);
        list.add(2);

        list.setComparator(new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return a - b;
            }
        });

        list.insertionSort();

        assertEquals((Integer)1, list.get(0));
        assertEquals((Integer)2, list.get(1));
        assertEquals((Integer)2, list.get(2));
    }
}