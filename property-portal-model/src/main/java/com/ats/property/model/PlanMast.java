package com.ats.property.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The PlanMast.
 *
 * @author anbarasan.s
 */
@Entity
public class PlanMast {
    private Long id;
    private String name;
    private Float cost;
    private Integer numberOfImages;
    private Long userTypeId;
    private String description;
    private Integer validDays;
    private Timestamp createdDate;
    private UserType userTypeByUserTypeId;

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
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "cost", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "numberOfImages", nullable = true, insertable = true, updatable = true)
    public Integer getNumberOfImages() {
        return numberOfImages;
    }

    public void setNumberOfImages(Integer numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

    @Basic
    @Column(name = "userTypeId", nullable = true, insertable = false, updatable = false)
    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "validDays", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getValidDays() {
        return validDays;
    }

    public void setValidDays(Integer validDays) {
        this.validDays = validDays;
    }

    @Basic
    @Column(name = "createdDate", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanMast planMast = (PlanMast) o;

        if (cost != null ? !cost.equals(planMast.cost) : planMast.cost != null) return false;
        if (createdDate != null ? !createdDate.equals(planMast.createdDate) : planMast.createdDate != null)
            return false;
        if (description != null ? !description.equals(planMast.description) : planMast.description != null)
            return false;
        if (id != null ? !id.equals(planMast.id) : planMast.id != null) return false;
        if (name != null ? !name.equals(planMast.name) : planMast.name != null) return false;
        if (numberOfImages != null ? !numberOfImages.equals(planMast.numberOfImages) : planMast.numberOfImages != null)
            return false;
        if (userTypeId != null ? !userTypeId.equals(planMast.userTypeId) : planMast.userTypeId != null) return false;
        if (validDays != null ? !validDays.equals(planMast.validDays) : planMast.validDays != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (numberOfImages != null ? numberOfImages.hashCode() : 0);
        result = 31 * result + (userTypeId != null ? userTypeId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (validDays != null ? validDays.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userTypeId", referencedColumnName = "id")
    public UserType getUserTypeByUserTypeId() {
        return userTypeByUserTypeId;
    }

    public void setUserTypeByUserTypeId(UserType userTypeByUserTypeId) {
        this.userTypeByUserTypeId = userTypeByUserTypeId;
    }
}
