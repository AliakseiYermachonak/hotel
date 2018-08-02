package app.command.executor;

import app.command.Command;
import app.db.dao.DaoRequest;
import app.db.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Realization of command for showing the request
 * registration form to complete the creating of
 * a new request.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class UserNewRequestCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(UserNewRequestCommand.class);
    private static final String URL = "WEB-INF/user.pages/basic.jsp";
    private static final String NOT_USER = "message.noUser";
    private static final String FORM_REQUEST = "message.formRequest";

    private String message;
    String url;
    DaoRequest daoRequest;

    public UserNewRequestCommand(){
        message = "";
        daoRequest = new DaoRequest();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.setAttribute("idRoomType", req.getParameter("idRoomType"));
        User user = (User) session.getAttribute("user");
        if (user != null) {
            message = FORM_REQUEST;
        } else {
            message = NOT_USER;
        }
        req.setAttribute("info", message);
        return URL;
    }
}
