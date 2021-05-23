package business.persistence;

import business.entities.Bom;
import business.entities.Order;
import business.entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    private final static String DATABASE = "fog";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static OrderMapper orderMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            orderMapper = new OrderMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    void setUp() {
        // reset test database and create users.
        try (Statement stmt = database.connect().createStatement()) {
            stmt.execute("drop table if exists users");
            stmt.execute("create table " + TESTDATABASE + ".users LIKE " + DATABASE + ".users;");
            stmt.execute(
                    //users = (id, email, password, role, name, address, postal, city, phone)
                    "insert into users values " +
                            "(1,'hej','hej','customer', 'hej', 'hej', 2300, 'hej', 8229193), " +
                            "(2,'hej','hej','customer', 'hej', 'hej', 2300, 'hej', 822919), " +
                            "(3,'hej','hej','customer', 'hej', 'hej', 2300, 'hej', 82294519), " +
                            "(4,'hej','hej','admin', 'hej', 'hej', 2300, 'hej', 822919)");
        } catch (SQLException ex) {
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }

        // reset test database and create orders.
        try (Statement stmt = database.connect().createStatement()) {
            stmt.execute("drop table if exists orders");
            stmt.execute("create table " + TESTDATABASE + ".orders LIKE " + DATABASE + ".orders;");
            stmt.execute(
                    //orders = (id, width, length, status, user_id, timestamp)
                    "insert into orders values " +
                            "(1, 650, 700, 'pending', 1, timestamp), " +
                            "(2, 800, 650, 'pending', 2, timestamp), " +
                            "(3, 400, 350, 'pending', 1, timestamp)");
        } catch (SQLException ex) {
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test
    void createOrder() throws Exception {
        int user_id = 4;
        int id = 4;
        double width = 700;
        double length = 900;
        String status = "pending";
        Timestamp timestamp = null;

        //String email, String password, String role, String name, String address, String postal, String city, String phone
        User user = new User("hej","hej","admin", "hej", "hej", "2300", "hej", "822919");

        //int id, double width, double length, String status, User user, Timestamp timestamp
        Order order = new Order(id, width, length, status, user, timestamp);
        Bom bom = new Bom();

        orderMapper.createOrder(order, user_id, bom);

        assertEquals(4, 4);

    }

    @Test
    void insertIntoPartListItem() {
    }

    @Test
    void getOrderByCustomerId() {
    }

    @Test
    void getAllOrders() {
    }

    @Test
    void updateOrderStatus() {
    }

    @Test
    void getOrderId() {
    }
}