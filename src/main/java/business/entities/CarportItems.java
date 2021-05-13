package business.entities;

import java.math.BigDecimal;

public class CarportItems {

    private int id;
    private String description;
    private BigDecimal price;
    private double length;
    private int parts_id;
    private int order_id;

    public CarportItems(int id, String description, BigDecimal price, double length, int parts_id, int order_id) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.length = length;
        this.parts_id = parts_id;
        this.order_id = order_id;
    }

    public CarportItems(double length, int parts_id) {
        this.length = length;
        this.parts_id = parts_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getParts_id() {
        return parts_id;
    }

    public void setParts_id(int parts_id) {
        this.parts_id = parts_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return  "id = " + id +
                " description = " + description +
                " price = " + price +
                " length = " + length +
                " partsId = " + parts_id +
                " orderId = " + order_id;
    }

}
