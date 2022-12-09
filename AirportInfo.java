//
//  Name:   Valdez, Andrew
//  Project:   Project #5
//  Due:    12/9/22
//  Course: CS-2400-02-f22
//
//  Description:
//  A data structure designed to store information supplied to it. 
//

public class AirportInfo
{
    private String code;
    private String city;
    private String name;
    private String state;

    /**
     * Constructor is designed to split a String and separate information from the string. 
     * @param line The string that will be split in the constructor. 
     */
    public AirportInfo(String line)
    {
        String[] str = line.split(",");
        code = str[0];
        city = str[1];
        name = str[2];
        state = str[3];
    }
    
    /**
     * Retrieves the value associated to the code variable
     * @return The value associated to the code variable.
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Retrieves the value associated to city variable
     * @return The value associated to the city variable.
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Retrieves the value associated to name variable
     * @return The value associated to the name variable.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Retrieves the value associated to state variable
     * @return The value associated to the state variable.
     */
    public String getState()
    {
        return state;
    }

    /**
     * Retrieves the values of the variables and returns as a combined String
     * @return the combined String of the called variables
     */
    public String toString()
    {
        return getCity() + " " + getName() + " " + getState();
    }

    /**
     * Prints to the terminal each variable's value
     */
    public void printOut()
    {
        System.out.println(getCode() + " - " + getCity() + " " + getName() + " " + getState());
    }
}
