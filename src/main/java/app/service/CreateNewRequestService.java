package app.service;

import app.db.dao.DaoRequest;
import app.db.entity.Request;
import app.db.entity.User;
import app.service.helper.NewRequestHelper;
import app.service.validator.NewRequestValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Class for creating a new request by the user.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class CreateNewRequestService {

    private static final Logger LOGGER = Logger.getLogger(CreateNewRequestService.class);
    private HttpSession session;
    private String url;
    private DaoRequest daoRequest;

    public CreateNewRequestService(){
        url = "WEB-INF/user.pages/basic.jsp";
        daoRequest = new DaoRequest();
    }

    /**
     * Generaing a new Request and validating it.
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     */
    public void generate(HttpServletRequest req, HttpServletResponse resp) {
        session = req.getSession();
        String idRoomType = (String) session.getAttribute("idRoomType");
        session.removeAttribute("idRoomType");

        if (idRoomType != null) {

            NewRequestHelper newRequestHelper = new NewRequestHelper();
            newRequestHelper.setDate(req.getParameter("date"));
            newRequestHelper.setIdRoomType(idRoomType);
            newRequestHelper.setnDays(req.getParameter("nDays"));
            newRequestHelper.setnRooms(req.getParameter("nRooms"));
            newRequestHelper.setWilling(req.getParameter("willing"));
            

            User user = (User) session.getAttribute("user");
            Request request = new NewRequestValidator().paramValidator(user.getIdUser(), newRequestHelper);

            if (new NewRequestValidator().validate(request)) {
                new DaoRequest().insert(request.getIdUser(), request.getDate(), request.getDays(), request.getIdRoomType(),
                        request.getRooms(), request.getIdRequestStatus());
            }
        }
    }

}
