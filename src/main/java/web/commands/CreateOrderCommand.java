package web.commands;

import business.entities.Bom;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.BomService;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrderCommand extends CommandProtectedPage {

    OrderFacade orderFacade;


    public CreateOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        return pageToShow;
    }

}
