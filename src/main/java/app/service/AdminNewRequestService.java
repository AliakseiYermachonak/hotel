package app.service;

import app.db.dao.DaoRequest;
import app.db.dao.DaoRequestStatus;
import app.db.dao.DaoRoomType;
import app.db.dao.DaoUser;
import app.db.entity.Request;
import app.db.entity.RequestStatus;
import app.db.entity.RoomType;
import app.db.entity.User;
import app.db.entity.united.URequestNew;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class helps to get the List of new Requests that need to be
 * processed by the administrator.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class AdminNewRequestService {

    private static final Logger LOGGER = Logger.getLogger(AdminNewRequestService.class);

    private List<Request> newRequests = null;
    private List<RoomType> roomTypes = null;
    private List<User> users = null;
    private List<RequestStatus> requestStatuses = null;
    private List<URequestNew> uRequests = null;

    public AdminNewRequestService(){
        newRequests = new DaoRequest().getAllNew();
        LOGGER.debug(newRequests);
        roomTypes = new DaoRoomType().getAll();
        users = new DaoUser().getAll();
        requestStatuses = new DaoRequestStatus().getAll();
        uRequests = new ArrayList<>();
    }

    /**
     * Method checks the requests from the Database and
     * creates a list of new users' requests separated with their
     * request status.
     * @return List of new united reuests
     */
    public List<URequestNew> getNewRequests() {
        String login = "";
        String status = "";
        String type = "";
        String availRooms = "";
        for (Request request : newRequests) {
            for (User user : users) {
                if (user.getIdUser() == request.getIdUser()) {
                    login = user.getLogin();
                }
            }
            for (RoomType roomType : roomTypes) {
                if (roomType.getIdRoomType() == request.getIdRoomType()) {
                    type = roomType.getType();
                }
            }
            for (RequestStatus requestStatus : requestStatuses) {
                if (requestStatus.getIdRequestStatus() == request.getIdRequestStatus()) {
                    status = requestStatus.getStatus();
                }
            }
            availRooms = new AvailableRoomService().getRooms(request.getIdRoomType(), request.getDate(), request.getDays());
            uRequests.add(new URequestNew(request, login, type, status, availRooms));
        }

        return  uRequests;
    }
}
