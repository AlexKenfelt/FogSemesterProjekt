package business.services;

import business.entities.CarportItems;
import business.entities.Parts;
import business.exceptions.UserException;
import business.persistence.Database;

public class BomService {

    PartsFacade partsFacade;

    public BomService(Database database) {
        this.partsFacade = new PartsFacade(database);
    }

    public CarportItems calculatePosts ( double length) throws UserException {

        Parts parts = partsFacade.getPartsById(1);
        int parts_id = parts.getId();

        String name = "25x200mm. trykimp. Brædt";
        String unit = "stk.";
        String desc = "This is a description of how to use this item.";
        int price;
        int quantity = 4;

        //Den foreste stolpe skal sidde en meter inde.
        int frontPost = 100;
        //Den bagerste stolpe skal sidde 20 cm meter inde.
        int backPost = 20;
        //dette er den faktiske længde efter vi har minusset med 'frontpost' og 'backpost'.
        int actualLength = 0;
        //Dette er minimums kravet for hvor meget plads der skal være mellem hver stolpe.
        int minimumPostSpacing = 310;
        //Dette er bare en konstant.
        int multiplier = 2;
        //dette er vores float som kun bliver brugt i mellem regningerne, denne bliver typecasted til int result længere nede.
        double result = 0;
        //Her vælger vi og tage carportens indtastede længde og minuser det med, det stykke som den foreste og bagerste stolpe skal sidde inde.
        actualLength = ((int)length - frontPost - backPost);
        //Her tager vi minimums kravet til spacing mellem hver stolpe og dividerer det med den faktiske længde på vore carport
        result = ( actualLength / minimumPostSpacing);
        //her tager vi og runder result op til det tætteste hel tal.
        result = Math.round(result);
        //Her ganger vi med 2 så vi får begge sider med af carporten.
        quantity = quantity + ((int) result * multiplier);
        //Nu typecaster vi vores result som er en float om til en int.
        int numberOfPosts = (int)result ;
        //Dett her er det endelige resultat.

        //Prisen er ligenu bare hardcodet. kunne være sjovt og lave en metode der henter prisen ud fra parts id.
        price = (quantity * 100);

        CarportItems tmpCarportItems = new CarportItems(parts_id, name, quantity, length, unit, desc, price);

        return tmpCarportItems;
    }

    public CarportItems calculateBeams (double length) throws UserException {

        Parts parts = partsFacade.getPartsById(2);
        int parts_id = parts.getId();

        String name = "25x200mm. trykimp. Brædt";
        String unit = "stk.";
        String desc = "This is a description of how to use this item.";
        int price;
        int quantity = 2;

        int lengthOfBeams = (int) length;

        price = (quantity * 75);

        CarportItems tmpCarportItems = new CarportItems(parts_id, name, quantity, lengthOfBeams, unit, desc, price);

        return tmpCarportItems;
    }

    public CarportItems calculateRafters (double width, double length) throws UserException {

        Parts parts = partsFacade.getPartsById(3);
        int parts_id = parts.getId();
        String name = "25x200mm. trykimp. Brædt";
        String unit = "stk.";
        String desc = "This is a description of how to use this item.";
        int price;
        int quantity;

        //Dette er afstanden der skal være imellem hver spær.
        double rafterSpacing = 0.55;
        //Dette er længden af vores spær. Dette skal helst være lig med den længde der bliver givet til carporten.
        int lengthOfRafters = (int) width;
        //Vi tager bare og dividerer længden med, den bestemte afstand der skal være, for at få antal spær.
        quantity = (int) (length / rafterSpacing );

        price = (quantity * 115);

        CarportItems tmpCarportItems = new CarportItems(parts_id, name, quantity, lengthOfRafters, unit, desc, price);

        return tmpCarportItems;
    }
}