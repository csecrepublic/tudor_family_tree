

/**
 * Class: CS230
 * Assignment: Final Project
 * Name: EventsPanel.java
 * Description: Represents the Events tab in the FamilyTreeGUI
 * Displays the chosen family's events as buttons and describes them in the GUI
 *
 * @author ecoe2
 * @version 05/06/2018
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.util.*;
public class EventsPanel extends JPanel
{
    // Instance Variables
    private FamilyTree families;
    private JPanel statusPanel, bioPanel, eventsPanel; //Holds the separate panels
    private JLabel statusLabel, bioLabel; //Tells the user's status of family choice
    private JButton b1, b2, b3, b4, b5, b6, b7, b8; //Holds event buttons

    /**
     * Constructor for objects of class EventsPanel
     */
    public EventsPanel(FamilyTree givenFamilies)
    {
        families = givenFamilies; //Initialize FamilyTree instance
        
        //-----------------------
        //-----Status Panel------
        //-----------------------
        statusPanel = new JPanel(); //Initialize the panel
        statusPanel.setPreferredSize(new Dimension(900, 30));
        statusPanel.setBackground(Color.white);
        
        //Initialize the label
        statusLabel = new JLabel("Choose an Event to view the major" +
                                 " actors on the family tree.");
        
        //Add the elements
        statusPanel.add(statusLabel);
        
        //-----------------------
        //-----Bio Panel--------
        //-----------------------
        bioPanel = new JPanel(); //Initialize the panel
        bioPanel.setPreferredSize(new Dimension(900, 400));
        bioPanel.setBackground(Color.white);
        bioLabel = new JLabel("Event Bio will appear here.");
        bioPanel.add(bioLabel);
        
        
        //-----------------------
        //-----Events Panel------
        //-----------------------
        eventsPanel = new JPanel();
        eventsPanel.setPreferredSize(new Dimension(900, 400));
        eventsPanel.setBackground(Color.white);
        
        //Initialize Buttons
        Vector<SingleEvent> events = families.getEventList().getEvents();
        b1 = new JButton(events.get(0).getName());
        b2 = new JButton(events.get(1).getName());
        b3 = new JButton(events.get(2).getName());
        b4 = new JButton(events.get(3).getName());
        b5 = new JButton(events.get(4).getName());
        b6 = new JButton(events.get(5).getName());
        b7 = new JButton(events.get(6).getName());
        b8 = new JButton(events.get(7).getName());
        
        //Add Listeners
        b1.addActionListener(new EventListener());
        b2.addActionListener(new EventListener());
        b3.addActionListener(new EventListener());
        b4.addActionListener(new EventListener());
        b5.addActionListener(new EventListener());
        b6.addActionListener(new EventListener());
        b7.addActionListener(new EventListener());
        b8.addActionListener(new EventListener());
        
        //Add Buttons
        eventsPanel.add(b1);
        eventsPanel.add(b2);
        eventsPanel.add(b3);
        eventsPanel.add(b4);
        eventsPanel.add(b5);
        eventsPanel.add(b6);
        eventsPanel.add(b7);
        eventsPanel.add(b8);
        
        
        //-----------------------
        //-----Total Panel-------
        //-----------------------
        //Add the panels
        add (statusPanel);
        add (bioPanel);
        add (eventsPanel);
        
        //Set the preferred size
        setPreferredSize(new Dimension(1000,1000));
        //Set background color
        setBackground(Color.blue);
    }
    /**
     * Action Listener for Events panel: all event buttons
     */
    private class EventListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Event events = families.getEventList();
            
            System.out.println(events.contains("Wars of the Roses"));
            System.out.println(events.getEvent("Wars of the Roses"));
            
            //Button Pressed
            JButton buttonPressed = (JButton)event.getSource();
            String buttonName = buttonPressed.getText();

            SingleEvent theEvent = events.getEvent(buttonName);
            
            String bio = "<html><br><br><br><br>" + theEvent.getName() + "<br>" + theEvent.getTime() + "<br>";
            bio += theEvent.getBio();
            
            String bioLineBreaks = "";
        
            Scanner bioScanner = new Scanner(bio);
            int numWords = 0;
        
            while(bioScanner.hasNext())
            {
                bioLineBreaks += bioScanner.next() + " ";
                numWords++;
            
                if(numWords >= 15)
                {
                    bioLineBreaks += "<br>";
                    numWords = 0;
                }
            
            }
        
        
            bioLineBreaks += "</html>";
            bioLabel.setText(bioLineBreaks);
        }
    }
}
