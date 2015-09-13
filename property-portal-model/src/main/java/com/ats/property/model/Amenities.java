package com.ats.property.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * The Amenities.
 *
 * @author anbarasan.s
 */
@Entity
public class Amenities {
    private Long id;
    private Long amenitiesCategoryId;
    private String name;
    private Integer displayOrder;
    private AmenitiesCategory amenitiesCategoryByAmenitiesCategoryId;
    private Collection<PropertyAmenities> propertyAmenitiesesById;

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
    @Column(name = "amenitiesCategoryId", nullable = true, insertable = false, updatable = false)
    public Long getAmenitiesCategoryId() {
        return amenitiesCategoryId;
    }

    public void setAmenitiesCategoryId(Long amenitiesCategoryId) {
        this.amenitiesCategoryId = amenitiesCategoryId;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "displayOrder", nullable = true, insertable = true, updatable = true)
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amenities amenities = (Amenities) o;

        if (amenitiesCategoryId != null ? !amenitiesCategoryId.equals(amenities.amenitiesCategoryId) : amenities.amenitiesCategoryId != null)
            return false;
        if (displayOrder != null ? !displayOrder.equals(amenities.displayOrder) : amenities.displayOrder != null)
            return false;
        if (id != null ? !id.equals(amenities.id) : amenities.id != null) return false;
        if (name != null ? !name.equals(amenities.name) : amenities.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amenitiesCategoryId != null ? amenitiesCategoryId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (displayOrder != null ? displayOrder.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "amenitiesCategoryId", referencedColumnName = "id")
    public AmenitiesCategory getAmenitiesCategoryByAmenitiesCategoryId() {
        return amenitiesCategoryByAmenitiesCategoryId;
    }

    public void setAmenitiesCategoryByAmenitiesCategoryId(AmenitiesCategory amenitiesCategoryByAmenitiesCategoryId) {
        this.amenitiesCategoryByAmenitiesCategoryId = amenitiesCategoryByAmenitiesCategoryId;
    }

    @OneToMany(mappedBy = "amenitiesByAmenitiesId")
    public Collection<PropertyAmenities> getPropertyAmenitiesesById() {
        return propertyAmenitiesesById;
    }

    public void setPropertyAmenitiesesById(Collection<PropertyAmenities> propertyAmenitiesesById) {
        this.propertyAmenitiesesById = propertyAmenitiesesById;
    }
}
