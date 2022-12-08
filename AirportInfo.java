public class AirportInfo
{
    private String code;
    private String city;
    private String name;
    private String state;
    
    public AirportInfo(String newCode, String newCity, String newName, String newState)
    {
        code = newCode;
        city = newCity;
        name = newName;
        state = newState;
    }

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

    public void printOut()
    {
        System.out.println(getCode() + "+" + getCity() + "+" + getName() + "+" + getState());
    }
}
