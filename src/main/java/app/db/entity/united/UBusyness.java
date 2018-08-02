package app.db.entity.united;

import java.util.Date;

/**
 * United entity class with additional fields
 * describing the exact information about busyness of the room.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class UBusyness {
	private int idRoom;
	private Date date;
	private int idBusyStatus;
	private String status;

	public UBusyness() {}

	public UBusyness(int idRoom, Date date, int idBusyStatu, String status) {
		this.idRoom = idRoom;
		this.date = date;
		this.idBusyStatus = idBusyStatus;
		this.status = status;
	}

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "[idRoom=" + idRoom +
                ", date=" + date +
                ", idBusyStatus=" + idBusyStatus +
                ", status='" + status + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UBusyness uBusyness = (UBusyness) o;

        if (idRoom != uBusyness.idRoom) return false;
        if (idBusyStatus != uBusyness.idBusyStatus) return false;
        if (date != null ? !date.equals(uBusyness.date) : uBusyness.date != null) return false;
        return status != null ? status.equals(uBusyness.status) : uBusyness.status == null;
    }

    @Override
    public int hashCode() {
        int result = idRoom;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + idBusyStatus;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdBusyStatus() {
        return idBusyStatus;
    }

    public void setIdBusyStatus(int idBusyStatus) {
        this.idBusyStatus = idBusyStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
