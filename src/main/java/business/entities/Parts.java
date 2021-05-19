package business.entities;

public class Parts {
    private int id;
    private String name;
    private int pricePerUnit;
    private String Unit;


    public Parts(int id, String name, int pricePerUnit, String unit) {
        this.id = id;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        Unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                ", Unit='" + Unit + '\'' +
                '}';
    }
}
