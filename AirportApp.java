import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//linkedlist or adjacency matrix

public class AirportApp {
    public static void main(String[] args) throws FileNotFoundException
    {
        File airports = new File("airports.csv");
        File distance = new File("distances.csv");
        Scanner scnr = new Scanner(airports);
        scnr.useDelimiter(",");
        while(scnr.hasNext())
        {
            System.out.println(scnr.next());
        }
        scnr.close();
        //keep number of airports

        scnr = new Scanner(distance);
        while(scnr.hasNext())
        {
            System.out.println(scnr.next());
        }
        scnr.close();
    }

    private void display()
    {
        System.out.println("Airports v0.1 by A. Valdez");
        System.out.println("");
        System.out.println("Command?");
    }
}

//make an airportInfo class
//holds constructors
//Will create a simple data structure that has the info for the airport and etc.

//pg 1082

//Must make your own hash table and hash functions

//Adjacency matrix or list

//https://github.com/hapjin/data-structures-and-abstraction-with-java/tree/master/graph