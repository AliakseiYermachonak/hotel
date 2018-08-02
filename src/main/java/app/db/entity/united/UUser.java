package app.db.entity.united;

import app.db.entity.User;

/**
 * United entity class with additional fields
 * describing the exact information about the Users.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class UUser {
    private int idUser;
    private String login;
    private String password;
    private int idRole;
    private String role;
    private int idDelStatus;
    private String delStatus;

    public UUser(int idUser, String login, String password, int idRole, String role, int idDelStatus, String delStatus) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.idRole = idRole;
        this.role = role;
        this.idDelStatus = idDelStatus;
        this.delStatus = delStatus;
    }

    public UUser(User user, String role, String delStatus) {
        this.idUser = user.getIdUser();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.idRole = user.getIdRole();
        this.role = role;
        this.idDelStatus = user.getIdDelStatus();
        this.delStatus = delStatus;
    }

    public UUser() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", idRole=" + idRole +
                ", role='" + role + '\'' +
                ", idDelStatus=" + idDelStatus +
                ", delStatus='" + delStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UUser uUser = (UUser) o;

        if (idUser != uUser.idUser) return false;
        if (idRole != uUser.idRole) return false;
        if (idDelStatus != uUser.idDelStatus) return false;
        if (login != null ? !login.equals(uUser.login) : uUser.login != null) return false;
        if (password != null ? !password.equals(uUser.password) : uUser.password != null) return false;
        if (role != null ? !role.equals(uUser.role) : uUser.role != null) return false;
        return delStatus != null ? delStatus.equals(uUser.delStatus) : uUser.delStatus == null;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + idRole;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + idDelStatus;
        result = 31 * result + (delStatus != null ? delStatus.hashCode() : 0);
        return result;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdDelStatus() {
        return idDelStatus;
    }

    public void setIdDelStatus(int idDelStatus) {
        this.idDelStatus = idDelStatus;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }
}
