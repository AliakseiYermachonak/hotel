package app.command.executor;

import app.command.Command;
import app.db.entity.User;
import app.db.entity.united.UUser;
import app.service.AdminUserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Realization of command for listing
 * the registered users.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class AdminUserCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(AdminUserCommand.class);
    private final String URL = "/WEB-INF/admin.pages/basic.jsp";
    private final String ADMIN_USER = "message.adminUser";
    private final String NOT_ADMIN = "message.notAdmin";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        String url;
        List<UUser> uUsers = new ArrayList<>();
        User user = (User) session.getAttribute("user");
        if((user.getIdRole() == 3) && (user.getIdDelStatus() == 1)) {
            uUsers = new AdminUserService().getUUsers();
            req.setAttribute("info", ADMIN_USER);
        } else {
            LOGGER.debug("To write about mistake here admin req command");
            req.setAttribute("info", NOT_ADMIN);
        }
        req.setAttribute("uUsers", uUsers);

        return URL;
    }
}
