package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the Influencer class.
 * 
 * @author Your Name
 * @version Apr 22, 2026
 */
public class InfluencerTest extends TestCase
{
    //~ Fields ................................................................
    private Influencer influencer;

    // ----------------------------------------------------------
    /**
     * Sets up test data.
     */
    public void setUp()
    {
        influencer = new Influencer(
            "jade",
            "wizardHighSchool",
            "US",
            "Tech");
    }


    // ----------------------------------------------------------
    /**
     * Tests the basic getter methods.
     */
    public void testGetters()
    {
        assertEquals("jade", influencer.getUsername());
        assertEquals("wizardHighSchool", influencer.getChannelName());
        assertEquals("US", influencer.getCountry());
        assertEquals("Tech", influencer.getMainTopic());
    }


    // ----------------------------------------------------------
    /**
     * Tests adding first-quarter monthly data.
     */
    public void testAddMonthlyDataQ1()
    {
        MonthlyData january = new MonthlyData(
            100,
            1000,
            10,
            500,
            Month.JANUARY,
            "jade",
            "wizardHighSchool",
            "US",
            "Tech",
            5);

        MonthlyData february = new MonthlyData(
            200,
            1100,
            20,
            600,
            Month.FEBRUARY,
            "jade",
            "wizardHighSchool",
            "US",
            "Tech",
            10);

        MonthlyData march = new MonthlyData(
            300,
            1200,
            30,
            700,
            Month.MARCH,
            "jade",
            "wizardHighSchool",
            "US",
            "Tech",
            15);

        influencer.addMonthlyData(january);
        influencer.addMonthlyData(february);
        influencer.addMonthlyData(march);

        assertEquals(600, influencer.getTotalLikesQ1());
        assertEquals(60, influencer.getTotalCommentsQ1());
        assertEquals(1800, influencer.getTotalViewsQ1());
        assertEquals(1200, influencer.getMarchFollowers());
    }


    // ----------------------------------------------------------
    /**
     * Tests the traditional engagement calculation.
     */
    public void testTraditionalEngagement()
    {
        MonthlyData january = new MonthlyData(
            100,
            1000,
            10,
            500,
            Month.JANUARY,
            "jade",
            "wizardHighSchool",
            "US",
            "Tech",
            5);

        MonthlyData march = new MonthlyData(
            300,
            1200,
            30,
            700,
            Month.MARCH,
            "jade",
            "wizardHighSchool",
            "US",
            "Tech",
            15);

        influencer.addMonthlyData(january);
        influencer.addMonthlyData(march);

        assertEquals(36.666, influencer.getTraditionalEngagement(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Tests the reach engagement calculation.
     */
    public void testReachEngagement()
    {
        MonthlyData january = new MonthlyData(
            100,
            1000,
            10,
            500,
            Month.JANUARY,
            "jade",
            "wizardHighSchool",
            "US",
            "Tech",
            5);

        influencer.addMonthlyData(january);

        assertEquals(22.0, influencer.getReachEngagement(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Tests invalid traditional engagement.
     */
    public void testTraditionalEngagementInvalid()
    {
        assertEquals(-1.0, influencer.getTraditionalEngagement(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Tests invalid reach engagement.
     */
    public void testReachEngagementInvalid()
    {
        assertEquals(-1.0, influencer.getReachEngagement(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Tests channel name matching.
     */
    public void testHasChannelName()
    {
        assertTrue(influencer.hasChannelName("wizardHighSchool"));
        assertTrue(influencer.hasChannelName("WIZARDHIGHSCHOOL"));
        assertFalse(influencer.hasChannelName("otherChannel"));
    }
}