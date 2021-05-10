package business.persistence;

import business.entities.Order;
import business.entities.PartListId;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public void createOrder(Order order) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO orders (width, length) VALUES (?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setDouble(1, order.getWidth());
                ps.setDouble(2, order.getLength());
                ps.executeUpdate();

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new Exception(ex.getMessage());
        }

    }

    public List<Order> getAllOrders() throws UserException {
        List<Order> orderList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders WHERE status = 'pending'";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    double width = rs.getDouble("width");
                    double length = rs.getDouble("length");
                    String status = rs.getString("status");
                    User user_id = new User(fk_user_id);
                    PartListId partlist_id = new PartListId(fk_partlist_id);
                    Timestamp timestamp = rs.getTimestamp("order_time");

                    orderList.add(new Order(id, width, length, status, user_id, partlist_id, timestamp));

                }
                return orderList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }

    }

}


