package business.entities;

public class CarportItems
{
    private int parts_id;
    private String name;
    private int quantity;
    private double length;
    private String unit;
    private String description;
    private int price;

    public CarportItems(int parts_id, String name, int quantity, double length, String unit, String description, int price)
    {
        this.parts_id = parts_id;
        this.name = name;
        this.quantity = quantity;
        this.length = length;
        this.unit = unit;
        this.description = description;
        this.price = price;
    }

    public int getParts_id()
    {
        return parts_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getDescription()
    {
        return description;
    }

    public int getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return
        (
                "parts_id = " + parts_id + ", name = " + name + ", quantity = " + quantity + ", length = "
                + length + ", unit = " + unit + ", description = " + description + ", price = " + price
        );
    }
}