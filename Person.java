/**
 * Creates a Person with basic attributes.
 *
 * @author fgazzolo
 * @version 5/13/18
 */
import java.io.*;
import java.util.*;

public class Person
{
    protected String name;
    protected String birthdate;
    protected String timePeriod;
    protected String familyName;
    protected String ethnicity;
    protected String gender;
    protected String causeOfDeath;
    private String reign;
    private String position;
    private Vector<SingleEvent> events; 
    
    /**
     * Creates a Person object by reading from file.
     * 
     * @param file - name of file to read from
     */
    public Person(String file)
    {
        Person.readPerson(file);
    }
    
    /**
     * Creates a Person object with empty instance variables.
     * Used in readPerson() method.
     */
    public Person()
    {
        name = "";
        birthdate = "";
        timePeriod = "";
        familyName = "";
        ethnicity = "";
        gender = "";
        causeOfDeath = "";
        reign = "";
        position = "";
    }

    /**
     * Gets name of person.
     * 
     * @return String - name instance variable
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Gets birthdate of person.
     * 
     * @return String - birthdate instance variable
     */
    public String getBirthdate()
    {
        return this.birthdate;
    }
    
    /**
     * Gets time period in which person lived.
     * 
     * @return String - timePeriod instance variable 
     */
    public String getTimePeriod()
    {
        return this.timePeriod;
    }
    
    /**
     * Gets family name of person.
     * 
     * @return String - familyName instance variable
     */
    public String getFamilyName()
    {
        return this.familyName;
    }
    
    /**
     * Gets ethnicity of person.
     * 
     * @return String - ethnicity instance variable
     */
    public String getEthnicity()
    {
        return this.ethnicity;
    }
    
    /**
     * Gets gender of person.
     * 
     * @return String - gender instance variable
     */
    public String getGender()
    {
        return this.gender;
    }
    
    /**
     * Gets person's cause of death.
     * 
     * @return String - causeOfDeath instance variable
     */
    public String getCauseOfDeath()
    {
        return this.causeOfDeath;
    }
    
    /**
     * Gets person's period of reign.
     * 
     * @return String - reign instance variable
     */
    public String getReign()
    {
        return this.reign;
    }
    
    /**
     * Gets person's position.
     * 
     * @return String - position instance variable
     */
    public String getPosition()
    {
        return this.position;
    }
    
    /**
     * Gets list of events that person was involved in.
     * 
     * @return Vector<Event> - events instance variable
     */
    public Vector<SingleEvent> getEvents()
    {
        return this.events;
    }
    
    /**
     * Sets person's name to desired input.
     * 
     * @param newName - new name instance variable
     */
    public void setName(String newName)
    {
        this.name = newName;
    }
    
    /**
     * Sets person's birthdate to desired input.
     * 
     * @param newBirth - new birthdate instance variable
     */
    public void setBirthdate(String newBirth)
    {
        this.birthdate = newBirth;
    }
    
    /**
     * Sets person's time period to desired input.
     * 
     * @param newPeriod - new timePeriod instance variable
     */
    public void setTimePeriod(String newPeriod)
    {
        this.timePeriod = newPeriod;
    }
    
    /**
     * Sets person's family name to desired input.
     * 
     * @param newFam - new familyName instance variable
     */
    public void setFamilyName(String newFam)
    {
        this.familyName = newFam;
    }
    
    /**
     * Sets person's ethnicity to desired input.
     * 
     * @param newEthnicity - new ethnicity instance variable
     */
    public void setEthnicity(String newEthnicity)
    {
        this.ethnicity = newEthnicity;
    }
    
    /**
     * Sets person's gender to desired input.
     * 
     * @param newGender - new gender instance variable
     */
    public void setGender(String newGender)
    {
        this.gender = newGender; 
    }
    
    /**
     * Sets person's cause of death to desired input.
     * 
     * @param newDeath - new causeOfDeath instance variable
     */
    public void setCauseOfDeath(String newDeath)
    {
        this.causeOfDeath = newDeath;
    }
    
    /**
     * Sets person's reign to desired input.
     * 
     * @param newReign - new reign instance variable
     */
    public void setReign(String newReign)
    {
        this.reign = newReign;
    }
    
    /**
     * Sets person's position to desired input.
     * 
     * @param newPosition - new position instance variable
     */
    public void setPosition(String newPosition)
    {
        this.position = newPosition;
    }
    
    /**
     * Formats person object into a String.
     * 
     * @return String - person's name and a list of their attributes
     */
    public String toString()
    {
        String result = "";
        
        result += this.name + " (" + this.familyName + ")\n____________________\n";
        result += "Birth date: " + this.birthdate + "\nTime period: " + this.timePeriod;
        result += "\nGender: " + this.gender + "\nEthnicity: " + this.ethnicity;
        result += "\nCause of death: " + this.causeOfDeath;
        result += "\nReign: " + this.reign + "\nPosition: " + this.position;
        result += "\nNotable events:\n";
        
        for(int i = 0; i < events.size(); i++)
        {
            result += events.get(i).getName() + "\n";
        }
        
        return result;
    }
    
    /**
     * Creates a person object by reading from a file.
     * 
     * @param file - name of file to read from
     * @return Person - new Person object
     */
    public static Person readPerson(String stringInput)
    {
        //initializes an empty person
        Person thisPerson = new Person();
        thisPerson.events = new Vector<SingleEvent>();

        Scanner scan = new Scanner(stringInput);
        scan.useDelimiter("\n");
        
        String name; 
        String time;
        String birthdate;
        String reign;
        String surname;
        //skip spouse
        //skip children
        String ethnicity;
        String gender;
        String death;
        String position;
        String eventsString; 
        
        //keep going until you hit "===" after 12 lines
        while(scan.hasNext())
        {
            name = scan.next();
            time = scan.next();
            birthdate = scan.next();
            reign = scan.next();
            surname = scan.next();
            
            //skips over spouse and children
            scan.next();
            scan.next();
            
            ethnicity = scan.next();
            gender = scan.next();
            death = scan.next(); 
            position = scan.next();
            eventsString = scan.next();
            
            thisPerson.setAttributes(name, time, birthdate, reign, surname, ethnicity, gender, death, position);
            
            if(eventsString.length() > 0)
            {
                thisPerson.readEvents(eventsString);
            }   
            
        }
        scan.close();
        
        return thisPerson;
    }
    
    /**
     * Helper method for setting attributes.
     * 
     * @param name - person's name
     * @param time - person's timePeriod
     * @param birthdate - person's birthdate
     * @param surname - person's familyName
     * @param ethnicity - person's ethnicity
     * @param gender - person's gender
     * @param death - person's causeOfDeath
     * @param gender - person's gender
     * @param death - person's causeOfDeath
     * @param position - person's position
     */
    public void setAttributes(String name, String time, String birthdate, String reign, String surname, String ethnicity, String gender, String death, String position)
    {
        this.setName(name);
        this.setTimePeriod(time);
        this.setBirthdate(birthdate);
        this.setFamilyName(surname);
        this.setEthnicity(ethnicity);
        this.setGender(gender);
        this.setCauseOfDeath(death);
        this.setReign(reign);
        this.setPosition(position);
        
    }
    
    private void readEvents(String eventsString)
    {
        Scanner eventScanner = new Scanner(eventsString).useDelimiter(", ");
                
        while(eventScanner.hasNext())
        {
            String eventName = eventScanner.next();
            
            SingleEvent newSingE = new SingleEvent();
            newSingE.setName(eventName);
            
            events.add(newSingE);
        }
        
    }
}