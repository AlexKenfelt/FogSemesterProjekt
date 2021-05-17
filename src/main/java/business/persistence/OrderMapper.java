package business.persistence;

import business.entities.CarportItems;
import business.entities.Order;

import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

   private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public void createOrder(Order order, List <CarportItems> bomlines) throws Exception {
        int orderId = 0;
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO orders (width, length, status, id, timestamp) VALUES (?,?,?,?,?)";
            User user = null;
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setDouble(1, order.getWidth());
                ps.setDouble(2, order.getLength());
                ps.setString(3, order.getStatus());
                ps.setInt(4,order.getId());
                ps.setTimestamp(5,order.getTimestamp());

                ps.executeUpdate();
               ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                orderId = ids.getInt(1);

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
            for (CarportItems carportItems : bomlines ) {
                insertIntoBomItems(orderId, carportItems);
            }
        } catch (SQLException | UserException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<Order> getOrderByCustomerId(Integer user_id) throws UserException {
        List<Order> orderList = new ArrayList<>();

        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM orders WHERE user_id = 1=1";

            if(user_id != null){
                sql += "AND user_id = ?";
            }

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    if(user_id != null){
                        user_id = rs.getInt("user_id");
                    }

                    //int id = rs.getInt("id");
                    double width = rs.getDouble("width");
                    double length = rs.getDouble("length");
                    String status = rs.getString("status");
                    Timestamp timestamp = rs.getTimestamp("timestamp");

                    orderList.add(new Order(width, length, status, timestamp));
                }
                return orderList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
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

    public void insertIntoBomItems (int orderId, CarportItems carportItems) throws UserException {
        try (Connection connection = database.connect()){
            String sql = "INSERT INTO partlistitem (id, description, price, length, parts_id, order_id) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1,carportItems.getId());
                ps.setString(2, carportItems.getDescription());
                ps.setBigDecimal(3, carportItems.getPrice() );
                ps.setDouble(4,carportItems.getLength());
                ps.setInt(5,carportItems.getParts_id());
                ps.setInt(6,carportItems.getOrder_id());
                ps.executeUpdate();

        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
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