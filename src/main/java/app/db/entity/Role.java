package app.db.entity;

/**
 * Usual entity class to describe
 * roles of the users according to
 * their identifiers
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class Role {
	private int idRole;
	private String role;
	
	public Role(int idRole, String role) {
		this.idRole = idRole;
		this.role = role;
	}
	
	public Role() {}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [idRole=" + idRole + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRole;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Role other = (Role) obj;
		if (idRole != other.idRole)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
