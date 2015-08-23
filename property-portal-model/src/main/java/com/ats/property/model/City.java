package com.ats.property.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * The City.
 *
 * @author anbarasan.s
 */
@Entity
public class City {
    private Long id;
    private String name;
    private Long stateId;
    private State stateByStateId;
    private Collection<Locations> locationsesById;
    private Byte isPopular;

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
    @Column(name = "stateId", nullable = true, insertable = false, updatable = false)
    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (stateId != null ? !stateId.equals(city.stateId) : city.stateId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (stateId != null ? stateId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "stateId", referencedColumnName = "id")
    public State getStateByStateId() {
        return stateByStateId;
    }

    public void setStateByStateId(State stateByStateId) {
        this.stateByStateId = stateByStateId;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<Locations> getLocationsesById() {
        return locationsesById;
    }

    public void setLocationsesById(Collection<Locations> locationsesById) {
        this.locationsesById = locationsesById;
    }

    @Basic
    @Column(name = "isPopular", nullable = true, insertable = true, updatable = true)
    public Byte getIsPopular() {
        return isPopular;
    }

    public void setIsPopular(Byte isPopular) {
        this.isPopular = isPopular;
    }
}
