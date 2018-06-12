
/**
 * Class: CS230
 * Assignment: Final Project
 * Name: FamilyPanel.java
 * Description: Represents the Family tab in the FamilyTreeGUI
 * Displays the six families we are providing on the Familly Tree app.
 * Once a family is clicked, its corresponding family tree will be displayed.
 *
 * @author ecoe2
 * @version 05/06/2018
 */

//Import classes needed for panels, listeners, and events
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FamilyPanel extends JPanel
{
    //Instance Variables
    private FamilyTree families; //Holds the collection of families 
    private JPanel statusPanel, buttonPanel, treePanel, panel1, panel2, 
    panel3, panel4, panel5, panel6; //Holds the separate panels
    private JLabel statusLabel, printTreeInfo, personInfo; //Tells the user's status of 
                                               //family choice                                         
    private JButton button1, button2, button3, button4, button5, button6, button7, button8,
    button9, button10, button11, button12, button13, button14, button15, button16,
    button17, button18, button19;
                                               

    /**
     * Constructor for objects of class FamilyPanel
     * Sets up each panel, buttons, listeners, and labels
     */
    public FamilyPanel(FamilyTree givenFamilies)
    {
        families = givenFamilies; //Initialize FamilyTree instance variable
        
        //-----------------------
        //-----Status Panel------
        //-----------------------
        statusPanel = new JPanel(); //Initialize the panel
        statusPanel.setPreferredSize(new Dimension(900, 50));
        statusPanel.setBackground(Color.white);
        
        //Initialize the label
        statusLabel = new JLabel("Tudor Family Tree");
        //Initialize the label
        printTreeInfo = new JLabel("Representation of the Tudor Family" +
                                   "\n separated by generation");
        //Add the elements
        statusPanel.add(statusLabel);
        statusPanel.add(printTreeInfo);
       
        
        //-----------------------
        //-----Tree Panel--------
        //-----------------------
        //Inititialize the Panel
        //Layout
        
        treePanel = new JPanel(); //initialize panel
        treePanel.setLayout(new BoxLayout(treePanel, BoxLayout.PAGE_AXIS));
        treePanel.setPreferredSize(new Dimension(900, 920));
        treePanel.setBackground(Color.white);
        
        //Create new panels for each generation
        JPanel panel1 = new JPanel();
        panel1.setMaximumSize(new Dimension(900,50));
        JPanel panel2 = new JPanel();
        panel2.setMaximumSize(new Dimension(900,100));
        JPanel panel3 = new JPanel();
        panel3.setMaximumSize(new Dimension(900,50));
        JPanel panel4 = new JPanel();
        panel4.setMaximumSize(new Dimension(900,50));
        JPanel panel5 = new JPanel();
        panel5.setMaximumSize(new Dimension(900,50));
        JPanel panel6 = new JPanel();
        panel6.setMaximumSize(new Dimension(500,600));
        
        //Set background colors for each panel
        panel1.setBackground(Color.red);
        panel2.setBackground(Color.orange);
        panel3.setBackground(Color.yellow);
        panel4.setBackground(Color.green);
        panel5.setBackground(Color.cyan);
        panel6.setBackground(Color.white);
        
        
        //Display the family tree
        //Traverse through the family graph
        Family tudors = families.getFamily("Tudors");
        
        //Linked List holds all the members of the Tudor family 
        LinkedList<Person> members = tudors.getGraph().bfsTraversal(tudors.getSource());
        

        JButton button1 = new JButton(members.get(0).getName()); //Henry VII
        JButton button2 = new JButton(members.get(1).getName()); //Elizabeth of York
        JButton button3 = new JButton(members.get(2).getName()); //Henry VIII
        JButton button4 = new JButton(members.get(3).getName()); //Margaret Tudor
        JButton button5 = new JButton(members.get(4).getName()); //Mary I
        JButton button6 = new JButton(members.get(5).getName()); //Elizabeth I
        JButton button7 = new JButton(members.get(6).getName()); //Edward VI
        JButton button8 = new JButton(members.get(7).getName()); //Catherine of Aragon
        JButton button9 = new JButton(members.get(8).getName()); //Anne Boleyn
        JButton button10 = new JButton(members.get(9).getName()); //Jane Seymour
        JButton button11 = new JButton(members.get(10).getName()); //Anne of Cleves
        JButton button12 = new JButton(members.get(11).getName()); //Catherine Howard
        JButton button13 = new JButton(members.get(12).getName()); //Catherin Parr
        JButton button14 = new JButton(members.get(13).getName()); //James IV
        JButton button15 = new JButton(members.get(14).getName()); //James V
        JButton button16 = new JButton(members.get(15).getName()); //Mary of Guise
        JButton button17 = new JButton(members.get(16).getName()); //Mary Queen of Scots
        JButton button18 = new JButton(members.get(17).getName()); //Henry Stuart
        JButton button19 = new JButton(members.get(18).getName()); //James VI & I
        
        //Add Listeners
        //Initialized listener
        button1.addActionListener(new PersonListener());
        button2.addActionListener(new PersonListener());
        button3.addActionListener(new PersonListener());
        button4.addActionListener(new PersonListener());
        button5.addActionListener(new PersonListener());
        button6.addActionListener(new PersonListener());
        button7.addActionListener(new PersonListener());
        button8.addActionListener(new PersonListener());
        button9.addActionListener(new PersonListener());
        button10.addActionListener(new PersonListener());
        button11.addActionListener(new PersonListener());
        button12.addActionListener(new PersonListener());
        button13.addActionListener(new PersonListener());
        button14.addActionListener(new PersonListener());
        button15.addActionListener(new PersonListener());
        button16.addActionListener(new PersonListener());
        button17.addActionListener(new PersonListener());
        button18.addActionListener(new PersonListener());
        button19.addActionListener(new PersonListener());
        
        //PANEL ONE
        //Add Buttons to panel
        panel1.add(button1); //Henry VII
        panel1.add(button2); //Elizabeth of York
        
        //PANEL TWO
        //Add Buttons to panel
        panel2.add(button8); //Catherine of Aragon
        panel2.add(button9); //Anne Boleyn
        panel2.add(button10); //Jane Seymour
        panel2.add(button11); //Anne of Cleves
        panel2.add(button12); //Catherine Howard
        panel2.add(button13); //Catherine Parr
        panel2.add(button4); //Margaret Tudor
        panel2.add(button3); //Henry VIII
        panel2.add(button14); //James IV
        
        //PANEL THREE
        //Add Buttons to Panel
        panel3.add(button5); //Mary I
        panel3.add(button6); //Elizabeth I
        panel3.add(button7); //Edward VI
        panel3.add(button15); //James V
        panel3.add(button16); //Mary of Guise
        
        //PANEL FOUR
        //Add Buttons to Panel
        panel4.add(button17); //Mary Queen of Scots
        panel4.add(button18); //Henry Stuart
        
        //PANEL FIVE
        panel5.add(button19); //James VI & I
        
        //PANEL SIX
        personInfo = new JLabel("Person info will appear here.");
        panel6.add(personInfo);

        //Add Panels to treePanel
        treePanel.add(panel1);
        treePanel.add(panel2);
        treePanel.add(panel3);
        treePanel.add(panel4);
        treePanel.add(panel5);
        treePanel.add(panel6);
        
        //-----------------------
        //-----Total Panel-------
        //-----------------------
        //Add the panels
        add (statusPanel);
        add (treePanel);
        
        //Set the preferred size
        setPreferredSize(new Dimension(900,1000));
        //Set background color
        setBackground(Color.blue);
    }
    
    /**
     * Action Listener for Tree Panel: all person buttons
     * 
     */
    private class PersonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String info = "";
            //Button pressed
            JButton buttonPressed = (JButton)event.getSource();
            String personName = buttonPressed.getText();
            Family currentFamily = families.getCurrentFamily();
            Hashtable<String, Person> personCollect = currentFamily.getPersonCollect();
            Person p = personCollect.get(personName);
            info = p.toString();
            
            Scanner infoScanner = new Scanner(info);
            infoScanner.useDelimiter("\n");
            //int numWords = 0;
            String infoLineBreaks = "<html>";
            while(infoScanner.hasNext())
            {
                infoLineBreaks += infoScanner.next() + "<br>";
            }
            
            //adding parents and children
            LinkedList<Person> spouses = currentFamily.getSpouses(p);

            infoLineBreaks += "Spouse(s):<br>";
            if(spouses != null)
            {
                for(int i = 0; i<spouses.size(); i++)
                {
                    System.out.println(spouses.get(i).getName());
                    infoLineBreaks += spouses.get(i).getName() + "<br>";
                }
            }
            
            infoLineBreaks += "</html>";
            
            personInfo.setText(infoLineBreaks); //Change the label
        }
        
       
    }
}
