package app.command.executor;

import app.command.Command;
import app.db.dao.DaoUserInfo;
import app.db.entity.User;
import app.db.entity.UserInfo;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Realization of command for listing
 * the additional information adout the user.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class AdminUserInfoCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(AdminUserInfoCommand.class);
    private final String URL = "/WEB-INF/admin.pages/basic.jsp";
    private final String ADMIN_USER_INFO = "message.adminUserInfo";
    private final String NOT_ADMIN = "message.notAdmin";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        String url;
        User userForInfo = null;
        List<UserInfo> usersInfo = null;

        User user = (User) session.getAttribute("user");
        if((user.getIdRole() == 3) && (user.getIdDelStatus() == 1)) {
            userForInfo = (User)req.getAttribute("userForInfo");
            usersInfo = new DaoUserInfo().getAll();
            req.setAttribute("info", ADMIN_USER_INFO);
        } else {
            req.setAttribute("info", NOT_ADMIN);
            LOGGER.debug("To write about mistake here admin req command");
        }
        req.setAttribute("userForInfo", userForInfo);
        req.setAttribute("usersInfo", usersInfo);

        return URL;
    }
}
