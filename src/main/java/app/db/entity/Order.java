package app.db.entity;

/**
 * Usual entity class to describe
 * orders according to the requests
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class Order {
	private int idOrder;
	private int idRequest;
	private float disount;
	private float price;
	private int idRoom;
	
	public Order(int idOrder, int idRequest, float disount, float price, int idRoom) {
		this.idOrder = idOrder;
		this.idRequest = idRequest;
		this.disount = disount;
		this.price = price;
		this.idRoom = idRoom;
	}

	public Order() {}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [idOrder=" + idOrder + ", idRequest=" + idRequest + ", disount=" + disount + ", price=" + price
				+ ", idRoom=" + idRoom + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(disount);
		result = prime * result + idOrder;
		result = prime * result + idRequest;
		result = prime * result + idRoom;
		result = prime * result + Float.floatToIntBits(price);
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
		Order other = (Order) obj;
		if (Float.floatToIntBits(disount) != Float.floatToIntBits(other.disount))
			return false;
		if (idOrder != other.idOrder)
			return false;
		if (idRequest != other.idRequest)
			return false;
		if (idRoom != other.idRoom)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
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
