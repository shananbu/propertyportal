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
 * <p>Java class for morePropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="morePropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bedRoomId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="pricePerUnitArea" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="totalCost" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="totalCostInWords" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bedRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="floorPlanFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "morePropertyType", propOrder = {
    "id",
    "bedRoomId",
    "area",
    "pricePerUnitArea",
    "totalCost",
    "totalCostInWords",
    "bedRoom",
    "floorPlanFileName"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class MorePropertyType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long id;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long bedRoomId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long area;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long pricePerUnitArea;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long totalCost;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String totalCostInWords;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String bedRoom;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String floorPlanFileName;

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
     * Gets the value of the bedRoomId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBedRoomId(Long value) {
        this.bedRoomId = value;
    }

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setArea(Long value) {
        this.area = value;
    }

    /**
     * Gets the value of the pricePerUnitArea property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getPricePerUnitArea() {
        return pricePerUnitArea;
    }

    /**
     * Sets the value of the pricePerUnitArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPricePerUnitArea(Long value) {
        this.pricePerUnitArea = value;
    }

    /**
     * Gets the value of the totalCost property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the value of the totalCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setTotalCost(Long value) {
        this.totalCost = value;
    }

    /**
     * Gets the value of the totalCostInWords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getTotalCostInWords() {
        return totalCostInWords;
    }

    /**
     * Sets the value of the totalCostInWords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setTotalCostInWords(String value) {
        this.totalCostInWords = value;
    }

    /**
     * Gets the value of the bedRoom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getBedRoom() {
        return bedRoom;
    }

    /**
     * Sets the value of the bedRoom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBedRoom(String value) {
        this.bedRoom = value;
    }

    /**
     * Gets the value of the floorPlanFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getFloorPlanFileName() {
        return floorPlanFileName;
    }

    /**
     * Sets the value of the floorPlanFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setFloorPlanFileName(String value) {
        this.floorPlanFileName = value;
    }

}
