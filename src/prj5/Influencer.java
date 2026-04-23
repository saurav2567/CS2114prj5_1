package prj5;

// -------------------------------------------------------------------------
/**
 * Represents one influencer aggregated across multiple months.
 * This class combines monthly records into first-quarter totals
 * for sorting and output.
 * 
 * @author Your Name
 * @version Apr 22, 2026
 */
public class Influencer
{
    //~ Fields ................................................................
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;

    private int totalLikesQ1;
    private int totalCommentsQ1;
    private int totalViewsQ1;
    private int marchFollowers;

    // ----------------------------------------------------------
    /**
     * Creates a new Influencer object.
     * 
     * @param username
     *            the influencer username
     * @param channelName
     *            the public channel name
     * @param country
     *            the country of origin
     * @param mainTopic
     *            the main topic of the channel
     */
    public Influencer(
        String username,
        String channelName,
        String country,
        String mainTopic)
    {
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * Adds monthly data into this influencer's first-quarter totals.
     * January, February, and March are included.
     * March followers are stored separately because traditional
     * engagement uses March followers only.
     * 
     * @param data
     *            the monthly data to add
     */
    public void addMonthlyData(MonthlyData data)
    {
        if (data == null)
        {
            return;
        }

        Month month = data.getMonth();

        if (month == Month.JANUARY
            || month == Month.FEBRUARY
            || month == Month.MARCH)
        {
            totalLikesQ1 += data.getLikes();
            totalCommentsQ1 += data.getComments();
            totalViewsQ1 += data.getViews();

            if (month == Month.MARCH)
            {
                marchFollowers = data.getFollowers();
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Gets the username.
     * 
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }


    // ----------------------------------------------------------
    /**
     * Gets the channel name.
     * 
     * @return the channel name
     */
    public String getChannelName()
    {
        return channelName;
    }


    // ----------------------------------------------------------
    /**
     * Gets the country.
     * 
     * @return the country
     */
    public String getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * Gets the main topic.
     * 
     * @return the main topic
     */
    public String getMainTopic()
    {
        return mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * Gets the total first-quarter likes.
     * 
     * @return the total likes for January through March
     */
    public int getTotalLikesQ1()
    {
        return totalLikesQ1;
    }


    // ----------------------------------------------------------
    /**
     * Gets the total first-quarter comments.
     * 
     * @return the total comments for January through March
     */
    public int getTotalCommentsQ1()
    {
        return totalCommentsQ1;
    }


    // ----------------------------------------------------------
    /**
     * Gets the total first-quarter views.
     * 
     * @return the total views for January through March
     */
    public int getTotalViewsQ1()
    {
        return totalViewsQ1;
    }


    // ----------------------------------------------------------
    /**
     * Gets the March follower count.
     * 
     * @return the March followers
     */
    public int getMarchFollowers()
    {
        return marchFollowers;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the traditional engagement rate for the first quarter.
     * This uses March followers as the denominator.
     * 
     * @return the traditional engagement rate, or -1.0 if invalid
     */
    public double getTraditionalEngagement()
    {
        if (marchFollowers == 0)
        {
            return -1.0;
        }

        return ((double)(totalLikesQ1 + totalCommentsQ1)
            / marchFollowers) * 100.0;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the reach engagement rate for the first quarter.
     * This uses total first-quarter views as the denominator.
     * 
     * @return the reach engagement rate, or -1.0 if invalid
     */
    public double getReachEngagement()
    {
        if (totalViewsQ1 == 0)
        {
            return -1.0;
        }

        return ((double)(totalLikesQ1 + totalCommentsQ1)
            / totalViewsQ1) * 100.0;
    }


    // ----------------------------------------------------------
    /**
     * Gets the traditional engagement value used for sorting.
     * 
     * @return the traditional engagement value
     */
    public double getTraditionalEngagementForSort()
    {
        return getTraditionalEngagement();
    }


    // ----------------------------------------------------------
    /**
     * Gets the reach engagement value used for sorting.
     * 
     * @return the reach engagement value
     */
    public double getReachEngagementForSort()
    {
        return getReachEngagement();
    }


    // ----------------------------------------------------------
    /**
     * Checks whether this influencer has the given channel name.
     * The comparison ignores case.
     * 
     * @param name
     *            the name to compare
     * @return true if the names match, false otherwise
     */
    public boolean hasChannelName(String name)
    {
        if (channelName == null && name == null)
        {
            return true;
        }
        if (channelName == null || name == null)
        {
            return false;
        }

        return channelName.equalsIgnoreCase(name);
    }
}