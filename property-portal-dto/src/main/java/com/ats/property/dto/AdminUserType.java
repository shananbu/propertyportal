//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.03 at 03:51:00 PM IST 
//


package com.ats.property.dto;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for adminUserType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="adminUserType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="designation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mailId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="doj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusType" type="{}statusType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adminUserType", propOrder = {
    "id",
    "firstName",
    "designation",
    "mailId",
    "phoneNumber",
    "status",
    "doj",
    "dor",
    "userName",
    "password",
    "statusType"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class AdminUserType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long id;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String firstName;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String designation;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String mailId;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String phoneNumber;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected long status;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String doj;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String dor;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String userName;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String password;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected StatusType statusType;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the designation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets the value of the designation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setDesignation(String value) {
        this.designation = value;
    }

    /**
     * Gets the value of the mailId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getMailId() {
        return mailId;
    }

    /**
     * Sets the value of the mailId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setMailId(String value) {
        this.mailId = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public long getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setStatus(long value) {
        this.status = value;
    }

    /**
     * Gets the value of the doj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getDoj() {
        return doj;
    }

    /**
     * Sets the value of the doj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setDoj(String value) {
        this.doj = value;
    }

    /**
     * Gets the value of the dor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getDor() {
        return dor;
    }

    /**
     * Sets the value of the dor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setDor(String value) {
        this.dor = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the statusType property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public StatusType getStatusType() {
        return statusType;
    }

    /**
     * Sets the value of the statusType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setStatusType(StatusType value) {
        this.statusType = value;
    }

}
