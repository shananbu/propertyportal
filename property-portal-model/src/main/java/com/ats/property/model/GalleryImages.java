package com.ats.property.model;

import javax.persistence.*;

/**
 * The GalleryImages.
 *
 * @author anbarasan.s
 */
@Entity
public class GalleryImages {
    private Long id;
    private String imageName;
    private Advertisement advertisementByAdvertisementId;
    private ImageType imageTypeByImageTypeId;
    private Long advertisementId;
    private Long imageTypeId;

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
    @Column(name = "imageName", nullable = true, insertable = true, updatable = true, length = 50)
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GalleryImages that = (GalleryImages) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (imageName != null ? !imageName.equals(that.imageName) : that.imageName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (imageName != null ? imageName.hashCode() : 0);
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
    @JoinColumn(name = "imageTypeId", referencedColumnName = "id")
    public ImageType getImageTypeByImageTypeId() {
        return imageTypeByImageTypeId;
    }

    public void setImageTypeByImageTypeId(ImageType imageTypeByImageTypeId) {
        this.imageTypeByImageTypeId = imageTypeByImageTypeId;
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
    @Column(name = "imageTypeId", nullable = true, insertable = false, updatable = false)
    public Long getImageTypeId() {
        return imageTypeId;
    }

    public void setImageTypeId(Long imageTypeId) {
        this.imageTypeId = imageTypeId;
    }
}
