package business.persistence;

import business.entities.Order;
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

    public void createOrder (Order order) throws Exception{
        try (Connection connection = database.connect()){
            String sql = "INSERT INTO orders (width, length) VALUES (?,?)";

            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
              ps.setDouble(1 ,order.getWidth());
              ps.setDouble(2,order.getLength());
              ps.executeUpdate();

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new Exception(ex.getMessage());
        }

            }

    }



