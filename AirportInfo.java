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

    public void printOut()
    {
        System.out.println(getCode() + " - " + getCity() + " " + getName() + " " + getState());
    }
}
