package web.commands;

import business.entities.CarportItems;
import business.exceptions.UserException;
import business.services.BomFacade;
import business.services.OrderFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OfferPageCommand extends CommandProtectedPage
{
    public String role;
    public String pageToShow;
    OrderFacade orderFacade;
    BomFacade bomFacade;

    public OfferPageCommand(String pageToShow, String role)
    {
        super(pageToShow, role);
        this.pageToShow = pageToShow;
        this.role = role;
        orderFacade = new OrderFacade(database);
        bomFacade = new BomFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
       HttpSession session = request.getSession();
       double totalPrice;
       int orderId;

       orderId = Integer.parseInt(request.getParameter("content"));
       totalPrice = bomFacade.getSummedPrice(orderId);
       request.setAttribute("totalPrice", totalPrice);

       //Get all carportItems
       List<CarportItems> carportItems = bomFacade.getBomByOrderId((orderId));
       session.setAttribute("carportItems", carportItems);

        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
