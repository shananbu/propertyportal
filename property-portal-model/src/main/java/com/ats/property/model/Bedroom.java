package com.ats.property.model;

import javax.persistence.*;

/**
 * The Bedroom.
 *
 * @author anbarasan.s
 */
@Entity
public class Bedroom {
    private Long id;
    private String name;
    private Long bedrooms;

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
    @Column(name = "bedrooms", nullable = true, insertable = true, updatable = true)
    public Long getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Long bedrooms) {
        this.bedrooms = bedrooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bedroom bedroom = (Bedroom) o;

        if (bedrooms != null ? !bedrooms.equals(bedroom.bedrooms) : bedroom.bedrooms != null) return false;
        if (id != null ? !id.equals(bedroom.id) : bedroom.id != null) return false;
        if (name != null ? !name.equals(bedroom.name) : bedroom.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (bedrooms != null ? bedrooms.hashCode() : 0);
        return result;
    }
}
