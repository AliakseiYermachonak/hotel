package app.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface for realization
 * of Command pattern.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public interface Command {

    public String execute(HttpServletRequest req, HttpServletResponse resp);

}
