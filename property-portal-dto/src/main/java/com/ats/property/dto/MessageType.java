//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.26 at 06:44:12 PM IST 
//


package com.ats.property.dto;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for messageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageType", propOrder = {
    "code",
    "message"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-26T06:44:12+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class MessageType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-26T06:44:12+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Integer code;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-26T06:44:12+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String message;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-26T06:44:12+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Integer getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-26T06:44:12+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setCode(Integer value) {
        this.code = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-26T06:44:12+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-26T06:44:12+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setMessage(String value) {
        this.message = value;
    }

}
