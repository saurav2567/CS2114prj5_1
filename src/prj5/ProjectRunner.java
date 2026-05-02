package prj5;

import java.io.IOException;
import java.text.DecimalFormat;

// -------------------------------------------------------------------------
/**
 * Runs the project and prints the console output.
 * 
 * @author Will Sadow
 * @version 4/23/2206
 */
public class ProjectRunner
{
    /**
     * Main method
     * 
     * @param args
     *            command line arguments
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException
    {
        InputFileReader reader;

        if (args.length > 0)
        {
            reader = new InputFileReader(args[0]);
        }
        else
        {
            reader = new InputFileReader("SampleInput1_2023.csv");
        }

        DoublyLinkedList<MonthlyData> monthlyData = reader.getMonthlyData();
        DoublyLinkedList<Influencer> influencers =
            buildInfluencers(monthlyData);
        GUI gui = new GUI(influencers);
        influencers.insertionSort(new CompareByChannelName());
        printTraditional(influencers);

        System.out.println("**********");
        System.out.println("**********");

        influencers.insertionSort(new CompareByReachEngagement());
        printReach(influencers);
    }


    /**
     * builds the influencer list from monthly data
     * 
     * @param monthlyData
     *            the monthly data list
     * @return the influencer list
     */
    private static DoublyLinkedList<Influencer> buildInfluencers(
        DoublyLinkedList<MonthlyData> monthlyData)
    {
        DoublyLinkedList<Influencer> influencers =
            new DoublyLinkedList<Influencer>();

        for (int i = 0; i < monthlyData.size(); i++)
        {
            MonthlyData data = monthlyData.get(i);

            if (data.getMonth() != null)
            {
                Influencer influencer =
                    findInfluencer(influencers, data.getChannelName());

                if (influencer == null)
                {
                    influencer = new Influencer(
                        data.getUsername(),
                        data.getChannelName(),
                        data.getCountry(),
                        data.getMainTopic());

                    influencers.add(influencer);
                }

                influencer.addMonthlyData(data);
            }
        }

        return influencers;
    }


    /**
     * finds an influencer by channel name
     * 
     * @param influencers
     *            the influencer list
     * @param channelName
     *            the channel name
     * @return the influencer if found
     */
    private static Influencer findInfluencer(
        DoublyLinkedList<Influencer> influencers,
        String channelName)
    {
        for (int i = 0; i < influencers.size(); i++)
        {
            Influencer influencer = influencers.get(i);

            if (influencer.hasChannelName(channelName))
            {
                return influencer;
            }
        }

        return null;
    }


    /**
     * prints traditional engagement output
     * 
     * @param influencers
     *            the influencer list
     */
    private static void printTraditional(
        DoublyLinkedList<Influencer> influencers)
    {
        DecimalFormat formatter = new DecimalFormat("#.#");

        for (int i = 0; i < influencers.size(); i++)
        {
            Influencer influencer = influencers.get(i);

            System.out.println(influencer.getChannelName());

            if (influencer.getTraditionalEngagement() < 0)
            {
                System.out.println("traditional: N/A");
            }
            else
            {
                System.out.println(
                    "traditional: " + formatter
                        .format(influencer.getTraditionalEngagement()));
            }

            System.out.println("==========");
        }
    }


    /**
     * prints reach engagement output
     * 
     * @param influencers
     *            the influencer list
     */
    private static void printReach(DoublyLinkedList<Influencer> influencers)
    {
        DecimalFormat formatter = new DecimalFormat("#.#");

        for (int i = 0; i < influencers.size(); i++)
        {
            Influencer influencer = influencers.get(i);

            System.out.println(influencer.getChannelName());

            if (influencer.getReachEngagement() < 0)
            {
                System.out.println("reach: N/A");
            }
            else
            {
                System.out.println(
                    "reach: "
                        + formatter.format(influencer.getReachEngagement()));
            }

            System.out.println("==========");
        }
    }
}
