package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Bom
{
    //This is our list that contains the items for our Bill of materials.
    private List<CarportItems> bomLines;

    public Bom()
    {
        this.bomLines = new ArrayList<>();
    }

    public List<CarportItems> getCarportItems()
    {
        return bomLines;
    }

    public void addToBill(CarportItems carportItems)
    {
        bomLines.add(carportItems);
    }
}
