
/**
 * Class: CS230
 * Assignment: Final Project
 * Name: FamilyTreeGUI.java
 * Description: GUI for Family Tree app. Incorporates FamilyPanel, 
 * BiographyPanel, TimelinePanel, and EventsPanel
 *
 * @author ecoe2
 * @version 05/06/2018
 */

import javax.swing.*; //Imported for GUI display

public class FamilyTreeGUI
{
    
    /**
     * Main Method: Sets up a frame containing tabbed panes. 
     *
     * @param String[] args
     * @return void
     */
    public static void main(String[] args)
    {
        //Create title of window
        JFrame frame = new JFrame("Family Trees");
        
        //Click on the red close window button to close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create a new tabbed pane
        JTabbedPane tp = new JTabbedPane();
        
        //Create an instance of FamilyTrees, read from file
        FamilyTree families = new FamilyTree();
        
        //Add the different tabs to the pane
        tp.addTab ("Family", new FamilyPanel(families));
        tp.addTab ("Biography", new BiographyPanel(families));
        tp.addTab ("Events", new EventsPanel(families));
        
        frame.getContentPane().add(tp);
        
        frame.pack();
        frame.setVisible(true);
        
    }
}
