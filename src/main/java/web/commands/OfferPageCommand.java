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
    CarportItems carportItems;
    Database database;
    Order order;



    public OfferPageCommand(String pageToShow, String role) {
        this.pageToShow = pageToShow;
        this.role = role;
        this.orderFacade = new OrderFacade(database);
        this.bomFacade = new BomFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        User user;
        double value;
        int orderId;

        // total prisen skal laves færdig her.


       value = bomFacade.getSummedPrice(order.getId());
       request.setAttribute("value", value);

        return pageToShow;
    }

    public String getRole() {
        return role;
    }




}
