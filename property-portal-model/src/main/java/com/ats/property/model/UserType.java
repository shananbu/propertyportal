package com.ats.property.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * The UserType.
 *
 * @author anbarasan.s
 */
@Entity
public class UserType {
    private Long id;
    private String name;
    private Collection<PlanMast> planMastsById;
    private String shortName;
    private String postPropertyUrl;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserType userType = (UserType) o;

        if (id != null ? !id.equals(userType.id) : userType.id != null) return false;
        if (name != null ? !name.equals(userType.name) : userType.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userTypeByUserTypeId")
    public Collection<PlanMast> getPlanMastsById() {
        return planMastsById;
    }

    public void setPlanMastsById(Collection<PlanMast> planMastsById) {
        this.planMastsById = planMastsById;
    }

    @Basic
    @Column(name = "shortName", nullable = true, insertable = true, updatable = true, length = 60)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "postPropertyUrl", nullable = true, insertable = true, updatable = true, length = 60)
    public String getPostPropertyUrl() {
        return postPropertyUrl;
    }

    public void setPostPropertyUrl(String postPropertyUrl) {
        this.postPropertyUrl = postPropertyUrl;
    }
}
