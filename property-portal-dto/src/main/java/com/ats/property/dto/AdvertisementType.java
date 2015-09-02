//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.01 at 11:38:23 PM IST 
//


package com.ats.property.dto;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for advertisementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="advertisementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="planId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="propertyForTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="propertyTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="locationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="buildupArea" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="buildupAreaUnitId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bedRoomId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bathRoomId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="furnishedStatusId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="balconyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="propertyOnFloorId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="totalFloor" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="expectedPrice" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="maintenanceCharges" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="maintenancePeriodId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="securityDeposit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="responseFromBrokers" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="projectName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="propertyFeatures" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isTermsAgreed" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "advertisementType", propOrder = {
    "id",
    "planId",
    "propertyForTypeId",
    "propertyTypeId",
    "locationId",
    "address",
    "buildupArea",
    "buildupAreaUnitId",
    "bedRoomId",
    "bathRoomId",
    "furnishedStatusId",
    "balconyId",
    "propertyOnFloorId",
    "totalFloor",
    "expectedPrice",
    "maintenanceCharges",
    "maintenancePeriodId",
    "securityDeposit",
    "responseFromBrokers",
    "projectName",
    "description",
    "propertyFeatures",
    "isTermsAgreed"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class AdvertisementType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long id;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long planId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long propertyForTypeId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long propertyTypeId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long locationId;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String address;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Double buildupArea;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long buildupAreaUnitId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long bedRoomId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long bathRoomId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long furnishedStatusId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long balconyId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long propertyOnFloorId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long totalFloor;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long expectedPrice;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long maintenanceCharges;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long maintenancePeriodId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long securityDeposit;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String responseFromBrokers;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String projectName;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String description;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String propertyFeatures;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String isTermsAgreed;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the planId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getPlanId() {
        return planId;
    }

    /**
     * Sets the value of the planId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPlanId(Long value) {
        this.planId = value;
    }

    /**
     * Gets the value of the propertyForTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setLocationId(Long value) {
        this.locationId = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the buildupArea property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Double getBuildupArea() {
        return buildupArea;
    }

    /**
     * Sets the value of the buildupArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBuildupArea(Double value) {
        this.buildupArea = value;
    }

    /**
     * Gets the value of the buildupAreaUnitId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBuildupAreaUnitId(Long value) {
        this.buildupAreaUnitId = value;
    }

    /**
     * Gets the value of the bedRoomId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBedRoomId(Long value) {
        this.bedRoomId = value;
    }

    /**
     * Gets the value of the bathRoomId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getBathRoomId() {
        return bathRoomId;
    }

    /**
     * Sets the value of the bathRoomId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBathRoomId(Long value) {
        this.bathRoomId = value;
    }

    /**
     * Gets the value of the furnishedStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getFurnishedStatusId() {
        return furnishedStatusId;
    }

    /**
     * Sets the value of the furnishedStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setFurnishedStatusId(Long value) {
        this.furnishedStatusId = value;
    }

    /**
     * Gets the value of the balconyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getBalconyId() {
        return balconyId;
    }

    /**
     * Sets the value of the balconyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setBalconyId(Long value) {
        this.balconyId = value;
    }

    /**
     * Gets the value of the propertyOnFloorId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getPropertyOnFloorId() {
        return propertyOnFloorId;
    }

    /**
     * Sets the value of the propertyOnFloorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPropertyOnFloorId(Long value) {
        this.propertyOnFloorId = value;
    }

    /**
     * Gets the value of the totalFloor property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getTotalFloor() {
        return totalFloor;
    }

    /**
     * Sets the value of the totalFloor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setTotalFloor(Long value) {
        this.totalFloor = value;
    }

    /**
     * Gets the value of the expectedPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setExpectedPrice(Long value) {
        this.expectedPrice = value;
    }

    /**
     * Gets the value of the maintenanceCharges property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getMaintenanceCharges() {
        return maintenanceCharges;
    }

    /**
     * Sets the value of the maintenanceCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setMaintenanceCharges(Long value) {
        this.maintenanceCharges = value;
    }

    /**
     * Gets the value of the maintenancePeriodId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getMaintenancePeriodId() {
        return maintenancePeriodId;
    }

    /**
     * Sets the value of the maintenancePeriodId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setMaintenancePeriodId(Long value) {
        this.maintenancePeriodId = value;
    }

    /**
     * Gets the value of the securityDeposit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Long getSecurityDeposit() {
        return securityDeposit;
    }

    /**
     * Sets the value of the securityDeposit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setSecurityDeposit(Long value) {
        this.securityDeposit = value;
    }

    /**
     * Gets the value of the responseFromBrokers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getResponseFromBrokers() {
        return responseFromBrokers;
    }

    /**
     * Sets the value of the responseFromBrokers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setResponseFromBrokers(String value) {
        this.responseFromBrokers = value;
    }

    /**
     * Gets the value of the projectName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets the value of the projectName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setProjectName(String value) {
        this.projectName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the propertyFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getPropertyFeatures() {
        return propertyFeatures;
    }

    /**
     * Sets the value of the propertyFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPropertyFeatures(String value) {
        this.propertyFeatures = value;
    }

    /**
     * Gets the value of the isTermsAgreed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getIsTermsAgreed() {
        return isTermsAgreed;
    }

    /**
     * Sets the value of the isTermsAgreed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setIsTermsAgreed(String value) {
        this.isTermsAgreed = value;
    }

}