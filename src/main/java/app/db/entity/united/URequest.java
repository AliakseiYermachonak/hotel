package app.db.entity.united;

import app.db.entity.Request;

import java.util.Date;

/**
 * United entity class with additional fields
 * describing the exact information about the Request.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class URequest {
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

    public URequest(int idRequest, int idUser, String login, Date date, int days, int idRoomType, String roomType, int rooms, int idRequestStatus, String requestStatus) {
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
    }

    public URequest(Request request, String login, String roomType, String requestStatus) {
        this.idRequest = request.getIdRequest();
        this.idUser = request.getIdUser();
        this.login = login;
        this.date = request.getDate();
        this.days = request.getDays();
        this.idRoomType = request.getIdRoomType();
        this.roomType = roomType;
        this.rooms = request.getRooms();
        this.idRequestStatus = request.getIdRequestStatus();
        this.requestStatus = requestStatus;
    }

    public URequest() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{idRequest=" + idRequest +
                ", idUser=" + idUser +
                ", login='" + login + '\'' +
                ", date=" + date +
                ", days=" + days +
                ", idRoomType=" + idRoomType +
                ", roomType='" + roomType + '\'' +
                ", rooms=" + rooms +
                ", idRequestStatus=" + idRequestStatus +
                ", requestStatus='" + requestStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        URequest uRequest = (URequest) o;

        if (idRequest != uRequest.idRequest) return false;
        if (idUser != uRequest.idUser) return false;
        if (days != uRequest.days) return false;
        if (idRoomType != uRequest.idRoomType) return false;
        if (rooms != uRequest.rooms) return false;
        if (idRequestStatus != uRequest.idRequestStatus) return false;
        if (login != null ? !login.equals(uRequest.login) : uRequest.login != null) return false;
        if (date != null ? !date.equals(uRequest.date) : uRequest.date != null) return false;
        if (roomType != null ? !roomType.equals(uRequest.roomType) : uRequest.roomType != null) return false;
        return requestStatus != null ? requestStatus.equals(uRequest.requestStatus) : uRequest.requestStatus == null;
    }

    @Override
    public int hashCode() {
        int result = idRequest;
        result = 31 * result + idUser;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + days;
        result = 31 * result + idRoomType;
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        result = 31 * result + rooms;
        result = 31 * result + idRequestStatus;
        result = 31 * result + (requestStatus != null ? requestStatus.hashCode() : 0);
        return result;
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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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
}
