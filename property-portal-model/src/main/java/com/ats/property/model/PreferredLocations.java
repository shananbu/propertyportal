package com.ats.property.model;

import javax.persistence.*;

/**
 * The PreferredLocations.
 *
 * @author anbarasan.s
 */
@Entity
public class PreferredLocations {
    private Long id;
    private Long propertyRequirementId;
    private Long locationId;
    private PropertyRequirement propertyRequirementByPropertyRequirementId;
    private Locations locationsByLocationId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "propertyRequirementId", nullable = true, insertable = false, updatable = false)
    public Long getPropertyRequirementId() {
        return propertyRequirementId;
    }

    public void setPropertyRequirementId(Long propertyRequirementId) {
        this.propertyRequirementId = propertyRequirementId;
    }

    @Basic
    @Column(name = "locationId", nullable = true, insertable = false, updatable = false)
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreferredLocations that = (PreferredLocations) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (locationId != null ? !locationId.equals(that.locationId) : that.locationId != null) return false;
        if (propertyRequirementId != null ? !propertyRequirementId.equals(that.propertyRequirementId) : that.propertyRequirementId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (propertyRequirementId != null ? propertyRequirementId.hashCode() : 0);
        result = 31 * result + (locationId != null ? locationId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "propertyRequirementId", referencedColumnName = "id")
    public PropertyRequirement getPropertyRequirementByPropertyRequirementId() {
        return propertyRequirementByPropertyRequirementId;
    }

    public void setPropertyRequirementByPropertyRequirementId(PropertyRequirement propertyRequirementByPropertyRequirementId) {
        this.propertyRequirementByPropertyRequirementId = propertyRequirementByPropertyRequirementId;
    }

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    public Locations getLocationsByLocationId() {
        return locationsByLocationId;
    }

    public void setLocationsByLocationId(Locations locationsByLocationId) {
        this.locationsByLocationId = locationsByLocationId;
    }
}
