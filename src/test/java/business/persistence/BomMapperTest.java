package business.persistence;

import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class BomMapperTest
{
    private final static String DATABASE = "fog";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static BomMapper bomMapper;

    @BeforeAll // Connection to DB is being established.
    public static void setUpClass()
    {
        try
        {
            database = new Database(USER, PASSWORD, URL);
            bomMapper = new BomMapper(database);
        }
        catch (ClassNotFoundException e)
        {
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach // Resetting the DB before inserting our hardcoded test values.
    public void setUp()
    {
        try (Statement stmt = database.connect().createStatement())
        {
            stmt.execute("drop table if exists partlistitem");
            stmt.execute("insert into partlistitem values " +
                            "(11, 16, 1, '25x200mm. trykimp. Brædt', 6, 700, 'stk.', 'This is a description of how to use this item.', 600), " +
                            "(12, 16, 3, '25x200mm. trykimp. Brædt', 12, 600, 'stk.', 'This is a description of how to use this item.', 1380), " +
                            "(13, 16, 2, '25x200mm. trykimp. Brædt', 2, 700, 'stk.', 'This is a description of how to use this item.', 150)");
        }
        catch (SQLException ex)
        {
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test // This is just a check to see if we have a connection.
    public void testSetUpOK()
    {
        assertNotNull(database);
    }

    @Test // Testing BomMapper Calculations
    public void testSumPrice1() throws UserException
    {
        int order_id = 16;
        double value = bomMapper.summedPrice(order_id);
        System.out.println(value);
        assertEquals(2130 , value, 1);
    }
}