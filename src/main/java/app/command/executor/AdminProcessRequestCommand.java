package app.command.executor;

import app.command.Command;
import app.db.entity.Request;
import app.db.entity.User;
import app.service.AdminNewOrderService;
import app.service.AdminProcessRequestService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Realization of command for processing the
 * request from the user and creating orders
 * based on this request.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class AdminProcessRequestCommand implements Command {

    private final String URL = "/WEB-INF/admin.pages/basic.jsp";
    private final String REQUEST_IN_PROCESS = "message.reqInProcess";
    private final String REQUEST_DENIED = "message.reqDenied";
    private final String REQUEST_CONFIRMED = "message.reqConfirmed";
    private final String NOT_ADMIN = "message.notAdmin";

    private static final Logger LOGGER = Logger.getLogger(AdminProcessRequestCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        AdminProcessRequestService aprs = new AdminProcessRequestService(req);
        User user = (User) session.getAttribute("user");
        if((user.getIdRole() == 3) && (user.getIdDelStatus() == 1)) {
        switch (req.getParameter("choice")) {
            case "true": {
                Request request = aprs.acceptNewRequest();
                req.setAttribute("request", request);
                session.setAttribute("orders", aprs.formOrders());
                session.setAttribute("total", aprs.totalOrders());
                session.setAttribute("rooms", aprs.roomByType());
                session.setAttribute("idReqStat", aprs.getIdReqStat());
                session.setAttribute("uUserInfos", aprs.getUserInfo());
                req.setAttribute("info", REQUEST_IN_PROCESS);
                break;
            }
            case "false": {
               aprs.denyNewRequest();
               new AdminRequestCommand().execute(req, resp);
               req.setAttribute("info", REQUEST_DENIED);
               break;
            }
            case "continue":{
                new AdminNewOrderService(req).generate();
                req.setAttribute("info", REQUEST_CONFIRMED);
                break;
            }
        }
        } else {
            req.setAttribute("info", NOT_ADMIN);
            LOGGER.debug("To write about mistake here admin req command");
        }

        return URL;
    }
}
