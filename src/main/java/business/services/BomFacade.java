package business.services;


import business.entities.CarportItems;
import business.exceptions.UserException;
import business.persistence.BomMapper;
import business.persistence.Database;


import java.util.List;

public class BomFacade {

    BomMapper bomMapper;

    public BomFacade(Database database) {
        bomMapper = new BomMapper(database);
    }

    public List<CarportItems> getBomByOrderId(Integer orderId) throws UserException {
        return bomMapper.getBomByOrderId(orderId);


    //public double getSummedPrice(Integer orderId) throws UserException {
        //return bomMapper.summedPrice(orderId);

    }
}
