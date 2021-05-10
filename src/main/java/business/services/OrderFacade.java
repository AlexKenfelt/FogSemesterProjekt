package business.services;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class OrderFacade {
    OrderMapper orderMapper;

    public OrderFacade(Database database){
        orderMapper = new OrderMapper(database);
    }
    public void createOrder (Order order) throws Exception{
        orderMapper.createOrder(order);
    }
    public List<Order> getAllOrders() throws UserException
    {
        return orderMapper.getAllOrders();
    }
}
