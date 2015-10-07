package com.ats.property.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * The ImageType.
 *
 * @author anbarasan.s
 */
@Entity
public class ImageType {
    private Long id;
    private String name;
    private Collection<GalleryImages> galleryImagesesById;
    private String label;
    private Integer imageOrder;
    private Boolean isActive;

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

        ImageType imageType = (ImageType) o;

        if (id != null ? !id.equals(imageType.id) : imageType.id != null) return false;
        if (name != null ? !name.equals(imageType.name) : imageType.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "imageTypeByImageTypeId")
    public Collection<GalleryImages> getGalleryImagesesById() {
        return galleryImagesesById;
    }

    public void setGalleryImagesesById(Collection<GalleryImages> galleryImagesesById) {
        this.galleryImagesesById = galleryImagesesById;
    }

    @Basic
    @Column(name = "label", nullable = true, insertable = true, updatable = true, length = 25)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "imageOrder", nullable = true, insertable = true, updatable = true)
    public Integer getImageOrder() {
        return imageOrder;
    }

    public void setImageOrder(Integer imageOrder) {
        this.imageOrder = imageOrder;
    }

    @Basic
    @Column(name = "isActive", nullable = true, insertable = true, updatable = true)
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
