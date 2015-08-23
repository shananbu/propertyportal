package com.ats.property.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The AdminLogin.
 *
 * @author anbarasan.s
 */
@Entity
public class AdminLogin {
    private Long id;
    private String firstName;
    private String designation;
    private String mailId;
    private String phoneNumber;
    private Timestamp doj;
    private Timestamp dor;
    private Long statusId;
    private String userName;
    private String password;
    private StatusMast statusMastByStatusId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName", nullable = true, insertable = true, updatable = true, length = 25)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "designation", nullable = true, insertable = true, updatable = true, length = 25)
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Basic
    @Column(name = "mailId", nullable = true, insertable = true, updatable = true, length = 25)
    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    @Basic
    @Column(name = "phoneNumber", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "DOJ", nullable = true, insertable = true, updatable = true)
    public Timestamp getDoj() {
        return doj;
    }

    public void setDoj(Timestamp doj) {
        this.doj = doj;
    }

    @Basic
    @Column(name = "DOR", nullable = true, insertable = true, updatable = true)
    public Timestamp getDor() {
        return dor;
    }

    public void setDor(Timestamp dor) {
        this.dor = dor;
    }

    @Basic
    @Column(name = "statusId", nullable = true, insertable = false, updatable = false)
    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "userName", nullable = true, insertable = true, updatable = true, length = 25)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 25)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminLogin that = (AdminLogin) o;

        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;
        if (doj != null ? !doj.equals(that.doj) : that.doj != null) return false;
        if (dor != null ? !dor.equals(that.dor) : that.dor != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (mailId != null ? !mailId.equals(that.mailId) : that.mailId != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (mailId != null ? mailId.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (doj != null ? doj.hashCode() : 0);
        result = 31 * result + (dor != null ? dor.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "statusId", referencedColumnName = "id")
    public StatusMast getStatusMastByStatusId() {
        return statusMastByStatusId;
    }

    public void setStatusMastByStatusId(StatusMast statusMastByStatusId) {
        this.statusMastByStatusId = statusMastByStatusId;
    }
}
