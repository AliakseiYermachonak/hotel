package app.db.entity;

import java.io.Serializable;

/**
 * Usual entity class to describe
 * Room Types of the rooms according to
 * their identifiers
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class RoomType implements Serializable, Cloneable {
	private int idRoomType;
	private String type;
	private float price;
	
	public RoomType(int idRoomType, String type, float price) {
		this.idRoomType = idRoomType;
		this.type = type;
		this.price = price;
	}
	
	public RoomType() {}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [idRoomType=" + idRoomType + ", type=" + type + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRoomType;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		RoomType other = (RoomType) obj;
		if (idRoomType != other.idRoomType)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
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
