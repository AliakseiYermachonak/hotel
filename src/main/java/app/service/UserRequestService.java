package app.service;

import app.db.dao.DaoRequest;
import app.db.dao.DaoRequestStatus;
import app.db.dao.DaoRoomType;
import app.db.dao.DaoUser;
import app.db.entity.Request;
import app.db.entity.RequestStatus;
import app.db.entity.RoomType;
import app.db.entity.User;
import app.db.entity.united.URequest;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class helps user to track his reuests.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class UserRequestService {

    private static final Logger LOGGER = Logger.getLogger(UserRequestService.class);

    private String messedge = "";
    private List<Request> requests = null;
    private List<RoomType> roomTypes = null;
    private List<User> users = null;
    private List<RequestStatus> requestStatuses = null;
    private List<URequest> uRequests = null;

    public UserRequestService() {
        requests = new DaoRequest().getAll();
        LOGGER.debug(requests);
        roomTypes = new DaoRoomType().getAll();
        users = new DaoUser().getAll();
        requestStatuses = new DaoRequestStatus().getAll();
        uRequests = new ArrayList<>();
    }

    /**
     * Method takes the request of a certain User.
     * @return List of new united orders
     */
    public List<URequest> getUserRequests(int id) {
        String login = "";
        String status = "";
        String type = "";
        for (Request request : requests) {
            if (request.getIdUser() == id) {
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
                uRequests.add(new URequest(request, login, type, status));
            }
        }
        return uRequests;
    }

}
