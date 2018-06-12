package graphsplusfoundations;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javafoundations.ArrayIterator;

public class AdjListsGraphPlus<T> extends AdjListsGraph<T> 
    implements GraphPlus<T> {
 
  /** DO NOT MODIFY THE CONSTRUCTORS AND THE FIRST METHOD ******************
  * The methods you will implement follow below.
  *  @author CS230 Staff (of the three first methods)
  *  @version 2018.04.19
  */

 /**
  * Construct an empty graph.
  */
 public AdjListsGraphPlus() {
   super();
 }
 
 /**
  * Construct a graph with the same vertices and edges as the given original.
  * @param original
  */
 public AdjListsGraphPlus(AdjListsGraphPlus<T> original) {
   super(original);
 }
 
 public AdjListsGraphPlus(AdjListsGraph<T> original) {
   super(original);
 }
 
 /**
  * DO NOT MODIFY!
  * Read a TGF file and create an AdjListsGraphPlus<String> from it.
  * @param tgfFile - the TGF file to read
  * @return a graph created from the TGF file
  * @throws FileNotFoundException if TGF file is not found.
  */
 public static AdjListsGraphPlus<String> fromTGF(String tgfFile) throws FileNotFoundException {
   AdjListsGraph<String> g = AdjListsGraph.AdjListsGraphFromFile(tgfFile);
   AdjListsGraphPlus<String> gPlus = new AdjListsGraphPlus(g);
   return gPlus;
 }
 
 
 
 
 
 /**** IMPLEMENT THE METHODS BELOW *********************************
  * Replace "throw new UnsupportedOperationException();" with
  * a working implementation.
  ******************************************************************/
 public GraphPlus<T> clone() {
        GraphPlus<T> clone = new AdjListsGraphPlus<T>();
        
        //Clone the vertices using a for loop
        for (int i=0; i<this.getNumVertices(); i++)
        {
            clone.addVertex(getVertex(i));
        }
        
        //Clone the arcs using another for loop
        for (int i=0; i<this.getNumVertices(); i++)
        {
            //Get a linked list of successors for each vertex
            LinkedList<T> successors = this.getSuccessors(getVertex(i));
            
            //Loop through the successors and add to arcs in clone
            if (successors.size() > 0)
            {
                for (int j=0; j<successors.size(); j++)
                {
                    clone.addArc(getVertex(i), successors.get(j));
                }
            }
            
        }
        
        //Return the cloned graph
        return clone;
 }

 /******************************************************************
    * Checks if a vertex is a sink (points to no other vertex)
    * 
    * @param vertex: the potential sink vertex
    * @return true if the vertex is a sink, false if it is not.
    * @throws IllegalArgumentException if given vertex is not in graph
    ******************************************************************/
 public boolean isSink(T vertex) {
     //Get the list of successors for the particular vertex
     LinkedList<T> successors = this.getSuccessors(vertex);
     
     //If the list is empty, it is a sink
     if (successors == null || successors.size() == 0) return true;
     //If it is not empty, it is not a sink
     return false;
 }

  /******************************************************************
  * Retrieves the vertices that are sinks and 
  * @return all the sinks in a linked list
  ******************************************************************/
 public LinkedList<T> allSinks() {
     //Create a new linked list to store all the sinks   
     LinkedList<T> sinks = new LinkedList<T>();
     //Loop through all vertices, add the sinks
     for (int i=0; i<this.getNumVertices(); i++)
     {
        if (this.isSink(getVertex(i))) sinks.add(this.getVertex(i));
     }
        
     return sinks;
 }

 /******************************************************************
    * Checks if a vertex is a source (no vertex points to it)
    * 
    * @param vertex: the potential source vertex
    * @return true if the vertex is a source, false if it is not
    * @throws IllegalArgumentException if given vertex is not in graph
    ******************************************************************/
 public boolean isSource(T vertex) {
    //Iterate through the vertices
     for (int i=0; i<this.getNumVertices(); i++){
         //Get the list of successors for the particular vertex
         LinkedList<T> successors = this.getSuccessors(getVertex(i));
         
        //If the successors is not empty, iterate through the 
        //successors for each vertex to see if the vertex is there.
        if (successors.size() > 0){
            for (int j=0; j<successors.size(); j++){
                
                //If the vertex is there, it is not a source
                if (successors.get(j).equals(vertex)) return false;
            
            }
        }
        
    }
    //If the vertex is not there, it is a source
    return true;
 }
 

 /******************************************************************
  * Retrieves the vertices that are sources and 
  * @return all the sources in a linked list
  ******************************************************************/
 public LinkedList<T> allSources() {
    //Create linked list to store sources
    LinkedList<T> sources = new LinkedList<T>();
    
    //Iterate through vertices
    for (int i=0; i<getNumVertices();i++)
    { 
        //Check to see if each vertex is a source
        if (this.isSource(getVertex(i))) sources.add(this.getVertex(i));
    }
    //Return list of sources
    return sources;
 }

 /******************************************************************
  * Checks if a vertex is a isolated, b/c it's source and sink
  * @return true if the vertex is isolated, false if it is not
  ******************************************************************/
 public boolean isIsolated(T vertex) {
      if (this.isSource(vertex) && this.isSink(vertex)) return true;
      return false;
 }

/******************************************************************
  * Returns a LinkedList contining a DEPTH first search traversal 
  * starting at the given vertex. If the vertex is not valid, 
  * it returns an empty list
  * @return a linked list with the vertices in depth-first order
  *****************************************************************/
 public LinkedList<T> dfsTraversal(T vertex) {
        //Create a clone of the current graph
        GraphPlus<T> clone = this.clone();
     
        //Stores the vertices already traversed
        LinkedList<T> traversed = new LinkedList<T>();
        Stack<T> stk = new Stack<T>();
        
        //Add the starting vertex
        traversed.add(vertex);
        stk.push(vertex);
       
        //Stores the successors of the current vertex called
        LinkedList<T> successors = clone.getSuccessors(vertex);

        for(int i=0; i<=clone.getNumVertices()+1; i++)
        {
            if(successors.isEmpty())
            {
                //Call dfsTraversal on the predecessor of the vertex called
                stk.pop();
                successors = clone.getSuccessors(stk.peek());
            }
            else
            {
                //Arc to add to Traversed linked List
                T arcToAdd = successors.get(0);
                successors.remove(0);

                //Add the vertex to the traversed list
                if (!traversed.contains(arcToAdd)) 
                {
                    traversed.add(arcToAdd);
                }
                stk.push(arcToAdd);
               
                successors = clone.getSuccessors(arcToAdd);
            }
       }
        return traversed;

 }
 
 /******************************************************************
  * Returns an iterator contining a DEPTH first search traversal 
  * starting at the given vertex. If the vertex is not valid, 
  * it returns an empty iterator.
  * @return an ArrayIterator<T> with the vertices in depth-first order
  *****************************************************************/
 public ArrayIterator<T> dfsTraversalIter(T vertex) {
     ArrayIterator<T> dfsTraversal = new ArrayIterator<T>();      
     
     if (this.isSource(vertex))
     {
         this.dfsTraversalIter(vertex);
     }
     
     return dfsTraversal;

 }
 
 
 
/******************************************************************
  * Returns a LinkedList contining a BREADTH first search traversal 
  * starting at the given vertex. If the vertex is not valid, 
  * it returns an empty list
  * @return a linked list with the vertices in breadth-first order
  *****************************************************************/
 public LinkedList<T> bfsTraversal(T vertex) {
     //Stores the vertices already traversed 
     LinkedList<T> traversed = new LinkedList<T>();
     //Add the first vertex
     traversed.add(vertex);
     
     for(int j=0; j<this.getNumVertices(); j++)
     {
         //Get the vertex at the new index
         T parentVertex = this.vertices.get(j);
         
         //Get the list of successors for each vertex
         LinkedList<T> successors = this.getSuccessors(parentVertex);

         //Loop through each successor
         for (int i=0; i<successors.size(); i++)
         {
             //Add the successor if it doesn't exist already
             if (!traversed.contains(successors.get(i)))
             {
                 traversed.add(successors.get(i));
             }
          }
        
      }

      return traversed;
 }
 
 /******************************************************************
  * Returns an iterator contining a BREADTH first search traversal 
  * starting at the given vertes. If the vertex is not valid, 
  * it returns an empty iterator.
  * @return an ArrayIterator<T> with the vertices in breadth-first order
  *****************************************************************/
 public ArrayIterator<T> bfsTraversalIter(T vertex) {
     ArrayIterator<T> bfsTraversal = new ArrayIterator<T>();      
     
     if (this.isSource(vertex))
     {
         this.bfsTraversalIter(vertex);
     }
     
     return bfsTraversal;

 }
 
 
 public static void main(String[] args)
 {
    AdjListsGraphPlus<String> g1Test = new AdjListsGraphPlus<String>();
    try{
        g1Test = g1Test.fromTGF("g1.tgf");
    }
    catch(java.io.FileNotFoundException e){
        System.out.println(e);
    }
    
    g1Test.saveToTGF("Test1Result.tgf");
    
    //Testing Clone method
    System.out.println("Test 1: Clone");
    GraphPlus<String> g1TestClone = g1Test.clone();
    System.out.println(g1TestClone.toString());
    System.out.println();
    
    //Testing Sink method
    System.out.println("Test 2: isSink");
    System.out.println("Is C a sink? Expected: true \nGot: ");
    System.out.println(g1Test.isSink(g1Test.getVertex(3)));
    System.out.println("Is A a sink? Expected; false \nGot: ");
    System.out.println(g1Test.isSink(g1Test.getVertex(1)));
    System.out.println();
    
    //Testing allSink method
    System.out.println("Test 3: allSinks");
    System.out.println("Expected: [3][4] \nGot: ");
    System.out.println(g1Test.allSinks().toString());
    System.out.println();
    
    //Testing isSource method
    System.out.println("Test 4: Source");
    System.out.println("Is D a source? Expected true \nGot: ");
    System.out.println(g1Test.isSource(g1Test.getVertex(4)));
    System.out.println("Is B a source? Expected false \nGot: ");
    System.out.println(g1Test.isSource(g1Test.getVertex(2)));
    System.out.println();
    
    //Testing allSources method
    System.out.println("Test 5: All Sources");
    System.out.println("Expected: [4] \nGot: ");
    System.out.println(g1Test.allSources().toString());
    System.out.println();
    
    //Testing isIsolated method
    System.out.println("Test 6: Is Isolated");
    System.out.println("Is D isolated? Expected: true \nGot: ");
    System.out.println(g1Test.isIsolated(g1Test.getVertex(4)));
    System.out.println("Is A isolated? Expected: false \nGot: ");
    System.out.println(g1Test.isIsolated(g1Test.getVertex(1)));
    
    
    //Testing g2 graph
    AdjListsGraphPlus<String> g2Test = new AdjListsGraphPlus<String>();
    try{
        g2Test = g2Test.fromTGF("g2.tgf");
    }
    catch(java.io.FileNotFoundException e){
        System.out.println(e);
    }
    g2Test.saveToTGF("Test2Result.tgf");
    
    //Testing dfsTraversal
    System.out.println("Test 7: DFS Traversal");
    System.out.println("Expected: [a, b, c, d, i, g, e, h, f] \nGot: ");
    System.out.println(g2Test.dfsTraversal("a").toString());
    System.out.println();
    
    System.out.println("Test 8: BFS Traversal");
    System.out.println("Expected: [a, b, d, c, i, e, h, f, g] \nGot: ");
    System.out.println(g2Test.bfsTraversal("a").toString());
    System.out.println();
    
 }
}
