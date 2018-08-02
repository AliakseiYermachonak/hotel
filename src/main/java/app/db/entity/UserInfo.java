package app.db.entity;

/**
 * Usual entity class to describe
 * additional user information
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class UserInfo {
	private String documentNumber;
	private int documentType;
	private int idUser;
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;
	private int ordersDone;
	
	public UserInfo(String documentNumber, int documentType, int idUser, String name, String surname,
			String phoneNumber, String email, int ordersDone) {
		this.documentNumber = documentNumber;
		this.documentType = documentType;
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.ordersDone = ordersDone;
	}
	
	public UserInfo() {}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [documentNumber=" + documentNumber + ", documentType=" + documentType + ", idUser=" + idUser
				+ ", name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", ordersDone=" + ordersDone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentNumber == null) ? 0 : documentNumber.hashCode());
		result = prime * result + documentType;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idUser;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ordersDone;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (documentNumber == null) {
			if (other.documentNumber != null)
				return false;
		} else if (!documentNumber.equals(other.documentNumber))
			return false;
		if (documentType != other.documentType)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUser != other.idUser)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ordersDone != other.ordersDone)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public int getDocumentType() {
		return documentType;
	}

	public void setDocumentType(int documentType) {
		this.documentType = documentType;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOrdersDone() {
		return ordersDone;
	}

	public void setOrdersDone(int ordersDone) {
		this.ordersDone = ordersDone;
	}
}
