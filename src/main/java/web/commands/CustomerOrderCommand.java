package web.commands;

import business.entities.Order;
import business.entities.User;
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

        //Her henter vi User_ID fra vores session scope så det passer på den user der er logget ind.

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        List<Order> orders = orderFacade.getOrderByCustomerId(user.getId());

        session.setAttribute("orders", orders);

        return pageToShow;
    }

}
