package app.db.entity;

import java.util.Date;

/**
 * Usual entity class to describe
 * requests from the users
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class Request {
	private int idRequest;
	private int idUser;
	private Date date;
	private int days;
	private int idRoomType;
	private int rooms;
	private int idRequestStatus;
	
	public Request(int idRequest, int idUser, Date date, int days, int idRoomType, int rooms, int idRequestStatus) {
		this.idRequest = idRequest;
		this.idUser = idUser;
		this.date = date;
		this.days = days;
		this.idRoomType = idRoomType;
		this.rooms = rooms;
		this.idRequestStatus = idRequestStatus;
	}

	public Request(int idUser, Date date, int days, int idRoomType, int rooms, int idRequestStatus) {
		this.idUser = idUser;
		this.date = date;
		this.days = days;
		this.idRoomType = idRoomType;
		this.rooms = rooms;
		this.idRequestStatus = idRequestStatus;
	}

	public Request() {}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [idRequest=" + idRequest + ", idUser=" + idUser + ", date=" + date + ", days=" + days
				+ ", idRoomType=" + idRoomType + ", rooms=" + rooms + ", idRequestStatus=" + idRequestStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + days;
		result = prime * result + idRequest;
		result = prime * result + idRequestStatus;
		result = prime * result + idRoomType;
		result = prime * result + idUser;
		result = prime * result + rooms;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (days != other.days)
			return false;
		if (idRequest != other.idRequest)
			return false;
		if (idRequestStatus != other.idRequestStatus)
			return false;
		if (idRoomType != other.idRoomType)
			return false;
		if (idUser != other.idUser)
			return false;
		if (rooms != other.rooms)
			return false;
		return true;
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
}
