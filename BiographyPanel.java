/**
 * Class: CS230
 * Assignment: Final Project
 * Name: BiographyPanel.java
 * Description: Represents the Biography tab in the FamilyTreeGUI
 * Displays a biography of the chosen family
 *
 * @author ecoe2
 * @version 05/06/2018
 */

//Import classes needed for panels, listeners, and events
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BiographyPanel extends JPanel
{
    private FamilyTree families; //Stores the familytree instance
    private JPanel familyPanel, bioPanel;
    private JLabel familyLabel, bioLabel; //Stores the labels
    private String bio; //Stores the bio to be displayed as a string

    /**
     * Constructor for objects of class BiographyPanel
     */
    public BiographyPanel(FamilyTree givenFamilies)
    {
        //Initialize FamilyTree variable
        families = givenFamilies;
        
        //-----------------------
        //-----Family Panel------
        //-----------------------
        familyPanel = new JPanel();
        familyPanel.setPreferredSize(new Dimension(900, 50)); 
        familyPanel.setBackground(Color.white);
        
        
        familyLabel = new JLabel("A Brief Biography of the Tudor Family");
        
        familyPanel.add(familyLabel);
        
        //-----------------------
        //-----Bio Panel--------
        //-----------------------
        bioPanel = new JPanel();
        bioPanel.setPreferredSize(new Dimension(900, 850));
        bioPanel.setBackground(Color.white);
        
        
        String bio = families.getFamily("Tudors").getBio();
        String bioLineBreaks = "<html><br><br><br><br>";
        
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
        bioLabel = new JLabel(bioLineBreaks);

        
        
        bioLabel.setMaximumSize(new Dimension(900, 700));

        bioPanel.add(bioLabel);
        
        //-----------------------
        //-----Total Panel-------
        //-----------------------
        add (familyPanel);
        add (bioPanel);
        setBackground(Color.blue);
    }

  
}
