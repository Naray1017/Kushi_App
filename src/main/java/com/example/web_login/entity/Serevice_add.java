package com.example.web_login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_service_info")
public class Serevice_add {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;  // Service ID (Auto-generated)

    private String serviceName;
    private String serviceType;
    private String serviceDescription;
    private String serviceDetails;
    private Double serviceCost;
    private String active;
    private String createdBy;
    private String createDate;
    private String updatedBy;
    private String updatedDate;
    private String serviceImageUrl;
    private String remarks;
    private String rating;
    private String rating_count;	

    public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRating_count() {
		return rating_count;
	}

	public void setRating_count(String rating_count) {
		this.rating_count = rating_count;
	}

	public String getReating() {
		return rating;
	}

	public void setReating(String reating) {
		this.rating = reating;
	}

	@Override
	public String toString() {
		return "Serevice_add [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceType=" + serviceType
				+ ", serviceDescription=" + serviceDescription + ", serviceDetails=" + serviceDetails + ", serviceCost="
				+ serviceCost + ", active=" + active + ", createdBy=" + createdBy + ", createDate=" + createDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", serviceImageUrl=" + serviceImageUrl
				+ ", remarks=" + remarks + ", rating=" + rating + ", rating_count=" + rating_count + ", getRating()="
				+ getRating() + ", getRating_count()=" + getRating_count() + ", getReating()=" + getReating()
				+ ", getServiceId()=" + getServiceId() + ", getServiceName()=" + getServiceName()
				+ ", getServiceType()=" + getServiceType() + ", getServiceDescription()=" + getServiceDescription()
				+ ", getServiceDetails()=" + getServiceDetails() + ", getServiceCost()=" + getServiceCost()
				+ ", getActive()=" + getActive() + ", getCreatedBy()=" + getCreatedBy() + ", getCreateDate()="
				+ getCreateDate() + ", getUpdatedBy()=" + getUpdatedBy() + ", getUpdatedDate()=" + getUpdatedDate()
				+ ", getServiceImageUrl()=" + getServiceImageUrl() + ", getRemarks()=" + getRemarks() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	// Getters and setters for each field
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getServiceImageUrl() {
        return serviceImageUrl;
    }

    public void setServiceImageUrl(String serviceImageUrl) {
        this.serviceImageUrl = serviceImageUrl;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
