package business.entities;

import java.math.BigDecimal;

public class PartListId
{
    private int id;
    private String description;
    private BigDecimal price;
    private double length;
    private double width;
    private double parts_id;

    public PartListId(int id, String description, BigDecimal price, double length, double width, double parts_id) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.length = length;
        this.width = width;
        this.parts_id = parts_id;
    }
}

