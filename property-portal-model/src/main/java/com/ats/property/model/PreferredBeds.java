package com.ats.property.model;

import javax.persistence.*;

/**
 * The PreferredBeds.
 *
 * @author anbarasan.s
 */
@Entity
public class PreferredBeds {
    private Long id;
    private Long propertyRequirementId;
    private Long bedRoomId;
    private PropertyRequirement propertyRequirementByPropertyRequirementId;
    private Bedroom bedroomByBedRoomId;

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
    @Column(name = "propertyRequirementId", nullable = true, insertable = false, updatable = false)
    public Long getPropertyRequirementId() {
        return propertyRequirementId;
    }

    public void setPropertyRequirementId(Long propertyRequirementId) {
        this.propertyRequirementId = propertyRequirementId;
    }

    @Basic
    @Column(name = "bedRoomId", nullable = true, insertable = false, updatable = false)
    public Long getBedRoomId() {
        return bedRoomId;
    }

    public void setBedRoomId(Long bedRoomId) {
        this.bedRoomId = bedRoomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreferredBeds that = (PreferredBeds) o;

        if (bedRoomId != null ? !bedRoomId.equals(that.bedRoomId) : that.bedRoomId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (propertyRequirementId != null ? !propertyRequirementId.equals(that.propertyRequirementId) : that.propertyRequirementId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (propertyRequirementId != null ? propertyRequirementId.hashCode() : 0);
        result = 31 * result + (bedRoomId != null ? bedRoomId.hashCode() : 0);
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
    @JoinColumn(name = "bedRoomId", referencedColumnName = "id")
    public Bedroom getBedroomByBedRoomId() {
        return bedroomByBedRoomId;
    }

    public void setBedroomByBedRoomId(Bedroom bedroomByBedRoomId) {
        this.bedroomByBedRoomId = bedroomByBedRoomId;
    }
}
