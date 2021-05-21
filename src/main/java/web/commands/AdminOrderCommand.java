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

public class AdminOrderCommand extends CommandProtectedPage {

    OrderFacade orderFacade;
    UserFacade userFacade;

    public AdminOrderCommand(String pageToShow, String status) {
        super(pageToShow, status);
        this.orderFacade = new OrderFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        List<Order> orderList = orderFacade.getAllOrders();

        session.setAttribute("orderList", orderList);
        User user = (User) session.getAttribute("user");

        List<User> userList = userFacade.getUser(user);
        session.setAttribute("userlist", userList);
        int orderId = 1; //orderFacade.getOrderIdByTimestamp();

        if (request.getParameter("confirm") != null) {
            orderFacade.updateOrderStatus(orderId);
            //session.setAttribute("billOfMaterials", billOfMaterials);
            return "status";
        }

        return pageToShow;
    }

}
