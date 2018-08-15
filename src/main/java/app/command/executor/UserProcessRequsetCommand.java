package app.command.executor;

import app.command.Command;
import app.db.entity.User;
import app.service.AdminProcessUserService;
import app.service.UserProcessRequestService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Realization of command for updating
 * the user requests.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class UserProcessRequsetCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(UserProcessRequsetCommand.class);
    private final String NOT_USER = "message.noUser";
    private final String DELETED = "message.reqDeleted";

    private final String URL = "/WEB-INF/user.pages/basic.jsp";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        UserProcessRequestService uprs = new UserProcessRequestService();
        User user = (User) session.getAttribute("user");
        if(user.getIdDelStatus() == 1) {
            uprs.deleteRequest(Integer.parseInt(req.getParameter("idRequest")));
            req.setAttribute("info", DELETED);
        } else {
            req.setAttribute("info", NOT_USER);
            LOGGER.debug("User doesn't registered");
        }
        return URL;
    }
}
