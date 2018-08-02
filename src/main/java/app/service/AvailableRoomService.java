package app.service;

import app.db.DbAccess;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class helps to get rooms suitable for the request.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class AvailableRoomService {
    private static final Logger LOGGER = Logger.getLogger(AvailableRoomService.class);

    private int idRoomType;
    private Date date;
    private int days;

    private Date tDate = new Date();

    /**
     * For getting helping information about the room
     * suitable for the request.
     * @param idRoomType identifier of the room's type
     * @param date Date;
     * @param days amount of days to check the availability
     * @return String line
     */
    public String getRooms(int idRoomType, Date date, int days){
        StringBuilder result = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.idRoomType = idRoomType;
        this.date = date;
        this.days = days;
        for (int i=0; i<days; i++) {
            dateFormat.format(date.getDate());
            String number = new DbAccess().getAvailableRooms(idRoomType, date.toString(), days);
            if (number.length()>2) {
                result.append(date);
                result.append(":\t");
                result.append(number);
                result.append("\n");
            }
            date = new Date(date.getTime() + (1000 * 60 * 60 * 24));
        }
        return result.toString();
    }
}
