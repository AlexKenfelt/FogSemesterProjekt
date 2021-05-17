package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CustomerOrderCommand extends CommandProtectedPage {

    OrderFacade orderFacade;

    public CustomerOrderCommand (String pageToShow, String status) {
        super(pageToShow, status);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        List<Order> orderList = orderFacade.getAllOrders();

        session.setAttribute("orderList", orderList);

        return pageToShow;
    }

}
