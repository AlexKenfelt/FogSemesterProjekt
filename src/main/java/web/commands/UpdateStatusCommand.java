package web.commands;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UpdateStatusCommand extends CommandProtectedPage {
    OrderFacade orderFacade;

    public UpdateStatusCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");

       // int id = orderFacade.getOrderId();
        int id;

        try
        {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex)
        {
            throw new UserException("Id is missing");
        }

        request.setAttribute("id", id);




        //This is where we confirm the orders.
        if (request.getParameter("confirm") != null) {
            orderFacade.updateOrderStatus(id);
            return pageToShow;
        }
        return pageToShow;
    }

}
