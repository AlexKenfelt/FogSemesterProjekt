package web.commands;

import business.entities.Bom;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.BomService;
import business.services.OrderFacade;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BuildCarportCommand extends CommandProtectedPage {

    OrderFacade orderFacade = new OrderFacade(database);
    BomService bomService;

    public BuildCarportCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();

        //Get user ID
        User user = (User) session.getAttribute("user");
        int userId = 1;

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

        //Draw Carport
        SVG svg = new SVG(0, 0, "0 0 855 600", 100, 100);

        //Draw frame
        svg.addRect(0, 0, length, width);

        //Draw rafter/spær


        //Save drawing
        request.setAttribute("drawing", svg.toString());
















        return pageToShow;
    }
}
