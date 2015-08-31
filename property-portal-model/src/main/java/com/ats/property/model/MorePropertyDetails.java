package com.ats.property.model;

import javax.persistence.*;

/**
 * The MorePropertyDetails.
 *
 * @author anbarasan.s
 */
@Entity
public class MorePropertyDetails {
    private Long id;
    private Long area;
    private Long pricePerUnitArea;
    private Long totalCost;
    private String floorPlanFileName;
    private Advertisement advertisementByAdvertisementId;
    private Long advertisementId;
    private Long bedRoomId;
    private Long areaAreaUnitId;
    private Bedroom bedroomByBedRoomId;
    private UnitMaster unitMasterByAreaAreaUnitId;

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
    @Column(name = "area", nullable = true, insertable = true, updatable = true)
    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    @Basic
    @Column(name = "pricePerUnitArea", nullable = true, insertable = true, updatable = true)
    public Long getPricePerUnitArea() {
        return pricePerUnitArea;
    }

    public void setPricePerUnitArea(Long pricePerUnitArea) {
        this.pricePerUnitArea = pricePerUnitArea;
    }

    @Basic
    @Column(name = "totalCost", nullable = true, insertable = true, updatable = true)
    public Long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }

    @Basic
    @Column(name = "floorPlanFileName", nullable = true, insertable = true, updatable = true, length = 200)
    public String getFloorPlanFileName() {
        return floorPlanFileName;
    }

    public void setFloorPlanFileName(String floorPlanFileName) {
        this.floorPlanFileName = floorPlanFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MorePropertyDetails that = (MorePropertyDetails) o;

        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (floorPlanFileName != null ? !floorPlanFileName.equals(that.floorPlanFileName) : that.floorPlanFileName != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (pricePerUnitArea != null ? !pricePerUnitArea.equals(that.pricePerUnitArea) : that.pricePerUnitArea != null)
            return false;
        if (totalCost != null ? !totalCost.equals(that.totalCost) : that.totalCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (pricePerUnitArea != null ? pricePerUnitArea.hashCode() : 0);
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        result = 31 * result + (floorPlanFileName != null ? floorPlanFileName.hashCode() : 0);
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

    @Basic
    @Column(name = "advertisementId", nullable = true, insertable = false, updatable = false)
    public Long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
    }

    @Basic
    @Column(name = "bedRoomId", nullable = true, insertable = false, updatable = false)
    public Long getBedRoomId() {
        return bedRoomId;
    }

    public void setBedRoomId(Long bedRoomId) {
        this.bedRoomId = bedRoomId;
    }

    @Basic
    @Column(name = "areaAreaUnitId", nullable = true, insertable = false, updatable = false)
    public Long getAreaAreaUnitId() {
        return areaAreaUnitId;
    }

    public void setAreaAreaUnitId(Long areaAreaUnitId) {
        this.areaAreaUnitId = areaAreaUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "bedRoomId", referencedColumnName = "id")
    public Bedroom getBedroomByBedRoomId() {
        return bedroomByBedRoomId;
    }

    public void setBedroomByBedRoomId(Bedroom bedroomByBedRoomId) {
        this.bedroomByBedRoomId = bedroomByBedRoomId;
    }

    @ManyToOne
    @JoinColumn(name = "areaAreaUnitId", referencedColumnName = "id")
    public UnitMaster getUnitMasterByAreaAreaUnitId() {
        return unitMasterByAreaAreaUnitId;
    }

    public void setUnitMasterByAreaAreaUnitId(UnitMaster unitMasterByAreaAreaUnitId) {
        this.unitMasterByAreaAreaUnitId = unitMasterByAreaAreaUnitId;
    }
}
