package web.commands;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;
import business.services.UserFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminOrderCommand extends CommandProtectedPage
{
    OrderFacade orderFacade;
    UserFacade userFacade;

    public AdminOrderCommand(String pageToShow, String status)
    {
        super(pageToShow, status);
        this.orderFacade = new OrderFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        HttpSession session = request.getSession();

        //Getting all orders from the database and setting them in our sessionScope.
        List<Order> orderList = orderFacade.getAllOrders();
        session.setAttribute("orderList", orderList);

        //Getting all users from the database and setting them in our sessionScope.
        User user = (User) session.getAttribute("user");
        List<User> userList = userFacade.getUser(user);
        session.setAttribute("userlist", userList);

        //If the admin presses the confirm order button, the order status on that specific order gets updated.
        if (request.getParameter("confirm") != null)
        {
            int orderId = 1;
            orderFacade.updateOrderStatus(orderId);
            return "status";
        }
        return pageToShow;
    }
}
