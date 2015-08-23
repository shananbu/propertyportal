package com.ats.property.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * The StatusMast.
 *
 * @author anbarasan.s
 */
@Entity
public class StatusMast {
    private Long id;
    private String name;
    private String target;
    private Collection<AdminLogin> adminLoginsById;

    @Id
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
    @Column(name = "target", nullable = true, insertable = true, updatable = true, length = 50)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusMast that = (StatusMast) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "statusMastByStatusId")
    public Collection<AdminLogin> getAdminLoginsById() {
        return adminLoginsById;
    }

    public void setAdminLoginsById(Collection<AdminLogin> adminLoginsById) {
        this.adminLoginsById = adminLoginsById;
    }
}
