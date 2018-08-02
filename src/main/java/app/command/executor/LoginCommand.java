package app.command.executor;

import app.command.Command;
import app.db.dao.DaoUser;
import app.db.entity.User;
import app.service.PasswordEncodingService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Realization of command for logging in the system.
 * If the user doesn't exist we show the information
 * about the rooms.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class LoginCommand implements Command {

	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);
    private final String URL = "room.jsp";
    private final String NULL_USER = "message.nullUser";
    private final String ACCESS_DENIED = "message.accessDenied";

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		String url;
		String login = req.getParameter("login");
		String inPassword = req.getParameter("password");
        String s = inPassword+login.hashCode();
        //String password = inPassword;
		String password = new PasswordEncodingService().encrypt(s);
		User user = new DaoUser().get(login);


		if (user == null || user.getIdUser() == 0) {
            req.setAttribute("info", NULL_USER);
            LOGGER.debug("User was not found.");
            new UserRoomCommand().execute(req, resp);
            url = URL;
        } else if (user.getPassword().equals(password) && (user.getIdDelStatus() == 1)) {
            session.setAttribute("user", user);
            if (user.getIdRole() == 3) {
                url = new AdminRequestCommand().execute(req, resp);
            } else {
                url = new UserRequestCommand().execute(req, resp);
            }
        } else {
            new UserRoomCommand().execute(req, resp);
            req.setAttribute("info", ACCESS_DENIED);
            url = URL;
        }
		return url;
	}

}
