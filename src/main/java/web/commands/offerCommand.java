package web.commands;

import business.exceptions.UserException;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class offerCommand extends CommandProtectedPage {
    public String pageToShow;

    public offerCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException {

        //Here we will need to display SVG drawing.

        return pageToShow;
    }
}


