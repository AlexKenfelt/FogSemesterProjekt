package business.services;

import business.entities.CarportItems;
import business.entities.Parts;
import business.exceptions.UserException;
import business.persistence.Database;

public class BomService
{
    PartsFacade partsFacade;

    public BomService(Database database)
    {
        this.partsFacade = new PartsFacade(database);
    }

    //Here we calculate the number of posts needed based on length of the carport.
    public CarportItems calculatePosts ( double length) throws UserException
    {
        //Pulling the parts id from the database.
        Parts parts = partsFacade.getPartsById(1);
        int parts_id = parts.getId();

        //Hardcoded parts info.
        String name = "Trykimp. Stopler";
        String unit = "stk.";
        String desc = "Stolper nedgraves 90 cm. i jord.";

        //The variables.
        int price;
        int quantity = 4;
        int frontPost = 100;
        int backPost = 20;
        int actualLength = 0;
        int minimumPostSpacing = 310;
        int multiplier = 2;
        double result = 0;

        //The calculations.
        actualLength = ((int)length - frontPost - backPost);
        result = ( actualLength / minimumPostSpacing);
        result = Math.round(result);
        quantity = quantity + ((int) result * multiplier);
        price = (quantity * 100);

        //Creating an object that contains the data.
        CarportItems tmpCarportItems = new CarportItems(parts_id, name, quantity, length, unit, desc, price);
        return tmpCarportItems;
    }

    //Here we calculate the number of Beams needed based on length of the carport.
    public CarportItems calculateBeams (double length) throws UserException
    {
        //Pulling the parts id from the database.
        Parts parts = partsFacade.getPartsById(2);
        int parts_id = parts.getId();

        //Hardcoded parts info.
        String name = "trykimp. Brædt";
        String unit = "stk.";
        String desc = "Understernbrædder til for & bag ende.";

        //The variables.
        int price;
        int quantity = 2;
        int lengthOfBeams;

        //The calculations.
        lengthOfBeams = (int) length;
        price = (quantity * 75);

        //Creating an object that contains the data.
        CarportItems tmpCarportItems = new CarportItems(parts_id, name, quantity, lengthOfBeams, unit, desc, price);
        return tmpCarportItems;
    }

    //Here we calculate the number of rafters needed based on length and width of the carport.
    public CarportItems calculateRafters (double width, double length) throws UserException
    {
        //Pulling the parts id from the database.
        Parts parts = partsFacade.getPartsById(3);
        int parts_id = parts.getId();

        //Hardcoded parts info.
        String name = "Spærtræ ubh";
        String unit = "stk.";
        String desc = "Spær monteres på rem.";

        //The variables.
        int price;
        int quantity;
        double rafterSpacing = 55;
        int lengthOfRafters;

        //The calculations.
        lengthOfRafters = (int) width;
        quantity = (int) (length / rafterSpacing);
        price = (quantity * 115);

        //Creating an object that contains the data.
        CarportItems tmpCarportItems = new CarportItems(parts_id, name, quantity, lengthOfRafters, unit, desc, price);
        return tmpCarportItems;
    }
}