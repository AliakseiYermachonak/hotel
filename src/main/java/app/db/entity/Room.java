package app.db.entity;

/**
 * Usual entity class to describe
 * rooms at the hotel according to their
 * room numbers
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class Room {
	private int idRoom;
	private int idRoomType;
	
	public Room(int idRoom, int idRoomType) {
		this.idRoom = idRoom;
		this.idRoomType = idRoomType;
	}
	
	public Room() {}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [idRoom=" + idRoom + ", idRoomType=" + idRoomType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRoom;
		result = prime * result + idRoomType;
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
		Room other = (Room) obj;
		if (idRoom != other.idRoom)
			return false;
		if (idRoomType != other.idRoomType)
			return false;
		return true;
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
}
