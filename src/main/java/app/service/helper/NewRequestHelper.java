package app.service.helper;

public class NewRequestHelper {
    private String date;
    private String nDays;
    private String idRoomType;
    private String nRooms;
    private String willing;

    public NewRequestHelper() {
    }

    public NewRequestHelper(String date, String nDays, String idRoomType, String nRooms, String willing) {
        this.date = date;
        this.nDays = nDays;
        this.idRoomType = idRoomType;
        this.nRooms = nRooms;
        this.willing = willing;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setnDays(String nDays) {
        this.nDays = nDays;
    }

    public void setIdRoomType(String idRoomType) {
        this.idRoomType = idRoomType;
    }

    public void setnRooms(String nRooms) {
        this.nRooms = nRooms;
    }

    public void setWilling(String willing) {
        this.willing = willing;
    }

    public String getDate() {
        return date;
    }

    public String getnDays() {
        return nDays;
    }

    public String getIdRoomType() {
        return idRoomType;
    }

    public String getnRooms() {
        return nRooms;
    }

    public String getWilling() {
        return willing;
    }
}
