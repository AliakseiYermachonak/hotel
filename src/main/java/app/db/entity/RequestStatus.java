package app.db.entity;


/**
 * Usual entity class to describe
 * request statuses according to
 * the identifiers
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class RequestStatus {
	private int idRequestStatus;
	private String status;
	
	public RequestStatus(int idRequestStatus, String status) {
		this.idRequestStatus = idRequestStatus;
		this.status = status;
	}
	
	public RequestStatus() {}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [idRequestStatus=" + idRequestStatus + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRequestStatus;
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
		RequestStatus other = (RequestStatus) obj;
		if (idRequestStatus != other.idRequestStatus)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public int getIdRequestStatus() {
		return idRequestStatus;
	}

	public void setIdRequestStatus(int idRequestStatus) {
		this.idRequestStatus = idRequestStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
