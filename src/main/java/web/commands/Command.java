package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND = "404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database) {
        commands = new HashMap<>();
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("adminpage", new CommandProtectedPage("adminpage", "admin"));
        commands.put("contactpage", new CommandUnprotectedPage("contactpage"));

        commands.put("adminpage", new AdminOrderCommand("adminpage", "admin"));

        //Her er vores orderpage blevet sat til en "CommandProtectedPage" så man skal være logget ind for at kunne få
        //lov til at bestille en carport.
        commands.put("orderpage", new CommandProtectedPage("orderpage", "customer"));
        //Det er her vores input data fra "orderpage" bliver sendt til.
        //Ligenu er det så selvfølgelig kun folk med customer rolen der har adgang til carports bestilling.
        commands.put("orderconfirmation", new BuildCarportCommand("orderconfirmation", "customer"));

    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db) {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null) {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException;
}