//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.12 at 11:11:07 PM IST 
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
 * <p>Java class for amenitiesCategoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="amenitiesCategoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="amenitiesesById" type="{}nameDataType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "amenitiesCategoryType", propOrder = {
    "id",
    "name",
    "amenitiesesById"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-12T11:11:07+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class AmenitiesCategoryType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-12T11:11:07+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected Long id;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-12T11:11:07+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected String name;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-12T11:11:07+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<NameDataType> amenitiesesById;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-12T11:11:07+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-12T11:11:07+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-12T11:11:07+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-12T11:11:07+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the amenitiesesById property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the amenitiesesById property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmenitiesesById().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameDataType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-10-12T11:11:07+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<NameDataType> getAmenitiesesById() {
        if (amenitiesesById == null) {
            amenitiesesById = new ArrayList<NameDataType>();
        }
        return this.amenitiesesById;
    }

    public void setAmenitiesesById(List<NameDataType> value) {
        List<NameDataType> draftl = this.getAmenitiesesById();
        draftl.addAll(value);
    }

}
