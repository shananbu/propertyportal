//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.03 at 03:51:00 PM IST 
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
 * <p>Java class for planType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="numberOfImages" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="userTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="userTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lineByeLineDescription" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="validDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="postPropertyUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planType", propOrder = {
    "id",
    "name",
    "cost",
    "numberOfImages",
    "userTypeId",
    "userTypeName",
    "description",
    "lineByeLineDescription",
    "validDays",
    "postPropertyUrl"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class PlanType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long id;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String name;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Float cost;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Integer numberOfImages;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long userTypeId;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String userTypeName;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String description;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<String> lineByeLineDescription;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Integer validDays;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String postPropertyUrl;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Float getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setCost(Float value) {
        this.cost = value;
    }

    /**
     * Gets the value of the numberOfImages property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Integer getNumberOfImages() {
        return numberOfImages;
    }

    /**
     * Sets the value of the numberOfImages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setNumberOfImages(Integer value) {
        this.numberOfImages = value;
    }

    /**
     * Gets the value of the userTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setUserTypeId(Long value) {
        this.userTypeId = value;
    }

    /**
     * Gets the value of the userTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getUserTypeName() {
        return userTypeName;
    }

    /**
     * Sets the value of the userTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setUserTypeName(String value) {
        this.userTypeName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the lineByeLineDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineByeLineDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineByeLineDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<String> getLineByeLineDescription() {
        if (lineByeLineDescription == null) {
            lineByeLineDescription = new ArrayList<String>();
        }
        return this.lineByeLineDescription;
    }

    /**
     * Gets the value of the validDays property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public Integer getValidDays() {
        return validDays;
    }

    /**
     * Sets the value of the validDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setValidDays(Integer value) {
        this.validDays = value;
    }

    /**
     * Gets the value of the postPropertyUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public String getPostPropertyUrl() {
        return postPropertyUrl;
    }

    /**
     * Sets the value of the postPropertyUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setPostPropertyUrl(String value) {
        this.postPropertyUrl = value;
    }

    public void setLineByeLineDescription(List<String> value) {
        List<String> draftl = this.getLineByeLineDescription();
        draftl.addAll(value);
    }

}
