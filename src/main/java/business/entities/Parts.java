package business.entities;

public class Parts
{
    private int id;
    private String name;
    private int pricePerUnit;
    private String unit;

    public Parts(int id, String name, int pricePerUnit, String unit)
    {
        this.id = id;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.unit = unit;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    @Override
    public String toString()
    {
        return
        (
        "id = " + id +
        ", name = " + name +
        ", pricePerUnit = " + pricePerUnit +
        ", Unit = " + unit
        );
    }
}
