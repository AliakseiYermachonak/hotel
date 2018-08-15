package app.service;

import app.db.dao.DaoRequest;
import app.db.entity.Request;
import org.apache.log4j.Logger;


/**
 * Class helps user to delete his request.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class UserProcessRequestService {

    private static final Logger LOGGER = Logger.getLogger(UserProcessRequestService.class);

    private String messedge = "";
    private Request request = null;

    /**
     * Deletes the requests of a certain User.
     * @param id Request's identifier
     */
    public void deleteRequest(int id) {
        DaoRequest daoRequest = new DaoRequest();
        request = daoRequest.get(id);
        if ((request.getIdRequestStatus() == 1)||(request.getIdRequestStatus() == 5)){
            daoRequest.delete(request);
        } else {
            LOGGER.debug("Request in processing while deleting");
        }
    }

}
