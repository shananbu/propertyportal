//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 11:46:05 PM IST 
//


package com.ats.property.dto;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="propertyForTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="propertyTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="locationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="expectedPrice" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bedRoomId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="userTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="pageNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="searchString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchType", propOrder = {
    "propertyForTypeId",
    "propertyTypeId",
    "locationId",
    "expectedPrice",
    "bedRoomId",
    "userTypeId",
    "pageNumber",
    "searchString"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class SearchType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long propertyForTypeId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long propertyTypeId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long locationId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long expectedPrice;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long bedRoomId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long userTypeId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Integer pageNumber;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String searchString;

    /**
     * Gets the value of the propertyForTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getPropertyForTypeId() {
        return propertyForTypeId;
    }

    /**
     * Sets the value of the propertyForTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPropertyForTypeId(Long value) {
        this.propertyForTypeId = value;
    }

    /**
     * Gets the value of the propertyTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getPropertyTypeId() {
        return propertyTypeId;
    }

    /**
     * Sets the value of the propertyTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPropertyTypeId(Long value) {
        this.propertyTypeId = value;
    }

    /**
     * Gets the value of the locationId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getLocationId() {
        return locationId;
    }

    /**
     * Sets the value of the locationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setLocationId(Long value) {
        this.locationId = value;
    }

    /**
     * Gets the value of the expectedPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getExpectedPrice() {
        return expectedPrice;
    }

    /**
     * Sets the value of the expectedPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setExpectedPrice(Long value) {
        this.expectedPrice = value;
    }

    /**
     * Gets the value of the bedRoomId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getBedRoomId() {
        return bedRoomId;
    }

    /**
     * Sets the value of the bedRoomId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBedRoomId(Long value) {
        this.bedRoomId = value;
    }

    /**
     * Gets the value of the userTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setUserTypeId(Long value) {
        this.userTypeId = value;
    }

    /**
     * Gets the value of the pageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets the value of the pageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPageNumber(Integer value) {
        this.pageNumber = value;
    }

    /**
     * Gets the value of the searchString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getSearchString() {
        return searchString;
    }

    /**
     * Sets the value of the searchString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-10T11:46:05+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setSearchString(String value) {
        this.searchString = value;
    }

}
