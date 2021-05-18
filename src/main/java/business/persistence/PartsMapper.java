package business.persistence;

import business.entities.Parts;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartsMapper {

    private Database database;

    public PartsMapper(Database database) {
        this.database = database;
    }

    public List<Parts> getAllParts() throws UserException {
        List<Parts> partsList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM parts";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int partsPerUnit = rs.getInt(3);
                    String unit = rs.getString(4);

                    Parts tmpParts = new Parts(id, name, partsPerUnit, unit);
                    partsList.add(tmpParts);
                }
                return partsList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public Parts getPartsById(int materialId) throws UserException {
        Parts tmpParts = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM parts WHERE id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, materialId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int price_per_unit = rs.getInt("price_per_unit");
                    String unit = rs.getString("unit");


                    tmpParts = new Parts(id, name, price_per_unit, unit);
                }
                return tmpParts;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}
