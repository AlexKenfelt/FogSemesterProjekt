package business.services;

import business.entities.Parts;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.PartsMapper;

import java.util.List;


public class PartsFacade
{
    PartsMapper partsMapper;


    public PartsFacade(Database database)
    {
       partsMapper = new PartsMapper(database);
    }

    //TODO: Never used delete?
    public List<Parts> getAllMaterials() throws UserException
    {
        return partsMapper.getAllParts();
    }

    //Here we get specific parts based on a given parts id.
    public Parts getPartsById(int partsId) throws UserException
    {
        return partsMapper.getPartsById(partsId);
    }
}