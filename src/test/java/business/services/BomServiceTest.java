package business.services;

import business.entities.CarportItems;
import business.exceptions.UserException;
import business.persistence.BomMapper;
import business.persistence.Database;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BomServiceTest {

    private final static String DATABASE = "fog";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static BomService bomService;
    private String unit;
    int parts_id;
    String name;
    CarportItems quantity;
    String desc;
    int price;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            bomService = new BomService(database);
        } catch (ClassNotFoundException e) {
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @Test
    void calculatePostsTest(double length) throws UserException {
        //CarportItems tmpCarportItems = new CarportItems(parts_id, name, quantity, length, unit, desc, price);
        length = 700;
        quantity = bomService.calculatePosts(length);
        System.out.println(quantity.getQuantity());
        assertEquals(8 , quantity.getQuantity());
    }

    @Test
    void calculateBeamsTest() {
    }

    @Test
    void calculateRaftersTest() {
    }
}