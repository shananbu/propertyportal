package com.ats.property.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Balconies.
 *
 * @author anbarasan.s
 */
@Entity
public class Balconies {
    private Long id;
    private String name;
    private Long balconies;

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
    @Column(name = "balconies", nullable = true, insertable = true, updatable = true)
    public Long getBalconies() {
        return balconies;
    }

    public void setBalconies(Long balconies) {
        this.balconies = balconies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balconies balconies1 = (Balconies) o;

        if (balconies != null ? !balconies.equals(balconies1.balconies) : balconies1.balconies != null) return false;
        if (id != null ? !id.equals(balconies1.id) : balconies1.id != null) return false;
        if (name != null ? !name.equals(balconies1.name) : balconies1.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (balconies != null ? balconies.hashCode() : 0);
        return result;
    }
}
