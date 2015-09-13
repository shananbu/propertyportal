package com.ats.property.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * The AmenitiesCategory.
 *
 * @author anbarasan.s
 */
@Entity
public class AmenitiesCategory {
    private Long id;
    private String name;
    private Integer displayOrder;
    private Collection<Amenities> amenitiesesById;

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

        AmenitiesCategory that = (AmenitiesCategory) o;

        if (displayOrder != null ? !displayOrder.equals(that.displayOrder) : that.displayOrder != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (displayOrder != null ? displayOrder.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "amenitiesCategoryByAmenitiesCategoryId")
    public Collection<Amenities> getAmenitiesesById() {
        return amenitiesesById;
    }

    public void setAmenitiesesById(Collection<Amenities> amenitiesesById) {
        this.amenitiesesById = amenitiesesById;
    }
}
