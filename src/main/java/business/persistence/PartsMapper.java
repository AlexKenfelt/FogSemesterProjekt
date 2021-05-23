package business.persistence;

import business.entities.Parts;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartsMapper
{
    private Database database;

    public PartsMapper(Database database)
    {
        this.database = database;
    }

    //This is where we get all the parts from our database.
    public List<Parts> getAllParts() throws UserException
    {
        List<Parts> partsList = new ArrayList<>();
        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM parts";
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int partsPerUnit = rs.getInt(3);
                    String unit = rs.getString(4);

                    //Here we create a object of Parts that can hold our data.
                    Parts tmpParts = new Parts(id, name, partsPerUnit, unit);
                    //And here we add those objects into an arraylist.
                    partsList.add(tmpParts);
                    //Each object corresponds to one row in the database.
                }
                //And then we return that array, so we can access its content else where.
                return partsList;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }

    //Here we get specific parts based on a given parts id.
    public Parts getPartsById(int materialId) throws UserException
    {
        Parts tmpParts = null;
        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM parts WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, materialId);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String unit = rs.getString("unit");
                    int price_per_unit = rs.getInt("price_per_unit");

                    tmpParts = new Parts(id, name, price_per_unit, unit);
                }
                return tmpParts;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }
}