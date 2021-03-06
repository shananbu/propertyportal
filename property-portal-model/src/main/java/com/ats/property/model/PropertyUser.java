package com.ats.property.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * The PropertyUser.
 *
 * @author anbarasan.s
 */
@Entity
public class PropertyUser {
    private Long id;
    private Long userTypeId;
    private String firstName;
    private String lastName;
    private String builderName;
    private String emailId;
    private Long cityId;
    private String phone;
    private String mobileNo;
    private String countryCode;
    private Boolean isTermsAgreed;
    private String isMailVerified;
    private String passwrd;
    private String status;
    private UserType userTypeByUserTypeId;
    private City cityByCityId;
    private Date registeredDate;
    private Collection<PropertyRequirement> propertyRequirementsById;
    private Collection<Advertisement> advertisementsById;
    private String passwordRecoveryToken;

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
    @Column(name = "userTypeId", nullable = true, insertable = false, updatable = false)
    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Basic
    @Column(name = "firstName", nullable = true, insertable = true, updatable = true, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = true, insertable = true, updatable = true, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "builderName", nullable = true, insertable = true, updatable = true, length = 100)
    public String getBuilderName() {
        return builderName;
    }

    public void setBuilderName(String builderName) {
        this.builderName = builderName;
    }

    @Basic
    @Column(name = "emailId", nullable = true, insertable = true, updatable = true, length = 25)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Basic
    @Column(name = "cityId", nullable = true, insertable = false, updatable = false)
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 25)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mobileNo", nullable = true, insertable = true, updatable = true, length = 25)
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Basic
    @Column(name = "isMailVerified", nullable = true, insertable = true, updatable = true, length = 2)
    public String getIsMailVerified() {
        return isMailVerified;
    }

    public void setIsMailVerified(String isMailVerified) {
        this.isMailVerified = isMailVerified;
    }

    @Basic
    @Column(name = "passwrd", nullable = true, insertable = true, updatable = true, length = 25)
    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true, length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyUser that = (PropertyUser) o;

        if (builderName != null ? !builderName.equals(that.builderName) : that.builderName != null) return false;
        if (cityId != null ? !cityId.equals(that.cityId) : that.cityId != null) return false;
        if (emailId != null ? !emailId.equals(that.emailId) : that.emailId != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isMailVerified != null ? !isMailVerified.equals(that.isMailVerified) : that.isMailVerified != null)
            return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (mobileNo != null ? !mobileNo.equals(that.mobileNo) : that.mobileNo != null) return false;
        if (passwrd != null ? !passwrd.equals(that.passwrd) : that.passwrd != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (userTypeId != null ? !userTypeId.equals(that.userTypeId) : that.userTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userTypeId != null ? userTypeId.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (builderName != null ? builderName.hashCode() : 0);
        result = 31 * result + (emailId != null ? emailId.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mobileNo != null ? mobileNo.hashCode() : 0);
        result = 31 * result + (isMailVerified != null ? isMailVerified.hashCode() : 0);
        result = 31 * result + (passwrd != null ? passwrd.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userTypeId", referencedColumnName = "id")
    public UserType getUserTypeByUserTypeId() {
        return userTypeByUserTypeId;
    }

    public void setUserTypeByUserTypeId(UserType userTypeByUserTypeId) {
        this.userTypeByUserTypeId = userTypeByUserTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "cityId", referencedColumnName = "id")
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @OneToMany(mappedBy = "propertyUserByPropertyUserId")
    public Collection<PropertyRequirement> getPropertyRequirementsById() {
        return propertyRequirementsById;
    }

    public void setPropertyRequirementsById(Collection<PropertyRequirement> propertyRequirementsById) {
        this.propertyRequirementsById = propertyRequirementsById;
    }

    @OneToMany(mappedBy = "propertyUserByPropertyUserId")
    public Collection<Advertisement> getAdvertisementsById() {
        return advertisementsById;
    }

    public void setAdvertisementsById(Collection<Advertisement> advertisementsById) {
        this.advertisementsById = advertisementsById;
    }

    @Basic
    @Column(name = "countryCode", nullable = true, insertable = true, updatable = true, length = 1)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "isTermsAgreed", nullable = true, insertable = true, updatable = true, length = 1)
    public Boolean getIsTermsAgreed() {
        return isTermsAgreed;
    }

    public void setIsTermsAgreed(Boolean isTermsAgreed) {
        this.isTermsAgreed = isTermsAgreed;
    }

    @Basic
    @Column(name = "registeredDate", nullable = true, insertable = true, updatable = true)
    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Basic
    @Column(name = "passwordRecoveryToken", nullable = true, insertable = true, updatable = true, length = 200)
    public String getPasswordRecoveryToken() {
        return passwordRecoveryToken;
    }

    public void setPasswordRecoveryToken(String passwordRecoveryToken) {
        this.passwordRecoveryToken = passwordRecoveryToken;
    }

}
