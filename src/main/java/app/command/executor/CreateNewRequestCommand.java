package app.command.executor;

import app.command.Command;
import app.db.dao.DaoRequest;
import app.service.CreateNewRequestService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Realization of command creating a new
 * request from the user.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class CreateNewRequestCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(CreateNewRequestCommand.class);
    private final String URL = "/WEB-INF/user.pages/basic.jsp";
    private final String NEW_REQ = "message.newReq";

    public CreateNewRequestCommand(){
        DaoRequest daoRequest = new DaoRequest();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        new CreateNewRequestService().generate(req, resp);
        new UserRequestCommand().execute(req, resp);
        req.setAttribute("info", NEW_REQ );
        new UserRequestCommand().execute(req, resp);
        return URL;
    }

}
