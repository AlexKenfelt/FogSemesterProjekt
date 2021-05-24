package web.commands;

import business.entities.Bom;
import business.entities.CarportItems;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.BomFacade;
import business.services.BomService;
import business.services.OrderFacade;
import business.services.SVG;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BuildCarportCommand extends CommandProtectedPage
{
    OrderFacade orderFacade = new OrderFacade(database);
    BomFacade bomFacade = new BomFacade(database);

    public BuildCarportCommand(String pageToShow, String role)
    {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        HttpSession session = request.getSession();

        //Variables.
        Order order;
        double length;
        double width;

        try //Here we request the width and length entered by the customer.
        {
            length = Double.parseDouble(request.getParameter("length"));
            width = Double.parseDouble(request.getParameter("width"));
        }
        catch (NumberFormatException ex)
        {
            throw new UserException("Lengh or Width is missing");
        }

        //And setting the length and width in the SessionScope, to be used elsewhere.
        request.setAttribute("length", length);
        request.setAttribute("width", width);

        //Here we do the calculations and add everything to our Bill of materials.
        Bom bom = new Bom();
        BomService bomService = new BomService(database);
        bom.addToBill(bomService.calculatePosts(length));
        bom.addToBill(bomService.calculateRafters(width,length));
        bom.addToBill(bomService.calculateBeams(length));

        //Here we pull the user ID from sessionScope and creates a new order object.
        User user = (User) session.getAttribute("user");
        order = new Order(length, width);

        try //Then here we are creating the new order, and inserting everything into the database.
        {
            orderFacade.createOrder(order, user.getId(), bom);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Setting the new order with the width and length to the SessionScope to be called on next page.
        request.setAttribute("order", order);

        //Pulls our Bill of materials from the database and setting it to the sessionScope.
        List<CarportItems> carportItems = bomFacade.getBomByOrderId(order.getId());
        session.setAttribute("carportItems", carportItems);

        //Pulls our Bill of materials from the database to be used for SVG drawings.
        List<CarportItems> carportItemsList = bomFacade.getBomByOrderId(order.getId());

        //Draw Carport
        SVG svg = new SVG(0, 0, "0 0 855 600", 100, 100);

        //Draw frame
        svg.addRect(0, 0, width, length);

        //Draw rafter/spær
        CarportItems rafter = carportItemsList.get(1);
        double dquantity = rafter.getQuantity();
        double distance = length / (dquantity - 1);
        for (int x = 0; x < rafter.getQuantity(); x++)
        {
            svg.addRect(distance * x, 0, width, 4.5);
        }

        //Draw beams/rem
        double remDistance = width / 100 * 5.83;
        svg.addRect(0, remDistance - 4.5, 4.5, length);
        svg.addRect(0, width - remDistance, 4.5, length);

        //Draw posts/stolper
        CarportItems posts = carportItemsList.get(0);
        double firstDistance = distance * 2;
        double distanceBetween = distance * 5;
        double secondDistance = distance * rafter.getQuantity() - (2 * distance);
        if (length > 630)
        {
            for (int x = 0; x < posts.getQuantity(); x++)
            {
                svg.addRect(firstDistance + distanceBetween * x - 2.25,width - remDistance - 2.25, 9, 9);
                svg.addRect(firstDistance + distanceBetween * x - 2.25, remDistance - 4.5 - 2.25, 9, 9);
            }
        }
        else
        {
            firstDistance = distance * 1;
            svg.addRect(firstDistance - 2.25, width - remDistance - 2.25, 9, 9);
            svg.addRect(secondDistance - 2.25, width - remDistance - 2.25, 9, 9);
            svg.addRect(firstDistance - 2.25, remDistance - 4.5 - 2.25, 9, 9);
            svg.addRect(secondDistance - 2.25, remDistance - 4.5 - 2.25, 9, 9);
        }

        //Draw the lines in the middel
        double firstDistanceHulbånd = distance * 1;
        svg.addLine(firstDistanceHulbånd + 4.5, remDistance, secondDistance, width - remDistance);
        svg.addLine(secondDistance, remDistance, firstDistanceHulbånd + 4.5, width - remDistance);

        //Save drawing
        request.setAttribute("drawing", svg.toString());

        return pageToShow;
    }
}