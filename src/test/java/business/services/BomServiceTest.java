package business.services;

import business.entities.CarportItems;
import business.exceptions.UserException;
import business.persistence.Database;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BomServiceTest {

    //private final static String DATABASE = "fog";  // Change this to your own database
    //private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/fog?serverTimezone=CET";

    private static Database database;
    private static BomService bomService;
    CarportItems quantity;

    @BeforeAll
    public static void setUpClass()
    {
        try
        {
            database = new Database(USER, PASSWORD, URL);
            bomService = new BomService(database);
        }
        catch (ClassNotFoundException e)
        {
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @Test
    void calculatePostsTest() throws UserException
    {
        double length = 700;
        quantity = bomService.calculatePosts(length);
        System.out.println(quantity.getQuantity());
        assertEquals(6 , quantity.getQuantity());
    }

    @Test
    void calculateBeamsTest() throws UserException
    {
        double length = 700;
        quantity = bomService.calculateBeams(length);
        System.out.println(quantity.getQuantity());
        assertEquals(2 , quantity.getQuantity());
    }

    @Test
    void calculateRaftersTest() throws UserException
    {
        double length = 700;
        double width = 700;
        quantity = bomService.calculateRafters(width, length);
        System.out.println(quantity.getQuantity());
        assertEquals(12 , quantity.getQuantity());
    }
}