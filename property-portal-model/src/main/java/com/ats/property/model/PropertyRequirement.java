package com.ats.property.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * The PropertyRequirement.
 *
 * @author anbarasan.s
 */
@Entity
public class PropertyRequirement {
    private Long id;
    private Long propertyUserId;
    private Long propertyForTypeId;
    private Double buildupAreaFrom;
    private Double buildupAreaTo;
    private Long buildupAreaUnitId;
    private Long budgetId;
    private Long alertFrequency;
    private Date registeredDate;
    private Integer isActive;
    private Collection<PreferredBeds> preferredBedsesById;
    private Collection<PreferredLocations> preferredLocationsesById;
    private PropertyUser propertyUserByPropertyUserId;
    private PropertyForType propertyForTypeByPropertyForTypeId;
    private UnitMaster unitMasterByBuildupAreaUnitId;
    private Budget budgetByBudgetId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "propertyUserId", nullable = true, insertable = false, updatable = false)
    public Long getPropertyUserId() {
        return propertyUserId;
    }

    public void setPropertyUserId(Long propertyUserId) {
        this.propertyUserId = propertyUserId;
    }

    @Basic
    @Column(name = "propertyForTypeId", nullable = true, insertable = false, updatable = false)
    public Long getPropertyForTypeId() {
        return propertyForTypeId;
    }

    public void setPropertyForTypeId(Long propertyForTypeId) {
        this.propertyForTypeId = propertyForTypeId;
    }

    @Basic
    @Column(name = "buildupAreaFrom", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getBuildupAreaFrom() {
        return buildupAreaFrom;
    }

    public void setBuildupAreaFrom(Double buildupAreaFrom) {
        this.buildupAreaFrom = buildupAreaFrom;
    }

    @Basic
    @Column(name = "buildupAreaTo", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getBuildupAreaTo() {
        return buildupAreaTo;
    }

    public void setBuildupAreaTo(Double buildupAreaTo) {
        this.buildupAreaTo = buildupAreaTo;
    }

    @Basic
    @Column(name = "buildupAreaUnitId", nullable = true, insertable = false, updatable = false)
    public Long getBuildupAreaUnitId() {
        return buildupAreaUnitId;
    }

    public void setBuildupAreaUnitId(Long buildupAreaUnitId) {
        this.buildupAreaUnitId = buildupAreaUnitId;
    }

    @Basic
    @Column(name = "budgetId", nullable = true, insertable = false, updatable = false)
    public Long getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    @Basic
    @Column(name = "alertFrequency", nullable = true, insertable = true, updatable = true)
    public Long getAlertFrequency() {
        return alertFrequency;
    }

    public void setAlertFrequency(Long alertFrequency) {
        this.alertFrequency = alertFrequency;
    }

    @Basic
    @Column(name = "registeredDate", nullable = true, insertable = true, updatable = true)
    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Basic
    @Column(name = "isActive", nullable = true, insertable = true, updatable = true)
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyRequirement that = (PropertyRequirement) o;

        if (alertFrequency != null ? !alertFrequency.equals(that.alertFrequency) : that.alertFrequency != null)
            return false;
        if (budgetId != null ? !budgetId.equals(that.budgetId) : that.budgetId != null) return false;
        if (buildupAreaFrom != null ? !buildupAreaFrom.equals(that.buildupAreaFrom) : that.buildupAreaFrom != null)
            return false;
        if (buildupAreaTo != null ? !buildupAreaTo.equals(that.buildupAreaTo) : that.buildupAreaTo != null)
            return false;
        if (buildupAreaUnitId != null ? !buildupAreaUnitId.equals(that.buildupAreaUnitId) : that.buildupAreaUnitId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
        if (propertyForTypeId != null ? !propertyForTypeId.equals(that.propertyForTypeId) : that.propertyForTypeId != null)
            return false;
        if (propertyUserId != null ? !propertyUserId.equals(that.propertyUserId) : that.propertyUserId != null)
            return false;
        if (registeredDate != null ? !registeredDate.equals(that.registeredDate) : that.registeredDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (propertyUserId != null ? propertyUserId.hashCode() : 0);
        result = 31 * result + (propertyForTypeId != null ? propertyForTypeId.hashCode() : 0);
        result = 31 * result + (buildupAreaFrom != null ? buildupAreaFrom.hashCode() : 0);
        result = 31 * result + (buildupAreaTo != null ? buildupAreaTo.hashCode() : 0);
        result = 31 * result + (buildupAreaUnitId != null ? buildupAreaUnitId.hashCode() : 0);
        result = 31 * result + (budgetId != null ? budgetId.hashCode() : 0);
        result = 31 * result + (alertFrequency != null ? alertFrequency.hashCode() : 0);
        result = 31 * result + (registeredDate != null ? registeredDate.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "propertyRequirementByPropertyRequirementId")
    public Collection<PreferredBeds> getPreferredBedsesById() {
        return preferredBedsesById;
    }

    public void setPreferredBedsesById(Collection<PreferredBeds> preferredBedsesById) {
        this.preferredBedsesById = preferredBedsesById;
    }

    @OneToMany(mappedBy = "propertyRequirementByPropertyRequirementId")
    public Collection<PreferredLocations> getPreferredLocationsesById() {
        return preferredLocationsesById;
    }

    public void setPreferredLocationsesById(Collection<PreferredLocations> preferredLocationsesById) {
        this.preferredLocationsesById = preferredLocationsesById;
    }

    @ManyToOne
    @JoinColumn(name = "propertyUserId", referencedColumnName = "id")
    public PropertyUser getPropertyUserByPropertyUserId() {
        return propertyUserByPropertyUserId;
    }

    public void setPropertyUserByPropertyUserId(PropertyUser propertyUserByPropertyUserId) {
        this.propertyUserByPropertyUserId = propertyUserByPropertyUserId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyForTypeId", referencedColumnName = "id")
    public PropertyForType getPropertyForTypeByPropertyForTypeId() {
        return propertyForTypeByPropertyForTypeId;
    }

    public void setPropertyForTypeByPropertyForTypeId(PropertyForType propertyForTypeByPropertyForTypeId) {
        this.propertyForTypeByPropertyForTypeId = propertyForTypeByPropertyForTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "buildupAreaUnitId", referencedColumnName = "id")
    public UnitMaster getUnitMasterByBuildupAreaUnitId() {
        return unitMasterByBuildupAreaUnitId;
    }

    public void setUnitMasterByBuildupAreaUnitId(UnitMaster unitMasterByBuildupAreaUnitId) {
        this.unitMasterByBuildupAreaUnitId = unitMasterByBuildupAreaUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "budgetId", referencedColumnName = "id")
    public Budget getBudgetByBudgetId() {
        return budgetByBudgetId;
    }

    public void setBudgetByBudgetId(Budget budgetByBudgetId) {
        this.budgetByBudgetId = budgetByBudgetId;
    }
}
