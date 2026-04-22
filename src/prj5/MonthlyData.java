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
 * This class creates a MonthlyData object that stores users monthly data.
 * 
 * @author Andrew Medberry
 * @version Apr 20, 2026
 */
public class MonthlyData
{
    // ~ Fields ................................................................
    private int likes;
    private int followers;
    private int comments;
    private int views;
    private Month month;
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private int posts;

    // ----------------------------------------------------------
    /**
     * Create a new MonthlyData object.
     * 
     * @param likes
     *            number of likes in a month
     * @param followers
     *            number of followers
     * @param comments
     *            number of replies to posts
     * @param views
     *            number of people who have seen the channel's posts
     * @param month
     *            what month the data is from
     * @param username
     *            unique identifier for the channel
     * @param channelName
     *            channels public name
     * @param country
     *            where the user is from
     * @param mainTopic
     *            what the user posts about
     * @param posts
     *            number of posts made that month
     */
    // ~ Constructors ..........................................................
    public MonthlyData(
        int likes,
        int followers,
        int comments,
        int views,
        Month month,
        String username,
        String channelName,
        String country,
        String mainTopic,
        int posts)
    {
        this.likes = likes;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
        this.month = month;
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
        this.posts = posts;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for likes
     * 
     * @return likes
     */
    // ~Public Methods ........................................................
    public int getLikes()
    {
        return likes;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for followers
     * 
     * @return followers
     */
    public int getFollowers()
    {
        return followers;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for comments
     * 
     * @return comments
     */
    public int getComments()
    {
        return comments;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for views
     * 
     * @return views
     */
    public int getViews()
    {
        return views;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for month
     * 
     * @return current month
     */
    public Month getMonth()
    {
        return month;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for username
     * 
     * @return username
     */
    public String getUsername()
    {
        return username;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for the name of the channel
     * 
     * @return channelName
     */
    public String getChannelName()
    {
        return channelName;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for country of origin
     * 
     * @return country
     */
    public String getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for mainTopic
     * 
     * @return mainTopic
     */
    public String getMainTopic()
    {
        return mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for the number of posts that month
     * 
     * @return posts
     */
    public int getPosts()
    {
        return posts;
    }

}
