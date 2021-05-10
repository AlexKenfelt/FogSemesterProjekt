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
                    int user_id = rs.getInt("user_id");
                    int id = rs.getInt("id");
                    double width = rs.getDouble("width");
                    double length = rs.getDouble("length");
                    String status = rs.getString("status");
                    User user = new User(user_id);
                    Timestamp timestamp = rs.getTimestamp("timestamp");

                    orderList.add(new Order(id, width, length, status, user, timestamp));
                }
                return orderList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public void updateOrderStatus(int id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE orders SET status = \"confirmed\" WHERE id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public int getOrderId() throws UserException {
        int id = 0;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders ORDER BY id";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("id");
                }
                return id;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}