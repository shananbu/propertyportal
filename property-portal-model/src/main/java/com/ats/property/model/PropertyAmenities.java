package com.ats.property.model;

import javax.persistence.*;

/**
 * The PropertyAmenities.
 *
 * @author anbarasan.s
 */
@Entity
public class PropertyAmenities {
    private Long id;
    private Long advertisementId;
    private Long amenitiesId;
    private Advertisement advertisementByAdvertisementId;
    private Amenities amenitiesByAmenitiesId;

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
    @Column(name = "advertisementId", nullable = true, insertable = false, updatable = false)
    public Long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
    }

    @Basic
    @Column(name = "amenitiesId", nullable = true, insertable = false, updatable = false)
    public Long getAmenitiesId() {
        return amenitiesId;
    }

    public void setAmenitiesId(Long amenitiesId) {
        this.amenitiesId = amenitiesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyAmenities that = (PropertyAmenities) o;

        if (advertisementId != null ? !advertisementId.equals(that.advertisementId) : that.advertisementId != null)
            return false;
        if (amenitiesId != null ? !amenitiesId.equals(that.amenitiesId) : that.amenitiesId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (advertisementId != null ? advertisementId.hashCode() : 0);
        result = 31 * result + (amenitiesId != null ? amenitiesId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "advertisementId", referencedColumnName = "id")
    public Advertisement getAdvertisementByAdvertisementId() {
        return advertisementByAdvertisementId;
    }

    public void setAdvertisementByAdvertisementId(Advertisement advertisementByAdvertisementId) {
        this.advertisementByAdvertisementId = advertisementByAdvertisementId;
    }

    @ManyToOne
    @JoinColumn(name = "amenitiesId", referencedColumnName = "id")
    public Amenities getAmenitiesByAmenitiesId() {
        return amenitiesByAmenitiesId;
    }

    public void setAmenitiesByAmenitiesId(Amenities amenitiesByAmenitiesId) {
        this.amenitiesByAmenitiesId = amenitiesByAmenitiesId;
    }
}
