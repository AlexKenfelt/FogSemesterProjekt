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

        //TODO: Den kan ikke li' detteher stykke kode (java.lang.NumberFormatException: null)
        //TODO: Kan ikke lige umiddelbart gennemskue hvordan vi ellers skal kunne få ''user_id'' med over fra vores sessionScope.
        //TODO: Så vi kan bruge den i vores ''getOrderByCustomerId'' metode.

        //int user_id = Integer.parseInt(request.getParameter("user_id"));
        //request.setAttribute("user_id", user_id);
        //List<Order> orderList = orderFacade.getOrderByCustomerId(user_id);

        //HttpSession session = request.getSession();
        //session.setAttribute("orderList", orderList);

        return pageToShow;
    }

}
