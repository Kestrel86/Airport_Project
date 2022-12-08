import java.io.File;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

//Ask professor about Directed Graph name

public class AirportApp 
{
    public static void main(String[] args) 
    { //Would this FileNotFoundException work?
        File airFile = new File("./airports.csv");
        File distFile = new File("./distances.csv");
        Scanner scnr = new Scanner(System.in);
        DictionaryInterface<String, AirportInfo> dictionary = new MapDictionary<>();
        GraphInterface<String> diGraph = new DirectedGraph<>();
        String[] userInput;

        System.out.println("Airports v0.1 by A. Valdez");

        try {
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

        } catch(FileNotFoundException e) {
            System.out.println("File not Found");
        }
        
        do {
            System.out.println("");
            System.out.print("Command? ");
            userInput = scnr.nextLine().toUpperCase().split(" ");

            switch(userInput[0])
            {
                case "H":
                    displayMenu();
                    break;

                case "Q":
                    for(int i = 1; i < userInput.length; i++)
                    {
                        if(dictionary.getValue(userInput[i]) == null)
                        {
                            System.out.println("Unknown Airport Code");
                            continue;
                        } else {
                            System.out.print(userInput[i] + " - ");
                            AirportInfo airInfo = dictionary.getValue(userInput[i]);
                            System.out.println(airInfo.toString());
                        }
                    }
                    break;

                case "D": 
                    if(!(dictionary.getValue(userInput[1]) == null) && !(dictionary.getValue(userInput[2]) == null))
                    {
                        Stack<String> stack = new Stack<>();
                        double cheapestPath = diGraph.getCheapestPath(userInput[1], userInput[2], stack);
                        if(cheapestPath == 0)
                        {
                            System.out.println("Airports Are not Connected");
                        } else {
                            System.out.println(dictionary.getValue(userInput[1]).toString() + " to " + dictionary.getValue(userInput[2]).toString() + " is " + cheapestPath + " through the route:");
                            while(!stack.isEmpty())
                            {
                                AirportInfo startPt = dictionary.getValue(stack.pop());
                                System.out.println(startPt.getCode() + " - " + startPt.toString());
                            }
                        }
                    } else {
                        System.out.println("Unknown Airport Code");
                    }
                    break;

                case "I": 
                    int distance;
                    try {
                        distance = Integer.parseInt(userInput[3]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        distance = -1;
                    } catch (NumberFormatException e) {
                        distance = -1;
                    }

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
								System.out.println("The connection already exist.");
                            }
						} else {
							System.out.println("Unknown Airport Code");
                        }
					} else {
						System.out.println("Failed: Distance is less than 0.");
                    }
					break;
                    
                case "R": //NOT WORKING
                    if(dictionary.getValue(userInput[1]) != null && dictionary.getValue(userInput[2]) != null) 
                    { //check dictionary for value from userInput
                        if(diGraph.hasEdge(userInput[1], userInput[2])) 
                        {//Check if edge exists to be deleted
                            boolean result = diGraph.addEdge(userInput[1], userInput[2]); //probable cause
                            if(result == true) 
                            {
                                System.out.println(dictionary.getValue(userInput[1]).toString() + " and " + dictionary.getValue(userInput[2]).toString() + " removed.");
                            }
                        } else {
                            System.out.println("Airports Are Not Connected");
                        }
                    } else {
                        System.out.println("Unknown Airport Code");
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
        } while(!userInput[0].equals("E"));
        scnr.close();
    }   

    private static void displayMenu()
    {
        //System.out.println("H Print Menu");
        System.out.println("Q Query the airport information by entering the airport code.");
        System.out.println("D Find the minimum distance between two aiports.");
        System.out.println("I Insert a connection between two airports.");
		System.out.println("R Remove a connection between two airports.");
		System.out.println("E Exit.");
    }
}
