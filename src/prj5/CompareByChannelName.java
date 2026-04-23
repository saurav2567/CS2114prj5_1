package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Compares influencers alphabetically by channel name,
 * ignoring case.
 * 
 * @author Your Name
 * @version Apr 22, 2026
 */
public class CompareByChannelName implements Comparator<Influencer>
{
    // ----------------------------------------------------------
    /**
     * Compares two influencers by channel name.
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
            return -1;
        }
        if (second == null)
        {
            return 1;
        }

        String firstName = first.getChannelName();
        String secondName = second.getChannelName();

        if (firstName == null && secondName == null)
        {
            return 0;
        }
        if (firstName == null)
        {
            return -1;
        }
        if (secondName == null)
        {
            return 1;
        }

        return firstName.compareToIgnoreCase(secondName);
    }
}