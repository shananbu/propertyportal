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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for moduleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="moduleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="moduleRequest" type="{}moduleRequestType"/>
 *           &lt;element name="moduleResponse" type="{}moduleResponseType"/>
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
@XmlType(name = "moduleType", propOrder = {
    "moduleRequest",
    "moduleResponse"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class ModuleType {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected ModuleRequestType moduleRequest;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected ModuleResponseType moduleResponse;

    /**
     * Gets the value of the moduleRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleRequestType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public ModuleRequestType getModuleRequest() {
        return moduleRequest;
    }

    /**
     * Sets the value of the moduleRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleRequestType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setModuleRequest(ModuleRequestType value) {
        this.moduleRequest = value;
    }

    /**
     * Gets the value of the moduleResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleResponseType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public ModuleResponseType getModuleResponse() {
        return moduleResponse;
    }

    /**
     * Sets the value of the moduleResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleResponseType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2015-09-01T11:38:23+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public void setModuleResponse(ModuleResponseType value) {
        this.moduleResponse = value;
    }

}
