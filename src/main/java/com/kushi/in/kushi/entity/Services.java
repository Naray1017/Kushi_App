package com.kushi.in.kushi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_service_info") // Specify the correct table name here
public class Services {

    @Id
    @Column(name = "SERVICE_ID")
    private int serviceId;

    @Column(name = "SERVICE_NAME", length = 100)
    private String serviceName;

    @Column(name = "SERVICE_TYPE", length = 100)
    private String serviceType;

    @Column(name = "SERVICE_DESCRIPTION", length = 100)
    private String serviceDescription;

    @Column(name = "SERVICE_DETAILS", length = 100)
    private String serviceDetails;

    @Column(name = "SERVICE_COST")
    private int serviceCost;

    @Column(name = "DISCOUNT_PERCENTAGE", precision = 5, scale = 2)
    private BigDecimal discountPercentage;

    @Column(name = "DISCOUNT_AMOUNT", precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "TOTAL_AMOUNT", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "ACTIVE", length = 1, columnDefinition = "CHAR(1) DEFAULT 'N'")
    private String active = "N";

    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATED_BY", length = 100)
    private String updatedBy;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "REMARKS", length = 600)
    private String remarks;

    public String getActive() {
        return active;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setActive(String active) {
        this.active = active;
    }
// Getters and Setters

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(int serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
    // Make sure you have all the necessary getters and setters
}
