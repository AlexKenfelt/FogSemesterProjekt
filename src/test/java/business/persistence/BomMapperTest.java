package business.persistence;

import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class BomMapperTest {

    private final static String DATABASE = "fog";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static BomMapper bomMapper;

    @BeforeAll //Før vi kan teste BomMapper'ens metoder skal vi have en connection til databasen den oprettes her.
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            bomMapper = new BomMapper(database);
        } catch (ClassNotFoundException e) {
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {
        // reset test database
        try (Statement stmt = database.connect().createStatement()) {
            stmt.execute("drop table if exists users");
            stmt.execute("create table " + TESTDATABASE + ".users LIKE " + DATABASE + ".users;");
            stmt.execute(
                    "insert into users values " +
                            "(1,'jens@somewhere.com','jensen','customer'), " +
                            "(2,'ken@somewhere.com','kensen','customer'), " +
                            "(3,'robin@somewhere.com','batman','employee')");
        } catch (SQLException ex) {
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(database);
    }


    /*
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
    */

}
