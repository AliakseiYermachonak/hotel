package app.command.executor;

import app.command.Command;
import app.db.entity.User;
import app.service.AdminProcessUserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Realization of command for updating
 * the user role or status.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class
AdminProcessUserCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(AdminProcessUserCommand.class);

    private final String URL = "/WEB-INF/admin.pages/basic.jsp";
    private final String NEW_ADMIN = "message.newAdmin";
    private final String DEFAULT_USER = "message.defUser";
    private final String USER_BANNED = "message.userBanned";
    private final String NOT_ADMIN = "message.notAdmin";
    private final String USER_INFO = "message.userInfo";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        LOGGER.debug(req);
        HttpSession session = req.getSession();
        LOGGER.debug(session);
        AdminProcessUserService apus = new AdminProcessUserService(req);
        User user = (User) session.getAttribute("user");
        if((user.getIdRole() == 3) && (user.getIdDelStatus() == 1)) {
            String choice = req.getParameter("choice");
        switch (choice) {
            case "sAdmin": {
                apus.setAdmin();
                req.setAttribute("info", NEW_ADMIN);
                break;
            }
            case "sUser": {
                apus.setDefaultUser();
                req.setAttribute("info", DEFAULT_USER);
               break;
            }
            case "ban":{
                apus.banUser();
                req.setAttribute("info", USER_BANNED);
                break;
            }
            case "userInfo":{
                apus.userInfo();
                req.setAttribute("info", USER_INFO);
                break;
            }
            case "addInfo":{
                apus.addUserInfo();
                req.setAttribute("info", USER_INFO);
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
