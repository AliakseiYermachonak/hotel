package app.command.executor;

import app.command.Command;
import app.db.entity.User;
import app.db.entity.united.URequest;
import app.service.UserRequestService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Realization of command for listing
 * the requests from the user.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class UserRequestCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(UserRequestCommand.class);
    private final String URL = "WEB-INF/user.pages/basic.jsp";
    private final String NOT_USER = "message.noUser";
    private final String REQ_CREATED = "message.reqCreated";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        List<URequest> uRequests = null;

        User user = (User) session.getAttribute("user");
        if((user.getIdRole() == 1) && (user.getIdDelStatus() == 1)) {
            req.setAttribute("info", REQ_CREATED);
            uRequests = new UserRequestService().getUserRequests(user.getIdUser());
        } else {
            req.setAttribute("info", NOT_USER);
        }
        req.setAttribute("uRequests", uRequests);
        return URL;
    }
}
