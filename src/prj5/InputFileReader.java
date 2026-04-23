// Project 5 Spring 2026
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

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import student.IOHelper;

// -------------------------------------------------------------------------
/**
 * Takes a csv file and converts it into a doubly linked list with a MonthlyData
 * data type
 * 
 * @author Andrew Medberry
 * @version Apr 20, 2026
 */
public class InputFileReader
{
    private DoublyLinkedList<MonthlyData> firstQuarterData =
        new DoublyLinkedList<MonthlyData>();

    /**
     * Create a new InputFileReader object.
     */
    public InputFileReader()
    {
        Scanner inStream = IOHelper.createScanner(new File(
                "C:\Users\Andrew Medberry\Downloads\SampleInput1_2023.csv"));
        inStream.nextLine();// skip header
        while (inStream.hasNextLine()) {
    
    
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            Month month = toMonth(values[0]);
            String username = values[1];
            String channel = values[2];
            String country = values[3];
            String mainTopic = values[4];
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);
            MonthlyData input = new MonthlyData(likes, followers, comments, 
                views, month, username, channelName, country, mainTopic, posts);
            firstQuarterData.add(input);
        }
        firstQuarterData = firstQuarterData.insertionSort();
    }


    /**
     * converts a String to an int
     * 
     * @param the
     *            string to convert
     * @return the int.
     */
    private int toInt(String str)
    {

        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    /**
     * converts a String to a month.
     * 
     * @return the month enum
     * @param the
     *            string to convert
     */
    private Month toMonth(String str)
    {
        if (str.equals("January"))
        {
            return Month.JANUARY;
        }
        if (str.equals("February"))
        {
            return Month.FEBRUARY;
        }
        if (str.equals("March"))
        {
            return Month.MARCH;
        }
        if (str.equals("April"))
        {
            return Month.APRIL;
        }
        if (str.equals("May"))
        {
            return Month.MAY;
        }
        if (str.equals("June"))
        {
            return Month.JUNE;
        }
        if (str.equals("July"))
        {
            return Month.JULY;
        }
        if (str.equals("August"))
        {
            return Month.AUGUST;
        }
        if (str.equals("September"))
        {
            return Month.SEPTEMBER;
        }
        if (str.equals("October"))
        {
            return Month.OCTOBER;
        }
        if (str.equals("November"))
        {
            return Month.NOVEMBER;
        }
        if (str.equals("December"))
        {
            return Month.DECEMBER;
        }
        return null;
    }


    // ----------------------------------------------------------
    /**
     * returns the data from the csv file in a doubly linked list.
     * 
     * @return the first quarter data list
     */
    public DoublyLinkedList<MonthlyData> getMonthlyData()
    {
        return firstQuarterData;
    }

}
