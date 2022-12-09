//
//  Name:   Valdez, Andrew
//  Project:   Project #5
//  Due:    12/9/22
//  Course: CS-2400-02-f22
//
//  Description:
//  Acts as an app that uses a user interface to display available commands and information to the user.
//  Designed to accept user input and output information based on what is inputted.
//  Tests the methods created in the Directed Graph.  
//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class AirportApp 
{
    public static void main(String[] args) throws FileNotFoundException 
    { 
        //DECLARING VALUES

        File airFile = new File("./airports.csv");
        File distFile = new File("./distances.csv");
        Scanner scnr = new Scanner(System.in);
        DictionaryInterface<String, AirportInfo> dictionary = new MapDictionary<>();
        GraphInterface<String> diGraph = new DirectedGraph<>();

        System.out.println("Airports v0.1 by A. Valdez");

        //SCANNING AND ALLOCATING VALUES

        Scanner airportScnr = new Scanner(airFile);
        Scanner distanceScnr = new Scanner(distFile);

        while(airportScnr.hasNextLine())
        {
            AirportInfo airport = new AirportInfo(airportScnr.nextLine());
            dictionary.add(airport.getCode(), airport); //create dictionary to store the values based on airport code
            diGraph.addVertex(airport.getCode()); //grabs code from aiport data structure
        }
        
        while(distanceScnr.hasNextLine())
        {
            String[] str = distanceScnr.nextLine().split(",");
            diGraph.addEdge(str[0], str[1], Double.parseDouble(str[2]));
        }

        airportScnr.close();
        distanceScnr.close();

        //MAIN MENU CODE

        System.out.println("");
        System.out.print("Command? ");
        String[] userInput = scnr.nextLine().toUpperCase().split(" ");

        while(!userInput[0].equals("E")) 
        {
            switch(userInput[0])
            {
                case "H":
                    System.out.println("Q Query the airport information by entering the airport code.");
                    System.out.println("D Find the minimum distance between two aiports.");
                    System.out.println("I Insert a connection between two airports.");
                    System.out.println("R Remove a connection between two airports.");
                    System.out.println("E Exit.");
                    break;

                case "Q": 
                    for(int i = 1; i < userInput.length; i++)
                    {
                        if(dictionary.getValue(userInput[i]) == null)
                        {
                            System.out.println(userInput[i] + " - unknown");
                            continue;
                        } else {
                            AirportInfo airInfo = dictionary.getValue(userInput[i]);
                            airInfo.printOut();
                        }
                    }
                    break;

                case "D": 
                    if(!(dictionary.getValue(userInput[1]) == null) && !(dictionary.getValue(userInput[2]) == null))
                    {
                        Stack<String> stack = new Stack<>();
                        int cheapestPath = (int)diGraph.getCheapestPath(userInput[1], userInput[2], stack);
                        if(cheapestPath != 0)
                        {
                            System.out.println(dictionary.getValue(userInput[1]).toString() + " to " + dictionary.getValue(userInput[2]).toString() + " is " + cheapestPath + " through the route:");
                            while(!stack.isEmpty())
                            {
                                AirportInfo airInfo = dictionary.getValue(stack.pop());
                                airInfo.printOut();
                            }
                        } else {
                            System.out.println("Airports not connected");
                        }
                    } else {
                        System.out.println("Airport code unknown");
                    }
                    break;

                case "I": 
                    int distance = 0;
                    distance = Integer.parseInt(userInput[3]);

                    if (distance > 0) {
                        if (dictionary.getValue(userInput[1]) != null && dictionary.getValue(userInput[2]) != null) {
                            //Check if user inputted values then execute
                            boolean result = diGraph.addEdge(userInput[1], userInput[2], distance); //Return true if the new edge is created, false if already existing

                            if (result == true) {
                                System.out.println(
                                        dictionary.getValue(userInput[1]).toString() + " to "
                                                + dictionary.getValue(userInput[2]).toString()
                                                + " with a distance of " + distance + " added.");
                            } else {
                                System.out.println("Connection already exists.");
                            }
                        } else {
                            System.out.println("Airport code unknown");
                        }
                    } else {
                        System.out.println("Failed: Distance is less than or equal to 0.");
                    }
                    break;
                    
                case "R": 
                    if(dictionary.getValue(userInput[1]) != null && dictionary.getValue(userInput[2]) != null) 
                    { //check dictionary for value from userInput
                        if(diGraph.hasEdge(userInput[1], userInput[2])) 
                        {//Check if edge exists to be deleted
                            boolean result = diGraph.addEdge(userInput[1], userInput[2]);
                            if(result == true) 
                            {
                                System.out.println(dictionary.getValue(userInput[1]).toString() + " and " + dictionary.getValue(userInput[2]).toString() + " removed.");
                            }
                        } else {
                            System.out.println("Airports not connected");
                        }
                    } else {
                        System.out.println("Airport code unknown");
                    }
                    break;

                case "E":
                    break;

                default:
                    System.out.println("");
                    System.out.println("Invalid Command");
                    System.out.println("For Command List, Type: H");
                    break;
            }
            System.out.println("");
            System.out.print("Command? ");
            userInput = scnr.nextLine().toUpperCase().split(" ");
        }
        scnr.close();
    }   
}
