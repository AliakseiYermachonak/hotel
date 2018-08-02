package app.db.entity;

/**
 * Usual entity class to describe
 * Del Status of the users according to
 * the identifiers
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DelStatus {
	
	private int idDelStatus;
	private String status;
	
	public DelStatus(int idDelStatus, String status) {
		this.idDelStatus = idDelStatus;
		this.status = status;
	}
	
	public DelStatus() {}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [idDelStatus=" + idDelStatus + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDelStatus;
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
		DelStatus other = (DelStatus) obj;
		if (idDelStatus != other.idDelStatus)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public int getIdDelStatus() {
		return idDelStatus;
	}

	public void setIdDelStatus(int idDelStatus) {
		this.idDelStatus = idDelStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
