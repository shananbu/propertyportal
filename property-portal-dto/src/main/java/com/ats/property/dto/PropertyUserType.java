//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.08 at 05:23:43 PM IST 
//


package com.ats.property.dto;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for propertyUserType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="propertyUserType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="builderName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emailId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobileNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isMailVerified" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passwrd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "propertyUserType", propOrder = {
    "id",
    "firstName",
    "lastName",
    "builderName",
    "emailId",
    "mobileNo",
    "isMailVerified",
    "passwrd",
    "status",
    "userTypeId"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class PropertyUserType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long id;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String firstName;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String lastName;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String builderName;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String emailId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String mobileNo;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String isMailVerified;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String passwrd;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String status;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long userTypeId;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the builderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getBuilderName() {
        return builderName;
    }

    /**
     * Sets the value of the builderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBuilderName(String value) {
        this.builderName = value;
    }

    /**
     * Gets the value of the emailId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the value of the emailId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setEmailId(String value) {
        this.emailId = value;
    }

    /**
     * Gets the value of the mobileNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the value of the mobileNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setMobileNo(String value) {
        this.mobileNo = value;
    }

    /**
     * Gets the value of the isMailVerified property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getIsMailVerified() {
        return isMailVerified;
    }

    /**
     * Sets the value of the isMailVerified property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setIsMailVerified(String value) {
        this.isMailVerified = value;
    }

    /**
     * Gets the value of the passwrd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getPasswrd() {
        return passwrd;
    }

    /**
     * Sets the value of the passwrd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPasswrd(String value) {
        this.passwrd = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the userTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getUserTypeId() {
        return userTypeId;
    }

    /**
     * Sets the value of the userTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-08T05:23:43+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setUserTypeId(Long value) {
        this.userTypeId = value;
    }

}
