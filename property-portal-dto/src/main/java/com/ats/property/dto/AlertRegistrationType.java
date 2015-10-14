//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.13 at 03:26:25 PM IST 
//


package com.ats.property.dto;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for alertRegistrationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alertRegistrationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="propertyForTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="locations" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bedRooms" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="buildupAreaFrom" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="buildupAreaTo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="buildupAreaUnitId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="budgetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="alertFrequency" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alertRegistrationType", propOrder = {
    "id",
    "propertyForTypeId",
    "locations",
    "bedRooms",
    "buildupAreaFrom",
    "buildupAreaTo",
    "buildupAreaUnitId",
    "budgetId",
    "alertFrequency"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class AlertRegistrationType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long id;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long propertyForTypeId;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String locations;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String bedRooms;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Double buildupAreaFrom;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Double buildupAreaTo;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long buildupAreaUnitId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long budgetId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long alertFrequency;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the propertyForTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPropertyForTypeId(Long value) {
        this.propertyForTypeId = value;
    }

    /**
     * Gets the value of the locations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getLocations() {
        return locations;
    }

    /**
     * Sets the value of the locations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setLocations(String value) {
        this.locations = value;
    }

    /**
     * Gets the value of the bedRooms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getBedRooms() {
        return bedRooms;
    }

    /**
     * Sets the value of the bedRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBedRooms(String value) {
        this.bedRooms = value;
    }

    /**
     * Gets the value of the buildupAreaFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Double getBuildupAreaFrom() {
        return buildupAreaFrom;
    }

    /**
     * Sets the value of the buildupAreaFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBuildupAreaFrom(Double value) {
        this.buildupAreaFrom = value;
    }

    /**
     * Gets the value of the buildupAreaTo property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Double getBuildupAreaTo() {
        return buildupAreaTo;
    }

    /**
     * Sets the value of the buildupAreaTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBuildupAreaTo(Double value) {
        this.buildupAreaTo = value;
    }

    /**
     * Gets the value of the buildupAreaUnitId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getBuildupAreaUnitId() {
        return buildupAreaUnitId;
    }

    /**
     * Sets the value of the buildupAreaUnitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBuildupAreaUnitId(Long value) {
        this.buildupAreaUnitId = value;
    }

    /**
     * Gets the value of the budgetId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getBudgetId() {
        return budgetId;
    }

    /**
     * Sets the value of the budgetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBudgetId(Long value) {
        this.budgetId = value;
    }

    /**
     * Gets the value of the alertFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getAlertFrequency() {
        return alertFrequency;
    }

    /**
     * Sets the value of the alertFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-13T03:26:25+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setAlertFrequency(Long value) {
        this.alertFrequency = value;
    }

}
