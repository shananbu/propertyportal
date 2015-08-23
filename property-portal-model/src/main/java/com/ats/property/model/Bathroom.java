package com.ats.property.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Bathroom.
 *
 * @author anbarasan.s
 */
@Entity
public class Bathroom {
    private Long id;
    private String name;
    private Long bathrooms;

    @Id
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
    @Column(name = "bathrooms", nullable = true, insertable = true, updatable = true)
    public Long getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Long bathrooms) {
        this.bathrooms = bathrooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bathroom bathroom = (Bathroom) o;

        if (bathrooms != null ? !bathrooms.equals(bathroom.bathrooms) : bathroom.bathrooms != null) return false;
        if (id != null ? !id.equals(bathroom.id) : bathroom.id != null) return false;
        if (name != null ? !name.equals(bathroom.name) : bathroom.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (bathrooms != null ? bathrooms.hashCode() : 0);
        return result;
    }
}
