package web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuildCarportCommand extends CommandProtectedPage {
    public BuildCarportCommand(String pageToShow, String role) { super(pageToShow, role); }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //Her requester vi den data der bliver indtastet i vores orderpage af kunden.
        //Og sætter den som attribute til den oprettede String,
        // så den kan kaldes på vores orderconfirmation page.
        String height = request.getParameter("height");
        request.setAttribute("height", height);
        String width = request.getParameter("width");
        request.setAttribute("width", width);
        return pageToShow;
    }
}
