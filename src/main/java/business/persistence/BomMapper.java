package business.persistence;

import business.entities.CarportItems;
import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BomMapper {

    private Database database;

    public BomMapper(Database database) {
        this.database = database;
    }

    public double summedPrice(int order_id) throws UserException {
        double value = 0.0;

        try (Connection connection = database.connect()) {

            String sql = "SELECT SUM(price) FROM partlistitem WHERE order_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, order_id);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String sum = rs.getString(1);
                    System.out.println(sum);
                    value = Double.parseDouble(sum);
                }
                return value;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<CarportItems> getBomByOrderId(int orderId) throws UserException {
        List<CarportItems> carportItemsList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM partlistitem WHERE order_id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int parts_id = rs.getInt("parts_id");
                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    double length = rs.getDouble("length");
                    String unit = rs.getString("unit");
                    String description = rs.getString("description");
                    int price = rs.getInt("price");

                    CarportItems tmpCarportItem = new CarportItems(parts_id, name, quantity, length, unit, description, price);
                    carportItemsList.add(tmpCarportItem);
                }
                return carportItemsList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}