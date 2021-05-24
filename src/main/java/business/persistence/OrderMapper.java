package business.persistence;

import business.entities.Bom;
import business.entities.CarportItems;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    private Database database;
    private long now = System.currentTimeMillis();
    private Timestamp sqlTimestamp = new Timestamp(now);

    public OrderMapper(Database database) {
        this.now = now;
        this.sqlTimestamp = sqlTimestamp;
        this.database = database;
    }

    //Here we add our order to the database and "insertIntoPartListItem" is called foreach order to add order_id.
    public void createOrder(Order order, int userId, Bom bom) throws Exception {
        int orderId = 0;
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO orders (width, length, status, user_id, timestamp) VALUES (?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setDouble(1, order.getWidth());
                ps.setDouble(2, order.getLength());
                ps.setString(3, order.getStatus());
                ps.setInt(4, userId);
                ps.setTimestamp(5, sqlTimestamp);
                ps.executeUpdate();

                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                orderId = ids.getInt(1);
                order.setId(orderId);

                for (CarportItems carportItems : bom.getCarportItems()) {
                    insertIntoPartListItem(orderId, carportItems);
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //This is where we populate our 'PartListItems' table in MySql. //Also referred too as 'Bom', 'CarportItems' or 'Bill of materials'.
    public void insertIntoPartListItem(int orderId, CarportItems carportItems) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO partlistitem (order_id, parts_id, name, quantity, length, unit, description, price) VALUES (?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.setInt(2, carportItems.getParts_id());
                ps.setString(3, carportItems.getName());
                ps.setInt(4, carportItems.getQuantity());
                ps.setDouble(5, carportItems.getLength());
                ps.setString(6, carportItems.getUnit());
                ps.setString(7, carportItems.getDescription());
                ps.setInt(8, carportItems.getPrice());
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    //This is where we can pull out a specific order, based on the linked customer id.
    public List<Order> getOrderByCustomerId(int user_id) throws UserException {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders WHERE user_id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, user_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    double width = rs.getDouble("width");
                    double length = rs.getDouble("length");
                    String status = rs.getString("status");
                    Timestamp timestamp = rs.getTimestamp("timestamp");

                    //Here we add the data from the database into an arraylist.
                    orders.add(new Order(id, width, length, status, timestamp));
                }
                return orders;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    //Here we get all orders from the database.
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

                    //Here we add the data from the database into an arraylist.
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

    //Here we can update order status on a given order id.
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

    //This is where you can get a specific order id from the database.
    public int getOrderId() throws UserException { //TODO: This method is not used anywhere, should we remove it?
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

    public List<Order> getOrderStatus(int user_id) throws UserException {
        String status = "no status";
        List<Order> orderStatusList = new ArrayList<>();

        try (Connection connection = database.connect()) {

            String sql = "SELECT status FROM orders WHERE user_id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, user_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                 status = rs.getString("status");
                   // System.out.println(status);

                    // We have created an object that contains the data and inserted that into an ArrayList
                    Order order = new Order(status);
                    orderStatusList.add(order);
                }
                return orderStatusList;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}