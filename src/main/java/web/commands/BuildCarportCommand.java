package web.commands;

import business.entities.Bom;
import business.entities.Order;
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

        // Her indsætter vi BillOfMaterials
        Bom bom = (Bom) session.getAttribute("bom");
        if(bom == null){
            bom = new Bom();
            session.setAttribute("bom",bom);
        }

        if(request.getParameter("submit") != null){

            //Stoplerne tilføjes
            bom.addToBill(bomService.calculatePosts(length));

            // Spær tilføjelse
            bom.addToBill((bomService.calculateBeams(length));

            // remme tilføjes
            bom.addToBill(bomService.calculateRafters(width, length));

            // ordren gemmes
            orderFacade.createOrder(
        }

        //Her requester vi den data der bliver indtastet i vores orderpage af kunden.
        //Og sætter den som attribute til den oprettede String,
        // så den kan kaldes på vores orderconfirmation page.

        // if statment der tjekker købknap
        /*if (request.getParameter("buy") != null) {
            try {
                orderFacade.createOrder(order, bomlines);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        return pageToShow;
    }
}
