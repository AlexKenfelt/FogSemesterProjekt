package business.services;

import business.entities.Bom;
import business.entities.CarportItems;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class OrderFacade {
    OrderMapper orderMapper;

    public OrderFacade(Database database) {
        orderMapper = new OrderMapper(database);
    }

    public void createOrder(Order order, int userId, Bom bom) throws Exception {
        orderMapper.createOrder(order, userId, bom );
    }

    public List<Order> getAllOrders() throws UserException {
        return orderMapper.getAllOrders();
    }

    public void updateOrderStatus(int orderId) throws UserException {
        orderMapper.updateOrderStatus(orderId);
    }

    public int getOrderId() throws UserException {
        return orderMapper.getOrderId();
    }

    public List<Order> getOrderByCustomerId(Integer user_id) throws UserException {
        return orderMapper.getOrderByCustomerId(user_id);
    }
}
