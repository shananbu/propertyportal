package com.ats.property.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * The FacingMast.
 *
 * @author anbarasan.s
 */
@Entity
public class FacingMast {
    private Long id;
    private String name;
    private Collection<AdvertisementDetails> advertisementDetailsesById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacingMast that = (FacingMast) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "facingMastByFacingId")
    public Collection<AdvertisementDetails> getAdvertisementDetailsesById() {
        return advertisementDetailsesById;
    }

    public void setAdvertisementDetailsesById(Collection<AdvertisementDetails> advertisementDetailsesById) {
        this.advertisementDetailsesById = advertisementDetailsesById;
    }
}
