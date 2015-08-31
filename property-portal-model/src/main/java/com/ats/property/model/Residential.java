package com.ats.property.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * The Residential.
 *
 * @author anbarasan.s
 */
@Entity
public class Residential {
    private Long id;
    private Long maintenanceCharges;
    private Long securityDeposit;
    private Date availableFrom;
    private String isFromBrokers;
    private String poojaRoom;
    private String studyRoom;
    private String servantRoom;
    private Advertisement advertisementByAdvertisementId;
    private Long advertisementId;
    private Long furnishedStatusId;
    private Long maintenancePeriodId;
    private Long bedRoomId;
    private Long bathRoomId;
    private FurnishedStatus furnishedStatusByFurnishedStatusId;
    private Terms termsByMaintenancePeriodId;
    private Bedroom bedroomByBedRoomId;
    private Bathroom bathroomByBathRoomId;

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
    @Column(name = "maintenanceCharges", nullable = true, insertable = true, updatable = true)
    public Long getMaintenanceCharges() {
        return maintenanceCharges;
    }

    public void setMaintenanceCharges(Long maintenanceCharges) {
        this.maintenanceCharges = maintenanceCharges;
    }

    @Basic
    @Column(name = "securityDeposit", nullable = true, insertable = true, updatable = true)
    public Long getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(Long securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    @Basic
    @Column(name = "availableFrom", nullable = true, insertable = true, updatable = true)
    public Date getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    @Basic
    @Column(name = "isFromBrokers", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsFromBrokers() {
        return isFromBrokers;
    }

    public void setIsFromBrokers(String isFromBrokers) {
        this.isFromBrokers = isFromBrokers;
    }

    @Basic
    @Column(name = "poojaRoom", nullable = true, insertable = true, updatable = true, length = 1)
    public String getPoojaRoom() {
        return poojaRoom;
    }

    public void setPoojaRoom(String poojaRoom) {
        this.poojaRoom = poojaRoom;
    }

    @Basic
    @Column(name = "studyRoom", nullable = true, insertable = true, updatable = true, length = 1)
    public String getStudyRoom() {
        return studyRoom;
    }

    public void setStudyRoom(String studyRoom) {
        this.studyRoom = studyRoom;
    }

    @Basic
    @Column(name = "servantRoom", nullable = true, insertable = true, updatable = true, length = 1)
    public String getServantRoom() {
        return servantRoom;
    }

    public void setServantRoom(String servantRoom) {
        this.servantRoom = servantRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Residential that = (Residential) o;

        if (availableFrom != null ? !availableFrom.equals(that.availableFrom) : that.availableFrom != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isFromBrokers != null ? !isFromBrokers.equals(that.isFromBrokers) : that.isFromBrokers != null)
            return false;
        if (maintenanceCharges != null ? !maintenanceCharges.equals(that.maintenanceCharges) : that.maintenanceCharges != null)
            return false;
        if (poojaRoom != null ? !poojaRoom.equals(that.poojaRoom) : that.poojaRoom != null) return false;
        if (securityDeposit != null ? !securityDeposit.equals(that.securityDeposit) : that.securityDeposit != null)
            return false;
        if (servantRoom != null ? !servantRoom.equals(that.servantRoom) : that.servantRoom != null) return false;
        if (studyRoom != null ? !studyRoom.equals(that.studyRoom) : that.studyRoom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (maintenanceCharges != null ? maintenanceCharges.hashCode() : 0);
        result = 31 * result + (securityDeposit != null ? securityDeposit.hashCode() : 0);
        result = 31 * result + (availableFrom != null ? availableFrom.hashCode() : 0);
        result = 31 * result + (isFromBrokers != null ? isFromBrokers.hashCode() : 0);
        result = 31 * result + (poojaRoom != null ? poojaRoom.hashCode() : 0);
        result = 31 * result + (studyRoom != null ? studyRoom.hashCode() : 0);
        result = 31 * result + (servantRoom != null ? servantRoom.hashCode() : 0);
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
    @Column(name = "furnishedStatusId", nullable = true, insertable = false, updatable = false)
    public Long getFurnishedStatusId() {
        return furnishedStatusId;
    }

    public void setFurnishedStatusId(Long furnishedStatusId) {
        this.furnishedStatusId = furnishedStatusId;
    }

    @Basic
    @Column(name = "maintenancePeriodId", nullable = true, insertable = false, updatable = false)
    public Long getMaintenancePeriodId() {
        return maintenancePeriodId;
    }

    public void setMaintenancePeriodId(Long maintenancePeriodId) {
        this.maintenancePeriodId = maintenancePeriodId;
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
    @Column(name = "bathRoomId", nullable = true, insertable = false, updatable = false)
    public Long getBathRoomId() {
        return bathRoomId;
    }

    public void setBathRoomId(Long bathRoomId) {
        this.bathRoomId = bathRoomId;
    }

    @ManyToOne
    @JoinColumn(name = "furnishedStatusId", referencedColumnName = "id")
    public FurnishedStatus getFurnishedStatusByFurnishedStatusId() {
        return furnishedStatusByFurnishedStatusId;
    }

    public void setFurnishedStatusByFurnishedStatusId(FurnishedStatus furnishedStatusByFurnishedStatusId) {
        this.furnishedStatusByFurnishedStatusId = furnishedStatusByFurnishedStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "maintenancePeriodId", referencedColumnName = "id")
    public Terms getTermsByMaintenancePeriodId() {
        return termsByMaintenancePeriodId;
    }

    public void setTermsByMaintenancePeriodId(Terms termsByMaintenancePeriodId) {
        this.termsByMaintenancePeriodId = termsByMaintenancePeriodId;
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
    @JoinColumn(name = "bathRoomId", referencedColumnName = "id")
    public Bathroom getBathroomByBathRoomId() {
        return bathroomByBathRoomId;
    }

    public void setBathroomByBathRoomId(Bathroom bathroomByBathRoomId) {
        this.bathroomByBathRoomId = bathroomByBathRoomId;
    }
}
