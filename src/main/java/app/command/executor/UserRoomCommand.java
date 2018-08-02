package app.command.executor;

import app.command.Command;
import app.db.dao.DaoRoomType;
import app.db.entity.RoomType;
import app.db.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Realization of command for listing
 * the types of the room at hotel.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class UserRoomCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(UserRoomCommand.class);
    private final String URL = "WEB-INF/user.pages/basic.jsp";
    private final String USER_ROOMS = "message.userRooms";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        List<RoomType> roomType = null;

        User user = (User) session.getAttribute("user");
        roomType = new DaoRoomType().getAll();

        req.setAttribute("info", USER_ROOMS);
        req.setAttribute("roomType", roomType);

        return URL;
    }
}
