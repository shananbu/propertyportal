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
 * <p>Java class for authenticationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="authenticationResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authenticationResponseType", propOrder = {
    "sessionID",
    "username"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class AuthenticationResponseType {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String sessionID;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String username;

    /**
     * Gets the value of the sessionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Sets the value of the sessionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setSessionID(String value) {
        this.sessionID = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setUsername(String value) {
        this.username = value;
    }

}
