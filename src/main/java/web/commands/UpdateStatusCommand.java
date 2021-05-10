package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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

        //Confirm order
        if (request.getParameter("confirm") != null) {
            orderFacade.updateOrderStatus(id);
            return pageToShow;
        }
        return pageToShow;
    }

}
