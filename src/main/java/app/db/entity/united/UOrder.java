package app.db.entity.united;

import app.db.entity.Order;

import java.util.Date;

/**
 * United entity class with additional fields
 * describing the exact information about the Order and the
 * Request connected with it.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class UOrder {
    private int idOrder;
    private int idRequest;
    private int idUser;
    private String login;
    private Date date;
    private int days;
    private int idRoomType;
    private String roomType;
    private int rooms;
    private int idRequestStatus;
    private String requestStatus;
    private float disount;
    private float price;
    private int idRoom;

    public UOrder(int idOrder, int idRequest, int idUser, String login, Date date, int days, int idRoomType, String roomType, int rooms, int idRequestStatus, String requestStatus, float disount, float price, int idRoom) {
        this.idOrder = idOrder;
        this.idRequest = idRequest;
        this.idUser = idUser;
        this.login = login;
        this.date = date;
        this.days = days;
        this.idRoomType = idRoomType;
        this.roomType = roomType;
        this.rooms = rooms;
        this.idRequestStatus = idRequestStatus;
        this.requestStatus = requestStatus;
        this.disount = disount;
        this.price = price;
        this.idRoom = idRoom;
    }

    public UOrder(Order order, URequest uRequest) {
        this.idOrder = order.getIdOrder();
        this.idRequest = uRequest.getIdRequest();
        this.idUser = uRequest.getIdUser();
        this.login = uRequest.getLogin();
        this.date = uRequest.getDate();
        this.days = uRequest.getDays();
        this.idRoomType = uRequest.getIdRoomType();
        this.roomType = uRequest.getRoomType();
        this.rooms = uRequest.getRooms();
        this.idRequestStatus = uRequest.getIdRequestStatus();
        this.requestStatus = uRequest.getRequestStatus();
        this.disount = order.getDisount();
        this.price = order.getPrice();
        this.idRoom = order.getIdRoom();
    }

    public UOrder() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{idOrder=" + idOrder +
                ", idRequest=" + idRequest +
                ", idUser=" + idUser +
                ", login='" + login + '\'' +
                ", date=" + date +
                ", days=" + days +
                ", idRoomType=" + idRoomType +
                ", roomType='" + roomType + '\'' +
                ", rooms=" + rooms +
                ", idRequestStatus=" + idRequestStatus +
                ", RequestStatus='" + requestStatus + '\'' +
                ", disount=" + disount +
                ", price=" + price +
                ", idRoom=" + idRoom +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UOrder uOrder = (UOrder) o;

        if (idOrder != uOrder.idOrder) return false;
        if (idRequest != uOrder.idRequest) return false;
        if (idUser != uOrder.idUser) return false;
        if (days != uOrder.days) return false;
        if (idRoomType != uOrder.idRoomType) return false;
        if (rooms != uOrder.rooms) return false;
        if (idRequestStatus != uOrder.idRequestStatus) return false;
        if (Float.compare(uOrder.disount, disount) != 0) return false;
        if (Float.compare(uOrder.price, price) != 0) return false;
        if (idRoom != uOrder.idRoom) return false;
        if (login != null ? !login.equals(uOrder.login) : uOrder.login != null) return false;
        if (date != null ? !date.equals(uOrder.date) : uOrder.date != null) return false;
        if (roomType != null ? !roomType.equals(uOrder.roomType) : uOrder.roomType != null) return false;
        return requestStatus != null ? requestStatus.equals(uOrder.requestStatus) : uOrder.requestStatus == null;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + idRequest;
        result = 31 * result + idUser;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + days;
        result = 31 * result + idRoomType;
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        result = 31 * result + rooms;
        result = 31 * result + idRequestStatus;
        result = 31 * result + (requestStatus != null ? requestStatus.hashCode() : 0);
        result = 31 * result + (disount != +0.0f ? Float.floatToIntBits(disount) : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + idRoom;
        return result;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getIdRoomType() {
        return idRoomType;
    }

    public void setIdRoomType(int idRoomType) {
        this.idRoomType = idRoomType;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getIdRequestStatus() {
        return idRequestStatus;
    }

    public void setIdRequestStatus(int idRequestStatus) {
        this.idRequestStatus = idRequestStatus;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public float getDisount() {
        return disount;
    }

    public void setDisount(float disount) {
        this.disount = disount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }
}
