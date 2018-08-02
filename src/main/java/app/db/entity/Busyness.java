package app.db.entity;

import java.util.Date;

/**
 * Usual entity class to describe
 * Busyness of the rooms
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class Busyness {
	private int idRoom;
	private Date date;
	private int idBusyStatus;
	private int idDocType;
	private String docNumber;
	
	public Busyness() {}
	
	public Busyness(int idRoom, Date date, int idBusyStatus, int idDocType, String docNumber) {
		this.idRoom = idRoom;
		this.date = date;
		this.idBusyStatus = idBusyStatus;
		this.idDocType  = idDocType;
		this.docNumber = docNumber;
	}

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " {idRoom=" + idRoom +
                ", date=" + date +
                ", idBusyStatus=" + idBusyStatus +
                ", idDocType=" + idDocType +
                ", docNumber='" + docNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Busyness busyness = (Busyness) o;

        if (idRoom != busyness.idRoom) return false;
        if (idBusyStatus != busyness.idBusyStatus) return false;
        if (idDocType != busyness.idDocType) return false;
        if (date != null ? !date.equals(busyness.date) : busyness.date != null) return false;
        return docNumber != null ? docNumber.equals(busyness.docNumber) : busyness.docNumber == null;
    }

    @Override
    public int hashCode() {
        int result = idRoom;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + idBusyStatus;
        result = 31 * result + idDocType;
        result = 31 * result + (docNumber != null ? docNumber.hashCode() : 0);
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

    public int getIdDocType() {
        return idDocType;
    }

    public void setIdDocType(int idDocType) {
        this.idDocType = idDocType;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }
}
