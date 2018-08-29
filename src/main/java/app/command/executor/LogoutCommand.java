package app.command.executor;

import app.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Realization of command for logging out
 * of the system.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class LogoutCommand implements Command {

	private static final Logger LOGGER = Logger.getLogger(LogoutCommand.class);
	private final String URL = "room.jsp";

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		LOGGER.debug("User i leaving the building.");
		HttpSession session = req.getSession();
        session.invalidate();
        new UserRoomCommand().execute(req, resp);
		return URL;
	}
}
