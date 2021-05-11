package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Bom {

    CarportItems carportItems;


    private List<CarportItems> billOfMaterials;

    public Bom() {
        this.billOfMaterials = new ArrayList<>();
    }
}
