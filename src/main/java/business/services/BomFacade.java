package business.services;

import business.exceptions.UserException;
import business.persistence.BomMapper;
import business.persistence.Database;

public class BomFacade {
BomMapper bomMapper;

    public BomFacade(Database database) {
        this.bomMapper = bomMapper;
    }

    public double getSummedPrice(Integer orderId) throws UserException {
        return bomMapper.summedPrice(orderId);
    }
}
