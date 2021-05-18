package web.commands;

import business.entities.Bom;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.BomService;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuildCarportCommand extends CommandProtectedPage {

    OrderFacade orderFacade = new OrderFacade(database);
    BomService bomService;

    public BuildCarportCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Order order;

        double length;
        double width;

        try
        {
            length = Double.parseDouble(request.getParameter("length"));
            width = Double.parseDouble(request.getParameter("width"));
        } catch (NumberFormatException ex)
        {
            throw new UserException("Lengh or Width is missing");
        }

        request.setAttribute("length", length);
        request.setAttribute("width", width);

        // Beregn styklisten
        Bom bom = new Bom();
        BomService bomService = new BomService(database);
        bom.addToBill(bomService.calculatePosts(length));
        bom.addToBill(bomService.calculateRafters(width,length));
        bom.addToBill(bomService.calculateBeams(length));

        order = new Order(length, width);
        try {
            orderFacade.createOrder(order, user.getId(), bom);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("order", order);

        return pageToShow;
    }
}
