package app.command.executor;

import app.command.Command;
import app.db.dao.DaoUser;
import app.db.entity.User;
import app.service.PasswordEncodingService;
import app.service.validator.NewUserValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Realization of command for registrating a new user.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class RegistrationCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class);
    public final String URL = "index.jsp";
    private final String LOGIN_BUSY = "message.loginBusy";
    private final String DIF_PASSES = "message.differentPasses";
    private final String NOT_VALID_USER = "message.userNotValid";

    private String message;
    private HttpSession session;
    private DaoUser daoUser;

    public RegistrationCommand(){
        message = "";
        daoUser = new DaoUser();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String url = URL;
        session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");

        User user = daoUser.get(login);
        resp.setContentType("text/html; charset=UTF-8");
        if (login.equals(user.getLogin())) {
            message = LOGIN_BUSY;
            LOGGER.debug("User with suchlike login exists.");
        } else if (password.equals(rePassword)) {
            String s = password+login.hashCode();
            String encryptedPassword = new PasswordEncodingService().encrypt(s);
            user = new User(login, encryptedPassword);
            if (new NewUserValidator().validate(user)) {
                daoUser.insert(user);
                User newUser=new DaoUser().get(login);
                session.setAttribute("user", newUser);
                url = new UserRoomCommand().execute(req, resp);
                LOGGER.debug("new user registered");
            } else {
                message = NOT_VALID_USER;
            }
        } else {
            message = DIF_PASSES;
        }
        req.setAttribute("info", message);
        return url;
    }
}

