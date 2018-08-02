package app.db.entity;

/**
 * Usual entity class to describe
 * users according to their identifiers
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class User {

    private int idUser;
    private String login;
    private String password;
    private int idRole;
    private int idDelStatus;
    
	public User(int idUser, String login, String password, int idRole, int idDelStatus) {
		this.idUser = idUser;
		this.login = login;
		this.password = password;
		this.idRole = idRole;
		this.idDelStatus = idDelStatus;
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
		this.idRole = 1;
		this.idDelStatus = 1;
	}

	public User() {}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [idUser=" + idUser + ", login=" + login + ", password=" + password + ", idRole=" + idRole
				+ ", idDelStatus=" + idDelStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDelStatus;
		result = prime * result + idRole;
		result = prime * result + idUser;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if (idDelStatus != other.idDelStatus)
			return false;
		if (idRole != other.idRole)
			return false;
		if (idUser != other.idUser)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public int getIdDelStatus() {
		return idDelStatus;
	}

	public void setIdDelStatus(int idDelStatus) {
		this.idDelStatus = idDelStatus;
	}
}