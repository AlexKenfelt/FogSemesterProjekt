package business.services;

import business.entities.CarportItems;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;

public class Tester {

    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/fog?serverTimezone=CET";

    private static Database database;
    private static Order order;


    public static void main(String[] args) throws UserException {

        try {
            database = new Database(USER, PASSWORD, URL);
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /*
        BomService bomService = new BomService(database);

        CarportItems carportItems = bomService.calculatePosts(580.0);
        System.out.println(carportItems.getLength());
        System.out.println(carportItems.getQuantity());
*/
        BomFacade bomFacade = new BomFacade(database);

    double value;
        value = bomFacade.getSummedPrice(16);
        System.out.println(value);



    }
}
