package app.db.entity.united;

import app.db.entity.Room;
import app.db.entity.RoomType;

/**
 * United entity class with additional fields
 * describing the exact information about the Rooms.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class URoom {
    private int idRoom;
    private int idRoomType;
    private String type;
    private float price;

    public URoom(int idRoom, int idRoomType, String type, float price) {
        this.idRoom = idRoom;
        this.idRoomType = idRoomType;
        this.type = type;
        this.price = price;
    }

    public URoom(Room room, RoomType roomType) {
        this.idRoom = room.getIdRoom();
        this.idRoomType = room.getIdRoomType();
        this.type = roomType.getType();
        this.price = roomType.getPrice();
    }

    public URoom() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{idRoom=" + idRoom +
                ", idRoomType=" + idRoomType +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        URoom uRoom = (URoom) o;

        if (idRoom != uRoom.idRoom) return false;
        if (idRoomType != uRoom.idRoomType) return false;
        if (Float.compare(uRoom.price, price) != 0) return false;
        return type != null ? type.equals(uRoom.type) : uRoom.type == null;
    }

    @Override
    public int hashCode() {
        int result = idRoom;
        result = 31 * result + idRoomType;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdRoomType() {
        return idRoomType;
    }

    public void setIdRoomType(int idRoomType) {
        this.idRoomType = idRoomType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
