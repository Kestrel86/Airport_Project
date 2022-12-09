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
    
    /* 
    /**
     * Constructor designed to store information based on the parameters.
     * @param newCode Determines the new Code assigned "code"
     * @param newCity Determines the new City assigned to "city"
     * @param newName Determines the new Name assigned to "name"
     * @param newState Determines the new State assigned to "state"
     
    public AirportInfo(String newCode, String newCity, String newName, String newState)
    {
        code = newCode;
        city = newCity;
        name = newName;
        state = newState;
    }
    */

    /**
     * 
     * @return
     */
    public String getCode()
    {
        return code;
    }

    public String getCity()
    {
        return city;
    }

    public String getName()
    {
        return name;
    }

    public String getState()
    {
        return state;
    }

    public String toString()
    {
        return getCity() + " " + getName() + " " + getState();
    }
}
