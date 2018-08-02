package app.db.entity;

/**
 * Usual entity class to describe
 * Busy Status according to their identifier
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class BusyStatus {
	private int idBusyStatus;
	private String status;
	
	public BusyStatus() {
	}
	
	public BusyStatus(int id, String status) {
		this.idBusyStatus = id;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id=" + idBusyStatus + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idBusyStatus;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		BusyStatus other = (BusyStatus) obj;
		if (idBusyStatus != other.idBusyStatus)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public int getIdBusyStatus() {
		return idBusyStatus;
	}

	public void setIdBusyStatus(int id) {
		this.idBusyStatus = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
