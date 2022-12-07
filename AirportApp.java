import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//linkedlist or adjacency matrix

//Choose adjacency Matrix

//do we turn airports into a constructor class and turn distances into the adjacency matrix?

//https://stackoverflow.com/questions/52801964/create-an-adjacency-matrix-from-a-csv-file-of-three-variables

public class AirportApp {
    public static void main(String[] args) throws FileNotFoundException
    {
        int numberOfAirports; //keep number of airports
        GraphInterface<String> graph = new DirectedGraph<>();
        File airports = new File("airports.csv");
        File distance = new File("distances.csv");
        Scanner scnr = new Scanner(airports);
        scnr.useDelimiter(",");
    
        scnr = new Scanner(distance);
        while(scnr.hasNext())
        {
            System.out.println(scnr.next());
        }
        scnr.close();
    }
}

//make an airportInfo class
//holds constructors
//Will create a simple data structure that has the info for the airport and etc.

//pg 1082

//Must make your own hash table and hash functions

//Adjacency matrix or list

//https://github.com/hapjin/data-structures-and-abstraction-with-java/tree/master/graph