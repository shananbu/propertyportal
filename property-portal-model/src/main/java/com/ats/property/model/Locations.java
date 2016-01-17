package com.ats.property.model;

import javax.persistence.*;

/**
 * The Locations.
 *
 * @author anbarasan.s
 */
@Entity
public class Locations {
    private Long id;
    private String name;
    private Long cityId;
    private City cityByCityId;
    private Long pincode;

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
    @Column(name = "cityId", nullable = true, insertable = false, updatable = false)
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locations locations = (Locations) o;

        if (cityId != null ? !cityId.equals(locations.cityId) : locations.cityId != null) return false;
        if (id != null ? !id.equals(locations.id) : locations.id != null) return false;
        if (name != null ? !name.equals(locations.name) : locations.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cityId", referencedColumnName = "id")
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }
}
