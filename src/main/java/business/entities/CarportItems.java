package business.entities;

import java.math.BigDecimal;

public class CarportItems {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private double length;
    private int parts_id;
    private int order_id;

    public CarportItems(int id, int order_id, int parts_id, String name, int quantity, double length, String unit, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.length = length;
        this.parts_id = parts_id;
        this.order_id = order_id;
        this.quantity = quantity;
    }

    public CarportItems(int quantity, double length, int parts_id) {
        this.quantity = quantity;
        this.length = length;
        this.parts_id = parts_id;
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
        return "CarportItems{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", length=" + length +
                ", parts_id=" + parts_id +
                ", order_id=" + order_id +
                '}';
    }
}