package app.service;

import app.db.dao.DaoOrder;
import app.db.entity.Order;
import app.db.entity.united.UOrder;
import app.db.entity.united.URequest;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class helps to get the List of Orders from Database
 * and to transmit it to client.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class AdminOrderService {
    private static final Logger LOGGER = Logger.getLogger(AdminNewRequestService.class);

    private List<URequest> uRequests = null;
    private List<Order> orders = null;
    private List<UOrder> uOrders = null;

    public AdminOrderService(){
        uRequests = new AdminRequestService().getRequests();
        orders = new DaoOrder().getAll();
        uOrders = new ArrayList<>();
    }

    /**
     * Method takes the orders from Databases and combines.
     * @return List of new united orders
     */
    public List<UOrder> getUOrders() {
        for(Order order: orders){
            for(URequest uRequest: uRequests) {
                if (uRequest.getIdRequest() == order.getIdRequest()){
                    uOrders.add(new UOrder(order, uRequest));
                }
            }
        }
        return  uOrders;
    }
}
