package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Compares influencers by reach engagement in descending order.
 * Invalid values sort last.
 * 
 * @author Your Name
 * @version Apr 22, 2026
 */
public class CompareByReachEngagement
    implements Comparator<Influencer>
{
    // ----------------------------------------------------------
    /**
     * Compares two influencers by reach engagement.
     * 
     * @param first
     *            the first influencer
     * @param second
     *            the second influencer
     * @return a negative value, zero, or a positive value
     */
    public int compare(Influencer first, Influencer second)
    {
        if (first == second)
        {
            return 0;
        }
        if (first == null)
        {
            return 1;
        }
        if (second == null)
        {
            return -1;
        }

        double firstRate = first.getReachEngagementForSort();
        double secondRate = second.getReachEngagementForSort();

        if (firstRate > secondRate)
        {
            return -1;
        }
        if (firstRate < secondRate)
        {
            return 1;
        }

        return first.getChannelName().compareToIgnoreCase(
            second.getChannelName());
    }
}