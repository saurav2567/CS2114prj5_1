// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Andrew Medberry (906594739)
// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.
package prj5;

// -------------------------------------------------------------------------
/**
 * Tests the MonthlyData class.
 * 
 * @author Andrew Medberry
 * @version Apr 21, 2026
 */
public class MonthlyDataTest
    extends student.TestCase
{
    private MonthlyData data;

    /**
     * sets up for the tests.
     */
    public void setUp()
    {
        data = new MonthlyData(
            1,
            2,
            3,
            4,
            Month.JANUARY,
            "Angie",
            "Andrew",
            "USA",
            "CS",
            5);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter method for likes
     */
    public void testGetLikes()
    {
        assertEquals(data.getLikes(), 1);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter method for followers
     */
    public void testGetFollowers()
    {
        assertEquals(data.getFollowers(), 2);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter method for comments
     */
    public void testGetComments()
    {
        assertEquals(data.getComments(), 3);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter method for views
     */
    public void testGetViews()
    {
        assertEquals(data.getViews(), 4);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter method for month
     */
    public void testGetMonth()
    {
        assertEquals(data.getMonth(), Month.JANUARY);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter method for username
     */
    public void testGetUsername()
    {
        assertEquals(data.getUsername(), "Angie");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter method for channel name
     */
    public void testGetChannelName()
    {
        assertEquals(data.getChannelName(), "Andrew");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter method for country
     */
    public void testGetCountry()
    {
        assertEquals(data.getCountry(), "USA");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter method for main topic
     */
    public void testGetMainTopic()
    {
        assertEquals(data.getMainTopic(), "CS");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter method for posts
     */
    public void testGetPosts()
    {
        assertEquals(data.getPosts(), 5);
    }
}
