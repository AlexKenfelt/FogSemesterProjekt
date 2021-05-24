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

       //Variables needed.
       double totalPrice;
       int orderId;

       //Here we pull the orderID from the sessionScope.
       orderId = Integer.parseInt(request.getParameter("content"));

       //That order ID is now used to display total price on the order.
       totalPrice = bomFacade.getSummedPrice(orderId);
       request.setAttribute("totalPrice", totalPrice);

       //And order ID is used here to pull the whole Bill of Materials from the DB.
       List<CarportItems> carportItems = bomFacade.getBomByOrderId((orderId));
       session.setAttribute("carportItems", carportItems);

        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}