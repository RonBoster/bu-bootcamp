public class Contact 
{
    private String name;
    private String phone;

    public Contact(String name, String phone)      //Constructor
    {
        this.name = name;   
        this.phone = phone;
    }

    public String getName()         //Getter for Name
    {        return name;    }

    public String getPhone()        //Getter for phone
    {       return phone;   }

    public String toString()        //OverrRide
    {   return name + "  |  " + phone; }
    
}
