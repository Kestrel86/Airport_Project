public class AirportInfo {
    private String label;
    private String city;
    private String name;
    private String state;

    public AirportInfo(String newLabel, String newCity, String newName, String newState)
    {
        label = newLabel;
        city = newCity;
        name = newName;
        state = newState;
    }

    public String getLabel()
    {
        return label;
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
        System.out.println("");
    }
}
