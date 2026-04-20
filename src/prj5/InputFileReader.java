package prj5;
import java.util.Scanner;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Andrew Medberry
 *  @version Apr 20, 2026
 */
import student.IOHelper;
public class InputFileReader
{
    Scanner inStream = IOHelper.createScanner("");
    inStream.nextLine();// skip header
    while (inStream.hasNextLine()) {


        String line = inStream.nextLine().replaceAll(" ", "");
        String[] values = line.split(",");
        String month = values[0];
        String username = values[1];
        String channel = values[2];
        String country = values[3];
        String mainTopic = values[4];
        int likes = toInt(values[5]);
        int posts = toInt(values[6]);
        int followers = toInt(values[7]);
        int comments = toInt(values[8]);
        int views = toInt(values[9]);


        // TODO : Populate the Classes created to store the data


    } // end while
}
