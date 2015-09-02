package com.ats.property.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * The Advertisement.
 *
 * @author anbarasan.s
 */
@Entity
public class Advertisement {
    private Long id;
    private String address;
    private String projectName;
    private String description;
    private String propertyFeatures;
    private String isTermsAgreed;
    private PropertyOwnershipType propertyOwnershipTypeByPropertyOwnershipId;
    private PossessionOrAge possessionOrAgeByPossessionOrAgeId;
    private Long propertyForTypeId;
    private Long propertyTypeId;
    private Long locationId;
    private Long transactionTypeId;
    private Long propertyOwnershipId;
    private Long possessionStatusId;
    private Long possessionOrAgeId;
    private PropertyType propertyTypeByPropertyTypeId;
    private Locations locationsByLocationId;
    private TransactionType transactionTypeByTransactionTypeId;
    private PossessionStatus possessionStatusByPossessionStatusId;
    private PropertyForType propertyForTypeByPropertyForTypeId;
    private Collection<AdvertisementDetails> advertisementDetailsesById;
    private Collection<GalleryImages> galleryImagesesById;
    private Collection<MorePropertyDetails> morePropertyDetailsesById;
    private Collection<Residential> residentialsById;
    private Long planId;
    private PlanMast planMastByPlanId;

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
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "projectName", nullable = true, insertable = true, updatable = true, length = 100)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "propertyFeatures", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getPropertyFeatures() {
        return propertyFeatures;
    }

    public void setPropertyFeatures(String propertyFeatures) {
        this.propertyFeatures = propertyFeatures;
    }

    @Basic
    @Column(name = "isTermsAgreed", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsTermsAgreed() {
        return isTermsAgreed;
    }

    public void setIsTermsAgreed(String isTermsAgreed) {
        this.isTermsAgreed = isTermsAgreed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advertisement that = (Advertisement) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isTermsAgreed != null ? !isTermsAgreed.equals(that.isTermsAgreed) : that.isTermsAgreed != null)
            return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (propertyFeatures != null ? !propertyFeatures.equals(that.propertyFeatures) : that.propertyFeatures != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (propertyFeatures != null ? propertyFeatures.hashCode() : 0);
        result = 31 * result + (isTermsAgreed != null ? isTermsAgreed.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "propertyOwnershipId", referencedColumnName = "id")
    public PropertyOwnershipType getPropertyOwnershipTypeByPropertyOwnershipId() {
        return propertyOwnershipTypeByPropertyOwnershipId;
    }

    public void setPropertyOwnershipTypeByPropertyOwnershipId(PropertyOwnershipType propertyOwnershipTypeByPropertyOwnershipId) {
        this.propertyOwnershipTypeByPropertyOwnershipId = propertyOwnershipTypeByPropertyOwnershipId;
    }

    @ManyToOne
    @JoinColumn(name = "possessionOrAgeId", referencedColumnName = "id")
    public PossessionOrAge getPossessionOrAgeByPossessionOrAgeId() {
        return possessionOrAgeByPossessionOrAgeId;
    }

    public void setPossessionOrAgeByPossessionOrAgeId(PossessionOrAge possessionOrAgeByPossessionOrAgeId) {
        this.possessionOrAgeByPossessionOrAgeId = possessionOrAgeByPossessionOrAgeId;
    }

    @Basic
    @Column(name = "propertyForTypeId", nullable = true, insertable = false, updatable = false)
    public Long getPropertyForTypeId() {
        return propertyForTypeId;
    }

    public void setPropertyForTypeId(Long propertyForTypeId) {
        this.propertyForTypeId = propertyForTypeId;
    }

    @Basic
    @Column(name = "propertyTypeId", nullable = true, insertable = false, updatable = false)
    public Long getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(Long propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    @Basic
    @Column(name = "locationId", nullable = true, insertable = false, updatable = false)
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "transactionTypeId", nullable = true, insertable = false, updatable = false)
    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Basic
    @Column(name = "propertyOwnershipId", nullable = true, insertable = false, updatable = false)
    public Long getPropertyOwnershipId() {
        return propertyOwnershipId;
    }

    public void setPropertyOwnershipId(Long propertyOwnershipId) {
        this.propertyOwnershipId = propertyOwnershipId;
    }

    @Basic
    @Column(name = "possessionStatusId", nullable = true, insertable = false, updatable = false)
    public Long getPossessionStatusId() {
        return possessionStatusId;
    }

    public void setPossessionStatusId(Long possessionStatusId) {
        this.possessionStatusId = possessionStatusId;
    }

    @Basic
    @Column(name = "possessionOrAgeId", nullable = true, insertable = false, updatable = false)
    public Long getPossessionOrAgeId() {
        return possessionOrAgeId;
    }

    public void setPossessionOrAgeId(Long possessionOrAgeId) {
        this.possessionOrAgeId = possessionOrAgeId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyTypeId", referencedColumnName = "id")
    public PropertyType getPropertyTypeByPropertyTypeId() {
        return propertyTypeByPropertyTypeId;
    }

    public void setPropertyTypeByPropertyTypeId(PropertyType propertyTypeByPropertyTypeId) {
        this.propertyTypeByPropertyTypeId = propertyTypeByPropertyTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    public Locations getLocationsByLocationId() {
        return locationsByLocationId;
    }

    public void setLocationsByLocationId(Locations locationsByLocationId) {
        this.locationsByLocationId = locationsByLocationId;
    }

    @ManyToOne
    @JoinColumn(name = "transactionTypeId", referencedColumnName = "id")
    public TransactionType getTransactionTypeByTransactionTypeId() {
        return transactionTypeByTransactionTypeId;
    }

    public void setTransactionTypeByTransactionTypeId(TransactionType transactionTypeByTransactionTypeId) {
        this.transactionTypeByTransactionTypeId = transactionTypeByTransactionTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "possessionStatusId", referencedColumnName = "id")
    public PossessionStatus getPossessionStatusByPossessionStatusId() {
        return possessionStatusByPossessionStatusId;
    }

    public void setPossessionStatusByPossessionStatusId(PossessionStatus possessionStatusByPossessionStatusId) {
        this.possessionStatusByPossessionStatusId = possessionStatusByPossessionStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyForTypeId", referencedColumnName = "id")
    public PropertyForType getPropertyForTypeByPropertyForTypeId() {
        return propertyForTypeByPropertyForTypeId;
    }

    public void setPropertyForTypeByPropertyForTypeId(PropertyForType propertyForTypeByPropertyForTypeId) {
        this.propertyForTypeByPropertyForTypeId = propertyForTypeByPropertyForTypeId;
    }

    @OneToMany(mappedBy = "advertisementByAdvertisementId")
    public Collection<AdvertisementDetails> getAdvertisementDetailsesById() {
        return advertisementDetailsesById;
    }

    public void setAdvertisementDetailsesById(Collection<AdvertisementDetails> advertisementDetailsesById) {
        this.advertisementDetailsesById = advertisementDetailsesById;
    }

    @OneToMany(mappedBy = "advertisementByAdvertisementId")
    public Collection<GalleryImages> getGalleryImagesesById() {
        return galleryImagesesById;
    }

    public void setGalleryImagesesById(Collection<GalleryImages> galleryImagesesById) {
        this.galleryImagesesById = galleryImagesesById;
    }

    @OneToMany(mappedBy = "advertisementByAdvertisementId")
    public Collection<MorePropertyDetails> getMorePropertyDetailsesById() {
        return morePropertyDetailsesById;
    }

    public void setMorePropertyDetailsesById(Collection<MorePropertyDetails> morePropertyDetailsesById) {
        this.morePropertyDetailsesById = morePropertyDetailsesById;
    }

    @OneToMany(mappedBy = "advertisementByAdvertisementId")
    public Collection<Residential> getResidentialsById() {
        return residentialsById;
    }

    public void setResidentialsById(Collection<Residential> residentialsById) {
        this.residentialsById = residentialsById;
    }

    @Basic
    @Column(name = "planId", nullable = true, insertable = false, updatable = false)
    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    @ManyToOne
    @JoinColumn(name = "planId", referencedColumnName = "id")
    public PlanMast getPlanMastByPlanId() {
        return planMastByPlanId;
    }

    public void setPlanMastByPlanId(PlanMast planMastByPlanId) {
        this.planMastByPlanId = planMastByPlanId;
    }
}
