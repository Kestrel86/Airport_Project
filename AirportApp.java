import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

//linkedlist or adjacency matrix

//Choose adjacency Matrix //to store distances

//do we turn airports into a constructor class and turn distances into the adjacency matrix?

//we use the adjacency matrix or list to state which airports are connected to each other and store the distances between airports

//What I dont understand:
/*
 * Cant figure out the adjacency matrix and how to use it
 * how does it correlate to the diGraph
 */

public class AirportApp 
{
    //private static int[][] adjMatrix;
    public static void main(String[] args) throws FileNotFoundException
    {
        int numberOfAirports = 0; //keep number of airports

        //Record number of airports first when going through airports
        GraphInterface<String> diGraph = new DirectedGraph<>();
        AirportInfo airInfo = new AirportInfo(null, null, null, null);
        ArrayList<AirportInfo> airport = new ArrayList<>();

        //add vertex from airport info from digraph
        File airports = new File("airports.csv");
        File distance = new File("distances.csv");

        //read whole and do a split with comma
        Scanner scnr = new Scanner(airports);
        while(scnr.hasNextLine())
        {
            String str = scnr.nextLine();
            String[] tokens = str.split(","); 
            airInfo = new AirportInfo(tokens[0], tokens[1], tokens[2], tokens[3]);
            airport.add(airInfo); //maybe grab from here
            diGraph.addVertex(airInfo); //Not applicable
            numberOfAirports++;
        }
        scnr.close();

        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

        for(int i = 0; i < numberOfAirports; i++)
        {
            arrList.add(new ArrayList<Integer>());
        }

        scnr = new Scanner(distance);
        while(scnr.hasNextLine())
        {
            String str = scnr.nextLine();
            String[] tokens = str.split(","); 
        }
        scnr.close();


        //use distances to add edge and possibly use adjacency matrix
        //Store which airports are connected to each other and distance
    }

    public void display() 
    {
        //Will print the Main Menu
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> arrList, int s, int d)
    {
        arrList.get(s).add(d);
        arrList.get(d).add(s);
    }

    /* 
    public static void graph(int num)
    {
        adjMatrix = new int[num][num];
    }

    // Add edges
    public void addEdge(int i, int j, int dist) {
        adjMatrix[i][j] = dist;
        adjMatrix[j][i] = dist;
    }

    // Remove edges
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }
    */
}

//https://github.com/orestespap/airport-network-java-graphs