//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.30 at 04:22:46 PM IST 
//


package com.ats.property.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ats.property.dto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ModuleList_QNAME = new QName("", "moduleList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ats.property.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MainPropertyType }
     * 
     */
    public MainPropertyType createMainPropertyType() {
        return new MainPropertyType();
    }

    /**
     * Create an instance of {@link ModuleList }
     * 
     */
    public ModuleList createModuleList() {
        return new ModuleList();
    }

    /**
     * Create an instance of {@link AdminUserType }
     * 
     */
    public AdminUserType createAdminUserType() {
        return new AdminUserType();
    }

    /**
     * Create an instance of {@link ModuleType }
     * 
     */
    public ModuleType createModuleType() {
        return new ModuleType();
    }

    /**
     * Create an instance of {@link NameDataType }
     * 
     */
    public NameDataType createNameDataType() {
        return new NameDataType();
    }

    /**
     * Create an instance of {@link PlanType }
     * 
     */
    public PlanType createPlanType() {
        return new PlanType();
    }

    /**
     * Create an instance of {@link StatusType }
     * 
     */
    public StatusType createStatusType() {
        return new StatusType();
    }

    /**
     * Create an instance of {@link ModuleRequestType }
     * 
     */
    public ModuleRequestType createModuleRequestType() {
        return new ModuleRequestType();
    }

    /**
     * Create an instance of {@link AdvertisementType }
     * 
     */
    public AdvertisementType createAdvertisementType() {
        return new AdvertisementType();
    }

    /**
     * Create an instance of {@link BedroomType }
     * 
     */
    public BedroomType createBedroomType() {
        return new BedroomType();
    }

    /**
     * Create an instance of {@link PropertyUserType }
     * 
     */
    public PropertyUserType createPropertyUserType() {
        return new PropertyUserType();
    }

    /**
     * Create an instance of {@link CountryType }
     * 
     */
    public CountryType createCountryType() {
        return new CountryType();
    }

    /**
     * Create an instance of {@link ModuleResponseType }
     * 
     */
    public ModuleResponseType createModuleResponseType() {
        return new ModuleResponseType();
    }

    /**
     * Create an instance of {@link BudgetType }
     * 
     */
    public BudgetType createBudgetType() {
        return new BudgetType();
    }

    /**
     * Create an instance of {@link MessageType }
     * 
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link StandardAuthRequestType }
     * 
     */
    public StandardAuthRequestType createStandardAuthRequestType() {
        return new StandardAuthRequestType();
    }

    /**
     * Create an instance of {@link AuthenticationResponseType }
     * 
     */
    public AuthenticationResponseType createAuthenticationResponseType() {
        return new AuthenticationResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModuleList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "moduleList")
    public JAXBElement<ModuleList> createModuleList(ModuleList value) {
        return new JAXBElement<ModuleList>(_ModuleList_QNAME, ModuleList.class, null, value);
    }

}
