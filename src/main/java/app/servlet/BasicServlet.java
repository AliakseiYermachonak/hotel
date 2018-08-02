package app.servlet;

import app.command.Command;
import app.command.CommandFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BasicServlet extends HttpServlet {

    /**
     * Class for handing the interaction between client and server.
     * @author Alexey Yermachyonok
     * @version 1.0
     */

    private static final long serialVersionUID = 5166315152078607928L;
    private static final Logger LOGGER = Logger.getLogger(BasicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        execute(req, resp);
    }

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandFactory commandManager = CommandFactory.getInstance();
        Command command = commandManager.getCommand(req.getParameter("command"));

        String url = command.execute(req, resp);
        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}