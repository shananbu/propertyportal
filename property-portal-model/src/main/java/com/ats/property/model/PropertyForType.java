package com.ats.property.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * The PropertyForType.
 *
 * @author anbarasan.s
 */
@Entity
public class PropertyForType {
    private Long id;
    private String nameForPoster;
    private String nameForFinder;
    private Collection<PropertyRequirement> propertyRequirementsById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nameForPoster", nullable = true, insertable = true, updatable = true, length = 25)
    public String getNameForPoster() {
        return nameForPoster;
    }

    public void setNameForPoster(String nameForPoster) {
        this.nameForPoster = nameForPoster;
    }

    @Basic
    @Column(name = "nameForFinder", nullable = true, insertable = true, updatable = true, length = 25)
    public String getNameForFinder() {
        return nameForFinder;
    }

    public void setNameForFinder(String nameForFinder) {
        this.nameForFinder = nameForFinder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyForType that = (PropertyForType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nameForFinder != null ? !nameForFinder.equals(that.nameForFinder) : that.nameForFinder != null)
            return false;
        if (nameForPoster != null ? !nameForPoster.equals(that.nameForPoster) : that.nameForPoster != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameForPoster != null ? nameForPoster.hashCode() : 0);
        result = 31 * result + (nameForFinder != null ? nameForFinder.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "propertyForTypeByPropertyForTypeId")
    public Collection<PropertyRequirement> getPropertyRequirementsById() {
        return propertyRequirementsById;
    }

    public void setPropertyRequirementsById(Collection<PropertyRequirement> propertyRequirementsById) {
        this.propertyRequirementsById = propertyRequirementsById;
    }
}
