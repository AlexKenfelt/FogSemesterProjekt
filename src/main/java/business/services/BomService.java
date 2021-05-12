package business.services;

import business.persistence.Database;

public class BomService {
    PartsFacade partsFacade;


    public BomService(Database database) {
        this.partsFacade = new PartsFacade(database);
    }
}

