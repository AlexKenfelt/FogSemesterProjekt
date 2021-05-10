package business.services;

import business.entities.Order;
import business.persistence.Database;
import business.persistence.OrderMapper;

public class OrderFacade {
    OrderMapper orderMapper;

    public OrderFacade(Database database){
        orderMapper = new OrderMapper(database);
    }
    public void createOrder (Order order) throws Exception{
        orderMapper.createOrder(order);
    }
}
