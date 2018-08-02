package app.command.executor;

import app.command.Command;
import app.db.entity.User;
import app.db.entity.united.URoom;
import app.service.AdminRoomService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Realization of command for listing
 * the rooms and theirs description.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class AdminRoomCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(AdminRoomCommand.class);
    private final String URL = "/WEB-INF/admin.pages/basic.jsp";
    private final String ADMIN_ROOM = "message.adminRoom";
    private final String NOT_ADMIN = "message.notAdmin";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        String url;
        List<URoom> uRooms = new ArrayList<>();
        User user = (User) session.getAttribute("user");
        if((user.getIdRole() == 3) && (user.getIdDelStatus() == 1)) {
            req.setAttribute("info", ADMIN_ROOM);
            uRooms = new AdminRoomService().getURooms();
        } else {
            LOGGER.debug("To write about mistake here admin req command");
            req.setAttribute("info", NOT_ADMIN);
        }
        req.setAttribute("uRooms", uRooms);
        return URL;
    }
}
