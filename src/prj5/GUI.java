package prj5;

import cs2.*;

// -------------------------------------------------------------------------
/**
 * The graphical user interface for the project.
 * 
 * @author Andrew Medberry
 * @version Apr 30, 2026
 */
public class GUI
{
    // ~ Fields ................................................................
    private DoublyLinkedList<Influencer> list;
    private Window window;
    private Button quitButton;
    private Button sortByChannelButton;
    private Button sortByEngagementButton;
    private Button traditionalEngagementButton;
    private Button reachEngagementButton;
    private Button firstQuarterButton;
    private Button januaryButton;
    private Button februaryButton;
    private Button marchButton;

    private boolean traditional = true;
    private boolean reach = false;

    // ----------------------------------------------------------
    /**
     * Creates a new GUI object.
     */
    public GUI(DoublyLinkedList<Influencer> list)
    {
        this.list = list;
        window = new Window("Social Media Vis");
        window.setSize(800, 600);

        sortByChannelButton = new Button("Sort by Channel Name");
        sortByChannelButton.onClick(this, "clickedSortByChannel");
        window.addButton(sortByChannelButton, WindowSide.NORTH);

        sortByEngagementButton = new Button("Sort by Engagement Rate");
        sortByEngagementButton.onClick(this, "clickedSortByEngagement");
        window.addButton(sortByEngagementButton, WindowSide.NORTH);

        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        traditionalEngagementButton = new Button("Traditional Engagement Rate");
        traditionalEngagementButton
            .onClick(this, "clickedTraditionalEngagement");
        window.addButton(traditionalEngagementButton, WindowSide.WEST);

        reachEngagementButton = new Button("Reach Engagement Rate");
        reachEngagementButton.onClick(this, "clickedReachEngagement");
        window.addButton(reachEngagementButton, WindowSide.WEST);

        firstQuarterButton = new Button("First Quarter (Jan-March)");
        firstQuarterButton.onClick(this, "clickedFirstQuarter");
        window.addButton(firstQuarterButton, WindowSide.SOUTH);

        januaryButton = new Button("January");
        januaryButton.onClick(this, "clickedJanuary");
        window.addButton(januaryButton, WindowSide.SOUTH);

        februaryButton = new Button("February");
        februaryButton.onClick(this, "clickedFebruary");
        window.addButton(februaryButton, WindowSide.SOUTH);

        marchButton = new Button("March");
        marchButton.onClick(this, "clickedMarch");
        window.addButton(marchButton, WindowSide.SOUTH);

        drawDefaultScreen();
    }


    // ----------------------------------------------------------
    /**
     * Draws the starting display.
     */
    private void drawDefaultScreen()
    {
        window.removeAllShapes();

        TextShape title =
            new TextShape(250, 40, "Social Media Engagement Data");
        window.addShape(title);

        TextShape message = new TextShape(
            230,
            80,
            "Choose a month, quarter, engagement type, or sorting option.");
        window.addShape(message);
    }


    // ----------------------------------------------------------
    /**
     * Draws a simple message on the screen.
     * 
     * @param text
     *            the message to display
     */
    private void drawMessage(String text)
    {
        window.removeAllShapes();

        TextShape message = new TextShape(250, 250, text);
        window.addShape(message);
    }


    // ----------------------------------------------------------
    /**
     * Handles the quit button.
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    // ----------------------------------------------------------
    /**
     * Handles sorting by channel name.
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedSortByChannel(Button button)
    {
        list.insertionSort(new CompareByChannelName());
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handles sorting by engagement rate.
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedSortByEngagement(Button button)
    {
        list.insertionSort(new CompareByReachEngagement());
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handles traditional engagement rate.
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedTraditionalEngagement(Button button)
    {
        traditional = true;
        reach = false;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handles reach engagement rate.
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedReachEngagement(Button button)
    {
        traditional = false;
        reach = true;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handles the first quarter button.
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedFirstQuarter(Button button)
    {
        drawMessage("First quarter selected.");
    }


    // ----------------------------------------------------------
    /**
     * Handles the January button.
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedJanuary(Button button)
    {
        drawMessage("January selected.");
    }


    // ----------------------------------------------------------
    /**
     * Handles the February button.
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedFebruary(Button button)
    {
        drawMessage("February selected.");
    }


    // ----------------------------------------------------------
    /**
     * Handles the March button.
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedMarch(Button button)
    {
        drawMessage("March selected.");
    }


    public void update()
    {
        window.removeAllShapes();
        for (int i = 0; i < 4; i++)
        {
            TextShape influencer =
                new TextShape(25 + (i * 125), 75, list.get(i).getChannelName());
            window.addShape(influencer);
            Shape data;
            if (traditional)
            {
                data = new Shape(
                    25 + (i * 125),
                    250 - (int)list.get(i).getReachEngagement() * 7,
                    50,
                    (int)list.get(i).getTraditionalEngagement() * 7);
            }
            else
            {
                data = new Shape(
                    25 + (i * 125),
                    250 - (int)list.get(i).getReachEngagement() * 7,
                    50,
                    (int)list.get(i).getReachEngagement() * 7);
            }
            window.addShape(data);
        }
    }
}
