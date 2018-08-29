package app.service.validator;

import app.db.entity.Request;
import app.service.helper.NewRequestHelper;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for validating the parameteres of the request
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class NewRequestValidator implements Validator<Request> {

    private static final Logger LOGGER = Logger.getLogger(NewRequestValidator.class);

    public NewRequestValidator(){
    }

    @Override
    public boolean validate(Request ob) {
        boolean result = ((ob.getDate() !=null)&&(ob.getIdUser()>0)&&(ob.getRooms()>0)&&((ob.getIdRoomType()>0)));
        return result;
    }

    public Request paramValidator(int id, NewRequestHelper newRequestHelper){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        int idUser = id;
        int days = 1;
        int roomType = 1;
        int rooms = 1;
        int reqStatus = 1;

        try {

            if (newRequestHelper.getDate() != null) {
                try {
                    date = sdf.parse(newRequestHelper.getDate());
                } catch (ParseException e) {
                    LOGGER.debug("Convertation date error in new request");
                    e.printStackTrace();
                }
            } else {

            }
            if (newRequestHelper.getnDays() != null) {
                days = Integer.parseInt(newRequestHelper.getnDays());
            }
            if (newRequestHelper.getIdRoomType() != null) {
                roomType = Integer.parseInt(newRequestHelper.getIdRoomType());
            }
            if (newRequestHelper.getnRooms() != null) {
                rooms = Integer.parseInt(newRequestHelper.getnRooms());
            }
            if (newRequestHelper.getWilling() != null){
                if (newRequestHelper.getWilling().equals("toBook")) {reqStatus = 5;}
                else {reqStatus = 1;}
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            LOGGER.debug("Convertation error in new request");
        }
        return new Request(idUser, date, days, roomType, rooms, reqStatus);
    }
}
