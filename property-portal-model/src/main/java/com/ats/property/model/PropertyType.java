package com.ats.property.model;

import javax.persistence.*;

/**
 * The PropertyType.
 *
 * @author anbarasan.s
 */
@Entity
public class PropertyType {
    private Long id;
    private String name;
    private Long propertyMainTypeId;
    private PropertyMainType propertyMainTypeByPropertyMainTypeId;

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
    @Column(name = "propertyMainTypeId", nullable = true, insertable = false, updatable = false)
    public Long getPropertyMainTypeId() {
        return propertyMainTypeId;
    }

    public void setPropertyMainTypeId(Long propertyMainTypeId) {
        this.propertyMainTypeId = propertyMainTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyType that = (PropertyType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (propertyMainTypeId != null ? !propertyMainTypeId.equals(that.propertyMainTypeId) : that.propertyMainTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (propertyMainTypeId != null ? propertyMainTypeId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "propertyMainTypeId", referencedColumnName = "id")
    public PropertyMainType getPropertyMainTypeByPropertyMainTypeId() {
        return propertyMainTypeByPropertyMainTypeId;
    }

    public void setPropertyMainTypeByPropertyMainTypeId(PropertyMainType propertyMainTypeByPropertyMainTypeId) {
        this.propertyMainTypeByPropertyMainTypeId = propertyMainTypeByPropertyMainTypeId;
    }
}
