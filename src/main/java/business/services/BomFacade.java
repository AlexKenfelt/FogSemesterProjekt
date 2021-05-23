package business.services;

import business.entities.CarportItems;
import business.exceptions.UserException;
import business.persistence.BomMapper;
import business.persistence.Database;
import java.util.List;

public class BomFacade
{
    BomMapper bomMapper;

    //The constructor.
    public BomFacade(Database database)
    {
        bomMapper = new BomMapper(database);
    }

    //Get the Bill of materials on specific order id.
    public List<CarportItems> getBomByOrderId(Integer orderId) throws UserException
    {
        return bomMapper.getBomByOrderId(orderId);
    }

    //Calculates the total price of a carport.
    public double getSummedPrice(Integer orderId) throws UserException
    {
        return bomMapper.summedPrice(orderId);
    }
}