package business.persistence;

import business.entities.CarportItems;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BomMapper {

    private Database database;

    public BomMapper(Database database) {
        this.database = database;
    }

    public List<CarportItems> getBillOfMaterials (int id) throws UserException{
        List<CarportItems> carportItems = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM bom_items WHERE order_id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int 
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException("Connection to database could not be established");
        }












    public void getTotalPrice(){

    }

}
