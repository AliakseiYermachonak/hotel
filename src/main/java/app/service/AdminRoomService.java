package app.service;

import app.db.dao.DaoRoom;
import app.db.dao.DaoRoomType;
import app.db.entity.Room;
import app.db.entity.RoomType;
import app.db.entity.united.URoom;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class helps to get the List of Rooms from Database
 * and to transmit it to client.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class AdminRoomService {
    private static final Logger LOGGER = Logger.getLogger(AdminNewRequestService.class);
    private List<Room> rooms = null;
    private List<RoomType> roomTypes = null;
    private List<URoom> uRooms = null;

    public AdminRoomService(){
        rooms = new DaoRoom().getAll();
        roomTypes = new DaoRoomType().getAll();
        uRooms = new ArrayList<>();
    }

    /**
     * Method takes the Rooms from Databases and combines.
     * @return List of united Rooms
     */
    public List<URoom> getURooms() {
        for(Room room: rooms){
            for(RoomType roomType: roomTypes) {
                if (room.getIdRoomType() == roomType.getIdRoomType()){
                    uRooms.add(new URoom(room, roomType));
                }
            }
        }
        return uRooms;
    }
}
