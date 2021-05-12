package business.entities;

public class Parts {
   private int id;
   private String name;
   private int partsPerUnit;
   private String Unit;

    public Parts(int id, String name, int partsPerUnit, String unit) {
        this.id = id;
        this.name = name;
        this.partsPerUnit = partsPerUnit;
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

    public int getPartsPerUnit() {
        return partsPerUnit;
    }

    public void setPartsPerUnit(int partsPerUnit) {
        this.partsPerUnit = partsPerUnit;
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
                ", partsPerUnit=" + partsPerUnit +
                ", Unit='" + Unit + '\'' +
                '}';
    }
}
