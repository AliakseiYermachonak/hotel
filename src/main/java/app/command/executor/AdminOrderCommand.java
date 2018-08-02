package app.command.executor;

import app.command.Command;
import app.db.entity.User;
import app.db.entity.united.UOrder;
import app.service.AdminOrderService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Realization of command for listing
 * the orders at hotel.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class AdminOrderCommand implements Command {

    private final String URL = "/WEB-INF/admin.pages/basic.jsp";
    private final String NEW_ORDERS = "message.newOrders";
    private final String NOT_ADMIN = "message.notAdmin";
    private final String LOG_NOT_ADMIN = "Admin order command from nat an admin.";

    private String message = "";
    private static final Logger LOGGER = Logger.getLogger(AdminOrderCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        String url;
        List<UOrder> uOrders = new ArrayList<>();
        User user = (User) session.getAttribute("user");
        if((user.getIdRole() == 3) && (user.getIdDelStatus() == 1)) {
            message = NEW_ORDERS;
            uOrders = new AdminOrderService().getUOrders();
        } else {
            message = NOT_ADMIN;
            LOGGER.debug(LOG_NOT_ADMIN);
        }
        req.setAttribute("uOrders", uOrders);
        req.setAttribute("info", message);
        return URL;

    }
}
