//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.06 at 07:50:29 PM IST 
//


package com.ats.property.dto;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="propertyTypeId" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded"/>
 *         &lt;element name="locationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="expectedPrice" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bedRoomId" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded"/>
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
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class SearchType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long propertyForTypeId;
    @XmlElement(type = Long.class)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<Long> propertyTypeId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long locationId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long expectedPrice;
    @XmlElement(type = Long.class)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<Long> bedRoomId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long userTypeId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Integer pageNumber;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String searchString;

    /**
     * Gets the value of the propertyForTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPropertyForTypeId(Long value) {
        this.propertyForTypeId = value;
    }

    /**
     * Gets the value of the propertyTypeId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyTypeId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyTypeId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<Long> getPropertyTypeId() {
        if (propertyTypeId == null) {
            propertyTypeId = new ArrayList<Long>();
        }
        return this.propertyTypeId;
    }

    /**
     * Gets the value of the locationId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setExpectedPrice(Long value) {
        this.expectedPrice = value;
    }

    /**
     * Gets the value of the bedRoomId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedRoomId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedRoomId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<Long> getBedRoomId() {
        if (bedRoomId == null) {
            bedRoomId = new ArrayList<Long>();
        }
        return this.bedRoomId;
    }

    /**
     * Gets the value of the userTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-03-06T07:50:29+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setSearchString(String value) {
        this.searchString = value;
    }

    public void setPropertyTypeId(List<Long> value) {
        List<Long> draftl = this.getPropertyTypeId();
        draftl.addAll(value);
    }

    public void setBedRoomId(List<Long> value) {
        List<Long> draftl = this.getBedRoomId();
        draftl.addAll(value);
    }

}
