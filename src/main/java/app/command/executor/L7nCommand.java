package app.command.executor;

import app.command.Command;
import app.command.CommandFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Realization of command for language
 * changing.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class L7nCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(L7nCommand.class);
    private static final String URL = "index.jsp";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String lang = req.getParameter("lang");
        session.setAttribute("lang", lang);
        if (req.getParameter("who").equals("admin")){
            LOGGER.debug("admin in l7n");
            return new AdminRequestCommand().execute(req, resp);
        } else if(req.getParameter("who").equals("user")){
            LOGGER.debug("user in l7n");
            String sCommand = req.getParameter("sCommand");
            Command cCommand = CommandFactory.getInstance().getCommand("userRooms");
            return new UserRequestCommand().execute(req, resp);
        } else {
            return URL;
        }
    }
}
