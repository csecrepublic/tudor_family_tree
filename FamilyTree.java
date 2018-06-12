
/**
 * Class: CS230
 * Assignment: Final Project
 * Name: FamilyTree.java
 * Description: Manages instances of the Families and stores them in a 
 * hashtable used for the FamilyTreeGUI
 *
 * @author ecoe2
 * @version 05/06/2018
 */

import java.util.*; //Imported for Hashtable ADT
import java.io.*; //Imported for scanner

public class FamilyTree
{
    //Create hashtable with key: family name, value: family graph
    private Hashtable<String, Family> families = 
            new Hashtable<String, Family>();
    protected Family currentFamily; //Stores the current family be examined
    //Events
    private Event tudorEvents;

    /**
     * Constructor for objects of class FamilyTree
     */
    public FamilyTree()
    {
        //Create instances of the families that we need
        Family Tudors = new Family("tudors_person.txt", "tudor_bio.txt");
        
        currentFamily = Tudors;
        
        //Add these families to the hash table
        //Key: Family Name, Value: Corresponding Family Instance
        families.put("Tudors", Tudors);
        
        //Create arcs
        Tudors.addArcs();
        
        //Initialize events
        tudorEvents = new Event("tudors_event.txt");
        
    }
    /**
     * getCurrentFamily: returns the current family
     * @param none
     * @return Family
     */
    public Family getCurrentFamily()
    {
        return currentFamily;
    }
    

    /**
     * getFamily: Getter method. Returns an object of type Family (value) 
     * based on the family name (key) provided as a parameter
     *
     * @param  String familyname
     * @return Family
     */
    public Family getFamily(String familyName)
    {
        return families.get(familyName);
    }
    
    /**
     * size: Returns the number of families stored in the hashtable
     * 
     * @param 
     * @return int
     */
    public int size()
    {
        return families.size();
    }
    
    /**
     * getEvents
     * @param
     * @return Event
     */
    public Event getEventList()
    {
        return tudorEvents;
    }

}
