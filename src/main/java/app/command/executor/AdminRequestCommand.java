package app.command.executor;

import app.command.Command;
import app.db.entity.User;
import app.db.entity.united.URequestNew;
import app.service.AdminNewRequestService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Realization of command for listing
 * the new requests from users.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class AdminRequestCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(AdminRequestCommand.class);
    private final String URL = "/WEB-INF/admin.pages/basic.jsp";
    private final String REQUEST_TO_PROCESS = "message.reqToProcess";
    private final String NOT_ADMIN = "message.notAdmin";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        List<URequestNew> uRequestNew = new ArrayList<>();
        HttpSession session = req.getSession();
        String url;
        User user = (User) session.getAttribute("user");
        if((user.getIdRole() == 3) && (user.getIdDelStatus() == 1)) {
            req.setAttribute("info", REQUEST_TO_PROCESS);
            uRequestNew = new AdminNewRequestService().getNewRequests();
        } else {
            req.setAttribute("info", NOT_ADMIN);
            LOGGER.debug("Not an admin is trying to make something important");
        }
        req.setAttribute("uRequestNew", uRequestNew);
        return URL;
    }
}
