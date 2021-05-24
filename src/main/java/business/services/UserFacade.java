package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;
import java.util.List;

public class UserFacade
{
    UserMapper userMapper;
    
    //The Constructor.
    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    //Our login method.
    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    //Create user method.
    public User createUser(String email, String password, String name, String address, String postal, String city, String phone) throws UserException
    {
        User user = new User(email, password, "customer", name, address, postal, city, phone);
        userMapper.createUser(user);
        return user;
    }

    //Gets everything for each user from the database.
    public List<User> getUser(User user) throws UserException
    {
        return userMapper.getUser(user);
    }
}
