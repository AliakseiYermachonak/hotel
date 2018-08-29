package app.service;

import app.db.dao.DaoRequest;
import app.db.dao.DaoRoom;
import app.db.dao.DaoRoomType;
import app.db.dao.DaoUserInfo;
import app.db.entity.*;
import app.db.entity.united.URequestNew;
import app.db.entity.united.UUserInfo;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for processing new requests.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class AdminProcessRequestService {

    private static final Logger LOGGER = Logger.getLogger(AdminProcessRequestService.class);

    private int idReqStat;
    private int idRequest;
    private Request request;
    private DaoRequest daoRequest;
    private HttpServletRequest req;

    private List<RoomType> roomTypes = null;
    private List<User> users = null;
    private List<RequestStatus> requestStatuses = null;
    private List<URequestNew> uRequests = null;

    public AdminProcessRequestService(HttpServletRequest req){
        this.req = req;
        init();
    }

    /**
     * Initializing the parameters of the class.
     */
    private void init(){
        idRequest = Integer.parseInt(req.getParameter("idRequest"));
        daoRequest = new DaoRequest();
        request = daoRequest.get(idRequest);
        idReqStat = request.getIdRequestStatus();
        LOGGER.debug("");
    }

    /**
     * Accepting a request from the User ad taking it in processing.
     * @return  Request needed to be processed.
     */
    public Request acceptNewRequest() {
        daoRequest.update(request);
        return request;
    }

    /**
     * Deny the Request from the User.
     */
    public void denyNewRequest() {
        request.setIdRequestStatus(3);
        daoRequest.update(request);
    }

    /**
     * Froming the preporatory Orders to the Request and gives the as a List.
     * @return List of Orders.
     */
    public List<Order> formOrders(){
        int idTemp=0;
        RoomType roomType = new DaoRoomType().get(request.getIdRoomType());
        List<Order> orders = new ArrayList<>();
        for(int i=0; i<request.getRooms(); i++){
           Order order = new Order();
           order.setIdOrder(idTemp);
           idTemp++;
           order.setIdRequest(request.getIdRequest());
           order.setPrice(request.getDays()*roomType.getPrice());
           orders.add(order);
        }
        return orders;
    }

    /**
     * Forming the total amount of all the Orders made by User.
     * @return int amount of finished Orders.
     */
    public int totalOrders(){
        List<UserInfo> userInfos = new DaoUserInfo().getAll(request.getIdUser());
        int totalOrders = 0;
        for(UserInfo userInfo: userInfos){
            totalOrders += userInfo.getOrdersDone();
        }
        LOGGER.debug(totalOrders);
        return totalOrders;
    }

    /**
     * Creating a List of Rooms, pointed in the Request.
     * @return List of Rooms.
     */
    public List<Room> roomByType() {
        List<Room> rooms = new DaoRoom().getByType(request.getIdRoomType());
        return rooms;
    }

    /**
     * Identifier of the processed request.
     * @return int identifier of therequest status.
     */
    public int getIdReqStat(){
        return idReqStat;
    }

    /**
     * Identifier of the processed request.
     * @return int identifier of therequest status.
     */
    public List<UUserInfo> getUserInfo(){
            List<UUserInfo> uUserInfos = new UserInfoService(request.getIdUser()).getUserInfos();
            return uUserInfos;
    }

}
