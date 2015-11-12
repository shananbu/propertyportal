package com.ats.property.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * The Budget.
 *
 * @author anbarasan.s
 */
@Entity
public class Budget {
    private Long id;
    private String name;
    private Long fromlevel;
    private Long tolevel;
    private String currencyVal;
    private Collection<PropertyRequirement> propertyRequirementsById;
    private PropertyForType propertyForTypeByPropertyForTypeId;
    private Long propertyForTypeId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "fromlevel", nullable = true, insertable = true, updatable = true)
    public Long getFromlevel() {
        return fromlevel;
    }

    public void setFromlevel(Long fromlevel) {
        this.fromlevel = fromlevel;
    }

    @Basic
    @Column(name = "tolevel", nullable = true, insertable = true, updatable = true)
    public Long getTolevel() {
        return tolevel;
    }

    public void setTolevel(Long tolevel) {
        this.tolevel = tolevel;
    }

    @Basic
    @Column(name = "currencyVal", nullable = true, insertable = true, updatable = true, length = 25)
    public String getCurrencyVal() {
        return currencyVal;
    }

    public void setCurrencyVal(String currencyVal) {
        this.currencyVal = currencyVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Budget budget = (Budget) o;

        if (currencyVal != null ? !currencyVal.equals(budget.currencyVal) : budget.currencyVal != null) return false;
        if (fromlevel != null ? !fromlevel.equals(budget.fromlevel) : budget.fromlevel != null) return false;
        if (id != null ? !id.equals(budget.id) : budget.id != null) return false;
        if (name != null ? !name.equals(budget.name) : budget.name != null) return false;
        if (tolevel != null ? !tolevel.equals(budget.tolevel) : budget.tolevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (fromlevel != null ? fromlevel.hashCode() : 0);
        result = 31 * result + (tolevel != null ? tolevel.hashCode() : 0);
        result = 31 * result + (currencyVal != null ? currencyVal.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "budgetByBudgetId")
    public Collection<PropertyRequirement> getPropertyRequirementsById() {
        return propertyRequirementsById;
    }

    public void setPropertyRequirementsById(Collection<PropertyRequirement> propertyRequirementsById) {
        this.propertyRequirementsById = propertyRequirementsById;
    }

    @Basic
    @Column(name = "propertyForTypeId", nullable = true, insertable = false, updatable = false)
    public Long getPropertyForTypeId() {
        return propertyForTypeId;
    }

    public void setPropertyForTypeId(Long propertyForTypeId) {
        this.propertyForTypeId = propertyForTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyForTypeId", referencedColumnName = "id")
    public PropertyForType getPropertyForTypeByPropertyForTypeId() {
        return propertyForTypeByPropertyForTypeId;
    }

    public void setPropertyForTypeByPropertyForTypeId(PropertyForType propertyForTypeByPropertyForTypeId) {
        this.propertyForTypeByPropertyForTypeId = propertyForTypeByPropertyForTypeId;
    }
}
