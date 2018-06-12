/**
 * Holds and instance of a single event. Uses Event class
 *
 * @author ecoe2
 * @version 05/13/2018
 */
public class SingleEvent
{
    //Instance Variables
    private String name, timePeriod, description;

    /**
     * Constructor for objects of class SingleEvent
     */
    public SingleEvent(String n, String tp, String descript)
    {
        // initialise instance variables
        name = n;
        timePeriod = tp;
        description = descript;
    }
    
    public SingleEvent()
    {
        name = "";
        timePeriod = "";
        description = "";
    }

    /**
     * Name Getter
     *
     * @param 
     * @return  String name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Time Period Getter
     *
     * @param 
     * @return  String period
     */
    public String getTime()
    {
        return timePeriod;
    }
    
    /**
     * Description Getter
     *
     * @param 
     * @return  String bio
     */
    public String getBio()
    {
        return description;
    }
    
    /**
     * Name Setter
     *
     * @param String
     * @return  
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Time Period Setter
     *
     * @param String 
     * @return void
     */
    public void setTime(String newTime)
    {
        timePeriod = newTime;
    }
    
    /**
     * Description Setter
     *
     * @param String
     * @return void
     */
    public void setBio(String newBio)
    {
        description = newBio;
    }
  
    
    /**
     * toString method
     * @param
     * @return
     */
    public String toString()
    {
        String toReturn = "";
        toReturn += "\n" + name + "\n" + timePeriod + "\n" + description;
        return toReturn;
    }
}