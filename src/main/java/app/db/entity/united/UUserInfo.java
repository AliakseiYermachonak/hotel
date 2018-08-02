package app.db.entity.united;

import app.db.entity.UserInfo;

/**
 * United entity class with additional fields
 * describing the exact information about the Users.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class UUserInfo {
    private int idUser;
    private String docNumber;
    private int idDocType;
    private String docType;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private int ordersDone;

    public UUserInfo() {
    }

    public UUserInfo(int idUser, String docNumber, int idDocType, String docType, String name, String surname, String phoneNumber, String email, int ordersDone) {
        this.idUser = idUser;
        this.docNumber = docNumber;
        this.idDocType = idDocType;
        this.docType = docType;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ordersDone = ordersDone;
    }

    public UUserInfo(UserInfo userInfo, String docType) {
        this.idUser = userInfo.getIdUser();
        this.docNumber = userInfo.getDocumentNumber();
        this.idDocType = userInfo.getDocumentType();
        this.docType = docType;
        this.name = userInfo.getName();
        this.surname = userInfo.getSurname();
        this.phoneNumber = userInfo.getPhoneNumber();
        this.email = userInfo.getEmail();
        this.ordersDone = userInfo.getOrdersDone();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{idUser=" + idUser +
                ", docNumber='" + docNumber + '\'' +
                ", idDocType=" + idDocType +
                ", docType='" + docType + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", ordersDone=" + ordersDone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UUserInfo uUserInfo = (UUserInfo) o;

        if (idUser != uUserInfo.idUser) return false;
        if (idDocType != uUserInfo.idDocType) return false;
        if (ordersDone != uUserInfo.ordersDone) return false;
        if (docNumber != null ? !docNumber.equals(uUserInfo.docNumber) : uUserInfo.docNumber != null) return false;
        if (docType != null ? !docType.equals(uUserInfo.docType) : uUserInfo.docType != null) return false;
        if (name != null ? !name.equals(uUserInfo.name) : uUserInfo.name != null) return false;
        if (surname != null ? !surname.equals(uUserInfo.surname) : uUserInfo.surname != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(uUserInfo.phoneNumber) : uUserInfo.phoneNumber != null)
            return false;
        return email != null ? email.equals(uUserInfo.email) : uUserInfo.email == null;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (docNumber != null ? docNumber.hashCode() : 0);
        result = 31 * result + idDocType;
        result = 31 * result + (docType != null ? docType.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + ordersDone;
        return result;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public int getIdDocType() {
        return idDocType;
    }

    public void setIdDocType(int idDocType) {
        this.idDocType = idDocType;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
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
