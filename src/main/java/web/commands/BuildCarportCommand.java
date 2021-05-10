package web.commands;

import business.entities.Order;
import business.persistence.Database;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuildCarportCommand extends CommandProtectedPage {

    OrderFacade orderFacade = new OrderFacade(database);

    public BuildCarportCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        double length = Double.parseDouble(request.getParameter("length"));
        request.setAttribute("length", length);
        double width = Double.parseDouble(request.getParameter("width"));
        request.setAttribute("width", width);

        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");

        if (order == null) {
            order = new Order(length, width);
        }

        //Her requester vi den data der bliver indtastet i vores orderpage af kunden.
        //Og sætter den som attribute til den oprettede String,
        // så den kan kaldes på vores orderconfirmation page.

        // if statment der tjekker købknap
        if (request.getParameter("buy") != null) {
            try {
                orderFacade.createOrder(order);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pageToShow;
    }
}
