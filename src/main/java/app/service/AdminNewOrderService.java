package app.service;

import app.db.dao.DaoBusyness;
import app.db.dao.DaoOrder;
import app.db.dao.DaoRequest;
import app.db.dao.DaoUserInfo;
import app.db.entity.Busyness;
import app.db.entity.Order;
import app.db.entity.Request;
import app.db.entity.UserInfo;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class helps in generating a new Order
 * based on a new Request fro the defenite user.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class AdminNewOrderService {

    private static final Logger LOGGER = Logger.getLogger(AdminNewOrderService.class);

    private String messedge;
    private Order order;
    private HttpServletRequest req;

    private List<Order> orders = null;

    public AdminNewOrderService(HttpServletRequest req){
        messedge = "";
        order = new Order();
        this.req = req;
        orders = new ArrayList<>();
    }

    /**
     * Method takes the User's Request from the HttpRequest,
     * checks if it is correct, generates an Order based on this Request and
     * writes it back to the HttpRequest. Also writes a new Order into the Database.
     * @see Request, Order
     */
    public void generate() {
        DaoRequest daoRequest = new DaoRequest();
        HttpSession session = req.getSession();
        int idReqStat = (Integer) session.getAttribute("idReqStat");

        orders = (ArrayList<Order>) session.getAttribute("orders");
        int idRequest = Integer.parseInt(req.getParameter("idRequest"));
        String document = req.getParameter("userInfo");
        String sDiscount = req.getParameter("discount");
        float discount;
        try {
            discount = Float.parseFloat(sDiscount);
        } catch (NumberFormatException e){
            discount = 0;
        }
        String sPrice = req.getParameter("price");
        float price = Float.parseFloat(sPrice)*((100-discount)/100);
        int room = Integer.parseInt(req.getParameter("room"));
        new DaoOrder().insert(idRequest, discount, price, room);
        Request request = daoRequest.get(idRequest);



        if(orders.size() == 1){
            request.setIdRequestStatus(4);
            daoRequest.update(request);
            writeBusyness(request, room, idReqStat);
            writeLoyality();

            session.removeAttribute("idReqStat");
            session.removeAttribute("orders");
            session.removeAttribute("rooms");
            session.removeAttribute("total");
            session.removeAttribute("userInfos");
        } else {
            orders.remove(Integer.parseInt(req.getParameter("idOrder")));
            session.setAttribute("orders", orders);
        }
    }

    /**
     * Writes the information about new Busyness of the room
     * based on the new Order.
     */
    public void writeBusyness(Request request, int room, int idReqStat){
        int idBusyStat = 3;
        Date date = request.getDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String userDocument = req.getParameter("userInfo");
        String[] docum = document(userDocument);
        int docType;
        try {
            docType = Integer.parseInt(docum[0]);
        } catch(NumberFormatException e){
            docType = 0;
        }
        if (idReqStat == 5){
            idBusyStat = 2;
        }
        for (int i=0; i<request.getDays(); i++) {
            dateFormat.format(date.getDate());
            new DaoBusyness().update(new Busyness(room, date, idBusyStat, docType, docum[1]));
            date = new Date(date.getTime() + (1000 * 60 * 60 * 24));
        }
    }

    private String[] document(String docInput){
        String[] document = {"empty", "empty"};
        if (docInput.trim().contains(" ")){
            document = docInput.trim().split(" ");
        }
        return document;
    }

    private void writeLoyality(){
        String document = req.getParameter("userInfo");
        int docType = Integer.parseInt(document.split(" ")[0]);
        String docNumber = document.split(" ")[1];
        DaoUserInfo daoUserInfo = new DaoUserInfo();
        UserInfo userInfo = daoUserInfo.get(docNumber, docType);
        userInfo.setOrdersDone(userInfo.getOrdersDone() + 1);

        daoUserInfo.update(userInfo);
    }
}
