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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for moduleList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="moduleList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="module" type="{}moduleType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="messages" type="{}messageType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moduleList", propOrder = {
    "module",
    "messages"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
public class ModuleList {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<ModuleType> module;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    protected List<MessageType> messages;

    /**
     * Gets the value of the module property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the module property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModuleType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<ModuleType> getModule() {
        if (module == null) {
            module = new ArrayList<ModuleType>();
        }
        return this.module;
    }

    /**
     * Gets the value of the messages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-04-03T03:51:00+05:30", comments = "JAXB RI vhudson-jaxb-ri-2.1-833")
    public List<MessageType> getMessages() {
        if (messages == null) {
            messages = new ArrayList<MessageType>();
        }
        return this.messages;
    }

    public void setModule(List<ModuleType> value) {
        List<ModuleType> draftl = this.getModule();
        draftl.addAll(value);
    }

    public void setMessages(List<MessageType> value) {
        List<MessageType> draftl = this.getMessages();
        draftl.addAll(value);
    }

}
