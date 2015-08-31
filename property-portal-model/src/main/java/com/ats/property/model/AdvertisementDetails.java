package com.ats.property.model;

import javax.persistence.*;

/**
 * The AdvertisementDetails.
 *
 * @author anbarasan.s
 */
@Entity
public class AdvertisementDetails {
    private Long id;
    private Long buildupArea;
    private Long carpetArea;
    private Long plotArea;
    private Long rooms;
    private Long washroom;
    private Long expectedPrice;
    private Advertisement advertisementByAdvertisementId;
    private FacingMast facingMastByFacingId;
    private Long advertisementId;
    private Long buildupAreaUnitId;
    private Long carpetAreaUnitId;
    private Long plotAreaUnitId;
    private Long balconyId;
    private Long propertyOnFloorId;
    private Long totalFloor;
    private Long facingId;
    private UnitMaster unitMasterByBuildupAreaUnitId;
    private UnitMaster unitMasterByCarpetAreaUnitId;
    private UnitMaster unitMasterByPlotAreaUnitId;
    private TotalFloors totalFloorsByPropertyOnFloorId;
    private TotalFloors totalFloorsByTotalFloor;
    private Balconies balconiesByBalconyId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "buildupArea", nullable = true, insertable = true, updatable = true)
    public Long getBuildupArea() {
        return buildupArea;
    }

    public void setBuildupArea(Long buildupArea) {
        this.buildupArea = buildupArea;
    }

    @Basic
    @Column(name = "carpetArea", nullable = true, insertable = true, updatable = true)
    public Long getCarpetArea() {
        return carpetArea;
    }

    public void setCarpetArea(Long carpetArea) {
        this.carpetArea = carpetArea;
    }

    @Basic
    @Column(name = "plotArea", nullable = true, insertable = true, updatable = true)
    public Long getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(Long plotArea) {
        this.plotArea = plotArea;
    }

    @Basic
    @Column(name = "rooms", nullable = true, insertable = true, updatable = true)
    public Long getRooms() {
        return rooms;
    }

    public void setRooms(Long rooms) {
        this.rooms = rooms;
    }

    @Basic
    @Column(name = "washroom", nullable = true, insertable = true, updatable = true)
    public Long getWashroom() {
        return washroom;
    }

    public void setWashroom(Long washroom) {
        this.washroom = washroom;
    }

    @Basic
    @Column(name = "expectedPrice", nullable = true, insertable = true, updatable = true)
    public Long getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(Long expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertisementDetails that = (AdvertisementDetails) o;

        if (buildupArea != null ? !buildupArea.equals(that.buildupArea) : that.buildupArea != null) return false;
        if (carpetArea != null ? !carpetArea.equals(that.carpetArea) : that.carpetArea != null) return false;
        if (expectedPrice != null ? !expectedPrice.equals(that.expectedPrice) : that.expectedPrice != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (plotArea != null ? !plotArea.equals(that.plotArea) : that.plotArea != null) return false;
        if (rooms != null ? !rooms.equals(that.rooms) : that.rooms != null) return false;
        if (washroom != null ? !washroom.equals(that.washroom) : that.washroom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (buildupArea != null ? buildupArea.hashCode() : 0);
        result = 31 * result + (carpetArea != null ? carpetArea.hashCode() : 0);
        result = 31 * result + (plotArea != null ? plotArea.hashCode() : 0);
        result = 31 * result + (rooms != null ? rooms.hashCode() : 0);
        result = 31 * result + (washroom != null ? washroom.hashCode() : 0);
        result = 31 * result + (expectedPrice != null ? expectedPrice.hashCode() : 0);
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
    @JoinColumn(name = "facingId", referencedColumnName = "id")
    public FacingMast getFacingMastByFacingId() {
        return facingMastByFacingId;
    }

    public void setFacingMastByFacingId(FacingMast facingMastByFacingId) {
        this.facingMastByFacingId = facingMastByFacingId;
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
    @Column(name = "buildupAreaUnitId", nullable = true, insertable = false, updatable = false)
    public Long getBuildupAreaUnitId() {
        return buildupAreaUnitId;
    }

    public void setBuildupAreaUnitId(Long buildupAreaUnitId) {
        this.buildupAreaUnitId = buildupAreaUnitId;
    }

    @Basic
    @Column(name = "carpetAreaUnitId", nullable = true, insertable = false, updatable = false)
    public Long getCarpetAreaUnitId() {
        return carpetAreaUnitId;
    }

    public void setCarpetAreaUnitId(Long carpetAreaUnitId) {
        this.carpetAreaUnitId = carpetAreaUnitId;
    }

    @Basic
    @Column(name = "plotAreaUnitId", nullable = true, insertable = false, updatable = false)
    public Long getPlotAreaUnitId() {
        return plotAreaUnitId;
    }

    public void setPlotAreaUnitId(Long plotAreaUnitId) {
        this.plotAreaUnitId = plotAreaUnitId;
    }

    @Basic
    @Column(name = "balconyId", nullable = true, insertable = false, updatable = false)
    public Long getBalconyId() {
        return balconyId;
    }

    public void setBalconyId(Long balconyId) {
        this.balconyId = balconyId;
    }

    @Basic
    @Column(name = "propertyOnFloorId", nullable = true, insertable = false, updatable = false)
    public Long getPropertyOnFloorId() {
        return propertyOnFloorId;
    }

    public void setPropertyOnFloorId(Long propertyOnFloorId) {
        this.propertyOnFloorId = propertyOnFloorId;
    }

    @Basic
    @Column(name = "totalFloor", nullable = true, insertable = false, updatable = false)
    public Long getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Long totalFloor) {
        this.totalFloor = totalFloor;
    }

    @Basic
    @Column(name = "facingId", nullable = true, insertable = false, updatable = false)
    public Long getFacingId() {
        return facingId;
    }

    public void setFacingId(Long facingId) {
        this.facingId = facingId;
    }

    @ManyToOne
    @JoinColumn(name = "buildupAreaUnitId", referencedColumnName = "id")
    public UnitMaster getUnitMasterByBuildupAreaUnitId() {
        return unitMasterByBuildupAreaUnitId;
    }

    public void setUnitMasterByBuildupAreaUnitId(UnitMaster unitMasterByBuildupAreaUnitId) {
        this.unitMasterByBuildupAreaUnitId = unitMasterByBuildupAreaUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "carpetAreaUnitId", referencedColumnName = "id")
    public UnitMaster getUnitMasterByCarpetAreaUnitId() {
        return unitMasterByCarpetAreaUnitId;
    }

    public void setUnitMasterByCarpetAreaUnitId(UnitMaster unitMasterByCarpetAreaUnitId) {
        this.unitMasterByCarpetAreaUnitId = unitMasterByCarpetAreaUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "plotAreaUnitId", referencedColumnName = "id")
    public UnitMaster getUnitMasterByPlotAreaUnitId() {
        return unitMasterByPlotAreaUnitId;
    }

    public void setUnitMasterByPlotAreaUnitId(UnitMaster unitMasterByPlotAreaUnitId) {
        this.unitMasterByPlotAreaUnitId = unitMasterByPlotAreaUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyOnFloorId", referencedColumnName = "id")
    public TotalFloors getTotalFloorsByPropertyOnFloorId() {
        return totalFloorsByPropertyOnFloorId;
    }

    public void setTotalFloorsByPropertyOnFloorId(TotalFloors totalFloorsByPropertyOnFloorId) {
        this.totalFloorsByPropertyOnFloorId = totalFloorsByPropertyOnFloorId;
    }

    @ManyToOne
    @JoinColumn(name = "totalFloor", referencedColumnName = "id")
    public TotalFloors getTotalFloorsByTotalFloor() {
        return totalFloorsByTotalFloor;
    }

    public void setTotalFloorsByTotalFloor(TotalFloors totalFloorsByTotalFloor) {
        this.totalFloorsByTotalFloor = totalFloorsByTotalFloor;
    }

    @ManyToOne
    @JoinColumn(name = "balconyId", referencedColumnName = "id")
    public Balconies getBalconiesByBalconyId() {
        return balconiesByBalconyId;
    }

    public void setBalconiesByBalconyId(Balconies balconiesByBalconyId) {
        this.balconiesByBalconyId = balconiesByBalconyId;
    }
}
