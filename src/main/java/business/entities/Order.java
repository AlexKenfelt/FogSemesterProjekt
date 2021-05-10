package business.entities;

import java.sql.Timestamp;

public class Order {
    private int id;
    private double width;
    private double length;
    private String status;
    private User user;
    private Timestamp timestamp;

    public Order(int id, double width, double length, String status, User user,  Timestamp timestamp) {
        this.id = id;
        this.width = width;
        this.length = length;
        this.status = "pending";
        this.user = user;
        this.timestamp = timestamp;
    }

    public Order(double width, double length) {
        this.width = width;
        this.length = length;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", width=" + width +
                ", length=" + length +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", timestamp=" + timestamp +
                '}';
    }
}
