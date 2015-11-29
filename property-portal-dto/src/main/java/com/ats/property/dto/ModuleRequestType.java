//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.28 at 02:23:03 PM IST 
//


package com.ats.property.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for moduleRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="moduleRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="standardAuth" type="{}standardAuthRequestType"/>
 *           &lt;element name="adminUser" type="{}adminUserType"/>
 *           &lt;element name="plan" type="{}planType" minOccurs="0"/>
 *           &lt;element name="propertyUser" type="{}propertyUserType" minOccurs="0"/>
 *           &lt;element name="country" type="{}nameDataType" minOccurs="0"/>
 *           &lt;element name="state" type="{}nameDataType" minOccurs="0"/>
 *           &lt;element name="city" type="{}nameDataType" minOccurs="0"/>
 *           &lt;element name="location" type="{}nameDataType" minOccurs="0"/>
 *           &lt;element name="advertisement" type="{}advertisementType" minOccurs="0"/>
 *           &lt;element name="search" type="{}searchType" minOccurs="0"/>
 *           &lt;element name="alertRegistration" type="{}alertRegistrationType" minOccurs="0"/>
 *           &lt;element name="advertisements" type="{}advertisementType" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moduleRequestType", propOrder = {
    "standardAuth",
    "adminUser",
    "plan",
    "propertyUser",
    "country",
    "state",
    "city",
    "location",
    "advertisement",
    "search",
    "alertRegistration",
    "advertisements"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class ModuleRequestType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected StandardAuthRequestType standardAuth;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected AdminUserType adminUser;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected PlanType plan;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected PropertyUserType propertyUser;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected NameDataType country;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected NameDataType state;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected NameDataType city;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected NameDataType location;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected AdvertisementType advertisement;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected SearchType search;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected AlertRegistrationType alertRegistration;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<AdvertisementType> advertisements;

    /**
     * Gets the value of the standardAuth property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAuthRequestType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public StandardAuthRequestType getStandardAuth() {
        return standardAuth;
    }

    /**
     * Sets the value of the standardAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAuthRequestType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setStandardAuth(StandardAuthRequestType value) {
        this.standardAuth = value;
    }

    /**
     * Gets the value of the adminUser property.
     * 
     * @return
     *     possible object is
     *     {@link AdminUserType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public AdminUserType getAdminUser() {
        return adminUser;
    }

    /**
     * Sets the value of the adminUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminUserType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setAdminUser(AdminUserType value) {
        this.adminUser = value;
    }

    /**
     * Gets the value of the plan property.
     * 
     * @return
     *     possible object is
     *     {@link PlanType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public PlanType getPlan() {
        return plan;
    }

    /**
     * Sets the value of the plan property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPlan(PlanType value) {
        this.plan = value;
    }

    /**
     * Gets the value of the propertyUser property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyUserType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public PropertyUserType getPropertyUser() {
        return propertyUser;
    }

    /**
     * Sets the value of the propertyUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyUserType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPropertyUser(PropertyUserType value) {
        this.propertyUser = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link NameDataType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public NameDataType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameDataType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setCountry(NameDataType value) {
        this.country = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link NameDataType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public NameDataType getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameDataType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setState(NameDataType value) {
        this.state = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link NameDataType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public NameDataType getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameDataType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setCity(NameDataType value) {
        this.city = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link NameDataType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public NameDataType getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameDataType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setLocation(NameDataType value) {
        this.location = value;
    }

    /**
     * Gets the value of the advertisement property.
     * 
     * @return
     *     possible object is
     *     {@link AdvertisementType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public AdvertisementType getAdvertisement() {
        return advertisement;
    }

    /**
     * Sets the value of the advertisement property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdvertisementType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setAdvertisement(AdvertisementType value) {
        this.advertisement = value;
    }

    /**
     * Gets the value of the search property.
     * 
     * @return
     *     possible object is
     *     {@link SearchType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public SearchType getSearch() {
        return search;
    }

    /**
     * Sets the value of the search property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setSearch(SearchType value) {
        this.search = value;
    }

    /**
     * Gets the value of the alertRegistration property.
     * 
     * @return
     *     possible object is
     *     {@link AlertRegistrationType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public AlertRegistrationType getAlertRegistration() {
        return alertRegistration;
    }

    /**
     * Sets the value of the alertRegistration property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlertRegistrationType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setAlertRegistration(AlertRegistrationType value) {
        this.alertRegistration = value;
    }

    /**
     * Gets the value of the advertisements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the advertisements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdvertisements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdvertisementType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-11-28T02:23:03+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<AdvertisementType> getAdvertisements() {
        if (advertisements == null) {
            advertisements = new ArrayList<AdvertisementType>();
        }
        return this.advertisements;
    }

    public void setAdvertisements(List<AdvertisementType> value) {
        List<AdvertisementType> draftl = this.getAdvertisements();
        draftl.addAll(value);
    }

}
