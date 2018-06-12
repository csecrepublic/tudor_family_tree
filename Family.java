import graphsplusfoundations.*; 
import java.io.*;
import java.util.*;
/**
 * Family class with graph ADT
 *
 * @author jxiao2, fgazzolo, ecoe2
 * @version 05/06/2018
 */
public class Family
{
    // instance variables
    private String numPeople; //Number of people in the family
    private String timePeriod; //Time period of the family lineage
    private Hashtable<String, Person> personCollect = new Hashtable<String, Person>();
    private String bio; //Family bio
    private AdjListsGraphPlus<Person> graph; //The graph ADT
    /**
     * Constructor for objects of class Family
     */
    public Family(String personFile, String bioFile)
    {
            try
            {
                //Initialize Graph
                graph = new AdjListsGraphPlus<Person>();
                
                //Need a scanner to read through personfile
                Scanner scan = new Scanner(new File(personFile));
                scan.useDelimiter("\n");
                
                while (scan.hasNext())
                {
                    String personString = "";
                    
                    for(int i = 0; i < 12; i++)
                    {
                        personString += scan.next() + "\n";
                    }
                    
                    //Add to HashTable
                    Person toAdd = Person.readPerson(personString);
                    personCollect.put(toAdd.getName(), toAdd);
                    //Add to Graph
                    graph.addVertex(toAdd);
                    
                    //scans over "==="
                    scan.next(); 
                }
                scan.close(); //Close the scanner
            }
            catch (java.io.FileNotFoundException e)
            {
                System.out.println(e);
            }
        
            
            try
            {
                Scanner bioScan = new Scanner(new File(bioFile));
                bio = bioScan.nextLine();
            }
            catch (java.io.FileNotFoundException e1)
            {
                System.out.println(e1);
            }
        
        }
        
    /**
     * Contains method for family
     * @param Person
     * @return boolean
     */   
    public boolean contains(Person p)
    {
        return graph.containsVertex(p);
    }
    
        
    /**
     * Getter method for numPeople instance variable
     *
     * @param  
     * @return the number of people 
     */
    public String getNumPeople()
    {
        return numPeople;
    }
    
    /**
     * Getter method for timePeriod instance variable
     *
     * @param  
     * @return the time period
     */
    public String getTimePeriod()
    {
        return timePeriod;
    }
    
    /**
     * Getter method for bio instance variable
     *
     * @param  
     * @return the bio
     */
    public String getBio()
    {
        return bio;
    }
    
    /**
     * getPersonCollect method
     * 
     * @param
     * @return Hashtable
     */
    public Hashtable<String, Person> getPersonCollect()
    {
        return personCollect;
    }
    
    /**
     * Add an arc between two people who are parent and child
     *
     * @param  the source, which is the parent. And the destination, which is the child.
     * @return 
     */
    public void addParent(Person parent, Person child)
    {
        graph.addArc(parent, child); //Add arc
    }
    
    /**
     * Add an edge between two people who are spouses
     *
     * @param  the source, which is the s. And the destination, which is the child.
     * @return 
     */
    public void addSpouse(Person spouse1, Person spouse2)
    {
        graph.addEdge(spouse1, spouse2);
    }
    
    /**
     *  Gets successors in the Family Tree
     *
     * @param  
     * @return a LinkedList of successors
     */
    public LinkedList<Person> getDescendents(Person vertex)
    {
        LinkedList<Person> successors = graph.getSuccessors(vertex);
        
        for(int i = 0; i < successors.size(); i++)
        {
            if(this.isSpouse(vertex, successors.get(i)))
            {
                successors.remove(successors.get(i));
            }
        }
        
        return successors;
    }
    
    /**
     *  Gets predecessors in the Family Tree
     *
     * @param  
     * @return a LinkedList of predecessors
     */
    public LinkedList<Person> getAncestors(Person vertex)
    {
        LinkedList<Person> predecessors = graph.getPredecessors(vertex);
        System.out.println(predecessors);
        
        for(int i = 0; i < predecessors.size(); i++)
        {
            if(this.isSpouse(vertex, predecessors.get(i)))
            {
                predecessors.remove(predecessors.get(i));
            }
        }
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println(predecessors);
        return predecessors;
    }
    
    public LinkedList<Person> getSpouses(Person vertex)
    {
        LinkedList<Person> spouses = graph.getPredecessors(vertex);
        
        for(int i = 0; i < spouses.size(); i++)
        {
            if(!this.isSpouse(vertex, spouses.get(i)))
            {
                spouses.remove(spouses.get(i));
            }
        }
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println(spouses);
        return spouses;
    }

    public AdjListsGraphPlus<Person> getGraph()
    {
        return this.graph;
    }
    
    public boolean isSpouse(Person spouse1, Person spouse2)
    {
        return graph.isEdge(spouse1, spouse2);
    }
    
    /**
     * Adds arcs between parents and children and between spouses.
     */
    public void addArcs()
    {
        this.addSpouse(personCollect.get("Henry VII"), personCollect.get("Elizabeth of York"));
        this.addParent(personCollect.get("Henry VII"), personCollect.get("Henry VIII"));
        this.addParent(personCollect.get("Elizabeth of York"), personCollect.get("Henry VIII"));
        this.addParent(personCollect.get("Henry VII"), personCollect.get("Margaret Tudor"));
        this.addParent(personCollect.get("Elizabeth of York"), personCollect.get("Margaret Tudor"));
        this.addSpouse(personCollect.get("Henry VIII"), personCollect.get("Catherine of Aragon"));
        this.addSpouse(personCollect.get("Henry VIII"), personCollect.get("Anne Boleyn"));
        this.addSpouse(personCollect.get("Henry VIII"), personCollect.get("Jane Seymour"));
        this.addSpouse(personCollect.get("Henry VIII"), personCollect.get("Anne of Cleves"));
        this.addSpouse(personCollect.get("Henry VIII"), personCollect.get("Catherine Howard"));
        this.addSpouse(personCollect.get("Henry VIII"), personCollect.get("Catherine Parr"));
        this.addParent(personCollect.get("Henry VIII"), personCollect.get("Mary I"));
        this.addParent(personCollect.get("Henry VIII"), personCollect.get("Elizabeth I"));
        this.addParent(personCollect.get("Henry VIII"), personCollect.get("Edward VI"));
        this.addParent(personCollect.get("Catherine of Aragon"), personCollect.get("Mary I"));
        this.addParent(personCollect.get("Anne Boleyn"), personCollect.get("Elizabeth I"));
        this.addParent(personCollect.get("Jane Seymour"), personCollect.get("Edward VI"));
        this.addSpouse(personCollect.get("Margaret Tudor"), personCollect.get("James IV"));
        this.addParent(personCollect.get("Margaret Tudor"), personCollect.get("James V"));
        this.addParent(personCollect.get("James IV"), personCollect.get("James V"));
        this.addSpouse(personCollect.get("James V"), personCollect.get("Mary of Guise"));
        this.addParent(personCollect.get("James V"), personCollect.get("Mary Queen of Scots"));
        this.addParent(personCollect.get("Mary of Guise"), personCollect.get("Mary Queen of Scots"));
        this.addSpouse(personCollect.get("Mary Queen of Scots"), personCollect.get("Henry Stuart"));
        this.addParent(personCollect.get("Mary Queen of Scots"), personCollect.get("James VI & I"));
        this.addParent(personCollect.get("Henry Stuart"), personCollect.get("James VI & I"));
        
    }
    
    /**
     * getSource: Returns a person who is the source
     * 
     */
    public Person getSource()
    {
        return this.graph.getVertex(0);
    }
}
