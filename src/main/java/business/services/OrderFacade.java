package business.services;

import business.entities.Bom;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;
import java.util.List;

public class OrderFacade
{
    OrderMapper orderMapper;

    //The constructor.
    public OrderFacade(Database database)
    {
        orderMapper = new OrderMapper(database);
    }

    //The method that creates our orders.
    public void createOrder(Order order, int userId, Bom bom) throws Exception
    {
        orderMapper.createOrder(order, userId, bom );
    }

    //A method to get all orders.
    public List<Order> getAllOrders() throws UserException
    {
        return orderMapper.getAllOrders();
    }

    //Here we can update a specific orders status with a given order id.
    public void updateOrderStatus(int orderId) throws UserException
    {
        orderMapper.updateOrderStatus(orderId);
    }

    //TODO: Never used? Should we remove it?
    public int getOrderId() throws UserException
    {
        return orderMapper.getOrderId();
    }

    //Here we can get a users order with their user id.
    public List<Order> getOrderByCustomerId(Integer user_id) throws UserException
    {
        return orderMapper.getOrderByCustomerId(user_id);
    }

    public List<Order> getOrderStatus (Integer user_id) throws UserException{
        return orderMapper.getOrderStatus(user_id);
    }
}