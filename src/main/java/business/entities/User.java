package business.entities;

public class User
{
    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;

    //Our additional variables to this class are the following below.
    private String name;
    private String address;
    private String postal;
    private String city;
    private String phone;

    public User(String email, String password, String role, String name, String address, String postal, String city, String phone)
    {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.address = address;
        this.postal = postal;
        this.city = city;
        this.phone = phone;
    }

    public User(String email, String password, String role)
    {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(int id)
    {
        this.id = id;
        this.email = "";
        this.password = "";
        this.role = "";
        this.name = "";
        this.address = "";
        this.postal = "";
        this.city = "";
        this.phone = "";
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPostal()
    {
        return postal;
    }

    public String getCity()
    {
        return city;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return
        (
        "Customer ID = " + id +
        ", Email = " + email +
        ", password = " + password +
        ", User role = " + role
        );
    }
}