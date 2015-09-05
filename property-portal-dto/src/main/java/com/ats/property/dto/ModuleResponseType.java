//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.04 at 08:43:10 PM IST 
//


package com.ats.property.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for moduleResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="moduleResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="authenticationData" type="{}authenticationResponseType"/>
 *           &lt;element name="countryData" type="{}countryType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="statusData" type="{}statusType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="adminUsers" type="{}adminUserType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="plans" type="{}planType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="countries" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="states" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="cities" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="locations" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="userType" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="bedrooms" type="{}bedroomType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="budgets" type="{}budgetType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="mainPropertyTypes" type="{}mainPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="bathrooms" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="furnishedStatus" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="propertyForTypes" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="balconies" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="totalFloors" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="units" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="transactionTypes" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="possessionStatus" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="terms" type="{}nameDataType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="advertisement" type="{}advertisementType" minOccurs="0"/>
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
@XmlType(name = "moduleResponseType", propOrder = {
    "authenticationData",
    "countryData",
    "statusData",
    "adminUsers",
    "plans",
    "countries",
    "states",
    "cities",
    "locations",
    "userType",
    "bedrooms",
    "budgets",
    "mainPropertyTypes",
    "bathrooms",
    "furnishedStatus",
    "propertyForTypes",
    "balconies",
    "totalFloors",
    "units",
    "transactionTypes",
    "possessionStatus",
    "terms",
    "advertisement"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class ModuleResponseType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected AuthenticationResponseType authenticationData;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<CountryType> countryData;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<StatusType> statusData;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<AdminUserType> adminUsers;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<PlanType> plans;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> countries;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> states;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> cities;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> locations;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> userType;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<BedroomType> bedrooms;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<BudgetType> budgets;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<MainPropertyType> mainPropertyTypes;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> bathrooms;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> furnishedStatus;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> propertyForTypes;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> balconies;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> totalFloors;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> units;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> transactionTypes;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> possessionStatus;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> terms;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected AdvertisementType advertisement;

    /**
     * Gets the value of the authenticationData property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationResponseType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public AuthenticationResponseType getAuthenticationData() {
        return authenticationData;
    }

    /**
     * Sets the value of the authenticationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationResponseType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setAuthenticationData(AuthenticationResponseType value) {
        this.authenticationData = value;
    }

    /**
     * Gets the value of the countryData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countryData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountryData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CountryType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<CountryType> getCountryData() {
        if (countryData == null) {
            countryData = new ArrayList<CountryType>();
        }
        return this.countryData;
    }

    /**
     * Gets the value of the statusData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statusData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatusData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<StatusType> getStatusData() {
        if (statusData == null) {
            statusData = new ArrayList<StatusType>();
        }
        return this.statusData;
    }

    /**
     * Gets the value of the adminUsers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adminUsers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdminUsers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdminUserType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<AdminUserType> getAdminUsers() {
        if (adminUsers == null) {
            adminUsers = new ArrayList<AdminUserType>();
        }
        return this.adminUsers;
    }

    /**
     * Gets the value of the plans property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plans property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlans().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlanType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<PlanType> getPlans() {
        if (plans == null) {
            plans = new ArrayList<PlanType>();
        }
        return this.plans;
    }

    /**
     * Gets the value of the countries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getCountries() {
        if (countries == null) {
            countries = new ArrayList<NameDataType>();
        }
        return this.countries;
    }

    /**
     * Gets the value of the states property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the states property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getStates() {
        if (states == null) {
            states = new ArrayList<NameDataType>();
        }
        return this.states;
    }

    /**
     * Gets the value of the cities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getCities() {
        if (cities == null) {
            cities = new ArrayList<NameDataType>();
        }
        return this.cities;
    }

    /**
     * Gets the value of the locations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getLocations() {
        if (locations == null) {
            locations = new ArrayList<NameDataType>();
        }
        return this.locations;
    }

    /**
     * Gets the value of the userType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getUserType() {
        if (userType == null) {
            userType = new ArrayList<NameDataType>();
        }
        return this.userType;
    }

    /**
     * Gets the value of the bedrooms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedrooms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedrooms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BedroomType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<BedroomType> getBedrooms() {
        if (bedrooms == null) {
            bedrooms = new ArrayList<BedroomType>();
        }
        return this.bedrooms;
    }

    /**
     * Gets the value of the budgets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the budgets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBudgets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BudgetType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<BudgetType> getBudgets() {
        if (budgets == null) {
            budgets = new ArrayList<BudgetType>();
        }
        return this.budgets;
    }

    /**
     * Gets the value of the mainPropertyTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mainPropertyTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMainPropertyTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MainPropertyType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<MainPropertyType> getMainPropertyTypes() {
        if (mainPropertyTypes == null) {
            mainPropertyTypes = new ArrayList<MainPropertyType>();
        }
        return this.mainPropertyTypes;
    }

    /**
     * Gets the value of the bathrooms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bathrooms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBathrooms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getBathrooms() {
        if (bathrooms == null) {
            bathrooms = new ArrayList<NameDataType>();
        }
        return this.bathrooms;
    }

    /**
     * Gets the value of the furnishedStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the furnishedStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFurnishedStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getFurnishedStatus() {
        if (furnishedStatus == null) {
            furnishedStatus = new ArrayList<NameDataType>();
        }
        return this.furnishedStatus;
    }

    /**
     * Gets the value of the propertyForTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyForTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyForTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getPropertyForTypes() {
        if (propertyForTypes == null) {
            propertyForTypes = new ArrayList<NameDataType>();
        }
        return this.propertyForTypes;
    }

    /**
     * Gets the value of the balconies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the balconies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBalconies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getBalconies() {
        if (balconies == null) {
            balconies = new ArrayList<NameDataType>();
        }
        return this.balconies;
    }

    /**
     * Gets the value of the totalFloors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalFloors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalFloors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getTotalFloors() {
        if (totalFloors == null) {
            totalFloors = new ArrayList<NameDataType>();
        }
        return this.totalFloors;
    }

    /**
     * Gets the value of the units property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the units property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnits().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getUnits() {
        if (units == null) {
            units = new ArrayList<NameDataType>();
        }
        return this.units;
    }

    /**
     * Gets the value of the transactionTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getTransactionTypes() {
        if (transactionTypes == null) {
            transactionTypes = new ArrayList<NameDataType>();
        }
        return this.transactionTypes;
    }

    /**
     * Gets the value of the possessionStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the possessionStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPossessionStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getPossessionStatus() {
        if (possessionStatus == null) {
            possessionStatus = new ArrayList<NameDataType>();
        }
        return this.possessionStatus;
    }

    /**
     * Gets the value of the terms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the terms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getTerms() {
        if (terms == null) {
            terms = new ArrayList<NameDataType>();
        }
        return this.terms;
    }

    /**
     * Gets the value of the advertisement property.
     * 
     * @return
     *     possible object is
     *     {@link AdvertisementType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-04T08:43:10+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setAdvertisement(AdvertisementType value) {
        this.advertisement = value;
    }

}
