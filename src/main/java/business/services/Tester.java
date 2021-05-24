package business.services;

import business.entities.CarportItems;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

public class Tester //This is our informal testing class, for a quick little test.
{
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/fog?serverTimezone=CET";

    private static Database database;
    private static Order order;


    public static void main(String[] args) throws UserException
    { //Unless you're doing a test everything in here should be commented, to avoid any conflicts.
        /*
        try //Here we create a connection to our database uncomment if a connection is needed.
        {
            database = new Database(USER, PASSWORD, URL);
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        */

        /*
        //Add any mapper or facade that is needed here.
        BomService bomService = new BomService(database);
        BomFacade bomFacade = new BomFacade(database);
        OrderMapper orderMapper = new OrderMapper(database);
         */

        /*
        //This was a test of our calculate posts.
        CarportItems carportItems = bomService.calculatePosts(580.0);
        System.out.println(carportItems.getLength());
        System.out.println(carportItems.getQuantity());
         */

        /*
        //Test of our total price on our final bill of materials.
        double value;
        value = bomFacade.getSummedPrice(16);
        System.out.println(value);
         */

        /*
        //Quick little test.
        System.out.println(orderMapper.getOrderStatus());
         */
    }
}
