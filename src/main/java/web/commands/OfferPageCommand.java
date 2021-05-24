package web.commands;

import business.entities.CarportItems;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.BomFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OfferPageCommand extends Command {
    public String role;
    public String pageToShow;
    OrderFacade orderFacade;
    BomFacade bomFacade;

    public OfferPageCommand(String pageToShow, String role)
    {
        this.pageToShow = pageToShow;
        this.role = role;
        this.orderFacade = new OrderFacade(database);
        this.bomFacade = new BomFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        HttpSession session = request.getSession();
        User user;
        double totalPrice;
        int orderId = 0;

       orderId = Integer.parseInt(request.getParameter("content"));
       totalPrice = bomFacade.getSummedPrice(orderId);
       request.setAttribute("totalPrice", totalPrice);

        return pageToShow;
    }
    public String getRole()
    {
        return role;
    }
}
