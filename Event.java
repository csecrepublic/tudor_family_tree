import java.io.*;
import java.util.*;
/**
 * A collection of all events, which includes each event's name, time period 
 * and description. 
 *
 * @author jxiao2
 * @version 05/13/2018
 */
public class Event
{
    // instance variables
    private String eventName;
    private String timePeriod;
    private String description;
    //a collection of each event with each event's name, time period, and description
    private Vector<SingleEvent> eachEvent; 
    
    /**
     * Constructor for objects of class Event to initialize intance variables.
     */
    public Event(String filename)
    {
        
        try{
            Scanner reader = new Scanner(new File(filename)); //read file

            eachEvent = new Vector<SingleEvent>();
            
            while (reader.hasNextLine()){
               //Create an instance of a single event to add to the Vector
               SingleEvent currentEvent = new SingleEvent();
               
               eventName = reader.nextLine(); //read the next line. First line is event name
               currentEvent.setName(eventName); //add event name to SingleEvent
               
               
               timePeriod = reader.nextLine(); //Second line is time period
               currentEvent.setTime(timePeriod); //add time period to linked list
               
               //Initially set description as empty string, later concatenate to form full description
               description = reader.nextLine();  
               currentEvent.setBio(description); //add description to SingleEvent
               
               //scans over "==="
               reader.nextLine();

               //Create LinkedList for each index in vector
               eachEvent.add(currentEvent);
            }
            reader.close(); //close the sceventsPanel.add(b1);eventsPanel.add(b1);eventsPanel.add(b1);eventsPanel.add(b1);eventsPanel.add(b1);eventsPanel.add(b1);eventsPanel.add(b1);eventsPanel.add(b1);anner
        }catch(IOException e) {
            System.out.println("error in reading file");
        }
    }
    
    /**
     * getEvents method
     * @param
     * @return Vector<SingleEvent>
     */
    public Vector<SingleEvent> getEvents()
    {
        return eachEvent;
    }
    
    /**
     * getEvent
     * @param String eventname
     * @return SingleEvent
     */
    public SingleEvent getEvent(String eventName)
    {
        SingleEvent toReturn = null;
        if (this.contains(eventName))
        {
            for( int i=0; i<eachEvent.size(); i++)
            {
                System.out.println(eachEvent.get(i).getName());
                if (eachEvent.get(i).getName().equals(eventName))
                {
                    toReturn = eachEvent.get(i);
                }
            }
        }
        return toReturn;
    }
    
    /**
     * contains 
     * @param String eventName
     * @return boolean
     */
    public boolean contains(String eventName){
        boolean contains = false;
        
        for (int i=0; i<eachEvent.size(); i++){
            if((eachEvent.get(i).getName()).equals(eventName))
            {
                contains = true;
                return contains;
            }
        }
        

        return contains;
    }
}
