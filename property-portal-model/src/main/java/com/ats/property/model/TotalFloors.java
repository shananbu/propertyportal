package com.ats.property.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The TotalFloors.
 *
 * @author anbarasan.s
 */
@Entity
public class TotalFloors {
    private Long id;
    private String name;
    private Long floors;

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
    @Column(name = "floors", nullable = true, insertable = true, updatable = true)
    public Long getFloors() {
        return floors;
    }

    public void setFloors(Long floors) {
        this.floors = floors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TotalFloors that = (TotalFloors) o;

        if (floors != null ? !floors.equals(that.floors) : that.floors != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (floors != null ? floors.hashCode() : 0);
        return result;
    }
}
