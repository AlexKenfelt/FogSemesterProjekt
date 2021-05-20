package business.persistence;

import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class BomMapperTest {

    //private final static String DATABASE = "fog";  // Change this to your own database
    //private final static String TESTDATABASE;
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/fog?serverTimezone=CET"; //&useSSL=false

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
            stmt.execute("insert into partlistitem values " +
                            "(11, 16, 1, '25x200mm. trykimp. Brædt', 6, 700, 'stk.', 'This is a description of how to use this item.', 600), " +
                            "(12, 16, 3, '25x200mm. trykimp. Brædt', 12, 600, 'stk.', 'This is a description of how to use this item.', 1380), " +
                            "(13, 16, 2, '25x200mm. trykimp. Brædt', 2, 700, 'stk.', 'This is a description of how to use this item.', 150)");
        } catch (SQLException ex) {
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(database);
    }

    @Test
    public void testSumPrice1() throws UserException {
        //Her tester vi at vores metode i bomMapper regner rigtigt.
        int order_id = 16;
        double value = bomMapper.summedPrice(order_id);
        System.out.println(value);
        assertEquals(2130 , value, 1);
    }
}
