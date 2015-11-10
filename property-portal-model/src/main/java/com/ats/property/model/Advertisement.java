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
    private Long planId;
    private Long propertyForTypeId;
    private Long propertyTypeId;
    private Long locationId;
    private String address;
    private String builderName;
    private String projectName;
    private Long transactionTypeId;
    private Long propertyOwnershipId;
    private Long possessionStatusId;
    private Long possessionOrAgeId;
    private String description;
    private String propertyFeatures;
    private String isTermsAgreed;
    private PropertyType propertyTypeByPropertyTypeId;
    private Locations locationsByLocationId;
    private TransactionType transactionTypeByTransactionTypeId;
    private PropertyOwnershipType propertyOwnershipTypeByPropertyOwnershipId;
    private PossessionStatus possessionStatusByPossessionStatusId;
    private PossessionOrAge possessionOrAgeByPossessionOrAgeId;
    private PlanMast planMastByPlanId;
    private PropertyForType propertyForTypeByPropertyForTypeId;
    private Collection<AdvertisementDetails> advertisementDetailsesById;
    private Collection<GalleryImages> galleryImagesesById;
    private Collection<MorePropertyDetails> morePropertyDetailsesById;
    private Collection<PropertyAmenities> propertyAmenitiesesById;
    private Collection<Residential> residentialsById;
    private PropertyUser propertyUserByPropertyUserId;
    private Boolean isApproved;
    private String specificationFileName;
    private String descriptionFileName;
    private String morePropertiesFileName;

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
    @Column(name = "planId", nullable = true, insertable = false, updatable = false)
    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
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
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "builderName", nullable = true, insertable = true, updatable = true, length = 100)
    public String getBuilderName() {
        return builderName;
    }

    public void setBuilderName(String builderName) {
        this.builderName = builderName;
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
        if (builderName != null ? !builderName.equals(that.builderName) : that.builderName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isTermsAgreed != null ? !isTermsAgreed.equals(that.isTermsAgreed) : that.isTermsAgreed != null)
            return false;
        if (locationId != null ? !locationId.equals(that.locationId) : that.locationId != null) return false;
        if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;
        if (possessionOrAgeId != null ? !possessionOrAgeId.equals(that.possessionOrAgeId) : that.possessionOrAgeId != null)
            return false;
        if (possessionStatusId != null ? !possessionStatusId.equals(that.possessionStatusId) : that.possessionStatusId != null)
            return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (propertyFeatures != null ? !propertyFeatures.equals(that.propertyFeatures) : that.propertyFeatures != null)
            return false;
        if (propertyForTypeId != null ? !propertyForTypeId.equals(that.propertyForTypeId) : that.propertyForTypeId != null)
            return false;
        if (propertyOwnershipId != null ? !propertyOwnershipId.equals(that.propertyOwnershipId) : that.propertyOwnershipId != null)
            return false;
        if (propertyTypeId != null ? !propertyTypeId.equals(that.propertyTypeId) : that.propertyTypeId != null)
            return false;
        if (transactionTypeId != null ? !transactionTypeId.equals(that.transactionTypeId) : that.transactionTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (planId != null ? planId.hashCode() : 0);
        result = 31 * result + (propertyForTypeId != null ? propertyForTypeId.hashCode() : 0);
        result = 31 * result + (propertyTypeId != null ? propertyTypeId.hashCode() : 0);
        result = 31 * result + (locationId != null ? locationId.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (builderName != null ? builderName.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (transactionTypeId != null ? transactionTypeId.hashCode() : 0);
        result = 31 * result + (propertyOwnershipId != null ? propertyOwnershipId.hashCode() : 0);
        result = 31 * result + (possessionStatusId != null ? possessionStatusId.hashCode() : 0);
        result = 31 * result + (possessionOrAgeId != null ? possessionOrAgeId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (propertyFeatures != null ? propertyFeatures.hashCode() : 0);
        result = 31 * result + (isTermsAgreed != null ? isTermsAgreed.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "propertyOwnershipId", referencedColumnName = "id")
    public PropertyOwnershipType getPropertyOwnershipTypeByPropertyOwnershipId() {
        return propertyOwnershipTypeByPropertyOwnershipId;
    }

    public void setPropertyOwnershipTypeByPropertyOwnershipId(PropertyOwnershipType propertyOwnershipTypeByPropertyOwnershipId) {
        this.propertyOwnershipTypeByPropertyOwnershipId = propertyOwnershipTypeByPropertyOwnershipId;
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
    @JoinColumn(name = "possessionOrAgeId", referencedColumnName = "id")
    public PossessionOrAge getPossessionOrAgeByPossessionOrAgeId() {
        return possessionOrAgeByPossessionOrAgeId;
    }

    public void setPossessionOrAgeByPossessionOrAgeId(PossessionOrAge possessionOrAgeByPossessionOrAgeId) {
        this.possessionOrAgeByPossessionOrAgeId = possessionOrAgeByPossessionOrAgeId;
    }

    @ManyToOne
    @JoinColumn(name = "planId", referencedColumnName = "id")
    public PlanMast getPlanMastByPlanId() {
        return planMastByPlanId;
    }

    public void setPlanMastByPlanId(PlanMast planMastByPlanId) {
        this.planMastByPlanId = planMastByPlanId;
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
    public Collection<PropertyAmenities> getPropertyAmenitiesesById() {
        return propertyAmenitiesesById;
    }

    public void setPropertyAmenitiesesById(Collection<PropertyAmenities> propertyAmenitiesesById) {
        this.propertyAmenitiesesById = propertyAmenitiesesById;
    }

    @OneToMany(mappedBy = "advertisementByAdvertisementId")
    public Collection<Residential> getResidentialsById() {
        return residentialsById;
    }

    public void setResidentialsById(Collection<Residential> residentialsById) {
        this.residentialsById = residentialsById;
    }

    @ManyToOne
    @JoinColumn(name = "propertyUserId", referencedColumnName = "id")
    public PropertyUser getPropertyUserByPropertyUserId() {
        return propertyUserByPropertyUserId;
    }

    public void setPropertyUserByPropertyUserId(PropertyUser propertyUserByPropertyUserId) {
        this.propertyUserByPropertyUserId = propertyUserByPropertyUserId;
    }

    @Basic
    @Column(name = "isApproved", nullable = true, insertable = true, updatable = true)
    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    @Basic
    @Column(name = "descriptionFileName", nullable = true, insertable = true, updatable = true, length = 100)
    public String getDescriptionFileName() {
        return descriptionFileName;
    }

    public void setDescriptionFileName(String descriptionFileName) {
        this.descriptionFileName = descriptionFileName;
    }

    @Basic
    @Column(name = "specificationFileName", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSpecificationFileName() {
        return specificationFileName;
    }

    public void setSpecificationFileName(String specificationFileName) {
        this.specificationFileName = specificationFileName;
    }

    @Basic
    @Column(name = "morePropertiesFileName", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMorePropertiesFileName() {
        return morePropertiesFileName;
    }

    public void setMorePropertiesFileName(String morePropertiesFileName) {
        this.morePropertiesFileName = morePropertiesFileName;
    }
}
