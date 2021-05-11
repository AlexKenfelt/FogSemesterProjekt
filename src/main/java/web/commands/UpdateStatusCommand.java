package web.commands;

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

        int id = orderFacade.getOrderId();

        //This is where we confirm the orders.
        if (request.getParameter("confirm") != null) {
            orderFacade.updateOrderStatus(id);
            return pageToShow;
        }
        return pageToShow;
    }

}
