package business.entities;

import java.math.BigDecimal;

public class CarportItems {

    //private int id;
    private int order_id;
    private int parts_id;
    private String name;
    private int quantity;
    private double length;
    private String unit;
    private String description;
    private int price;

    public CarportItems(int parts_id, String name, int quantity, double length, String unit, String description, int price) {
        //this.id = id;
        this.order_id = order_id;
        this.parts_id = parts_id;
        this.name = name;
        this.quantity = quantity;
        this.length = length;
        this.unit = unit;
        this.description = description;
        this.price = price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getParts_id() {
        return parts_id;
    }

    public void setParts_id(int parts_id) {
        this.parts_id = parts_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarportItems{" +
                "order_id=" + order_id +
                ", parts_id=" + parts_id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", length=" + length +
                ", unit='" + unit + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}